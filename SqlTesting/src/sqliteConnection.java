import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn =null;
	public static Connection dbConnector() {
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/vettel/Desktop/projects/college/java/SQLiteDb/OeeJava3.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection is successfull");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
