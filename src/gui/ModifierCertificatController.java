/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import modals.Certification;
import service.CertificationService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierCertificatController implements Initializable {

    @FXML
    private JFXTextField NomCertificat;
    @FXML
    private JFXTextField organisme;
    @FXML
    private JFXTextField Numerolicence;
    @FXML
    private JFXTextField url;
    @FXML
    private JFXComboBox<String> Moisdebut;
    @FXML
    private JFXComboBox<String> Moisfin;
    @FXML
    private JFXComboBox<String> Anneedebut;
    @FXML
    private JFXComboBox<String> Anneefin;
    @FXML
    private JFXButton Enregistrer;
    @FXML
    private JFXButton Annuler;
    public static int id;
    @FXML
    private JFXCheckBox check;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Moisdebut.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
             Moisfin.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
                  Anneedebut.setItems(FXCollections.observableArrayList(
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
                 Anneefin.setItems(FXCollections.observableArrayList(
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
                   CertificationService cs = new   CertificationService();
                    Certification ce=cs.get(id);
                    organisme.setText(ce.getOrganisme());
                    NomCertificat.setText(ce.getNom_de_certification());
                    Numerolicence.setText(ce.getId_diplome()+"");
                   
    }    

    @FXML
    private void OnAdd(ActionEvent event) {
        CertificationService cs = new   CertificationService();
        if (!NomCertificat.getText().isEmpty()|| !organisme.getText().isEmpty() || !Numerolicence.getText().isEmpty()) {
            if(Integer.parseInt(Anneefin.getValue())>Integer.parseInt(Anneedebut.getValue()))
            {

            
           Certification ce=cs.get(id);
           
         ce.setNom_de_certification(NomCertificat.getText());
         
         ce.setOrganisme(organisme.getText());
         ce.setId_diplome(Integer.parseInt( Numerolicence.getText()));
         ce.setAnnée_debut(Anneedebut.getValue());
         ce.setAnnée_fin(Anneefin.getValue());
         ce.setMois_debut(Moisdebut.getValue());
         ce.setMois_fin(Moisfin.getValue());
         ce.setUrl(url.getText());
         ce.setId_user(1);
         cs.modiferCertification(ce);
          ((Node)(event.getSource())).getScene().getWindow().hide();

        }else
            { 
            System.out.println("remplir tous les champs!");
            }
        }
       else{
            System.out.println("remplir tous les champs!");
        }
    }
   

    @FXML
    private void Annuler(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void check(ActionEvent event) {
          if(check.isSelected())
        {
        Moisfin.setVisible(false);
        Anneefin.setVisible(false);}
        else{
            Moisfin.setVisible(true);
            Anneefin.setVisible(true);
        }
    }
    
}
