/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Santos
 */
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectionSQL {
    private String database, server, user, pwd;
    private Connection con;
    
    
    public connectionSQL(){
        database = "labb1";
        server = "jdbc:mysql://localhost:3306/" + database;
        user = "clientapp";
        pwd = "carlos";
        
        con = null;
        
        
    }
    
    public ArrayList<Artist> searchForArtistByName(String searchString) {
        ArrayList<Artist> artistList = new ArrayList<>();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(server, user, pwd);
            
            Statement st = con.createStatement();
            String sql = "Select * from T_Artist where K_Name = " +"\"" +searchString +"\";";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next() ) {
                artistList.add(new Artist(rs.getInt(1), rs.getString(2), rs.getString(3) ));
            }

        }
        catch(Exception e) {System.out.println("Connection lost");}
        finally {
            try {
                con.close();
            }catch(SQLException e) {}
        }
        return artistList;
    }
}
