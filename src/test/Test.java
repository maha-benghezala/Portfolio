/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modals.User;

/**
 *
 * @author Maha
 */
public class Test extends Application{

   public static String link;
    //Variable statique de l'utilisateur connectèe : 
    
    final ScrollBar sc=new ScrollBar();
    
    public void start(Stage stage) throws Exception {
        
      try {
           
            Parent root ;
            
                root = FXMLLoader.load(getClass().getResource("/gui/ProfilUser.fxml"));
//                   root = FXMLLoader.load(getClass().getResource("/gui/ProfilEntreprise.fxml"));
//                        
           
            stage.setTitle("Mon Profil");
            Scene scene = new Scene(root);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.centerOnScreen();
            stage.setScene(scene);
         
       
            stage.show();
            
        } catch (Exception e) {
            //showExceptionDialog(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        launch(args);
        
    }
    
}
