/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modals.Formation;
import service.FormationService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierFormationController implements Initializable {

    @FXML
    private JFXComboBox<String> anneedebut;
    @FXML
    private JFXButton enreg;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXTextField Nomecole;
    @FXML
    private JFXTextField diplome;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField domaine;
    public static int id;
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
            FormationService fs = new FormationService();
        Formation f=fs.get(id);
            
           f.setId_user(1);
           Nomecole.setText(f.getNom_ecole());
           domaine.setText(f.getDomaine());
           diplome.setText(f.getDiplome());
           description.setText(f.getDescription());
           

       
           

      
           
       
    }    

    @FXML
    private void EnregistrerFormation(ActionEvent event) {
                     FormationService fs = new FormationService();
    if (!Nomecole.getText().isEmpty() ||!domaine.getText().isEmpty() || !diplome.getText().isEmpty()) {
           
         
          Formation f = fs.get(id);
            f.setNom_ecole(Nomecole.getText());
            f.setDomaine(domaine.getText());
            f.setDiplome(diplome.getText());
            f.setDescription(description.getText());
            f.setId_user(1);
            f.setAnnée_debut( anneedebut.getValue());
            fs.modiferFormation(f);
         ((Node)(event.getSource())).getScene().getWindow().hide();      
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
