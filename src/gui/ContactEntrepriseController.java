/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modals.Competence;
import modals.ContactEntreprise;
import modals.Entreprise;
import modals.User;
import org.controlsfx.control.Notifications;
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
      if (!nom.getText().equals("")|| !sujet.getText().equals("") || !tele.getText().equals("") ||!commentaire.getText().equals("")) {
          
          if(Utilities.validateEmail(email.getText()))
          {
             
                ce.setId_user(4);
           ce.setNom(nom.getText());
           ce.setEmail(email.getText());
           ce.setSujet(sujet.getText());
           ce.setTel((int) Double.parseDouble(tele.getText()));
           ce.setMessage(commentaire.getText());
           ces.ajouterContactEntreprise(ce);
           Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");
         Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication("monguide07@gmail.com", "so what00112233");
         }
         });
         try {
         // Etape 2 : Création de l'objet Message
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("monguide07@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse("maha.benghezala@gmail.com"));
         message.setSubject(sujet.getText());
         message.setText(commentaire.getText()
                 +"envoyée depuis : "
                 +"Nom : "+nom.getText()
                 +email.getText());
         // Etape 3 : Envoyer le message
         Transport.send(message);
         System.out.println("Message_envoye");
             Notifications notificationBuilder;
            notificationBuilder = Notifications.create()
                    .title("Done")
                    .text("votre message a été envoyé")
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

         } catch (MessagingException e) {
         throw new RuntimeException(e);
         }
              
          }else{
                          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dialog");
       
        alert.setContentText("Verifier votre e-mail!");

        alert.showAndWait();
          }
         
        
    
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
    

