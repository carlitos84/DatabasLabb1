/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
user: clientapp
password: qwerty
*/
/**
 *
 * @author Teddy
 */
import View.UserInterface;
import java.sql.*;

public class JDBCmain {
    public static void main(String[] args)
    {
        String username = "clientapp";
        String password = "qwerty";
        Connection con = null;
        try
        {
            String Query = "Select * from T_Album";
            // 2nd steg
            Class.forName("com.mysql.jdbc.Driver");
            // 3:e steg
            con = DriverManager.getConnection("jdbc:mysql://localhost/labb1", username, password);
            System.out.println("Connected!");
            // 4:e steg
            UserInterface UI = new UserInterface(con);
            /*
            Statement st = con.createStatement();
            // 5:e steg
            ResultSet rs = st.executeQuery(Query);
            rs.next();
            String sname = rs.getString(2);
            System.out.println(sname);*/
           // 7:e
            
        }   
        catch(Exception e)
        {
                    
        }
        finally
        {
            try
            {
                if(con != null)
                {
                    con.close();
                    System.out.println("Connection closed2");
                }
                
            }
            catch(SQLException e){}
        }
    }
}
