import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import java.util.Random;
public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtph;
	private JTextField txtspl;
	private JTextField txtadd;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	Connection connection=null;
	private JButton btnHome;
	public AddEmployee() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(38, 73, 58, 15);
		contentPane.add(lblName);
		
		JLabel lblPhonenum = new JLabel("PhoneNum");
		lblPhonenum.setBounds(38, 107, 103, 15);
		contentPane.add(lblPhonenum);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(38, 169, 103, 15);
		contentPane.add(lblAddress);
		
		JLabel lblSpecializes = new JLabel("specializes");
		lblSpecializes.setBounds(38, 134, 103, 23);
		contentPane.add(lblSpecializes);
		
		txtname = new JTextField();
		txtname.setBounds(135, 71, 124, 19);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtph = new JTextField();
		txtph.setColumns(10);
		txtph.setBounds(135, 103, 124, 19);
		contentPane.add(txtph);
		
		txtspl = new JTextField();
		txtspl.setColumns(10);
		txtspl.setBounds(135, 134, 124, 19);
		contentPane.add(txtspl);
		
		txtadd = new JTextField();
		txtadd.setColumns(10);
		txtadd.setBounds(135, 165, 207, 19);
		contentPane.add(txtadd);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();   
				int rand_int1 = rand.nextInt(10);
				int rand_pswd = rand.nextInt(1000);
				try {
					String querry ="insert into Employee (name,id,phoneNum,workeff,specializes,address) values(?,?,?,?,?,?)";
					PreparedStatement psst;
					psst = connection.prepareStatement(querry);
					psst.setString(1,txtname.getText());
					psst.setLong(2,rand_pswd);
					psst.setString(3,txtph.getText());
					psst.setLong(4,rand_int1);
					psst.setString(5,txtspl.getText());
					psst.setString(6,txtadd.getText());
					 psst.execute();
					

					JOptionPane.showMessageDialog(null,"DATA ADDED");
					
					psst.close();
					dispose();
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				}
		});
		btnAdd.setBounds(38, 203, 105, 25);
		contentPane.add(btnAdd);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=new Navigator();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(333, 12, 105, 25);
		contentPane.add(btnHome);
	}
}
