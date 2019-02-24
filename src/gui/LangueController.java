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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import modals.Experience;
import modals.Langue;
import service.LangueService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class LangueController implements Initializable {

    @FXML
    private TextField langue;
    @FXML
    private ComboBox<String> niveau;
    @FXML
    private Button enregistrer;
    @FXML
    private Button anuuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         niveau.setItems(FXCollections.observableArrayList(
                    new String("Debutant"),
                    new String("Intermidiare"),
                    new String("Professionnelle")));
    }    

    @FXML
    private void NiveauLangue(ActionEvent event) {
           Window owner = niveau.getScene().getWindow();

        if (niveau.getValue().equals("")) {
            niveau.setDisable(false);
            niveau.setItems(FXCollections.observableArrayList(
                new String("Debutant"),
                    new String("Intermidiare"),
                    new String("Professionnelle")));
//        } else {
//           niveau.setValue("");
//           niveau.setDisable(true);
    }}

    @FXML
    private void EnregistrerLangue(ActionEvent event) {
        LangueService ls=new LangueService ();
//           if (!langue.getText().isEmpty()) {
//            System.out.println("remplir tous les champs!");}
//        else
//        { 
           Langue l=new Langue();
        l.setLangue(langue.getText());
        l.setNiveau(niveau.getValue());
        l.setId_user(1);
        
           
          ls.ajouterLangue(l);
           
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Langue.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Langue");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);}
//            }
        
    }

    @FXML
    private void AnnulerLangue(ActionEvent event) {
    }
    
}
