/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modals.Entreprise;
import modals.User;
import service.PortfolioEntrpriseService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ProfilEntrepriseController implements Initializable {

    
    @FXML
    private Label NomEntreprise;
    @FXML
    private Label TitreEntrprise;
    @FXML
    private Label adresseEntreprise;
    @FXML
    private JFXTextArea descriptionEntreprise;
    @FXML
    private Label mail;
    @FXML
    private Label numero;
    @FXML
    private ImageView imge;
    @FXML
    private JFXButton profil;
    @FXML
    private JFXButton liste;
    @FXML
    private JFXButton rate;
    @FXML
    private JFXButton deconnection;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PortfolioEntrpriseService ce=new PortfolioEntrpriseService();
        User e=ce.getById(4);
         System.out.println(e.toString());
         NomEntreprise.setText(e.getNomSc());
         TitreEntrprise.setText(e.getSpecialite());
         adresseEntreprise.setText(e.getAdresse());
         descriptionEntreprise.setText(e.getDescription());
         mail.setText(e.getMail());
         numero.setText(e.getTel()+"");
        Image image=new Image("http://127.0.0.1"+e.getImage());
        imge.setImage(image);
         
         
    }    

    @FXML
    private void Profil(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfilEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Mon Profil");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void listeFeelancer(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/listeFreelancer.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste Entreprise");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void Rate(ActionEvent event) {
        
    }

    @FXML
    private void Deconnection(ActionEvent event) {
    }
    
}
