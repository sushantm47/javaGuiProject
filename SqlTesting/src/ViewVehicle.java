import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;


public class ViewVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewVehicle frame = new ViewVehicle();
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
	private JTextField txtCurrentName;
	private JTextField txtUpdatingAttribute;
	private JTextField txtUpdatingData;
	public ViewVehicle() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800	, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 99, 747, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Display");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="select * from Vehicle";
				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(querry);
					ResultSet rss  = psst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rss));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(56, 47, 105, 25);
		
		
		contentPane.add(btnAdd);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=new Navigator();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(647, 47, 105, 25);
		contentPane.add(btnHome);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="update Vehicle set '"+txtUpdatingAttribute.getText()+"'='"+txtUpdatingData.getText()+"' where regNum=?";

				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(querry);

					psst.setString(1,txtCurrentName.getText());
					/*psst.setString(1,txtNewId.getText());
					psst.setString(2,txtPhoneNumber.getText());
					psst.setString(3,txtCurrentName.getText());*/
					psst.execute();
					

					JOptionPane.showMessageDialog(null,"DATA mOdified");
					dispose();
					ViewVehicle n1=new ViewVehicle();
					n1.setVisible(true);
					psst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(344, 507, 154, 25);
		contentPane.add(btnUpdate);
		
		txtCurrentName = new JTextField();
		txtCurrentName.setText("Model Name");
		txtCurrentName.setBounds(114, 436, 175, 31);
		contentPane.add(txtCurrentName);
		txtCurrentName.setColumns(10);
		
		txtUpdatingAttribute = new JTextField();
		txtUpdatingAttribute.setText("Updating Attribute");
		txtUpdatingAttribute.setColumns(10);
		txtUpdatingAttribute.setBounds(344, 436, 164, 31);
		contentPane.add(txtUpdatingAttribute);
		
		txtUpdatingData = new JTextField();
		txtUpdatingData.setText("Updating Data");
		txtUpdatingData.setColumns(10);
		txtUpdatingData.setBounds(548, 436, 164, 31);
		contentPane.add(txtUpdatingData);
		
		JLabel lblNewLabel = new JLabel("UPDATE VEHICLE DATA");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(323, 356, 259, 53);
		contentPane.add(lblNewLabel);
	}
}