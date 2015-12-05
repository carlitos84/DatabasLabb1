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
import java.sql.PreparedStatement;
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
    
    public connectionSQL(String user, String pwd) {
        database = "labb1";
        server = "jdbc:mysql://localhost:3306/" + database;
        this.user = user;
        this.pwd = pwd;
        
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
    
    public void addArtist(String name, String nationality) {
        
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);
            String sql = "Insert into T_Artist(K_Name, K_Nationality) values(?,?)";
            
            PreparedStatement addArtist = con.prepareStatement(sql);
            addArtist.setString(1, name);
            addArtist.setString(2, nationality);            
            
            int n = addArtist.executeUpdate();
            
        }catch(Exception e) {System.out.println("Connection lost");}
        finally {
            try{
                con.close();
            }catch(SQLException e){}
        }
    }
    
    public void addAlbum(String title, String genre, String artistName) {
        
        if(!checkIfArtisExists(artistName) ) {
            //Exception bör skapas
        }
        else {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection(server, user, pwd);
                String sqlGetId = "select K_Id from T_Artist where K_Name = ?";
                PreparedStatement getArtistId = con.prepareStatement(sqlGetId);
                
                getArtistId.setString(1, artistName);
                ResultSet rs = getArtistId.executeQuery();
                boolean next = rs.next();
                int artistId = rs.getInt(1);
                
                String sql = "insert into T_Album(K_Title, K_Genre, K_MadeBy) "
                            +"values(?, ?, ?)";
                PreparedStatement insertAlbum = con.prepareStatement(sql);
                insertAlbum.setString(1, title);
                insertAlbum.setString(2, genre);
                insertAlbum.setInt(3, artistId);
                int n = insertAlbum.executeUpdate();
            
            }catch(Exception e) {}
            finally {
                try {
                    con.close();
                }catch(SQLException e) {}
            }
        
        }
    }
    
    private boolean checkIfArtisExists(String artistName) {
        
        boolean artistFound = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);    
            
            String sql = "select count(K_Id) from T_Artist where K_Name = ?";
            PreparedStatement checkArtistExistance = con.prepareStatement(sql);
            checkArtistExistance.setString(1, artistName);      
            
            ResultSet rs = checkArtistExistance.executeQuery();
            
            boolean next = rs.next();
            if(rs.getInt(1) > 0) {
                artistFound = true;
            }
            
        }catch(Exception e) {}
        finally {
            try {
                con.close();
            }catch(SQLException e) {}
        }
        
        return artistFound;
    }
}
