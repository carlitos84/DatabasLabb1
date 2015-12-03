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
    public Rate(User user, Album album)
    {
        this.albumID = album.getId();
        this.userID = user.getId();
    }
    
}
