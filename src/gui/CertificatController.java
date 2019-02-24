/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import modals.Certification;
import modals.Competence;
import service.CertificationService;
import service.CompetenceService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class CertificatController implements Initializable {

    @FXML
    private TextField NomCertificat;
    @FXML
    private ComboBox<String> Moisdebut;
    @FXML
    private ComboBox<String> Moisfin;
    @FXML
    private ComboBox<String> Anneedebut;
    @FXML
    private ComboBox<String> Anneefin;
    @FXML
    private Button Enregistrer;
    @FXML
    private Button Annuler;
   
    @FXML
    private TextField Numerolicence;
 
    private File file,file1;
    @FXML
    private JFXTextField organisme;
    @FXML
    private JFXTextField url;
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
           

    }    

//    private void ChooseFile(ActionEvent event) {
//        Window owner = Nomf.getScene().getWindow();
//        FileChooser chooser = new FileChooser();
//         File file = chooser.showOpenDialog(null);
//         file1 = file.getAbsoluteFile();
//        if (file1.getAbsolutePath().endsWith(".pdf") || file1.getAbsolutePath().endsWith(".docx")) {
//            
//            String imagePath = "/propriete/" + file1.getName();
//            Nomf.setText(imagePath);
//        }
        
//    }

    @FXML
    private void OnAdd(ActionEvent event) {
             CertificationService cs = new   CertificationService();
//        if (!NomCertificat.getText().isEmpty()|| !AutoriteCertificat.getText().isEmpty() || !Numerolicence.getText().isEmpty()) {
//            System.out.println("remplir tous les champs!");}
//        else
//        { 
            
           Certification ce=new Certification();
           ce.setId_user(1);
         ce.setNom_de_certification(NomCertificat.getText());
         
         ce.setOrganisme(organisme.getText());
         ce.setId_diplome(Integer.parseInt( Numerolicence.getText()));
         ce.setAnnée_debut(Anneedebut.getValue());
         ce.setAnnée_fin(Anneefin.getValue());
         ce.setMois_debut(Moisdebut.getValue());
         ce.setMois_fin(Moisfin.getValue());
         ce.setUrl(url.getText());
//         try {
//  

//                Path path1 = Paths.get(file1.getAbsolutePath());
//                
//                Files.copy(path1, path1.resolve(path1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
//               
//            } catch (IOException ex) {
//                Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
//            }
           
          cs.ajouterCertification(ce);
           
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CréeCv.fxml"));
//            try {
//                Pane pane = (Pane) loader.load();
//                stage.setTitle("Competence");
//                Scene scene = new Scene(pane);
//                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
//                stage.centerOnScreen();
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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
