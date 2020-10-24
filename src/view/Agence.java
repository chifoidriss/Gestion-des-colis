package view;

import java.awt.*;
import javax.swing.*;

import listenner.EcouteurA;

public class Agence extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton depot,liste,retrait,search;
	public JPanel content,contentButton,contentRech;
	public JLabel labelRech;
	public JTextField rech;
	public JMenuBar menu;
	public JMenu fichier,operation,about;
	public JMenuItem item1,item2,itemA,itemB,itemx,itemy;
	
	
	public Agence() {
		content = new JPanel();
		contentButton = new JPanel();
		contentRech = new JPanel();
		menu = new JMenuBar();
		
		depot = new JButton("Depôt");
		liste = new JButton("Liste des colis");
		retrait = new JButton("Retrait");
		search = new JButton("Rechercher");
		labelRech = new JLabel("Entrer l'identifiant à rechercher...");
		rech = new JTextField(32);
		
		fichier = new JMenu("Fichier");
		operation = new JMenu("Opération");
		about = new JMenu("A propos");
		item1 = new JMenuItem("Ouvrir");
		item2 = new JMenuItem("Exit");
		itemA = new JMenuItem("Aller en ligne");
		itemB = new JMenuItem("A propos de GesCol");
		itemx = new JMenuItem("Depôt");
		itemy = new JMenuItem("Retrait");
		
		fichier.add(item1);
		fichier.add(item2);
		operation.add(itemx);
		operation.add(itemy);
		about.add(itemA);
		about.add(itemB);
		menu.add(fichier);
		menu.add(operation);
		menu.add(about);
		menu.setBackground(Color.green);
		
		depot.addActionListener(new EcouteurA(this));
		liste.addActionListener(new EcouteurA(this));
		retrait.addActionListener(new EcouteurA(this));
		search.addActionListener(new EcouteurA(this));
		
		contentButton.setLayout(new GridLayout(1,3,5,5));
		contentButton.add(depot);
		contentButton.add(liste);
		contentButton.add(retrait);
		
		contentRech.setLayout(new GridLayout(3,1,5,5));
		contentRech.add(labelRech);
		contentRech.add(rech);
		contentRech.add(search);
		
		
		content.add("North",contentRech);
		content.add(new JLabel("___________________________________________________"));
		content.add(new JLabel("___________________________________________________"));
		content.add("Center",contentButton);
		
		this.setJMenuBar(menu);
		this.setContentPane(content);
		this.setSize(500,500);
		this.setTitle("Programme de Gestion des colis.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
            new Agence();
	}

}
