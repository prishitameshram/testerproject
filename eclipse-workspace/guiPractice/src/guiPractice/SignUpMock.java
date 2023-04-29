package guiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Choice;

public class SignUpMock extends JFrame implements ActionListener{

	private JPanel contentPane;
	JTextField nametf, passwordtf2, usernametf2, uniqueIdtf;
	JButton signupbtn, backbttn;
	Choice createchoice;
	
	public static void main(String[] args) {
		new SignUpMock();
	}

	
	public SignUpMock() {
		setFont(new Font("Arial Black", Font.BOLD, 12));
		setTitle("Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1126, 744);
		// Center the frame on the screen
        setLocationRelativeTo(null);
		//setBounds(100, 100, 1126, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 243, 227));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBounds(672, 217, 95, 22);
		contentPane.add(name);
		
		JLabel password_1 = new JLabel("Password");
		password_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password_1.setBounds(672, 329, 95, 22);
		contentPane.add(password_1);
		
		JLabel uniqueId = new JLabel("Unique ID");
		uniqueId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		uniqueId.setBounds(672, 372, 95, 37);
		contentPane.add(uniqueId);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 220, 149));
		panel.setBounds(0, 0, 602, 719);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignUpMock.class.getResource("/images/signup logo.png")));
		lblNewLabel_2.setBounds(44, 45, 467, 301);
		panel.add(lblNewLabel_2);
		
		JLabel welcometxt = new JLabel("Ooops !!!");
		welcometxt.setBounds(113, 341, 376, 78);
		panel.add(welcometxt);
		welcometxt.setHorizontalAlignment(SwingConstants.CENTER);
		welcometxt.setForeground(new Color(0, 0, 0));
		welcometxt.setFont(new Font("Segoe Script", Font.BOLD, 44));
		welcometxt.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Looks like you haven’t created an account yet.");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(102, 415, 406, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Please fill in the details to");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(190, 447, 225, 22);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("become a part of our community.");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(125, 479, 363, 22);
		panel.add(lblNewLabel_3_2);
		
		backbttn = new JButton("Back");
		backbttn.setBackground(new Color(255, 255, 255));
		backbttn.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		backbttn.setBounds(895, 456, 151, 37);
		contentPane.add(backbttn);
		backbttn.addActionListener(this);
		
		signupbtn = new JButton("Sign Up");
		signupbtn.setBackground(new Color(255, 255, 255));
		signupbtn.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		signupbtn.setBounds(672, 456, 151, 37);
		contentPane.add(signupbtn);
		signupbtn.addActionListener(this);
		
		nametf = new JTextField();
		nametf.setBounds(817, 217, 198, 26);
		contentPane.add(nametf);
		nametf.setColumns(10);
		
		passwordtf2 = new JTextField();
		passwordtf2.setColumns(10);
		passwordtf2.setBounds(817, 325, 198, 26);
		contentPane.add(passwordtf2);
		
		JLabel username_1 = new JLabel("Username");
		username_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		username_1.setBounds(672, 273, 95, 22);
		contentPane.add(username_1);
		
		usernametf2 = new JTextField();
		usernametf2.setColumns(10);
		usernametf2.setBounds(817, 273, 198, 26);
		contentPane.add(usernametf2);
		
		uniqueIdtf = new JTextField();
		uniqueIdtf.setColumns(10);
		uniqueIdtf.setBounds(817, 383, 198, 26);
		contentPane.add(uniqueIdtf);
		
		JLabel createAs = new JLabel("Create As");
		createAs.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		createAs.setBounds(672, 168, 95, 22);
		contentPane.add(createAs);
		
		createchoice = new Choice();
		createchoice.add("");
		createchoice.add("Admin");
		createchoice.add("Tester");
		createchoice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		createchoice.setBounds(817, 168, 198, 18);
		contentPane.add(createchoice);
		
		//adding condition for the unique id
				/*uniqueIdtf.addFocusListener(new FocusListener() {
		            @Override
		            public void focusGained(FocusEvent fe) {}
		            
		            @Override
		            public void focusLost(FocusEvent fe) {
		                try {
		                    Conn c  = new Conn();
		                    ResultSet rs = c.s.executeQuery("select * from login where uniquie_id = '"+uniqueIdtf.getText()+"'");
		                    while(rs.next()) {
		                    	nametf.setText(rs.getString("name"));
		                    }
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        }); */
		
		createchoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = createchoice.getSelectedItem();
                if (user.equals("Tester")) {
                	uniqueId.setVisible(true);
                	uniqueIdtf.setVisible(true);
                	//nametf.setEditable(false);
                	
                } else {
                	uniqueId.setVisible(false);
                	uniqueIdtf.setVisible(false);
                	//nametf.setEditable(true);
                }
            }
        });
		
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == signupbtn) {
            String atype = createchoice.getSelectedItem();
            String susername = usernametf2.getText();
            String sname = nametf.getText();
            String spassword = passwordtf2.getText();
            String sid = uniqueIdtf.getText();
           
            try {
                Conn c = new Conn();
                
                /*String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+sid+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where uniquie_id = '"+sid+"'";
                } */
        
                
                String query = "insert into signin values('"+sid+"', '"+susername+"','"+sname+"', '"+spassword+"', '"+atype+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
                
            } catch (Exception e) {
                e.printStackTrace();
            } 
        } else if (ae.getSource() == backbttn) {
            setVisible(false);
            
            new Login();
        }
		
	}
}
