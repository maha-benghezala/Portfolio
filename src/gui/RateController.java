/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import modals.Rate;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import service.RateService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class RateController implements Initializable {

    @FXML
    private Rating rate;
    @FXML
    private JFXTextArea commentaire;
    int Value;
    @FXML
    private JFXButton ajout;
    @FXML
    private JFXButton annuler;
    public static int id ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rate.ratingProperty().addListener(new ChangeListener<Number>() {
           @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
               Value = newValue.intValue();
                System.out.println(Value);
            }

           
        });
    }    

    @FXML
    private void AjouterRate(ActionEvent event) {
        RateService rs=new RateService();
        
       Rate r=new Rate();
       if (!commentaire.getText().equals("")|| Value !=0) {
       r.setIduser(4);
       r.setAvis(Value);
       r.setCommentaire(commentaire.getText());
       rs.ajouterRate(r);
           Notifications notificationBuilder = Notifications.create()
                .title("Done")
                .text("hello")
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
       
       }else{
          Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Dialog");
       
        alert.setContentText("remplir votre champs!");

        alert.showAndWait();
          }

    }

    @FXML
    private void AnnulerRate(ActionEvent event) {
    }
    
}
