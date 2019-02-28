/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.FileNotFoundException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modals.Portfolio;
import org.jpedal.PdfDecoderFX;
import org.jpedal.exception.PdfException;
import service.PortfolioService;
import service.ProjetService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class TelechargerPdfController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private JFXButton profil;
    @FXML
    private JFXButton creecv;
    @FXML
    private JFXButton listeentreprise;
    @FXML
    private JFXButton telechergercv;
    @FXML
    private JFXButton deconnection;
    @FXML
    private PdfDecoderFX pdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         PortfolioService ps = new PortfolioService();
           ProjetService prj = new ProjetService();
           
        Portfolio p=ps.getByIdUser(1);
         Image image=new Image("http://127.0.0.1"+p.getImage());
       img.setImage(image);
         try {
            
            pdf.openPdfFile("C:\\Users\\Jasser\\Desktop/Cv.pdf");
            decodePage();
            System.out.println(pdf.getNumberOfPages());
            
            
    
        } catch (PdfException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }    

    @FXML
    private void MonProfil(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfilUser.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Profil");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void CreeCv(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("CV");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void ListeEntreprise(ActionEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListeEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste des Entreprises");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void TélechargerCv(ActionEvent event) throws FileNotFoundException{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
//            /     Stage stage = new Stage();

               FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TélechargerPdf.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Profil");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
                
         
    }
 private void decodePage() {

    try {
        pdf.setPageDisplayMode(1);
        pdf.setPageParameters(1.0f, 1);
        pdf.decodePage(1);
        pdf.setPageParameters(1.2f, 1);
        pdf.decodePage(1);
        pdf.waitForDecodingToFinish();
       
    } catch (final Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
}
    @FXML
    private void Deconnection(ActionEvent event) {
    }
    
}
