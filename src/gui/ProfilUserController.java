/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.Crudfreelancer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modals.Freelancer;
import modals.Portfolio;
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
    private Label description;
    @FXML
    private Label nbprojet;
    @FXML
    private JFXToggleButton disponible;
    @FXML
    private JFXToggleButton visible;
    @FXML
    private JFXButton cv;
    @FXML
    private JFXButton recrutement;
    @FXML
    private JFXButton listeentreprise;
    @FXML
    private JFXButton deconnetion;

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
        if(user.getDisponible().equals("Disponible")){
            disponible.setSelected(true);
        }
        if(user.getVisible().equals("Visible")){
            visible.setSelected(true);
        }
       nom.setText(user.getPrenom()+" "+user.getNom());
       
       adresse.setText(p.getAdresse());
       Image image=new Image("http://127.0.0.1"+p.getImage());
       img.setImage(image);
       titre.setText(p.getTitre());
       description.setText(p.getParler());
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
    
    
}
