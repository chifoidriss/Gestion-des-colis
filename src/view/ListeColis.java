package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import javax.swing.*;

import agent.*;
import listenner.*;

@SuppressWarnings("serial")
public class ListeColis extends JFrame {

	public static int t =100;
	public int n;
	public JPanel content,contentData;
	public JLabel label;
	public JButton dat,info,del;
	public ConnectDB db;
	public ResultSet rs;
	public Graphics g;
	public JTextField zone,num,passe;
	
	public ListeColis() {
		content = new JPanel();
		dat = new JButton("Déjà rétiré!");
		dat.setEnabled(false);
		dat.setVisible(false);
		info = new JButton("About!");
		info.setVisible(false);
		del = new JButton("Supprimez?");
		del.setVisible(false);
		contentData = new JPanel();
		label = new JLabel("Aucun colis pour le moment!");
		zone = new JTextField(2);
		num = new JTextField(2);
		passe = new JTextField(2);
		zone.setVisible(false);
		num.setVisible(false);
		passe.setVisible(false);
		db = new ConnectDB();
		try {
			rs = db.query("SELECT * FROM colis");
			n=0;
			while(rs.next()) {
				
					label.setText("Identifiant colis: "+rs.getString("ident")+": ");
					zone.setText(rs.getString("id"));
					num.setText(rs.getString("id_r"));
					passe.setText(rs.getString("passe"));
					dat.setVisible(true);
					info.setVisible(true);
					del.setVisible(true);
					if(rs.getInt("etat")==0) {
						dat = new JButton("Retirer ce colis!");
						dat.setEnabled(true);
					}
		
				/*
					content.add(new JLabel(rs.getString("ident")));
					if(rs.getInt("etat")==0)
						content.add(new JButton("Retirer ce colis!"));
					else
						content.add(new JButton("Déjà rétiré!"));
				*/
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur: "+e);
		}
		
		dat.addActionListener(new EcouteurL(this));
		info.addActionListener(new EcouteurL(this));
		del.addActionListener(new EcouteurL(this));
		
		content.setLayout(new FlowLayout(10));
		content.add(label);
		content.add(zone);
		content.add(num);
		content.add(passe);
		content.add(dat);
		content.add(info);
		content.add(del);
		
		this.setContentPane(content);
		this.setSize(500,600);
		this.setTitle("liste des colis");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ListeColis();
	}
}
