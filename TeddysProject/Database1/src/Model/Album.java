/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Santos
 */
public class Album {    
    private SimpleStringProperty title, genre, rate, madeby ;
    private SimpleIntegerProperty id;
   
    
    public Album(int id, String title, String genre, String madeby){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.madeby = new SimpleStringProperty(madeby);
        this.rate = new SimpleStringProperty("no rate yet");
    }
    
    public int getID() {
        return this.id.get();
    }
    public String getTitle() {
        return title.get();
    }
    public String getGenre(){
        return genre.get();
    }    
    public String getRate() {
        return rate.get();
    }
    
    public void setRate(String setrate) {
        rate.set(setrate);
    }
    
    public String GetMadeBy() {
        return madeby.get();
    }
}