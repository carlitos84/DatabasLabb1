/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import Model.Album;
import Model.Artist;
import Model.ArtistDoesNotExistException;
import Model.ConnectionSQL;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Teddy
 */
public class FXMLController implements Initializable{
    private String username;
    private String password;
    private String artist;
    private String album;
    private String title;
    private String genre;
    private int date;
    
    @FXML
    private Label label;
    @FXML
    private Button button;
   
    //Login scene:
    @FXML
    private void handleConnectButtonOnClicked(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        if(username.isEmpty() || password.isEmpty())
        {
            System.out.println("username or password i empty!");
        }
        else
        {
            //här kopplas det till servern med username och password
            ConnectionSQL con = new ConnectionSQL(username, password);
            //här hämtas root och stage som vi sedan endast byter scener.
            Parent SQLsceneParent = FXMLLoader.load(getClass().getResource("FXMLSQL_scene.fxml"));
            Scene SQLsceneScene = new Scene(SQLsceneParent);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(SQLsceneScene);
            mainStage.show();
        }      
    }
    
    @FXML
    private void handleLogInUsernameEvent(ActionEvent event)
    {
        
        TextField text = (TextField) event.getSource();
        username = text.getText();
        System.out.println(username);
    }
    
    @FXML
    private void handleLogInPasswordEvent(ActionEvent event)
    {
        PasswordField psw = (PasswordField) event.getSource();
        password = psw.getText();
        System.out.println(password);
    }
    
    //SQL_scene:
    @FXML
    private void handleSQLquestionSearchButtonEvent(ActionEvent event) throws IOException
    {
           //här hämtas root och stage som vi sedan endast byter scener.
            Parent SQLSearchParent = FXMLLoader.load(getClass().getResource("FXMLSearchPage.fxml"));
            Scene SQLSearchScene = new Scene(SQLSearchParent);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(SQLSearchScene);
            mainStage.show();    
    }
    
    @FXML
    private void handleSQLquestionAddButtonEvent(ActionEvent event) throws IOException
    {
               //här hämtas root och stage som vi sedan endast byter scener.
            Parent SQLAddParent = FXMLLoader.load(getClass().getResource("FXMLAddPage.fxml"));
            Scene SQLAddScene = new Scene(SQLAddParent);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(SQLAddScene);
            mainStage.show();
    }
    
    
    //Search object scene:
     @FXML
    private void handleSearchArtistButtonEvent(ActionEvent event)
    {
        if(artist.isEmpty())
        {
            System.out.println("artist is empty!");
        }
        else
        {
            ArrayList<Artist> resultList;
            
            ConnectionSQL con = new ConnectionSQL(username, password);
            resultList = con.searchForArtistByName(artist);
            
            System.out.print(resultList.toString());
            System.out.println("Searching...");
        }
    }
    
    @FXML 
    private void handleSearchArtistTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        artist = text.getText();
        System.out.println(artist);
    }
    
    @FXML
    private void handleSearchAlbumButtonEvent(ActionEvent event)
    {
        if( album.isEmpty())
        {
            System.out.println("album is empty!");
        }
        else
        {
            ArrayList<Album> resultList;
            
            ConnectionSQL con = new ConnectionSQL(username, password);
            /*resultList = con.searchForArtistByName(album);
            System.out.print(resultList.toString());*/
            System.out.println(album);
            System.out.println("Searching...");
        }     
    }
    
    @FXML 
    private void handleSearchAlbumTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        album = text.getText();
        System.out.println(album);
        
    }
    
    //Add object scene:
    @FXML
    private void handleAddArtistEventButton(ActionEvent event) throws ArtistDoesNotExistException
    {
        if(artist.isEmpty())
        {
            System.out.println("artist is empty!");
        }
        else
        {
            
            System.out.println("adding...");
            ConnectionSQL con = new ConnectionSQL(username, password);
            con.addArtist(username, artist);           
            System.out.println(artist + "added");
        }
    }
    
    @FXML 
    private void handleAddArtistTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        artist = text.getText();
        System.out.println(artist);
    }
    
    @FXML
    private void handleAddAlbumEventButton(ActionEvent event) throws ArtistDoesNotExistException
    {
        if( album.isEmpty())
        {
            System.out.println("album is empty!");
        }
        else
        {
            System.out.println("adding...");
            ConnectionSQL con = new ConnectionSQL(username, password);
            con.addAlbum(title, genre, artist, date);          
            System.out.println(album + "added");
        }     
    }
    
    @FXML 
    private void handleAddAlbumTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        album = text.getText();
        System.out.println(album);
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}