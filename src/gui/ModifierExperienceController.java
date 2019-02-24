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
import modals.Experience;
import service.ExperienceService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierExperienceController implements Initializable {

    @FXML
    private JFXComboBox<String> moisf;
    @FXML
    private JFXComboBox<String> moisd;
    @FXML
    private JFXComboBox<String> anneed;
    @FXML
    private JFXComboBox<String> anneef;
    @FXML
    private JFXComboBox<String> secteur;
    @FXML
    private JFXCheckBox check;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXTextField intitule;
    @FXML
    private JFXTextField Nomentreprise;
    @FXML
    private JFXTextField lieu;
    @FXML
    private JFXTextArea Description;
    public static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        ExperienceService es = new  ExperienceService();
//        if (!Nomentreprise.getText().isEmpty()) {
//            System.out.println("remplir tous les champs!");}
//        else
//        { 
           Experience e=es.get(id);
          e.setId(e.getId());
           e.setId_user(1);
         Nomentreprise.setText(e.getNomentreprise());
         intitule.setText(e.getIntitule());
        lieu.setText(e.getLieu());
        Description.setText(e.getDescription());
           e.setAnnée_debut(anneed.getValue());
         e.setMois_debut(moisd.getValue()); 
         e.setMois_fin(moisf.getValue());
             e.setAnnée_fin(anneef.getValue());
        e.setSecteur(secteur.getValue());
      
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
            secteur.setItems(FXCollections.observableArrayList(
                    new String("Service Informatique"),
                    new String("Design"),
                    new String("Logiciel Informatique"),
                    new String("Securité informatique et sécurité"),
                    new String("Télécommunication")));
    }    

    @FXML
    private void change(ActionEvent event) {
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
    private void Enregistrer(ActionEvent event) {
       ExperienceService es = new  ExperienceService();
//        if (!Nomentreprise.getText().isEmpty()) {
//            System.out.println("remplir tous les champs!");}
//        else
//        { 
           Experience e=es.get(id);
         
           e.setId_user(1);
        e.setNomentreprise(Nomentreprise.getText());
         e.setIntitule(intitule.getText());
        e.setLieu(lieu.getText());
       e.setDescription(Description.getText());
           e.setAnnée_debut(anneed.getValue());
         e.setMois_debut(moisd.getValue()); 
         e.setMois_fin(moisf.getValue());
             e.setAnnée_fin(anneef.getValue());
        e.setSecteur(secteur.getValue());
        es.modiferExperience(e);
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    
}
