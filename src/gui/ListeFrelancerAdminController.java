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
import modals.Freelancer;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ListeFrelancerAdminController implements Initializable {

    @FXML
    private JFXButton listeEntreprise;
    @FXML
    private JFXButton ListeFreelancer;
    @FXML
    private JFXButton ListeRates;
    @FXML
    private JFXButton deconnection;
    @FXML
    private JFXListView listeView;
    @FXML
    private Pane pane;
    @FXML
    private Label Nom;
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
                          Nom.setVisible(false);
                           adresse.setVisible(false);
                           ville.setVisible(false);
                           specialite.setVisible(false);
                           description.setVisible(false);
                           tel.setVisible(false);
                           contact.setVisible(false);
                           description.setDisable(true);
          PortfolioService es = new PortfolioService();
       ArrayList<Freelancer> p= new ArrayList<>();
       p = es.SelectFreelancer();
        System.out.println(p);

        ObservableList<Freelancer> observableList = FXCollections.observableArrayList(p);
        listeView.setItems(observableList);
      
        listeView.setCellFactory(new Callback<ListView<Freelancer>, ListCell<Freelancer>>() {

            @Override
            public ListCell<Freelancer> call(ListView<Freelancer> arg0) {
                return new ListCell<Freelancer>() {

                    @Override
                    protected void updateItem(Freelancer item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getImage()+"  "+item.getPrenom()+" "+item.getNom());
                            Text t1 = new Text(item.getSpecialite());
                            Text t2 = new Text(item.getDescription());
                           
                            JFXButton voir = new JFXButton("Voir plus");
                            t.setStyle("-fx-font-size: 20 arial;");
                          
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    pane.setVisible(true);
                           Nom.setVisible(true);
                           adresse.setVisible(true);
                           ville.setVisible(true);
                           specialite.setVisible(true);
                           description.setVisible(true);
                           tel.setVisible(true);
                           contact.setVisible(true);
                           Nom.setText(item.getPrenom()+" "+item.getNom());
                           specialite.setText(item.getSpecialite());
                           adresse.setText(item.getAdresse());
                           ville.setText(item.getVille());
                           tel.setText(item.getTel()+"");
                           description.setText(item.getDescription());
            
                                }
                                
                            });
                        
                           
                            VBox vBox = new VBox(t,t1,t2);
                            vBox.setSpacing(4);
//  
                            HBox hBox = new HBox(vBox,voir);
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
    private void ListeFreelancer(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListeFrelancer.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste Freelancer");
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
    private void ListeRates(ActionEvent event) {
    }

    @FXML
    private void Deconnection(ActionEvent event) {
    }

    @FXML
    private void Contact(ActionEvent event) {
         Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ContactUser.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Liste Freelancer");
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
