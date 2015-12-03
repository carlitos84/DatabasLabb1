/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author Teddy
 */
public class UserInterface {
   private String query;
   private ResultSet resultquery;
   private Statement statement;
   private Connection con;
    public UserInterface(Connection con)
    {
        this.con = con;
        Start();
    }
    
    private void Start()
    {
        
        System.out.println("Welcome to database!");
        showMenu();
        executeQuestion();
        
    }
    
    
    private void executeQuestion()
    {
        try
        {
           
            statement = con.createStatement();
            resultquery = statement.executeQuery(query);
            String sname = resultquery.getString(2);
            if(sname.isEmpty())
            {
                System.out.println("NULL");
            }
            else
            {
                System.out.println("result");
                System.out.println(sname);
            }
            System.out.println("After result");
        }
        catch(Exception e) {}
        
  
        
    }
    
    private void showMenu()
    {
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("1. Search");
        System.out.println("2. Add album or artist");
        String ans = scan.next();
        
        if(ans.matches("1"))
        {
            showSearchMenu();
        }
        else
        {
            showAddMenu();
        }
    }
    
    private void showSearchMenu()
    {
        Scanner scan = new Scanner(System.in);
       
        
        System.out.println("1. Search Album");
        System.out.println("2. Search Artist");
        String ans = scan.next();
        
        if(ans.matches("1"))
        {
            searchAlbum();
        }
        else
        {
            searchAlbumByArtist();
        }
    }
    
    
    private void searchAlbum()
    {
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        this.query = "Select * from t_album where K_title = "+ ans + ";";
        
        
    }
    
    private void searchAlbumByArtist()
    {
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        this.query = "Select * from t_album where K_MadeBy = (select K_ID from t_artist where K_name = " + ans + ") ;";
    }
    
    
    
    
    private void showAddMenu()
    {
        System.out.println("1. Search");
        System.out.println("2. Add album or artist");
    }
    
    
    
    
}
