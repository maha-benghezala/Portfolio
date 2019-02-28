/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import modals.Projet;
import org.controlsfx.control.Notifications;
import service.ProjetService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ProjetController implements Initializable {

    @FXML
    private JFXTextField nomprojet;
    @FXML
    private JFXTextField url;
    @FXML
    private JFXCheckBox check;
    @FXML
    private JFXComboBox<String> moisd;
    @FXML
    private JFXComboBox<String> moisf;
    @FXML
    private JFXComboBox<String> anneed;
    @FXML
    private JFXComboBox<String> anneef;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton enregistrer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         moisd.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("5"),

                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
             moisf.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("5"),

                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
                  anneed.setItems(FXCollections.observableArrayList(
                    new String("2010"),
                    new String("2011"),
                    new String("2012"),
                    new String("2013"),
                    new String("2014"),
                    new String("2015"),
                    new String("2016"),
                    new String("2017"),
                    new String("2018"),
                    new String("2019"),
                    new String("2020")));
                anneef.setItems(FXCollections.observableArrayList(
                    new String("2010"),
                    new String("2011"),
                    new String("2012"),
                    new String("2013"),
                    new String("2014"),
                    new String("2015"),
                    new String("2016"),
                    new String("2017"),
                    new String("2018"),
                    new String("2019"),
                    new String("2020")));
    }    

    @FXML
    private void EnregistrerProjet(ActionEvent event) {
           ProjetService ps= new ProjetService();
     if(!nomprojet.getText().equals("")||!url.getText().equals("")){
         if(Integer.parseInt(anneef.getValue()) > Integer.parseInt(anneed.getValue())){
          Projet p= new Projet();
           p.setId_user(1);
           p.setMoisdebut(moisd.getValue());
           p.setMoisfin(moisf.getValue());
           p.setAnneedebut(anneed.getValue());
           p.setAnneefin(anneef.getValue());
           p.setNom_projet(nomprojet.getText());
           p.setUrl(url.getText());
            p.setDescription(description.getText());
        ps.ajouterProjet(p);
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
         
         
         
         }
         else{
              Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dialog");
       
        alert.setContentText("Verifier Votre date!");

        alert.showAndWait();
         }}
     else{
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

    @FXML
    private void checkprojet(ActionEvent event) {
          if(check.isSelected())
        {
        moisf.setVisible(false);
        anneef.setVisible(false);}
        else{
           moisf.setVisible(true);
            anneef.setVisible(true);
        }
    }
    
}
