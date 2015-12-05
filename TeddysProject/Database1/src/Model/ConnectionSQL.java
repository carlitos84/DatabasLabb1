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

public class ConnectionSQL {
    private String database, server, user, pwd;
    private Connection con;
    
    /**
     * Default constructor without parameters only for testing
     */
    public ConnectionSQL(){
        database = "labb1";
        server = "jdbc:mysql://localhost:3306/" + database;
        user = "clientapp";
        pwd = "carlos";
        
        con = null; 
    }
    
    /**
     * Sets up for connection to database named "labb1" in localhost with 
     * portnumber 3306. Username and password has to be provided.
     * @param user Username for database
     * @param pwd Password for database
     */
    public ConnectionSQL(String user, String pwd) {
        database = "labb1";
        server = "jdbc:mysql://localhost:3306/" + database;
        this.user = user;
        this.pwd = pwd;
        
        con = null;
    }
    
    /**
     * Returns ArrayList with artists in database that matches search string.
     * @param searchString Search string to be searched by.
     * @return ArrayList<Artist> 
     */
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
    
    /**
     * Add artist to database
     * @param name Artist name
     * @param nationality Artist Nationality
     */
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
    
    /**
     * Adds album to database based on parameters. Checks if artist and album 
     * already exists before and adding the album. 
     * @param title Title of album
     * @param genre Genre of album
     * @param artistName Artist that made the album
     * @param date Date of release
     */
    public void addAlbum(String title, String genre, String artistName, int date) throws ArtistDoesNotExistException {
        
        if(!checkIfArtistExists(artistName) ) {
            throw new ArtistDoesNotExistException(artistName);
        }
        else {
            if(checkIfAlbumExists(title, artistName) ) {
                //Bör göra exception
            }
            else {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    
                    con = DriverManager.getConnection(server, user, pwd);                    
                    con.setAutoCommit(false);
                    
                    System.out.println("Getting artist id");//Endast för test
                    //Get Artist Id that matches artistName
                    String sqlGetId = "select K_Id from T_Artist where K_Name = ?";
                    PreparedStatement getArtistId = con.prepareStatement(sqlGetId);
                    getArtistId.setString(1, artistName);
                    ResultSet rs = getArtistId.executeQuery();
                    boolean next = rs.next();
                    int artistId = rs.getInt(1);
                    
                    System.out.println("Inserting row for album");//Endast för test
                    //Insert row for album in T_Album
                    String sqlInsertAlbum = "insert into T_Album(K_Title, K_Genre, K_Date) "
                                +"values(?, ?, ?)";
                    PreparedStatement insertAlbum = con.prepareStatement(sqlInsertAlbum);
                    insertAlbum.setString(1, title);
                    insertAlbum.setString(2, genre);
                    insertAlbum.setInt(3, date);
                    int n = insertAlbum.executeUpdate();
                    
                    //Fungerar inte
                    System.out.println("Inserting album in madeBy");//Endast för test
                    //Insert row in T_MadeBy for album created and artist defined in artistName
                    String sqlInsertMadeBy = "insert into T_MadeBy(K_ArtistId, K_AlbumId) "
                                            +"values( (select K_Id from T_Artist where K_Name = ?), "
                                            +"(select K_Id from T_Album where K_Title = ?) )";
                    PreparedStatement insertMadeBy = con.prepareStatement(sqlInsertMadeBy);
                    insertMadeBy.setString(1, artistName);
                    insertMadeBy.setString(2, title);
                    insertMadeBy.executeUpdate();
                    System.out.println("Inserting album in madeBy done");//Endast för test
                    
                    con.commit();                    
                    con.setAutoCommit(true);

                }catch(Exception e) {System.out.println("Exception");}
                    
                finally {
                    try {
                        con.rollback();
                        con.close();
                    }catch(SQLException e) {}
                }
            }
        
        }
    }
    
    private boolean checkIfArtistExists(String artistName) {
        
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
    
    private boolean checkIfAlbumExists(String title, String artistName) {
        boolean albumFound = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);    
            
            String sql = "select count(K_ArtistId) from T_MadeBy where K_Name = ? AND A_Id = "
                        +"(select K_Id from T_Album where K_Title = ?";
            PreparedStatement checkArtistExistance = con.prepareStatement(sql);
            checkArtistExistance.setString(1, artistName);      
            checkArtistExistance.setString(1, title);  
            
            ResultSet rs = checkArtistExistance.executeQuery();
            
            boolean next = rs.next();
            if(rs.getInt(1) > 0) {
                albumFound = true;
            }
            
        }catch(Exception e) {}
        finally {
            try {
                con.close();
            }catch(SQLException e) {}
        }
        return albumFound;
    }
}
