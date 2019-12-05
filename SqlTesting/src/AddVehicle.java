import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
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
	private JLabel Img;
	public AddVehicle() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Model");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(83, 398, 58, 15);
		contentPane.add(lblName);
		
		JLabel lblPhonenum = new JLabel("PhoneNum");
		lblPhonenum.setForeground(Color.WHITE);
		lblPhonenum.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhonenum.setBounds(79, 517, 103, 30);
		contentPane.add(lblPhonenum);
		
		JLabel lblAddress = new JLabel("Type Of Vehicle");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddress.setBounds(79, 647, 151, 28);
		contentPane.add(lblAddress);
		
		JLabel lblSpecializes = new JLabel("CurrentOdo");
		lblSpecializes.setForeground(Color.WHITE);
		lblSpecializes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSpecializes.setBounds(79, 600, 103, 35);
		contentPane.add(lblSpecializes);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtname.setBounds(263, 389, 135, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtph = new JTextField();
		txtph.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtph.setColumns(10);
		txtph.setBounds(263, 518, 135, 29);
		contentPane.add(txtph);
		
		txtodo2 = new JTextField();
		txtodo2.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtodo2.setColumns(10);
		txtodo2.setBounds(263, 602, 135, 32);
		contentPane.add(txtodo2);
		
		txttypvehicle = new JTextField();
		txttypvehicle.setFont(new Font("Dialog", Font.PLAIN, 16));
		txttypvehicle.setColumns(10);
		txttypvehicle.setBounds(263, 646, 135, 29);
		contentPane.add(txttypvehicle);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.GRAY);
		btnAdd.setFont(new Font("Fira Sans Book", Font.BOLD, 18));
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
		btnAdd.setBounds(83, 687, 315, 42);
		contentPane.add(btnAdd);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=Navigator.getInstance();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(314, 12, 105, 25);
		contentPane.add(btnHome);
		
		lblRegistration = new JLabel("Registration Number");
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistration.setBounds(83, 440, 176, 15);
		contentPane.add(lblRegistration);
		
		txtRegNum = new JTextField();
		txtRegNum.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtRegNum.setColumns(10);
		txtRegNum.setBounds(263, 433, 135, 31);
		contentPane.add(txtRegNum);
		
		txtCust = new JTextField();
		txtCust.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCust.setColumns(10);
		txtCust.setBounds(263, 476, 135, 30);
		contentPane.add(txtCust);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setForeground(Color.WHITE);
		lblCustomer.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCustomer.setBounds(79, 476, 103, 29);
		contentPane.add(lblCustomer);
		
		lblLastserviceodo = new JLabel("LastServiceOdo");
		lblLastserviceodo.setForeground(Color.WHITE);
		lblLastserviceodo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLastserviceodo.setBounds(79, 560, 151, 28);
		contentPane.add(lblLastserviceodo);
		
		txtlodo1 = new JTextField();
		txtlodo1.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtlodo1.setColumns(10);
		txtlodo1.setBounds(263, 559, 135, 31);
		contentPane.add(txtlodo1);
		
		Img = new JLabel("");
		Img.setBounds(100, 106, 257, 218);
		Image img=new ImageIcon(this.getClass().getResource("/rsz_addvehicle.png")).getImage();
		Img.setIcon(new ImageIcon(img));
		contentPane.add(Img);
	}
}
