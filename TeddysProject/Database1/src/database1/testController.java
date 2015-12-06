/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import Model.Album;
import Model.Artist;
import Model.ArtistDoesNotExistException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Teddy
 */
public class testController  implements Initializable {

    //för Album tabellen:
    
    @FXML private TableView<Album> albumTable;
    @FXML private TableColumn idC;
    @FXML private TableColumn titleC;
    @FXML private TableColumn genreC;
    @FXML private TableColumn rateC;
    @FXML private TableColumn madebyC;
    
    ObservableList<Album> albumList;
    private int columnindex;
    
    @FXML private TextField titleTF;
    @FXML private TextField genreTF;
    @FXML private TextField rateTF;
    @FXML private TextField madebyTF;
    
    @FXML private Button addB;
    
    private void initiateTable(String[] columns, ObservableList list, TableView tableview)
    {
        for(int i=0; i<columns.length;i++)
        {
            titleC.setCellValueFactory(new PropertyValueFactory<Album,String>(columns[i]));           
        }
        list = FXCollections.observableArrayList();
        tableview.setItems(list);       
    }
    
    @FXML
    private void getAlbumSearchTest()
    {
        Album newalbum = new Album(1, "test","POP", "MJ");
        albumList.add(newalbum);
    }
    
    private void initiateAlbumTable()
    {
        titleC.setCellValueFactory(new PropertyValueFactory<Album,String>("Title"));
        genreC.setCellValueFactory(new PropertyValueFactory<Album,String>("Genre"));
        madebyC.setCellValueFactory(new PropertyValueFactory<Album,String>("Made By"));
        idC.setCellValueFactory(new PropertyValueFactory<Album,String>("ID"));
        rateC.setCellValueFactory(new PropertyValueFactory<Album,String>("Rate"));
        
        albumList = FXCollections.observableArrayList();
        albumTable.setItems(albumList);
    }
    
    @FXML
    private void handleAddAlbumButton(ActionEvent event) throws ArtistDoesNotExistException
    {
        
        Album newalbum = new Album(1, titleTF.getText(), genreTF.getText(), madebyTF.getText());
        albumList.add(newalbum);
           
    }
    
    //these 3 methods is from https://github.com/jarroba/Tablas-JavaFX--FXML-/blob/master/src/agendajarroba/VistaController.java and is modified after our situation.
    private final ListChangeListener<Album> focusAlbumTable = 
        new ListChangeListener<Album>() 
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Album> c) 
            {
                changeFocusAlbum();
            }
        };
    
     private void changeFocusAlbum() {
        final Album tempalbum = getTableOfSelectedAlbum();
        columnindex = albumList.indexOf(tempalbum);

        if (tempalbum != null) {

            // Pongo los textFields con los datos correspondientes
            titleTF.setText(tempalbum.getTitle());
            madebyTF.setText(tempalbum.GetMadeBy());
            genreTF.setText(tempalbum.getGenre());
            rateTF.setText(tempalbum.getRate());
        }
    }
     
    public Album getTableOfSelectedAlbum() {
        if (albumTable != null) {
            List<Album> table = albumTable.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Album competisionselected = table.get(0);
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
        initiateAlbumTable(); 
        final ObservableList<Album> albumTableSelect = albumTable.getSelectionModel().getSelectedItems();
        albumTableSelect.addListener(focusAlbumTable); 
    }
    
}
