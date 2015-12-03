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
public class Artist {
    private int ID;
    private String name;
    private String Nationality;
    
    public Artist(int id, String name, String nationality)
    {
        this.ID = id;
        this.name = name;
        this.Nationality = nationality;
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getNationality()
    {
        return this.Nationality;
    }

      
}
