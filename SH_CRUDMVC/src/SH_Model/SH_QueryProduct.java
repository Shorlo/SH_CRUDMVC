package SH_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shorlo
 */
public class SH_QueryProduct extends SH_DBConnection
{
    public boolean register(SH_Product product)
    {
        PreparedStatement ps = null;
        Connection connection = getConnection();

        String sql = "INSERT INTO product (code, name, price, quantity) VALUES (?,?,?,?)";
        
        try
        {
            ps = connection.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            
            ps.execute();
            return true;
        }
        catch (SQLException error)
        {
            System.err.println(error);
            return false;
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException error)
            {
                System.err.println(error);
            }
        }
    }
    
    public boolean modify(SH_Product product)
    {
        PreparedStatement ps = null;
        Connection connection = getConnection();
        
        
        String sql = "UPDATE product SET code=?, name=?, price=?, quantity=? WHERE id=?";
        
        try
        {
            ps = connection.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getId());
            
            ps.execute();
            return true;
        }
        catch (SQLException error)
        {
            System.err.println(error);
            return false;
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException error)
            {
                System.err.println(error);
            }
        }
    }
    
    public boolean delete(SH_Product product)
    {
        PreparedStatement ps = null;
        Connection connection = getConnection();
        
        
        String sql = "DELETE FROM product WHERE id=?";
        
        try
        {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, product.getId());
            
            ps.execute();
            return true;
        }
        catch (SQLException error)
        {
            System.err.println(error);
            return false;
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException error)
            {
                System.err.println(error);
            }
        }
    }
    
    public boolean search(SH_Product product)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = getConnection();
        
        
        String sql = "SELECT * FROM product WHERE code=?";
        
        try
        {
            ps = connection.prepareStatement(sql);
            ps.setString(1, product.getCode());
            
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                product.setId(Integer.parseInt(rs.getString("id")));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setPrice(Double.parseDouble(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                
                return true;
            }
            return false;
        }
        catch (SQLException error)
        {
            System.err.println(error);
            return false;
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException error)
            {
                System.err.println(error);
            }
        }
    }
}
