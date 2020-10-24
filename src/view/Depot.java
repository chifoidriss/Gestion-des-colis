package view;

import java.awt.*;
import javax.swing.*;

import listenner.EcouteurD;

public class Depot extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton back,save,cancel;
	public JPanel content,contentForm,contentForm0,contentForm1,contentForm2,contentForm3,contentButton;
	public JLabel nom_e,prenom_e,sexe_e,ville_e,numero_e,nom_r,prenom_r,sexe_r,ville_r,numero_r,ident,passe;
	public JTextField tNom_e,tPrenom_e,tVille_e,tNumero_e,tNom_r,tPrenom_r,tVille_r,tNumero_r,tIdent;
	public JPasswordField tPasse;
	public JComboBox<String> tSexe_e = new JComboBox<String>(),tSexe_r = new JComboBox<String>();
	
	public Depot() {
		content = new JPanel();
		contentForm = new JPanel();
		contentForm0 = new JPanel();
		contentForm1 = new JPanel();
		contentForm2 = new JPanel();
		contentForm3 = new JPanel();
		contentButton = new JPanel();
		
		back = new JButton("Retour");
		save = new JButton("Enregistrer...");
		cancel = new JButton("Annuler...");
		
		EcouteurD ea = new EcouteurD(this);
		
		back.addActionListener(ea);
		save.addActionListener(ea);
		cancel.addActionListener(ea);
		
		nom_e = new JLabel("Nom Expéditeur: ");
		prenom_e = new JLabel("Prenom Expéditeur: ");
		sexe_e = new JLabel("Sexe Expéditeur: ");
		ville_e = new JLabel("Ville Expéditeur: ");
		numero_e = new JLabel("Numéro Expéditeur: ");
		
		nom_r = new JLabel("Nom Recepteur: ");
		prenom_r = new JLabel("Prenom Recepteur: ");
		sexe_r = new JLabel("Sexe Recepteur: ");
		ville_r = new JLabel("Ville Recepteur: ");
		numero_r = new JLabel("Numéro Recepteur: ");
		
		ident = new JLabel("Identification du colis: ");
		passe = new JLabel("Mot de passe du colis: ");
		
		tIdent = new JTextField(30);
		tPasse = new JPasswordField(30);
		
		tNom_e = new JTextField(30);
		tPrenom_e = new JTextField(30);
		tSexe_e.addItem("M");
		tSexe_e.addItem("F");
		tVille_e = new JTextField(30);
		tNumero_e = new JTextField(30);
		tNom_r = new JTextField(30);
		tPrenom_r = new JTextField(30);
		tSexe_r.addItem("M");
		tSexe_r.addItem("F");
		tVille_r = new JTextField(30);
		tNumero_r = new JTextField(30);
		
		contentForm.setLayout(new GridLayout(1,1,20,20));

		contentForm0.setLayout(new GridLayout(2,2,1,1));

		contentForm0.add(ident);
		contentForm0.add(tIdent);
		contentForm0.add(passe);
		contentForm0.add(tPasse);
		
		contentForm1.setLayout(new GridLayout(5,2,1,1));

		contentForm1.add(nom_e);
		contentForm1.add(tNom_e);
		contentForm1.add(prenom_e);
		contentForm1.add(tPrenom_e);
		contentForm1.add(sexe_e);
		contentForm1.add(tSexe_e);
		contentForm1.add(ville_e);
		contentForm1.add(tVille_e);
		contentForm1.add(numero_e);
		contentForm1.add(tNumero_e);

		contentForm2.setLayout(new GridLayout(5,2,1,1));

		contentForm2.add(nom_r);
		contentForm2.add(tNom_r);
		contentForm2.add(prenom_r);
		contentForm2.add(tPrenom_r);
		contentForm2.add(sexe_r);
		contentForm2.add(tSexe_r);
		contentForm2.add(ville_r);
		contentForm2.add(tVille_r);
		contentForm2.add(numero_r);
		contentForm2.add(tNumero_r);
		
		contentForm3.setLayout(new GridLayout(1,2,1,1));

		contentForm3.add(save);
		contentForm3.add(cancel);

		content.add(contentForm0);
		content.add(contentForm1);
		content.add(contentForm2);
		content.add(contentForm3);

		
		content.add(contentButton);
		// content.setBackground(Color.green);
		// content.add(back,BorderLayout.SOUTH);
		
		this.setContentPane(content);
		this.setTitle("Effectuer un depôt");
		//this.setLocationRelativeTo(null);
        //this.setResizable(false);
		this.setVisible(true);
		this.setSize(750,450);
	}
	
	public static void main(String[] args) {
		new Depot();
	}

}
