package listenner;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import agent.*;
import view.Agence;
import view.Depot;
import view.ListeColis;

public class EcouteurA implements ActionListener {
	
	Agence a;
	Depot d;
	Colis C;
	Object ob;
	ResultSet rs;
	ConnectDB db;
	
	
	public EcouteurA(Agence a) {
		this.a = a;
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		ob = e.getSource();
		
		if(ob == a.depot) {
			a.content.add(new Depot());
		}
		if(ob == a.liste) {
			a.content.add(new ListeColis());
		}
		if(ob == a.search) {
			
			try {
				String m = a.rech.getText();
				rs = db.query("SELECT * FROM colis WHERE ident LIKE %"+m+"%");
				while(rs.next()) {
					int id = rs.getInt("id");
					// String ident = rs.getString("ident");
					//int etat = rs.getInt("etat");
					C = new Colis(id);
					a.content.add(new JLabel(C.ident));
				}
			}catch(SQLException e1) {
				System.out.println("Erreur: "+e1);
			}
		}
		if(ob == a.retrait) {
			String ident = JOptionPane.showInputDialog("Entrer l'identifiant du colis: ",null);
			/*try {
				rs = db.query("SELECT * FROM colis WHERE ident LIKE %"+ident+"%");
				while(rs.next()) {
					int id = rs.getInt("id");
					C = new Colis(id);
				}
			}catch(SQLException e1) {
				System.out.println("Erreur: "+e1);
			}*/
			String passe = JOptionPane.showInputDialog("Entrer le mot de passe pour rétirer le colis: ",null);
		}
	}

}
