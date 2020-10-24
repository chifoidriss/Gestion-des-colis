package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import agent.Colis;
import view.ListeColis;

public class EcouteurL implements ActionListener {

	public ListeColis l;
	Object ob;
	Colis C,Ci;
	
	public EcouteurL(ListeColis l) {
		this.l = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ob = e.getSource();
		if(ob == l.dat) {
			String z = l.zone.getText();
			int id = Integer.valueOf(z).intValue();
			C = new Colis(id);
			JOptionPane.showMessageDialog(null, "Voulez vous retirer ce colis?\n"+C.toString(),"Retrait de "+C.ident,
			JOptionPane.WARNING_MESSAGE);
			String passe = JOptionPane.showInputDialog("Entrer le mot de passe pour rétirer le colis: ",null);
			if(C.etat == 0) {
				if(C.passe.equals(passe)) {
					C.retrait(passe);
					JOptionPane.showMessageDialog(null, "Retrait effectué avec succès!","Retratit de "+C.ident,
					JOptionPane.INFORMATION_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect!","Retratit de "+C.ident,
					JOptionPane.ERROR_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "Mot de passe incorrect!","Retratit de "+C.ident,
				JOptionPane.ERROR_MESSAGE);
		}
		if(ob == l.info) {
			String z = l.zone.getText();
			int id = Integer.valueOf(z).intValue();
			Ci = new Colis(id);
			JOptionPane.showMessageDialog(null,Ci.toString(),"A propos de "+Ci.ident,
			JOptionPane.INFORMATION_MESSAGE);
		}
		if(ob == l.del) {
			String z = l.zone.getText();
			int id = Integer.valueOf(z).intValue();
			C = new Colis(id);
			JOptionPane.showMessageDialog(null, "Voulez-vous vraiment supprimer ce colis?\n"+C.toString(),"Suppression de "+C.ident,
			JOptionPane.WARNING_MESSAGE);
			String passe = JOptionPane.showInputDialog("Entrer le mot de passe pour supprimer le colis: ",null);
			if(C.passe.equals(passe)) {
				C.deleteColis(passe);
				JOptionPane.showMessageDialog(null, "Supprimé avec succès","Suppression de "+C.ident,
				JOptionPane.INFORMATION_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "Suppression impossible!!!\nMot de passe incorrect!","Suppression de "+C.ident,
				JOptionPane.ERROR_MESSAGE);
		}
	}

}
