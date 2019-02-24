/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    private Label fax;
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
     
         
          ce.setId_user(3);
           ce.setNom(nom.getText());
           ce.setEmail(email.getText());
           ce.setSujet(sujet.getText());
           ce.setTel((int) Double.parseDouble(tele.getText()));
           ce.setMessage(commentaire.getText());
           ces.ajouterContactEntreprise(ce);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ContactEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Contact");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ContactEntrepriseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

