package agent;

import java.sql.*;

public class ConnectDB {
	
	public Connection db;
	public Statement st;

	public ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.db = DriverManager.getConnection("jdbc:mysql://localhost/agence","root","");
			this.st = db.createStatement();
			System.out.println("Connexion réussie!!!");
		}catch(ClassNotFoundException e) {
			System.out.println("Erreur du Driver: "+e);
		}catch(SQLException e) {
			System.out.println("Erreur Database: "+e);
		}
	}
	
	public ResultSet query(String rq) {
		try {
			System.out.println("Success!");
			return st.executeQuery(rq);
		}catch(SQLException e) {
			System.out.println("Erreur: "+e);
			return null;
		}
	}
	
	public int sql(String rq) {
		try {
			System.out.println("Success!");
			return st.executeUpdate(rq);
		}catch(SQLException e) {
			System.out.println("Erreur: "+e);
			return 0;
		}
	}
	
	public static void main(String[] args) {
		new ConnectDB();
	}
}