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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import modals.Entreprise;
import modals.Freelancer;
import service.PortfolioEntrpriseService;
import service.PortfolioService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ListeEntrepriseController implements Initializable {

    @FXML
    private JFXListView listeEntreprise;
    @FXML
    private Label adresse;
    @FXML
    private Label specialite;
    @FXML
    private JFXTextArea description;
    @FXML
    private Label tel;
    @FXML
    private JFXButton contact;
    @FXML
    private Label ville;
      public static int id;
    @FXML
    private Label NomSc;
    @FXML
    private Pane pane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
                           NomSc.setVisible(false);
                           adresse.setVisible(false);
                           ville.setVisible(false);
                           specialite.setVisible(false);
                           description.setVisible(false);
                           tel.setVisible(false);
                           contact.setVisible(false);
                           description.setDisable(true);
           PortfolioEntrpriseService es = new PortfolioEntrpriseService();
       ArrayList<Entreprise> e= new ArrayList<>();
       e = es.selectEntreprise();
        System.out.println(e);
 
        ObservableList<Entreprise> observableList = FXCollections.observableArrayList(e);
        listeEntreprise.setItems(observableList);
      
        listeEntreprise.setCellFactory(new Callback<ListView<Entreprise>, ListCell<Entreprise>>() {

      
            @Override
            public ListCell<Entreprise> call(ListView<Entreprise> arg0) {
                return new ListCell<Entreprise>() {

                    @Override
                    protected void updateItem(Entreprise item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t=new Text(item.getNomSc());
                            Text t1=new Text(item.getSpecialite());
                            Text t2=new Text(item.getAdresse());
                            Text t3= new Text(item.getTel()+"");
                            Text t4=new Text(item.getVille());
                         //   Text t5=new Text(item.getDescription());
                            JFXButton voir = new JFXButton("Voir plus");
                            t.setStyle("-fx-font-size: 20 arial;");
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                  
                                 
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
                        
                           
                            VBox vBox = new VBox(t,t1,t2,t3,t4);
                            vBox.setSpacing(4);
                      
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
    private void Contact(ActionEvent event) {
            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ContactEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Competence");
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
    private void ListeEntreprise(ActionEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListeEntreprise.fxml"));
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
    private void TélechargerCv(ActionEvent event) {
    }

    @FXML
    private void Deconnection(ActionEvent event) {
    }
    }
    

