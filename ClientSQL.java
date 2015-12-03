/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;

/**
 *
 * @author Santos
 */
public class ClientSQL extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        String Query = "Select * from T_Artist";
            
        
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labb1", "clientapp", "carlos");
            
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(Query);
            rs.next();
            String sname = rs.getString(2);
            System.out.println(sname);
            //con.close();
            
        }
        catch(Exception e)
        {
            
        }
        finally {
            try {
                if( con != null) {
                    con.close();
                }
            }
            catch(SQLException e){}
            
        }
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
