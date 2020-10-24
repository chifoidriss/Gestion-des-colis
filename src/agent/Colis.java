package agent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Colis {

	public int id,etat;
	public String ident,passe,dateD,dateR;
	public Personne E,R;
	public ConnectDB db;
	public ResultSet rs;
	
	public Colis(String ident,String mdp,Personne E,Personne R) {
		id++;
		db = new ConnectDB();
		this.ident = ident;
		this.passe = mdp;
		this.E = E;
		this.R = R;
		etat = 0;
		db.sql("INSERT INTO colis(ident,passe,id_e,id_r,date_d,etat) VALUES('"+ident+"','"+passe+"',"+E.numero+","+R.numero+",NOW(),0)");
	}

	public Colis(int id) {
		db = new ConnectDB();
		this.id = id;
		try {
			rs = db.query("SELECT * FROM colis WHERE id="+id);
			while(rs.next()) {
				this.passe = rs.getString("passe");
				this.ident = rs.getString("ident");
				this.E = new Personne(rs.getInt("id_e"));
				this.R = new Personne(rs.getInt("id_r"));
				this.etat = rs.getInt("etat");
				this.dateD = rs.getString("date_d");
				this.dateR = rs.getString("date_r");
			}
		} catch (SQLException e) {
			System.out.println("Erreur: "+e);
		}
	}
	
	public String toString() {		
		String n="";
		n +="Identifiant du colis: "+ident+"\nEnvoyé depuis: "+E.ville;
			if(E.sexe.equalsIgnoreCase("M")) n += "\nPar: Mr. "+E.nom+" "+E.prenom;
			else if(E.sexe.equalsIgnoreCase("F")) n += "\nPar: Mme. "+E.nom+" "+E.prenom;
			if(R.sexe.equalsIgnoreCase("M")) n += "\nVers: Mr. "+R.nom+" "+R.prenom;
			else if(R.sexe.equalsIgnoreCase("F")) n += "\nVers: Mme. "+R.nom+" "+R.prenom;
			n += "\nDepuis: "+R.ville+
			"\nLe: "+dateD+
			"\nEtat du colis: ";
		if(this.etat == 1) n += "Déjà livré."+"\nLe :"+dateR;
		else n += "Pas encore livré.";
		return n;
	}
	
	public void retrait(String mdp) {
		if(this.etat == 0) {
			if(this.passe.equals(mdp)) {
				this.etat = 1;
				db.sql("UPDATE colis SET etat=1, date_r=NOW() WHERE id="+id);
				System.out.println("Retrait Effectué avec succès. Le: "+dateD);
			}else
				System.out.println("Retrait impossible. Le mot de passe ne correspond");
		}else
			System.out.println("Retrait impossible. Déjà livré. Depuis le: "+dateR);
	}
	
	public void deleteColis(String mdp) {
		if(this.passe.equals(mdp)) {
			db.sql("DELETE * FROM colis WHERE id="+id);
			System.out.println("Suppression Success!!!");
		}
	}

	public static void main(String[] args) {
		Colis C1 = new Colis(4);
		System.out.println(C1.toString());
	}
}