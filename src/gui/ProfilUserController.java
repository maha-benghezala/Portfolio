/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXToggleButton;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import static com.lowagie.text.pdf.BidiOrder.PDF;
import static com.lowagie.text.pdf.PdfName.PDF;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static javax.print.DocFlavor.BYTE_ARRAY.PDF;
import static javax.print.DocFlavor.INPUT_STREAM.PDF;
import static javax.print.DocFlavor.URL.PDF;
import modals.Freelancer;
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
public class ProfilUserController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label nom;
    @FXML
    private Label titre;
    @FXML
    private Label adresse;
    @FXML
    private JFXTextArea description;
    @FXML
    private Label nbprojet;
    @FXML
    private JFXToggleButton disponible;
    @FXML
    private JFXToggleButton visible;
    @FXML
    private JFXButton listeentreprise;
    @FXML
    private JFXButton creecv;
    @FXML
    private JFXButton telechergercv;
    @FXML
    private JFXButton deconnection;
    @FXML
    private JFXButton profil;
    @FXML
    private PdfDecoderFX menudeco;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
           PortfolioService ps = new PortfolioService();
           ProjetService prj = new ProjetService();
           
        Portfolio p=ps.getByIdUser(1);
        System.out.println(p.toString());
        Freelancer user=ps.selectFreelancer();
        nbprojet.setText(prj.nbProjet(user)+"");
       
       nom.setText(user.getPrenom()+" "+user.getNom());
       
       adresse.setText(p.getAdresse());
       Image image=new Image("http://127.0.0.1"+p.getImage());
       img.setImage(image);
       titre.setText(p.getTitre());
       description.setText(p.getParler());
       description.setDisable(true);
       
        if(user.getDisponible().equals("Disponible")){
            disponible.setSelected(true);
        }
        if(user.getVisible().equals("Visible")){
            visible.setSelected(true);
        }
    }    

    @FXML
    private void onDisponibilite(ActionEvent event) {
        PortfolioService ps = new PortfolioService();
            Freelancer f =ps.selectFreelancer();
            
        if(disponible.isSelected()){
            f.setDisponible("Disponible");
            ps.updateDisonibilite(f);
           System.out.println("button is selected");
} else {
            f.setDisponible("Non Disponible");
            ps.updateDisonibilite(f);
    System.out.println("button is not selected");
}
    }

    @FXML
    private void onVisible(ActionEvent event) {
        PortfolioService ps = new PortfolioService();
            Freelancer f =ps.selectFreelancer();
            
            if(visible.isSelected()){
            f.setVisible("Visible");
            ps.updatevisibilite(f);
           System.out.println("button is selected");
} else {
            f.setVisible("Non Visible");
            ps.updatevisibilite(f);
    System.out.println("button is not selected");
}
    }

    @FXML
    private void ListeEntreprise(ActionEvent event) {
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListeEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Crée Cv");
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
                               Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Crée Cv");
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
    private void TélechargerCv(ActionEvent event) throws FileNotFoundException {
       
       
            
            try {
            menudeco.openPdfFile("c:/cv.pdf");
            decodePage();
            System.out.println(menudeco.getNumberOfPages());
            
            
    
        } catch (PdfException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
       }
       
   
 private void decodePage() {

    try {
        menudeco.setPageDisplayMode(1);
        menudeco.setPageParameters(1.0f, 1);
        menudeco.decodePage(1);
        menudeco.setPageParameters(1.2f, 1);
        menudeco.decodePage(1);
        menudeco.waitForDecodingToFinish();
       
    } catch (final Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
}
    @FXML
    private void Deconnection(ActionEvent event) {
    }

    @FXML
    private void MonProfil(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Crée Cv");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
