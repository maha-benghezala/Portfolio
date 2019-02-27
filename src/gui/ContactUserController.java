/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
    private void Envoyer(ActionEvent event) {
        Mail m1 = new Mail();
            m1.envoyer("maha.benghezala@gmail.com","marche","ok");
    }

    @FXML
    private void Annuler(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.close();
        
    }
    
}
