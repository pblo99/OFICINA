package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConexaoDAO {
    
    public Connection connectaBD(){
        
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/oficina?user=root&password=";
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ConexaoDAO (SQLException): " + e.getMessage());
        }
        return conn;
    }
}
