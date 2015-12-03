/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Teddy
 */
public class Storage {
    private final int userID;
    private final int artistID;
    private final int albumID;
    
    public Storage(User user, Artist artist, Album album)
    {
        this.userID = user.getId();
        this.artistID = artist.getID();
        this.albumID = album.getId();
    }
    
    public int getUserID()
    {
        return this.userID;
    }
    
    public int getArtistiD()
    {
        return this.artistID;
    }
    
    public int getAlbumID()
    {
        return this.albumID;
    }
}
