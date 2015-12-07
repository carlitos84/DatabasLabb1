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
    private SimpleStringProperty title, genre ;
    private SimpleIntegerProperty id,date;
    private SimpleFloatProperty rate;
   
    
    public Album(int id, String title, String genre, int date){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(date);
        this.rate = new SimpleFloatProperty(0);
    }
    public Album(int id, String title, String genre, int date, float setRate){
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.date = new SimpleIntegerProperty(date);
        this.rate = new SimpleFloatProperty(setRate);
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
}