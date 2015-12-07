/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Teddy
 */
public class Rate {
    private final int userID;
    private final int albumID;
    private final int score;
    
    public Rate(User user, Album album, int score)
    {
        this.albumID = album.getID();
        this.userID = user.getID();
        this.score = score;
    }
    
    public int getUserId() {
        return userID;
    }
    
    public int getAlbumId() {
        return albumID;
    }
    
    public int getScore() {
        return score;
    }
    
}
