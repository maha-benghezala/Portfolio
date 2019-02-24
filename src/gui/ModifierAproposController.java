/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import modals.Freelancer;
import modals.Portfolio;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ModifierAproposController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private JFXTextField btn;
    @FXML
    private JFXButton ajoutimg;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton sup;
    @FXML
    private JFXButton ajoutimg1;
    @FXML
    private JFXTextField btn1;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextArea description;
    private File file;
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
            PortfolioService ps = new PortfolioService();
        Portfolio p=ps.get(1);
        System.out.println(p.toString());
        Freelancer user=ps.selectFreelancer();
       nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        tel.setText(user.getTel()+"");
       adresse.setText(p.getAdresse());
       Image image=new Image("http://localhost/"+p.getImage());
       img.setImage(image);
       titre.setText(p.getTitre());
       description.setText(p.getParler());
        p.setId_user(1);
    }    

    @FXML
    private void ChooseImage(ActionEvent event) {
          Window owner = img.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        File file1 = chooser.showOpenDialog(null);
        file = file1.getAbsoluteFile();
        if (file1.getAbsolutePath().endsWith(".jpg") || file1.getAbsolutePath().endsWith(".jpeg") || file1.getAbsolutePath().endsWith(".png")) {
            Image ims = new Image(file1.toURI().toString());
            System.out.println(file1.toURI().toString());
            img.setImage(ims);
            String imagePath = "/image/" + file.getName();
            btn.setText(imagePath);
            
        } 
    }

    @FXML
    private void OnAdd(ActionEvent event) {
           PortfolioService ps = new PortfolioService();
       Portfolio p=ps.get(1);
         try {
                
                Path path = Paths.get("C:/xampp/htdocs/image");
                Path path1 = Paths.get(file.getAbsolutePath());
             
                Files.copy(path1, path.resolve(path1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(p.toString());
        Freelancer user=ps.selectFreelancer();
       nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
       p.setImage(btn.getText());
 
      
       tel.setText(user.getTel()+"");
       
           
           
           p.setAdresse(adresse.getText());
           
           p.setParler(description.getText());
           p.setTitre(titre.getText());
           
          
           p.setId_user(1);
            ps.modiferPortfolio(p);
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    
}
