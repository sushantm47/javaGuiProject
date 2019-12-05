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


public class ViewEmp extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmp frame = new ViewEmp();
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
	public ViewEmp() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800	, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 313, 747, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Display");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="select * from Employee";
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
		btnAdd.setBounds(30, 261, 122, 40);
		
		
		contentPane.add(btnAdd);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setIcon(new ImageIcon("/home/vettel/Downloads/rsz_home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Navigator n1=new Navigator();
				n1.setVisible(true);
			}
		});
		btnHome.setBounds(648, 47, 104, 40);
		contentPane.add(btnHome);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String querry ="update Employee set '"+txtUpdatingAttribute.getText()+"'='"+txtUpdatingData.getText()+"' where name=?";

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
					ViewEmp n1=new ViewEmp();
					n1.setVisible(true);
					psst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(344, 672, 164, 44);
		contentPane.add(btnUpdate);
		
		txtCurrentName = new JTextField();
		txtCurrentName.setText("Current Name");
		txtCurrentName.setBounds(114, 629, 175, 31);
		contentPane.add(txtCurrentName);
		txtCurrentName.setColumns(10);
		
		txtUpdatingAttribute = new JTextField();
		txtUpdatingAttribute.setText("Updating Attribute");
		txtUpdatingAttribute.setColumns(10);
		txtUpdatingAttribute.setBounds(344, 629, 164, 31);
		contentPane.add(txtUpdatingAttribute);
		
		txtUpdatingData = new JTextField();
		txtUpdatingData.setText("Updating Data");
		txtUpdatingData.setColumns(10);
		txtUpdatingData.setBounds(548, 629, 164, 31);
		contentPane.add(txtUpdatingData);
		
		JLabel lblNewLabel = new JLabel("UPDATE DATA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(355, 522, 198, 53);
		contentPane.add(lblNewLabel);
		
		JLabel Img = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/rs_Tesla.png")).getImage();
		Img.setIcon(new ImageIcon(img));
		Img.setBounds(290, 33, 274, 258);
		contentPane.add(Img);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Fira Sans Medium", Font.BOLD, 14));
		lblName.setBounds(176, 584, 58, 28);
		contentPane.add(lblName);
		
		JLabel lblUpdatingField = new JLabel("Updating Field");
		lblUpdatingField.setForeground(Color.LIGHT_GRAY);
		lblUpdatingField.setFont(new Font("Fira Sans Medium", Font.BOLD, 14));
		lblUpdatingField.setBounds(371, 586, 116, 25);
		contentPane.add(lblUpdatingField);
		
		JLabel lblUpdatingData = new JLabel("Updating Data");
		lblUpdatingData.setForeground(Color.LIGHT_GRAY);
		lblUpdatingData.setFont(new Font("Fira Sans Medium", Font.BOLD, 14));
		lblUpdatingData.setBounds(575, 586, 110, 28);
		contentPane.add(lblUpdatingData);
	}
}
