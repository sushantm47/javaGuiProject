import java.awt.BorderLayout; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
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
import java.awt.Image;
import java.awt.Color;


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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 321, 747, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Display");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
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
		btnAdd.setBounds(31, 257, 164, 37);
		
		
		contentPane.add(btnAdd);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(Color.WHITE);
		btnHome.setIcon(new ImageIcon("/home/vettel/Downloads/rsz_home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=Navigator.getInstance();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(647, 47, 107, 37);
		contentPane.add(btnHome);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 14));
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
					

					JOptionPane.showMessageDialog(null,"DATA Updated");
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
		btnUpdate.setBounds(326, 654, 164, 43);
		contentPane.add(btnUpdate);
		
		txtCurrentName = new JTextField();
		txtCurrentName.setText("Model Name");
		txtCurrentName.setBounds(96, 583, 175, 43);
		contentPane.add(txtCurrentName);
		txtCurrentName.setColumns(10);
		
		txtUpdatingAttribute = new JTextField();
		txtUpdatingAttribute.setText("Updating Attribute");
		txtUpdatingAttribute.setColumns(10);
		txtUpdatingAttribute.setBounds(326, 583, 164, 43);
		contentPane.add(txtUpdatingAttribute);
		
		txtUpdatingData = new JTextField();
		txtUpdatingData.setText("Updating Data");
		txtUpdatingData.setColumns(10);
		txtUpdatingData.setBounds(530, 583, 164, 43);
		contentPane.add(txtUpdatingData);
		
		JLabel lblNewLabel = new JLabel("UPDATE VEHICLE DATA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(300, 518, 259, 53);
		contentPane.add(lblNewLabel);
		
		JLabel Img = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/rs_Tesla.png")).getImage();
		Img.setIcon(new ImageIcon(img));
		Img.setBounds(300, 47, 245, 243);
		contentPane.add(Img);
	}
}
