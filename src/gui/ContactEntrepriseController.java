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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modals.Competence;
import modals.ContactEntreprise;
import modals.Entreprise;
import modals.User;
import service.CompetenceService;
import service.ContactEntrepriseService;
import utlis.Utilities;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ContactEntrepriseController implements Initializable {

    @FXML
    private Label nomSc;
    @FXML
    private Label adresse;
    @FXML
    private Label ville;
    @FXML
    private Label tel;
    @FXML
    private Label mail;
    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField sujet;
    @FXML
    private TextField tele;
    @FXML
    private TextArea commentaire;
    @FXML
    private Button envoyer;
    public static Entreprise entreprise;
    @FXML
    private JFXButton annuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ContactEntrepriseService ces = new   ContactEntrepriseService();
          System.out.println(ces.selectEntrprise(entreprise));
          User u1 = ces.selectEntrprise(entreprise);
         nomSc.setText(u1.getNomSc());
           adresse.setText(u1.getAdresse());
           ville.setText(u1.getVille());
           tel.setText(u1.getTel()+"");
           mail.setText(u1.getMail());
    }    

    @FXML
    private void EnvoyerMessage(ActionEvent event) {
          ContactEntrepriseService ces = new   ContactEntrepriseService();
     
        
            ContactEntreprise ce=new ContactEntreprise();
      if (!nom.getText().isEmpty()|| !sujet.getText().isEmpty() || !tele.getText().isEmpty() ||!commentaire.getText().isEmpty()) {
          
          if(!Utilities.validateEmail(email.getText()))
          {
             
                ce.setId_user(3);
           ce.setNom(nom.getText());
           ce.setEmail(email.getText());
           ce.setSujet(sujet.getText());
           ce.setTel((int) Double.parseDouble(tele.getText()));
           ce.setMessage(commentaire.getText());
           ces.ajouterContactEntreprise(ce);
              
          }else{
               System.out.println("verifier votre email");
          }
         
        
    
      }else{
            System.out.println("remplir tous les champs!");
        }
    }

    @FXML
    private void Annuler(ActionEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // do what you have to do
    stage.close();
    }
}
    

