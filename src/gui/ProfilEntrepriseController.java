/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.Crudentreprise;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modals.Entreprise;
import modals.User;
import service.PortfolioEntrpriseService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ProfilEntrepriseController implements Initializable {

    
    @FXML
    private Label NomEntreprise;
    @FXML
    private Label TitreEntrprise;
    @FXML
    private Label adresseEntreprise;
    @FXML
    private Label descriptionEntreprise;
    @FXML
    private Label mail;
    @FXML
    private Label numero;
    @FXML
    private ImageView imge;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PortfolioEntrpriseService ce=new PortfolioEntrpriseService();
        User e=ce.getById(3);
         System.out.println(e.toString());
         NomEntreprise.setText(e.getNomSc());
         TitreEntrprise.setText(e.getSpecialite());
         adresseEntreprise.setText(e.getAdresse());
         descriptionEntreprise.setText(e.getDescription());
         mail.setText(e.getMail());
         numero.setText(e.getTel()+"");
        Image image=new Image("http://127.0.0.1"+e.getImage());
        imge.setImage(image);
         
         
    }    
    
}
