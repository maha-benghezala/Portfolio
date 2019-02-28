/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import modals.Langue;
import org.controlsfx.control.Notifications;
import service.LangueService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierLangueController implements Initializable {

    @FXML
    private JFXTextField langue;
    @FXML
    private JFXComboBox<String> niveau;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private JFXButton anuuler;
public static int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             niveau.setItems(FXCollections.observableArrayList(
                    new String("Debutant"),
                    new String("Intermidiare"),
                    new String("Professionnelle")));
                 LangueService ls=new LangueService ();
                  Langue l=ls.get(id);
                 langue.setText(l.getLangue());
                 
    }    

    @FXML
    private void EnregistrerLangue(ActionEvent event) {
          LangueService ls=new LangueService ();
     if (!langue.getText().isEmpty()) {
        Langue l=ls.get(id);
        l.setLangue(langue.getText());
        l.setNiveau(niveau.getValue());
        l.setId_user(1);
        ls.modiferLangue(l);

        
                 Notifications notificationBuilder;
            notificationBuilder = Notifications.create()
                    .title("Done")
                    .text("Ajouter avec succés")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("you clicked me");
                        }
                    });
        notificationBuilder.show();
//      ((Node)(event.getSource())).getScene().getWindow().hide();

         
         }  else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Dialog");
       
        alert.setContentText("remplir tous les champs!");

        alert.showAndWait();
                }
    }

    @FXML
    private void AnnulerLangue(ActionEvent event) {
    }
    
}
