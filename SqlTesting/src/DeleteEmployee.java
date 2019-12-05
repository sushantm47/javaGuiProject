import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DeleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnShow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		Connection connection=null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(311, 342, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelte = new JButton("DELTE");
		btnDelte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();   
				int rand_int1 = rand.nextInt(1000);
				int rand_pswd = rand.nextInt(1000);
				try {
					String querry="DELETE FROM Employee WHERE name=?";
					PreparedStatement psst;
					psst = connection.prepareStatement(querry);
					psst.setString(1,textField.getText());
					 psst.execute();
					

					JOptionPane.showMessageDialog(null,"Data Deleted");
					
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
		btnDelte.setBounds(466, 339, 105, 25);
		contentPane.add(btnDelte);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(201, 344, 92, 15);
		contentPane.add(lblEmployee);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 101, 684, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query ="select * from Employee";
				PreparedStatement psst;
				try {
					psst = connection.prepareStatement(query);
					ResultSet rss  = psst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rss));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShow.setBounds(42, 29, 105, 25);
		contentPane.add(btnShow);
	}
}
