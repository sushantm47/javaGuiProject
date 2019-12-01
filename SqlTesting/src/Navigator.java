import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Navigator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigator frame = new Navigator();
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
	public Navigator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780	, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmployeeDetails = new JButton("Employee details");
		btnEmployeeDetails.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewEmp n1=new ViewEmp();
				n1.setVisible(true);
			}
		});
		btnEmployeeDetails.setBounds(178, 275, 412, 41);
		contentPane.add(btnEmployeeDetails);
		
		JButton btnVehicleDetails = new JButton("Vehicle details");
		btnVehicleDetails.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnVehicleDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewVehicle n1=new ViewVehicle();
				n1.setVisible(true);
			}
		});
		btnVehicleDetails.setBounds(178, 433, 412, 46);
		contentPane.add(btnVehicleDetails);
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddVehicle a =new AddVehicle();
				a.setVisible(true);
			}
		});
		btnAddVehicle.setBounds(178, 491, 412, 41);
		contentPane.add(btnAddVehicle);
		
		JButton btnFinance = new JButton("Search");
		btnFinance.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinance.setBounds(178, 545, 412, 46);
		contentPane.add(btnFinance);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddEmployee n1=new AddEmployee();
				n1.setVisible(true);
			}
		});
		btnAddEmployee.setBounds(178, 328, 412, 41);
		contentPane.add(btnAddEmployee);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnDeleteEmployee.setBounds(178, 381, 412, 41);
		contentPane.add(btnDeleteEmployee);
	}
}
