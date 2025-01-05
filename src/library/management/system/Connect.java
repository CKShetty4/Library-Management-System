/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CKShetty
 */
public class Connect {
    static Connection con = null;

    public static Connection Connection() {
        try {
            // Retrieve the credentials from environment variables
            String dbUsername = System.getProperty("DB_USERNAME"); 
            String dbPassword = System.getProperty("DB_PASSWORD"); 
            String dbUrl = System.getProperty("DB_URL"); 
//            String dbUsername = "root"; 
//            String dbPassword = "Rb4ckshetty"; 
//            String dbUrl = "jdbc:mysql://localhost:3306/library"; 
            

            // Check if any environment variable is null (safety check)
            if (dbUrl == null || dbUsername == null || dbPassword == null) {
                System.out.println("Error: Environment variables are not properly set.");
                return null;
            }

            // Establish connection using credentials from environment variables
            con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
