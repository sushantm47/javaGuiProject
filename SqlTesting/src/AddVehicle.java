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
public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtph;
	private JTextField txtodo2;
	private JTextField txttypvehicle;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicle frame = new AddVehicle();
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
	private JLabel lblRegistration;
	private JTextField txtRegNum;
	private JTextField txtCust;
	private JLabel lblCustomer;
	private JLabel lblLastserviceodo;
	private JTextField txtlodo1;
	public AddVehicle() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Model");
		lblName.setBounds(38, 63, 58, 15);
		contentPane.add(lblName);
		
		JLabel lblPhonenum = new JLabel("PhoneNum");
		lblPhonenum.setBounds(38, 187, 103, 15);
		contentPane.add(lblPhonenum);
		
		JLabel lblAddress = new JLabel("Type Of Vehicle");
		lblAddress.setBounds(38, 317, 103, 15);
		contentPane.add(lblAddress);
		
		JLabel lblSpecializes = new JLabel("CurrentOdo");
		lblSpecializes.setBounds(38, 270, 103, 23);
		contentPane.add(lblSpecializes);
		
		txtname = new JTextField();
		txtname.setBounds(218, 61, 124, 19);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtph = new JTextField();
		txtph.setColumns(10);
		txtph.setBounds(218, 185, 124, 19);
		contentPane.add(txtph);
		
		txtodo2 = new JTextField();
		txtodo2.setColumns(10);
		txtodo2.setBounds(218, 272, 124, 19);
		contentPane.add(txtodo2);
		
		txttypvehicle = new JTextField();
		txttypvehicle.setColumns(10);
		txttypvehicle.setBounds(218, 313, 124, 19);
		contentPane.add(txttypvehicle);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();   
				int rand_int1 = rand.nextInt(1000);
				int rand_pswd = rand.nextInt(1000);
				try {
					String querry ="insert into Vehicle (model,regNum,Customer,phoneNum,LastServiceOdo,CurrentOdo,typeOfVehicle,ServiceCharge) values(?,?,?,?,?,?,?,?)";
					PreparedStatement psst;
					psst = connection.prepareStatement(querry);
					psst.setString(1,txtname.getText());
					psst.setString(2,txtRegNum.getText());
					psst.setString(3,txtCust.getText());
					psst.setString(4,txtph.getText());
					psst.setString(5,txtlodo1.getText());
					psst.setString(6,txtodo2.getText());
					psst.setString(7,txttypvehicle.getText());
					psst.setLong(8,rand_int1);
					 psst.execute();
					

					JOptionPane.showMessageDialog(null,"DATA ADDED");
					
					psst.close();
					dispose();
					Navigator n1=new Navigator();
					n1.setVisible(true);
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				}
		});
		btnAdd.setBounds(38, 361, 105, 25);
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
		
		lblRegistration = new JLabel("Registration Number");
		lblRegistration.setBounds(38, 104, 136, 15);
		contentPane.add(lblRegistration);
		
		txtRegNum = new JTextField();
		txtRegNum.setColumns(10);
		txtRegNum.setBounds(218, 102, 124, 19);
		contentPane.add(txtRegNum);
		
		txtCust = new JTextField();
		txtCust.setColumns(10);
		txtCust.setBounds(218, 144, 124, 19);
		contentPane.add(txtCust);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(38, 146, 103, 15);
		contentPane.add(lblCustomer);
		
		lblLastserviceodo = new JLabel("LastServiceOdo");
		lblLastserviceodo.setBounds(38, 230, 103, 15);
		contentPane.add(lblLastserviceodo);
		
		txtlodo1 = new JTextField();
		txtlodo1.setColumns(10);
		txtlodo1.setBounds(218, 228, 124, 19);
		contentPane.add(txtlodo1);
	}
}
