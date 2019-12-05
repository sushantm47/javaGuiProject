import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textVEhicle;
	private JTextField textField_1;
	private JLabel lblVehicle;
	private JLabel lblEmployee;
	private JLabel lblCustomer;
	private JTextField txtCust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	private JButton btnEmployee;
	private JButton btnHome;
	private JButton button;
	public Search() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 299, 734, 97);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textVEhicle = new JTextField();
		textVEhicle.setBounds(317, 173, 182, 29);
		contentPane.add(textVEhicle);
		textVEhicle.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(317, 214, 182, 29);
		contentPane.add(textField_1);
		
		lblVehicle = new JLabel("Vehicle");
		lblVehicle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVehicle.setBounds(36, 173, 98, 15);
		contentPane.add(lblVehicle);
		
		lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEmployee.setBounds(36, 216, 121, 15);
		contentPane.add(lblEmployee);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCustomer.setBounds(36, 134, 121, 15);
		contentPane.add(lblCustomer);
		
		txtCust = new JTextField();
		txtCust.setColumns(10);
		txtCust.setBounds(317, 134, 182, 29);
		contentPane.add(txtCust);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="Select * from Vehicle  where Customer='"+txtCust.getText()+"'";

				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(querry);
					/*psst.setString(1,txtNewId.getText());
					psst.setString(2,txtPhoneNumber.getText());
					psst.setString(3,txtCurrentName.getText());*/
					psst.execute();
					ResultSet rss  = psst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rss));
					

					JOptionPane.showMessageDialog(null,"DATA mOdified");
					
					
					
					
					dispose();
					ViewEmp n1=new ViewEmp();
					n1.setVisible(true);
					
					
					
					psst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(617, 131, 146, 25);
		contentPane.add(btnNewButton);
		
		btnEmployee = new JButton("Search");
		btnEmployee.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="Select * from Employee  where name='"+textField_1.getText()+"'";

				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(querry);
					/*psst.setString(1,txtNewId.getText());
					psst.setString(2,txtPhoneNumber.getText());
					psst.setString(3,txtCurrentName.getText());*/
					psst.execute();
					ResultSet rss  = psst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rss));
				psst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnEmployee.setBounds(617, 216, 146, 25);
		contentPane.add(btnEmployee);
		
		btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

				Navigator n1=Navigator.getInstance();
				n1.setVisible(true);
				
			}
		});
		btnHome.setBounds(617, 452, 150, 25);
		contentPane.add(btnHome);
		
		button = new JButton("Search");
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="Select * from vehicle  where model='"+textVEhicle.getText()+"'";

				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(querry);
					/*psst.setString(1,txtNewId.getText());
					psst.setString(2,txtPhoneNumber.getText());
					psst.setString(3,txtCurrentName.getText());*/
					psst.execute();
					ResultSet rss  = psst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rss));
				psst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setBounds(617, 173, 146, 25);
		contentPane.add(button);
	}
}
