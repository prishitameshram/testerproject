package guiPractice;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener { //

	JPanel contentPane;
	JTextField usernametf, passwordtf;
	JButton logInbttn, signUpbttn;
    Choice choice;
    
    Login() {
        super("Login Page");
        setFont(new Font("Arial Black", Font.BOLD, 12));
		setTitle("Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1126, 744);
		// Center the frame on the screen
        setLocationRelativeTo(null);
		//setBounds(100, 100, 1126, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		username.setBounds(672, 217, 95, 22);
		contentPane.add(username);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setBounds(672, 269, 95, 22);
		contentPane.add(password);
		
		JLabel loginAs = new JLabel("Login As");
		loginAs.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		loginAs.setBounds(672, 339, 95, 37);
		contentPane.add(loginAs);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(111, 107, 148));
		panel.setBounds(0, 0, 602, 719);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/logo welcome.png")));
		lblNewLabel_2.setBounds(41, 45, 467, 301);
		panel.add(lblNewLabel_2);
		
		JLabel welcometxt = new JLabel("Welcome Back !");
		welcometxt.setBounds(113, 341, 376, 78);
		panel.add(welcometxt);
		welcometxt.setHorizontalAlignment(SwingConstants.CENTER);
		welcometxt.setForeground(new Color(255, 255, 255));
		welcometxt.setFont(new Font("Segoe Script", Font.BOLD, 44));
		welcometxt.setBackground(new Color(0, 128, 64));
		
		JLabel lblNewLabel_3 = new JLabel("We have been waiting for you. ");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(166, 415, 274, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thank You for becoming our tester.");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(142, 447, 314, 22);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("We have some new features. ");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(180, 479, 274, 22);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Do check them out!");
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblNewLabel_3_2_1.setBounds(202, 511, 225, 22);
		panel.add(lblNewLabel_3_2_1);
		
		signUpbttn = new JButton("Sign Up");
		signUpbttn.setBackground(new Color(255, 255, 255));
		signUpbttn.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		signUpbttn.setBounds(905, 435, 151, 37);
		contentPane.add(signUpbttn);
		signUpbttn.addActionListener(this);
		
		logInbttn = new JButton("Log In");
		logInbttn.setBackground(new Color(255, 255, 255));
		logInbttn.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		logInbttn.setBounds(682, 435, 151, 37);
		contentPane.add(logInbttn);
		logInbttn.addActionListener(this);
		
		usernametf = new JTextField();
		usernametf.setBounds(817, 217, 198, 26);
		contentPane.add(usernametf);
		usernametf.setColumns(10);
		
		passwordtf = new JTextField();
		passwordtf.setColumns(10);
		passwordtf.setBounds(817, 269, 198, 26);
		contentPane.add(passwordtf);
		
		choice = new Choice();
		choice.add("");
		choice.add("Admin");
		choice.add("Tester");
		choice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		choice.setBounds(817, 349, 198, 20);
		contentPane.add(choice);
		
		
		setVisible(true);
       
    }
    
  //adding action
	
  	public void actionPerformed(ActionEvent ae) {
  		if (ae.getSource() == logInbttn) {
  		    String susername = usernametf.getText();
  		    String spassword = passwordtf.getText();
  		    String user = choice.getSelectedItem().toString(); // fixed: added toString()

  		    try {
  		        Conn c = new Conn();
  		        String query;
  		        ResultSet rs;
  		        ResultSet rsAdmin;

  		        if (user.equals("Tester")) { // fixed: added condition to check for Tester user
  		            query = "select * from signin where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
  		            rs = c.s.executeQuery(query);

  		            if (rs.next()) {
  		                String id = rs.getString("uniquie_id");
  		                setVisible(false);
  		                new testerpage();
  		            } else {
  		                JOptionPane.showMessageDialog(null, "Invalid Login");
  		                usernametf.setText("");
  		                passwordtf.setText("");
  		            }
  		        } else if (user.equals("Admin")) { // fixed: added condition to check for Admin user
  		            query = "select * from signin where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
  		            rsAdmin = c.s.executeQuery(query);

  		            if (rsAdmin.next()) {
  		                setVisible(false);
  		                new addframe();
  		            } else {
  		                JOptionPane.showMessageDialog(null, "Invalid Login");
  		                usernametf.setText("");
  		                passwordtf.setText("");
  		            }
  		        } else {
  		            JOptionPane.showMessageDialog(null, "Invalid User");
  		            usernametf.setText("");
  		            passwordtf.setText("");
  		        }
  		    } catch (Exception e) {
  		        e.printStackTrace();
  		    }
          } else if (ae.getSource() == signUpbttn) {
              setVisible(false);
              
              new SignUpMock();
          }
  	}
  	
    public static void main(String[] args) {
        new Login();
    }
}
