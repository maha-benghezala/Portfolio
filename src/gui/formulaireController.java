/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import modals.Freelancer;
import modals.Portfolio;
import modals.User;

import service.PortfolioService;
import test.Test;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class formulaireController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
 
    @FXML
    private TextField adresse;
    @FXML
    private TextField tel;
    @FXML
    private TextArea description;

    private static User u;
    @FXML
    private JFXButton ajoutimg;
    @FXML
    private ImageView img;
    @FXML
    private JFXTextField btn ;
    @FXML
    private JFXButton ajoutimg1;
    @FXML
    private JFXTextField btn1;
    @FXML
    private TextField titre;
      private File file;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton sup;
 public static int id;
    @FXML
    private JFXTextField likedin;
    @FXML
    private JFXTextField github;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         PortfolioService ps = new PortfolioService();
        Portfolio p=ps.getByIdUser(1);
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
       btn.setText(p.getImage());
       github.setText(p.getGithub());
       likedin.setText(p.getLinkedin());
      

    }

//    private void onCreate(ActionEvent event) {
//       
//        System.out.println(t1.getText()+"et"+t2.getText());
//    }
 

    @FXML
    private void OnAdd(ActionEvent event) throws IOException {
 
     PortfolioService ps = new PortfolioService();
       Portfolio p=ps.getByIdUser(1);
           
            if(p ==null)
        {
            if(!adresse.getText().isEmpty() && !titre.getText().isEmpty() &&!description.getText().isEmpty())
            {
              if((tel+"").length()==8)
              {
                  
             
        
       adresse.setText(p.getAdresse());
       Image image=new Image("http://localhost"+p.getImage());
       img.setImage(image);
       titre.setText(p.getTitre());
       description.setText(p.getParler());
       github.setText(p.getGithub());
       likedin.setText(p.getLinkedin());
            ps.ajouterPortfolio(p);
              ((Node)(event.getSource())).getScene().getWindow().hide(); 
              }
            else{
                System.out.println("Verifier votre numero!");
            }
      }else{
                  System.out.println("remplir tous les champs!");   
      }
                   
    }else{
      
        System.out.println(p.toString());
        p.setParler(description.getText());
        p.setTitre(titre.getText());
        p.setAdresse(adresse.getText());
        p.setImage(btn.getText());
        p.setGithub(github.getText());
        p.setLinkedin(likedin.getText());
    
             ps.modiferPortfolio(p);
               ((Node)(event.getSource())).getScene().getWindow().hide(); 
             //Window owner = titre.getScene().getWindow();
                
//              Alert alert = new Alert(AlertType.INFORMATION);
//alert.setTitle("Information Dialog");
//alert.setHeaderText("Look, an Information Dialog");
//alert.setContentText("I have a great message for you!");
//
//alert.showAndWait();
            }
   add.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                  
                  Stage stage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Supprimer");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                           }
                    });
           ((Node)(event.getSource())).getScene().getWindow().hide();
         
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
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // do what you have to do
    stage.close();
                                }
    }

   
  

  


