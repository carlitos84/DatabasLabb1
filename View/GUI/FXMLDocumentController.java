/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Teddy
 */
public class FXMLDocumentController implements Initializable {
    private String username;
    private String password;
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    
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
            //här hämtas root och stage som vi sedan endast byter scener.
            Parent SQLsceneParent = FXMLLoader.load(getClass().getResource("FXMLSQL_scene.fxml"));
            Scene SQLsceneScene = new Scene(SQLsceneParent);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(SQLsceneScene);
            mainStage.show();
        }
        
    }
    
    @FXML
    private void handleUsernameEvent(ActionEvent event)
    {
        
        TextField text = (TextField) event.getSource();
        username = text.getText();
        System.out.println(username);
    }
    
    @FXML
    private void handlePasswordEvent(ActionEvent event)
    {
        PasswordField psw = (PasswordField) event.getSource();
        password = psw.getText();
        System.out.println(password);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
