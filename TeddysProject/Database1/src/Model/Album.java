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
    private SimpleStringProperty title, genre, madeby ;
    private SimpleIntegerProperty id, date,rate;
   
    
    public Album(int id, String title, String genre, int setdate){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(setdate);
        this.rate = new SimpleIntegerProperty(0);
    }
    
    public Album(String title, String genre, int setdate){
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(setdate);
        this.rate = new SimpleIntegerProperty(0);
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
    public int getRate() {
        return rate.get();
    } 
    
    public int getDate() {
        return date.get();
    }
    
    public int setMadeBy() {
        return date.get();
    }

    public void setRate(int setrate) {
        rate.set(setrate);
    }
    
    public void getRate(int setrate) {
        rate.get();
    }
    
    public String GetMadeBy() {
        return madeby.get();
    }
}