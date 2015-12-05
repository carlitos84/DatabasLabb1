/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Teddy
 */
public class FXMLSearchPageController implements Initializable {
    private String artist;
    private String album;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handleSearchArtistEvent(ActionEvent event)
    {
        if(artist.isEmpty())
        {
            System.out.println("artist is empty!");
        }
        else
        {
            System.out.println(album);
            System.out.println("Searching...");
        }
    }
    
    @FXML 
    private void handleArtistTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        artist = text.getText();
        System.out.println(artist);
    }
    
    @FXML
    private void handleSearchAlbumEvent(ActionEvent event)
    {
        if( album.isEmpty())
        {
            System.out.println("album is empty!");
        }
        else
        {
            System.out.println(album);
            System.out.println("Searching...");
        }     
    }
    
    @FXML 
    private void handleAlbumTextFieldEvent(ActionEvent event)
    {
        TextField text = (TextField) event.getSource();
        album = text.getText();
        System.out.println(album);
        
    }
}
