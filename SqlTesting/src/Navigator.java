import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewEmp n1=new ViewEmp();
				n1.setVisible(true);
			}
		});
		btnEmployeeDetails.setBounds(301, 137, 212, 25);
		contentPane.add(btnEmployeeDetails);
		
		JButton btnVehicleDetails = new JButton("Vehicle details");
		btnVehicleDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVehicleDetails.setBounds(301, 241, 212, 25);
		contentPane.add(btnVehicleDetails);
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setBounds(301, 304, 212, 25);
		contentPane.add(btnAddVehicle);
		
		JButton btnFinance = new JButton("Finance");
		btnFinance.setBounds(301, 355, 212, 25);
		contentPane.add(btnFinance);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddEmployee n1=new AddEmployee();
				n1.setVisible(true);
			}
		});
		btnAddEmployee.setBounds(301, 190, 212, 25);
		contentPane.add(btnAddEmployee);
	}
}
