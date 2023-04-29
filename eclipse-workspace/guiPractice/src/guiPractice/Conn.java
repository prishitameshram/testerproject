package guiPractice;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    PreparedStatement pst;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "prishita");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}