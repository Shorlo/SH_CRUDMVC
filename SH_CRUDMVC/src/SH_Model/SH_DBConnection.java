package SH_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shorlo
 */
public class SH_DBConnection 
{
    private final String DB = "shop";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/" + DB;
    private Connection con = null;
    
    public Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
        }
        catch (SQLException error)
        {
            System.err.println(error);
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(SH_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
