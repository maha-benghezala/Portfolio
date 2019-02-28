/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modals.Formation;
import org.controlsfx.control.Notifications;

import service.FormationService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class FormationController implements Initializable {
    ObservableList list =FXCollections.observableArrayList();
    @FXML
    private TextField Nomecole;
    
    @FXML
    private TextArea description;
   
    @FXML
    private TextField domaine;
    @FXML
    private TextField diplome;
    @FXML
    private JFXButton enreg;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXComboBox<String> anneedebut;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
   anneedebut.setItems(FXCollections.observableArrayList(
                    new String("2004"),
                    new String("2005"),
                    new String("2006"),
                    new String("2007"),
                    new String("2008"),
                    new String("2009"),
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
    private void EnregistrerFormation(ActionEvent event) {
     
    if (!Nomecole.getText().equals("") ||!domaine.getText().equals("") || !diplome.getText().equals("")) {
           
         if (!anneedebut.getValue().equals("")) 
            {
           
             FormationService fs = new FormationService();
          Formation f = new Formation();
            f.setNom_ecole(Nomecole.getText());
            f.setDomaine(domaine.getText());
            f.setDiplome(diplome.getText());
            f.setDescription(description.getText());
           
            f.setAnnée_debut( anneedebut.getValue());
            f.setId_user(1);
            fs.ajouterFormation(f);
//            Properties props = new Properties();
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.smtp.host", "smtp.gmail.com");
//         props.put("mail.smtp.port", "587");
//         Session session = Session.getInstance(props,
//         new javax.mail.Authenticator() {
//         protected PasswordAuthentication getPasswordAuthentication() {
//         return new PasswordAuthentication("monguide07@gmail.com", "so what00112233");
//         }
//         });
//         try {
//         // Etape 2 : Création de l'objet Message
//         Message message = new MimeMessage(session);
//         message.setFrom(new InternetAddress("monguide07@gmail.com"));
//         message.setRecipients(Message.RecipientType.TO,
//         InternetAddress.parse("maha.benghezala@esprit.tn"));
//         message.setSubject("working");
//         message.setText("hello");
//         // Etape 3 : Envoyer le message
//         Transport.send(message);
//         System.out.println("Message_envoye");
//
//         } catch (MessagingException e) {
//         throw new RuntimeException(e);
//         }
//            NexmoClient client = new NexmoClient.Builder()
//                .apiKey("73968abf")
//                .apiSecret("QWF7vJN9F1ngqTEd")
//                .build();
//
//        String messageText = "Bien Reçu";
//        TextMessage message = new TextMessage("Nexmo", "21652065704", messageText);
//
//        SmsSubmissionResponse response = null;
//        try {
//            response = client.getSmsClient().submitMessage(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NexmoClientException e) {
//            e.printStackTrace();
//        }
//
//        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
//            System.out.println(responseMessage);
//        }
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
//        ((Node)(event.getSource())).getScene().getWindow().hide();

                }else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dialog");
       
        alert.setContentText("remplir date!");

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
