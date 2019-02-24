/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modals.Competence;
import service.CompetenceService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierCompetenceController implements Initializable {

    @FXML
    private JFXTextField competencetxt;
    @FXML
    private JFXButton AjouterCompetence;
    public static int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
        CompetenceService cs = new   CompetenceService();
         Competence c=cs.get(id);
         
           c.setId_user(1);
        competencetxt.setText(c.getCompetence());
    }    

    @FXML
    private void OnAddCompetence(ActionEvent event) {
             CompetenceService cs = new   CompetenceService();
//        if (!competencetxt.getText().isEmpty()) {
//            System.out.println("remplir le nom de competence!");}
//        else
//        { 
            Competence c=cs.get(id);
           c.setCompetence(competencetxt.getText());
           c.setId_user(1);
          cs.modiferCompetence(c);
           
        }
    }
    

