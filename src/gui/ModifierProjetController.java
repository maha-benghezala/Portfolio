/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modals.Projet;
import service.ProjetService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierProjetController implements Initializable {

    @FXML
    private JFXTextField nomprojet;
    @FXML
    private JFXTextField url;
    @FXML
    private JFXCheckBox check;
    @FXML
    private JFXComboBox<String> moisd;
    @FXML
    private JFXComboBox<String> moisf;
    @FXML
    private JFXComboBox<String> anneed;
    @FXML
    private JFXComboBox<String> anneef;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton enregistrer;
    public static int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            moisd.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("5"),

                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
             moisf.setItems(FXCollections.observableArrayList(
                    new String("1"),
                    new String("2"),
                    new String("3"),
                    new String("4"),
                    new String("5"),

                    new String("6"),
                    new String("7"),
                    new String("8"),
                    new String("9"),
                    new String("10"),
                    new String("11"),
                    new String("12")));
                  anneed.setItems(FXCollections.observableArrayList(
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
                anneef.setItems(FXCollections.observableArrayList(
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
          ProjetService ps= new ProjetService();
          Projet p= ps.get(id);
         nomprojet.setText(p.getNom_projet());
         description.setText(p.getDescription());
         
    }    

    @FXML
    private void checkprojet(ActionEvent event) {
            if(check.isSelected())
        {
        moisf.setVisible(false);
        anneef.setVisible(false);}
        else{
           moisf.setVisible(true);
            anneef.setVisible(true);
        }
    
    }

    @FXML
    private void EnregistrerProjet(ActionEvent event) {
             ProjetService ps= new ProjetService();
          Projet p= ps.get(id);
           p.setId_user(1);
           p.setMoisdebut(moisd.getValue());
           p.setMoisfin(moisf.getValue());
           p.setAnneedebut(anneed.getValue());
           p.setAnneefin(anneef.getValue());
           p.setNom_projet(nomprojet.getText());
           p.setUrl(url.getText());
            p.setDescription(description.getText());
            ps.modiferprojet(p);
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    
}
