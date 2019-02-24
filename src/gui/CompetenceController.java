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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modals.Competence;
import modals.Portfolio;
import service.CompetenceService;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class CompetenceController implements Initializable {

    @FXML
    private TextField competencetxt;
    @FXML
    private Button AjouterCompetence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnAddCompetence(ActionEvent event) {
        CompetenceService cs = new   CompetenceService();
//        if (!competencetxt.getText().isEmpty()) {
//            System.out.println("remplir le nom de competence!");}
//        else
//        { 
            Competence c=new Competence();
           c.setCompetence(competencetxt.getText());
           c.setId_user(1);
          cs.ajouterCompetence(c);
         
        
    }
    
}
