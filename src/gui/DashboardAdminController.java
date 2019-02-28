/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import modals.Entreprise;
import modals.Freelancer;
import modals.User;
import service.ContactEntrepriseService;
import service.PortfolioEntrpriseService;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private JFXButton listeEntreprise;
    @FXML
    private JFXButton ListeFreelancer;
    @FXML
    private JFXButton ListeRates;
    @FXML
    private JFXButton deconnection;
    @FXML
    private JFXListView liste1;
    @FXML
    private Pane pane;
    @FXML
    private Label NomSc;
    @FXML
    private Label adresse;
    @FXML
    private Label specialite;
    @FXML
    private Label ville;
    @FXML
    private JFXButton contact;
    @FXML
    private Label tel;
    @FXML
    private JFXTextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pane.setVisible(false);
        NomSc.setVisible(false);
                           adresse.setVisible(false);
                           ville.setVisible(false);
                           specialite.setVisible(false);
                           description.setVisible(false);
                           tel.setVisible(false);
                           contact.setVisible(false);
        PortfolioEntrpriseService es = new PortfolioEntrpriseService();
       ArrayList<Entreprise> e= new ArrayList<>();
       e = es.selectEntreprise();
        System.out.println(e);
       ContactEntrepriseService c=new ContactEntrepriseService();
       ObservableList<Entreprise> observableList = FXCollections.observableArrayList(e);
        liste1.setItems(observableList);
      
        liste1.setCellFactory(new Callback<ListView<Entreprise>, ListCell<Entreprise>>() {

            @Override
            public ListCell<Entreprise> call(ListView<Entreprise> arg0) {
                return new ListCell<Entreprise>() {

                    @Override
                    protected void updateItem(Entreprise item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getNomSc());
                            Text t1 = new Text(item.getSpecialite());
                            Text t2=new Text(item.getAdresse());
                         
                           
                            JFXButton voir = new JFXButton("Voir Plus");
                            t.setStyle("-fx-font-size: 20 arial;");
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    pane.setVisible(true);
                           NomSc.setVisible(true);
                           adresse.setVisible(true);
                           ville.setVisible(true);
                           specialite.setVisible(true);
                           description.setVisible(true);
                           tel.setVisible(true);
                           contact.setVisible(true);
                           NomSc.setText(item.getNomSc());
                           specialite.setText(item.getSpecialite());
                           adresse.setText(item.getAdresse());
                           ville.setText(item.getVille());
                           tel.setText(item.getTel()+"");
                           description.setText(item.getDescription());
            
                                }
                                
                            });
                                             
         JFXButton supprimer = new JFXButton("Supprimer");
                supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                    c.SupprimerContactEntreprise(item.getId());
                    es.SupprimerPortfolioEntrprise(item.getId());
            
                
                           }
                    });
                        
                           
                            VBox vBox = new VBox(t,t1,t2);
                            vBox.setSpacing(4);
//  
                            HBox hBox = new HBox(vBox,voir,supprimer);
                            hBox.setSpacing(10);

                            setGraphic(hBox);

                        } else {

                            setText(null);
                            setGraphic(null);

                        }
                    }

                };
            }

        });
    }    

    @FXML
    private void ListeEntreprise(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/DashboardAdmin.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste Entreprise");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void ListeFreelancer(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListeFrelancerAdmin.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste Freelancer");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void ListeRates(ActionEvent event) {
    }

    @FXML
    private void Deconnection(ActionEvent event) {
    }

    @FXML
    private void Contact(ActionEvent event) {
          Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ContactEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Contact Entreprise");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(formulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
