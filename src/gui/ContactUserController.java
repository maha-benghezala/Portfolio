/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ContactUserController implements Initializable {

    @FXML
    private JFXTextField objet;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton envoyer;
    @FXML
    private JFXButton annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Envoyer(ActionEvent event) throws NexmoClientException {
        
         NexmoClient client = new NexmoClient.Builder()
                .apiKey("73968abf")
                .apiSecret("QWF7vJN9F1ngqTEd")
                .build();

        String messageText = "objet:"+objet.getText()+"description:"+description.getText();
        TextMessage message = new TextMessage("Nexmo", "21652065704", messageText);

        SmsSubmissionResponse response = null;
        try {
            response = client.getSmsClient().submitMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NexmoClientException e) {
            e.printStackTrace();
        }

        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            System.out.println(responseMessage);
        }
    }

    @FXML
    private void Annuler(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.close();
        
    }
    
}
