/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import modals.Formation;

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
     
    if (!Nomecole.getText().isEmpty() ||!domaine.getText().isEmpty() || !diplome.getText().isEmpty()) {
           
         if (!anneedebut.getValue().isEmpty()) 
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
        ((Node)(event.getSource())).getScene().getWindow().hide();

                }else{
                 System.out.println("remplir date");
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
