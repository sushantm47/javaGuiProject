import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;

class Singleton extends JFrame {

	private JPanel contentPane;
	private JTextField txtExperiment;
	private static final Singleton se=new Singleton(); 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Singleton frame = new Singleton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Singleton getInstance() {
		return se;
	}
	
	
	public void setData(String S) {
		txtExperiment.setText(S);
		
	}
	
	private Singleton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setBounds(159, 83, 69, 52);
		contentPane.add(lblNewLabel);
		
		txtExperiment = new JTextField();
		txtExperiment.setText("Apple");
		txtExperiment.setBounds(159, 151, 124, 19);
		contentPane.add(txtExperiment);
		txtExperiment.setColumns(10);
	}
}



class Navigator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private static final Navigator se=new Navigator(); 
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
	public static Navigator getInstance() {
		return se;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Navigator() {
		setTitle("Navigator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780	, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmployeeDetails = new JButton("View Employee details");
		btnEmployeeDetails.setBackground(Color.WHITE);
		btnEmployeeDetails.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewEmp n1=new ViewEmp();
				n1.setVisible(true);
			}
		});
		btnEmployeeDetails.setBounds(178, 315, 412, 41);
		contentPane.add(btnEmployeeDetails);
		
		JButton btnVehicleDetails = new JButton("View Vehicle details");
		btnVehicleDetails.setBackground(Color.WHITE);
		btnVehicleDetails.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnVehicleDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewVehicle n1=new ViewVehicle();
				n1.setVisible(true);
			}
		});
		btnVehicleDetails.setBounds(178, 421, 412, 46);
		contentPane.add(btnVehicleDetails);
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setBackground(Color.WHITE);
		btnAddVehicle.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddVehicle a =new AddVehicle();
				a.setVisible(true);
			}
		});
		btnAddVehicle.setBounds(178, 479, 412, 41);
		contentPane.add(btnAddVehicle);
		
		JButton btnFinance = new JButton("Search");
		btnFinance.setBackground(Color.WHITE);
		btnFinance.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Search n1=new Search();
				n1.setVisible(true);	
			}
		});
		btnFinance.setBounds(178, 533, 412, 46);
		contentPane.add(btnFinance);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBackground(Color.WHITE);
		btnAddEmployee.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddEmployee n1=new AddEmployee();
				n1.setVisible(true);
			}
		});
		btnAddEmployee.setBounds(178, 368, 412, 41);
		contentPane.add(btnAddEmployee);
		
		JButton btnExit = new JButton(" EXIT");
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExit.setIcon(new ImageIcon("/home/vettel/Downloads/rsz_exit.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(557, 696, 156, 41);
		contentPane.add(btnExit);
		
		JLabel Img = new JLabel("");
		Img.setBounds(280, 12, 254, 297);
		Image img=new ImageIcon(this.getClass().getResource("/rs_Tesla.png")).getImage();
		Img.setIcon(new ImageIcon(img));
		contentPane.add(Img);
		
		/*JButton btnSingleton = new JButton("Singleton");
		btnSingleton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
				Singleton n1=Singleton.getInstance();
				//Singleton n2=Singleton.getInstance();
				n1.setVisible(true);
				//n1.setData("apple");
				
				//n2.setVisible(true);
			}
		});
		btnSingleton.setBounds(336, 603, 105, 25);
		contentPane.add(btnSingleton);
		
		JButton btnS = new JButton("S2");
		btnS.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Singleton n2=Singleton.getInstance();
			n2.setVisible(true);
			n2.setData("Pineapple");
		}
		});
		btnS.setBounds(336, 640, 105, 25);
		contentPane.add(btnS);
		
		JButton btnS_1 = new JButton("S3");
		btnS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Singleton n3=Singleton.getInstance();
				n3.setVisible(true);
			}
		});
		btnS_1.setBounds(336, 673, 105, 25);
		contentPane.add(btnS_1);*/
	}
}
