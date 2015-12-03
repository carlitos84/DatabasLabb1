/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Santos
 */
public class Album {
    private int id, rate;
    private String title, genre;
    
    public Album(int id, String title, String genre){
        this.id = id;
        this.title = title;
        this.genre = genre;
    }
    
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre(){
        return genre;
    }    
    public int rate() {
        return rate;
    }
}