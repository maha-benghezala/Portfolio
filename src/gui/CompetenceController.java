/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modals.Competence;
import modals.Portfolio;
import org.controlsfx.control.Notifications;
import service.CompetenceService;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class CompetenceController implements Initializable {

    @FXML
    private TextField competencetxt;
    @FXML
    private Button AjouterCompetence;
    @FXML
    private JFXButton Annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnAddCompetence(ActionEvent event) {
        CompetenceService cs = new   CompetenceService();
        if (!competencetxt.getText().equals("")) {
          
       
            Competence c=new Competence();
           c.setCompetence(competencetxt.getText());
           c.setId_user(1);
          cs.ajouterCompetence(c);
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
         // ((Node)(event.getSource())).getScene().getWindow().hide();

  
        }else{
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dialog");
       
        alert.setContentText("remplir tous les champs!");

        alert.showAndWait();
        }
    }

    @FXML
    private void Annuler(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
}
