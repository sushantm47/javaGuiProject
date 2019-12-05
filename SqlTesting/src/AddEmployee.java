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
	private JLabel Img;
	public AddEmployee() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(74, 433, 65, 31);
		contentPane.add(lblName);
		
		JLabel lblPhonenum = new JLabel("Phone Num");
		lblPhonenum.setForeground(Color.WHITE);
		lblPhonenum.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhonenum.setBounds(74, 480, 93, 32);
		contentPane.add(lblPhonenum);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddress.setBounds(74, 573, 103, 31);
		contentPane.add(lblAddress);
		
		JLabel lblSpecializes = new JLabel("Specializes");
		lblSpecializes.setForeground(Color.WHITE);
		lblSpecializes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSpecializes.setBounds(74, 524, 103, 37);
		contentPane.add(lblSpecializes);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtname.setBounds(171, 431, 207, 33);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtph = new JTextField();
		txtph.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtph.setColumns(10);
		txtph.setBounds(171, 476, 207, 36);
		contentPane.add(txtph);
		
		txtspl = new JTextField();
		txtspl.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtspl.setColumns(10);
		txtspl.setBounds(171, 524, 207, 33);
		contentPane.add(txtspl);
		
		txtadd = new JTextField();
		txtadd.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtadd.setColumns(10);
		txtadd.setBounds(171, 573, 207, 31);
		contentPane.add(txtadd);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GRAY);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Fira Sans Book", Font.BOLD, 23));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();   
				int rand_int1 = rand.nextInt(10);
				int rand_pswd = rand.nextInt(10000);
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
					Navigator n1=new Navigator();
					n1.setVisible(true);
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				}
		});
		btnAdd.setBounds(74, 628, 304, 50);
		contentPane.add(btnAdd);
		
		btnHome = new JButton("HOME");
		btnHome.setIcon(new ImageIcon("/home/vettel/Desktop/projects/college/java/SqlTesting/Images/rsz_home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=Navigator.getInstance();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(317, 12, 103, 37);
		contentPane.add(btnHome);
		
		Img = new JLabel("");
		Img.setBounds(98, 73, 261, 324);
		Image img=new ImageIcon(this.getClass().getResource("/rsz_userplus.png")).getImage();
		Img.setIcon(new ImageIcon(img));
		contentPane.add(Img);
	}
}
