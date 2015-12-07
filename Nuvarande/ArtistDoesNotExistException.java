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
public class ArtistDoesNotExistException extends Exception{
    private String artist;
    
    public ArtistDoesNotExistException(String artist) {
        this.artist = artist;
    }
    
    public String toString(String artist) {
        return "The artist " +artist +" does not exist.";
    }
}
