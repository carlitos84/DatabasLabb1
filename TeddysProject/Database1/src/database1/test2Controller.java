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
import Model.MadeBy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Teddy
 */
public class test2Controller  implements Initializable {

    // för Artist tabellen;
    @FXML private TableView<Artist> artistTable;
    @FXML private TableColumn artistidC;
    @FXML private TableColumn nameC;
    @FXML private TableColumn nationalityC;
  
    ObservableList<Artist> artistList;
    private int searchsolumnindex;
    
    @FXML private TextField artistnameTF;
    @FXML private TextField artistnationalityTF;
    
    @FXML private Button searchartistB;
    @FXML private Button searchalbumB;
    @FXML private Button returntomenuB;
    @FXML private Button getAlbumListB;
    @FXML private Button addArtistB;
    
    //för Album tabellen:
    
    private void initiateArtistTable()
    {
        artistidC.setCellValueFactory(new PropertyValueFactory<Album,String>("ID"));
        nameC.setCellValueFactory(new PropertyValueFactory<Album,String>("Name"));
        nationalityC.setCellValueFactory(new PropertyValueFactory<Album,String>("Nationality"));
        
        artistList = FXCollections.observableArrayList();
        artistTable.setItems(artistList);
    }
    
    @FXML
    private void getArtistInAdd()  //gives list of artist from the database
    {
        System.out.println("searchin artist...");
        ArrayList<Artist> resultList = new ArrayList<>();
            
        ConnectionSQL con = new ConnectionSQL("clientapp", "qwerty"); //koppla till username och password        
        resultList = con.searchForArtistByName("");
        artistList.remove(0, artistList.size());
        for(Artist m : resultList)
        {
            artistList.add(m);
        }
    }
    
    @FXML
    private void addArtist()
    {
        ConnectionSQL con = new ConnectionSQL("clientapp", "qwerty"); //koppla till username och password       
        con.addArtist(artistnameTF.getText(), artistnationalityTF.getText());
        System.out.println(artistnameTF.getText() +" " + artistnationalityTF.getText());
        getArtistInAdd();
        
    }
    
    @FXML
    private void getSearchTest() 
    {
        artistList.remove(0, artistList.size()); //clears table
        
        System.out.println("searchin artist...");
        ArrayList<MadeBy> resultList = new ArrayList<>();
            
        ConnectionSQL con = new ConnectionSQL("clientapp", "qwerty"); //koppla till username och password
        
        resultList = con.searchForString(artistnameTF.getText());
        System.out.println(resultList.size());
        
        if(resultList.size() > 0)
        {
            artistList.add(resultList.get(0).getArist());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Artist does't exist or have a album");
            alert.show();
        }
             
        
       
        //artistList.add(resultList.get(0).getArist());
    }
    
    private final ListChangeListener<Artist> focusArtistTable = 
        new ListChangeListener<Artist>() 
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Artist> c) 
            {
                changeFocusArtist();
            }
        };
    
     private void changeFocusArtist() {
        final Artist tempartist = getTableOfSelectedArtist();
        searchsolumnindex = artistList.indexOf(tempartist);

        if (tempartist != null) {

            // Pongo los textFields con los datos correspondientes
            artistnameTF.setText(tempartist.getName());
            artistnationalityTF.setText(tempartist.getNationality());
        }
    }
     
    public Artist getTableOfSelectedArtist() {
        if (artistTable != null) {
            List<Artist> table = artistTable.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Artist competisionselected = table.get(0);
                return competisionselected;
            }
        }
        return null;
    }
    
    @FXML
    private void handleReturnButtonEvent(ActionEvent event) throws IOException
    {
            //här hämtas root och stage som vi sedan endast byter scener.
            Parent SQLAddParent = FXMLLoader.load(getClass().getResource("FXMLSQL_scene.fxml"));
            Scene SQLAddScene = new Scene(SQLAddParent);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(SQLAddScene);
            mainStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        initiateArtistTable();
        final ObservableList<Artist> artistTableSelect = artistTable.getSelectionModel().getSelectedItems();
        artistTableSelect.addListener(focusArtistTable);
    }
    
}

