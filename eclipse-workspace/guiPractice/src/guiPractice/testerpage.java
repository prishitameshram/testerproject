package guiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testerpage extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		new testerpage();
	}

	
	public testerpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1218, 754);
		// Center the frame on the screen
        setLocationRelativeTo(null);
		//setBounds(100, 100, 1218, 754);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorry!");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 46));
		lblNewLabel.setBounds(537, 354, 148, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Looks like we are high on load. ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(448, 445, 403, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("We appreciate your patience. ");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(461, 495, 403, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("We will get back to you as soon as possible.");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(391, 545, 484, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblDontWorry = new JLabel("Don’t worry!");
		lblDontWorry.setFont(new Font("Segoe Script", Font.PLAIN, 26));
		lblDontWorry.setBounds(461, 595, 177, 60);
		contentPane.add(lblDontWorry);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(testerpage.class.getResource("/images/gif.gif")));
		lblNewLabel_2.setBounds(341, 10, 548, 368);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				new Login();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 173, 91));
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 24));
		btnNewButton.setBounds(658, 603, 104, 40);
		contentPane.add(btnNewButton);
		
		setVisible(true);
	}
}
