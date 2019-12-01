import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblName.setBounds(86, 417, 58, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblPassword.setBounds(86, 492, 105, 15);
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Ubuntu", Font.BOLD, 18));
		txtUserName.setBounds(196, 408, 180, 34);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Ubuntu", Font.BOLD, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(196, 483, 180, 34);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query ="select * from Employee where name=? and id=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtUserName.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					
					while(rs.next()) {
						count++;
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null,"Usernsame and password is correcct ");
						Navigator n1=new Navigator();
						n1.setVisible(true);
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null,"DUPLICATE Usernsame and password ");
					}
					else {
						JOptionPane.showMessageDialog(null,"Usernsame and password is incorrect");
					}

					rs.close();
					pst.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnLogin.setBounds(86, 565, 290, 42);
		frame.getContentPane().add(btnLogin);
	}
}
