import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Example extends JFrame {

	private JPanel contentPane;
	private JTextField txtExperiment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
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
	public Example() {
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
