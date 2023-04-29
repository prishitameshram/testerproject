package guiPractice;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;


public class addframe extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextField nametfaf, usernametfaf, idtfaf;
	JTable displaytable;
	JButton addbttn, updatebttn, deletebttn;
	Conn c  = new Conn();
	ResultSet rs;
    PreparedStatement pst;
    DefaultTableModel tableModel;


	public static void main(String[] args) {
		new addframe();
	}

	
	public addframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1098, 762);
		// Center the frame on the screen
        setLocationRelativeTo(null);
		//setBounds(100, 100, 1098, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hey Admin!");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 38));
		lblNewLabel.setBounds(54, 21, 255, 50);
		contentPane.add(lblNewLabel);
		
		addbttn = new JButton("Add Tester");
		addbttn.setForeground(new Color(255, 255, 255));
		addbttn.setBackground(new Color(130, 130, 189));
		addbttn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		addbttn.setBounds(54, 100, 176, 40);
		contentPane.add(addbttn);
		addbttn.addActionListener(this);
		
		
		/*table = new JTable();
		table.setBounds(290, 595, 560, -302);
		contentPane.add(table); */
		
		updatebttn = new JButton("Update Tester");
		updatebttn.setForeground(new Color(255, 255, 255));
		updatebttn.setBackground(new Color(130, 130, 189));
		updatebttn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		updatebttn.setBounds(289, 100, 176, 40);
		contentPane.add(updatebttn);
		updatebttn.addActionListener(this);
		
		
		
		deletebttn = new JButton("Delete Tester");
		deletebttn.setBackground(new Color(130, 130, 189));
		deletebttn.setForeground(new Color(255, 255, 255));
		deletebttn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		deletebttn.setBounds(519, 100, 176, 40);
		contentPane.add(deletebttn);
		deletebttn.addActionListener(this);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(130, 130, 189));
		panel.setBounds(53, 168, 445, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(73, 64, 73, 32);
		panel.add(lblNewLabel_1);
		
		nametfaf = new JTextField();
		nametfaf.setBounds(229, 64, 160, 32);
		panel.add(nametfaf);
		nametfaf.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(73, 138, 113, 32);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Unique ID");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(73, 211, 113, 32);
		panel.add(lblNewLabel_1_2);
		
		usernametfaf = new JTextField();
		usernametfaf.setColumns(10);
		usernametfaf.setBounds(229, 138, 160, 32);
		panel.add(usernametfaf);
		
		idtfaf = new JTextField();
		idtfaf.setColumns(10);
		idtfaf.setBounds(229, 211, 160, 32);
		panel.add(idtfaf);
		
		/*displaytable = new JTable();
		displaytable.setBounds(553, 168, 481, 504);
		contentPane.add(displaytable); */
		
		// Create the JTable with 4 columns: Sr No, Name, Username, ID
		String[] columnNames = {"Sr No", "Name", "Username", "ID"};
		tableModel = new DefaultTableModel(columnNames, 0);
		JTable displaytable = new JTable(tableModel);

		// Set the column widths and alignment
		displaytable.getColumnModel().getColumn(0).setPreferredWidth(50); // Sr No
		displaytable.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
		displaytable.getColumnModel().getColumn(2).setPreferredWidth(150); // Username
		displaytable.getColumnModel().getColumn(3).setPreferredWidth(150); // ID
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		displaytable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		displaytable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		// Add the JTable to the content pane
		JScrollPane scrollPane = new JScrollPane(displaytable);
		scrollPane.setBounds(553, 168, 481, 504);
		contentPane.add(scrollPane);
		
		setVisible(true);
		
		table_load();
		
		
	}
	
	// Load data from the database into the JTable
	public void table_load() {
	    try {
	        pst = c.c.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY uniquie_id ASC) AS `Sr No`, name, username, uniquie_id AS `ID` FROM signin WHERE uniquie_id IS NOT NULL AND uniquie_id <> ''");
	        rs = pst.executeQuery();
	        tableModel.setRowCount(0);
	        while (rs.next()) {
	            Object[] row = {rs.getInt("Sr No"), rs.getString("name"), rs.getString("username"), rs.getString("ID")};
	            tableModel.addRow(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addbttn) {
		    try {
		        String name = nametfaf.getText();
		        String username = usernametfaf.getText();
		        String id = idtfaf.getText();

		        // Check if the unique id already exists
		        pst = c.c.prepareStatement("select count(*) from signin where uniquie_id = ?");
		        pst.setString(1, id);
		        ResultSet rs = pst.executeQuery();
		        rs.next();
		        int count = rs.getInt(1);

		        if (count > 0) {
		            // Unique id already exists, display message
		            JOptionPane.showMessageDialog(null, "The unique id already exists. Please enter a different unique id.");
		        } else {
		            // Unique id doesn't exist, insert new record
		            pst = c.c.prepareStatement("insert into signin (name, username, uniquie_id) values (?, ?, ?)");
		            pst.setString(1, name);
		            pst.setString(2, username);
		            pst.setString(3, id);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Record added successfully");
		            table_load();

		            // Clear the text fields
		            nametfaf.setText("");
		            usernametfaf.setText("");
		            idtfaf.setText("");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		} // Update button action
		else if (ae.getSource() == updatebttn) { 
	    	    try {
	    	        // Retrieve input values from the text fields
	    	        String name = nametfaf.getText().trim();
	    	        String username = usernametfaf.getText().trim();
	    	        String id = idtfaf.getText().trim();

	    	        // If any of the fields are empty, show an error message
	    	        if (name.equals("") || username.equals("") || id.equals("")) {
	    	            JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
	    	            return;
	    	        }

	    	        // Create the SQL query to update the row
	    	        String query = "UPDATE signin SET name = ?, username = ? WHERE uniquie_id = ?";

	    	        // Prepare the statement with the query
	    	        pst = c.c.prepareStatement(query);

	    	        // Set the parameters for the query
	    	        pst.setString(1, name);
	    	        pst.setString(2, username);
	    	        pst.setString(3, id);

	    	        // Execute the update query
	    	        pst.executeUpdate();

	    	        // Show a success message
	    	        JOptionPane.showMessageDialog(null, "Record updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	    	        table_load();

	    	        // Clear the text fields
	    	        nametfaf.setText("");
	    	        usernametfaf.setText("");
	    	        idtfaf.setText("");

	    	    } catch (SQLException ex) {
	    	        JOptionPane.showMessageDialog(null, "Error updating record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    	    }
	    	}
		// Delete button action

	    else if (ae.getSource() == deletebttn) {
	    	    try {
	    	        // Retrieve input values from the text fields
	    	        String id = idtfaf.getText().trim();

	    	        // If the ID field is empty, show an error message
	    	        if (id.equals("")) {
	    	            JOptionPane.showMessageDialog(null, "ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
	    	            return;
	    	        }

	    	        // Create the SQL query to delete the row
	    	        String query = "DELETE FROM signin WHERE uniquie_id = ?";

	    	        // Prepare the statement with the query
	    	        pst = c.c.prepareStatement(query);

	    	        // Set the parameter for the query
	    	        pst.setString(1, id);

	    	        // Execute the delete query
	    	        int result = pst.executeUpdate();

	    	        // If the query affected any rows, show a success message
	    	        if (result > 0) {
	    	            JOptionPane.showMessageDialog(null, "Record deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	    	            table_load();

	    	            // Clear the text fields
	    	            nametfaf.setText("");
	    	            usernametfaf.setText("");
	    	            idtfaf.setText("");
	    	        } else {
	    	            // If no rows were affected, show an error message
	    	            JOptionPane.showMessageDialog(null, "No record found with the given ID!", "Error", JOptionPane.ERROR_MESSAGE);
	    	        }

	    	    } catch (SQLException ex) {
	    	        JOptionPane.showMessageDialog(null, "Error deleting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    	    }
	    	}

		
	}
	
	
}
