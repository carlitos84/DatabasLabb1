/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import Model.Album;
import Model.Artist;
import Model.ArtistDoesNotExistException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Teddy
 */
public class test3Controller  implements Initializable {

    // för Artist tabellen;
    @FXML private TableView<Artist> artistTable;
    @FXML private TableColumn artistidC;
    @FXML private TableColumn nameC;
    @FXML private TableColumn nationalityC;
  
    ObservableList<Artist> artistList;
    private int searchsolumnindex;
    
    @FXML private TextField artistnameTF;
    @FXML private TextField albumtitleTF;
    
    @FXML private Button searchartistB;
    @FXML private Button searchalbumB;
    
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
    private void getSearchTest()
    {
        Artist newartist = new Artist(1, artistnameTF.getText(), "USA");
        artistList.add(newartist);
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
    
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        initiateArtistTable();
        final ObservableList<Artist> artistTableSelect = artistTable.getSelectionModel().getSelectedItems();
        artistTableSelect.addListener(focusArtistTable);
    }
    
}

