package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import agent.*;
import view.*;

public class EcouteurD implements ActionListener {

	public Depot d;
	Object ob;
	Personne Pe,Pr;
	Colis C;
	
	public EcouteurD(Depot d) {
		this.d = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ob = e.getSource();
		if(ob == d.back) {
			d.setVisible(false);
		}
		if(ob == d.save) {
			String ident = d.tIdent.getText();
			@SuppressWarnings("deprecation")
			String passe = d.tPasse.getText();

			String nom_e = d.tNom_e.getText();
			String prenom_e = d.tPrenom_e.getText();
			String sexe_e = (String) d.tSexe_e.getSelectedItem();
			String ville_e = d.tVille_e.getText();
			String num_e = d.tNumero_e.getText();
			int numero_e = Integer.valueOf(num_e).intValue();

			String nom_r = d.tNom_r.getText();
			String prenom_r = d.tPrenom_r.getText();
			String sexe_r = (String) d.tSexe_r.getSelectedItem();
			String ville_r = d.tVille_r.getText();
			String num_r = d.tNumero_r.getText();
			int numero_r = Integer.valueOf(num_r).intValue();

			Pe = new Personne(nom_e,prenom_e,sexe_e,ville_e,numero_e);
			Pr = new Personne(nom_r,prenom_r,sexe_r,ville_r,numero_r);
			C = new Colis(ident,passe,Pe,Pr);
			System.out.println("Enregistrement réussi!");
			JOptionPane.showMessageDialog(null, "Enregistrement réussi!");
		}
		if(ob == d.cancel)
			d.tIdent.setText("");
			d.tPasse.setText("");
	
			d.tNom_e.setText("");
			d.tPrenom_e.setText("");
			d.tVille_e.setText("");
			d.tNumero_e.setText("");
	
			d.tNom_r.setText("");
			d.tPrenom_r.setText("");
			d.tVille_r.setText("");
			d.tNumero_r.setText("");
	}

}
