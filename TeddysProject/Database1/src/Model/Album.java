/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Santos
 */
public class Album {    
    private SimpleStringProperty title, genre, madeby ;
    private SimpleIntegerProperty id, date;
    private SimpleFloatProperty rate;
   
    
    public Album(int id, String title, String genre, int setdate){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(setdate);
        this.rate = new SimpleFloatProperty(0);
    }
    
    public Album(int id, String title, String genre, int setdate, float setrate){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(setdate);
        this.rate = new SimpleFloatProperty(setrate);
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
    public float getRate() {
        return rate.get();
    } 
    
    public int getDate() {
        return date.get();
    }
    
    public int setMadeBy() {
        return date.get();
    }

    public void setRate(float setrate) {
        rate.set(setrate);
    }
    
    
    public String GetMadeBy() {
        return madeby.get();
    }
}