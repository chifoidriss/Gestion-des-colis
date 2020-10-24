package agent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Personne {

	public int id,numero;
	public String nom,prenom,ville,sexe;
	public ConnectDB db;
	public ResultSet rs;
	
	public Personne(String nom,String prenom,String sexe,String ville,int numero) {
		db = new ConnectDB();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.ville = ville;
		this.numero = numero;
		db.sql("INSERT INTO personne(nom,prenom,sexe,ville,numero)"+
			   "VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+ville+"','"+numero+"')");		
	}
	
	public Personne(int num) {
		db = new ConnectDB();
		this.numero = num;
		try {
			rs = db.query("SELECT * FROM personne WHERE numero="+num);
			while(rs.next()) {
				id = rs.getInt("id");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				sexe = rs.getString("sexe");
				ville = rs.getString("ville");
			}
		} catch (SQLException e) {
			System.out.println("Erreur: "+e);
		}
	}

	public String toString() {
		String n="";
		if(sexe.equalsIgnoreCase("M")) n+="Mr. ";
		else if(sexe.equalsIgnoreCase("F")) n+="Mme. ";
		n += nom+" "+prenom+"\n Adresse: "+ville+"\n Téléphone: "+numero;
		return n;

	}
	
	public void deletePersonne() {
		db.sql("DELETE * FROM personne WHERE id="+id);
		System.out.println("Success!!!");
	}
	
	public static void main(String[] args) {
		// Personne P1 = new Personne("CHIFO","IDRISS","M","Dschang","672243491");
		// Personne P2= new Personne("kuete","TANEFO","m","Dschang","652148617");
		
		System.out.println(new Personne(672243491).toString());
	}
}

