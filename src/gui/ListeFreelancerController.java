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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

import modals.Experience;
import modals.Freelancer;
import modals.Portfolio;
import modals.Rate;
import org.controlsfx.control.Rating;
import service.ExperienceService;
import service.PortfolioService;
import service.RateService;

/**
 * FXML Controller class
 *
 * @author Maha
 */
public class ListeFreelancerController implements Initializable {

    @FXML
    private ImageView imge;
    @FXML
    private JFXButton profil;
    @FXML
    private JFXButton liste;
    @FXML
    private JFXListView listeFreelancer;
       public static int id;
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
    @FXML
    private JFXButton rate;
    @FXML
    private JFXButton deconnection;
     final Rating rating = new Rating();
    int Value;
    private JFXListView listerate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        final Rating rating = new Rating();
//           rating.setPartialRating(true);

                           Nom.setVisible(false);
                           adresse.setVisible(false);
                           ville.setVisible(false);
                           specialite.setVisible(false);
                           description.setVisible(false);
                           tel.setVisible(false);
                           contact.setVisible(false);
                           description.setDisable(true);
                           pane.setVisible(false);
          PortfolioService es = new PortfolioService();
       ArrayList<Freelancer> p= new ArrayList<>();
       p = es.SelectFreelancer();
        System.out.println(p);
      RateService rs=new RateService();
        ObservableList<Freelancer> observableList = FXCollections.observableArrayList(p);
        listeFreelancer.setItems(observableList);
      
        listeFreelancer.setCellFactory(new Callback<ListView<Freelancer>, ListCell<Freelancer>>() {

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
                            
                           JFXButton avis = new JFXButton("Donner un avis");
                             avis.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    RateController.id = item.getId();
                  Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Rate.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Langue");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                                }
                            });
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
//                          rating.setPartialRating(true);
                                }
                                   });
                            VBox vBox = new VBox(t,t1,t2);
                            vBox.setSpacing(4);
//  
                            HBox hBox = new HBox(vBox,voir,avis);
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
        
       listeFreelancer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Freelancer>() {

            @Override
            public void changed(ObservableValue<? extends Freelancer> observable, Freelancer oldValue, Freelancer newValue) {

               
                
                
                ArrayList<Rate>al=rs.getByIdUser(id);
                ObservableList<Rate> observableList1 = FXCollections.observableArrayList(al);
                listerate.setItems(observableList1);
                listerate.setCellFactory(new Callback<ListView<Rate>, ListCell<Rate>>() {

            @Override
            public ListCell<Rate> call(ListView<Rate> arg0) {
                return new ListCell<Rate>() {

                    @Override
                    protected void updateItem(Rate item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {

                            Rating t = new Rating();
                            t.setRating(item.getAvis());
                            //t.setStyle("-fx-font-size: 25 arial;");
                            //t.setFill(Color.web("#ff214f"));
                            VBox vBox = new VBox(t,
                                    //new Timestamp(item.s),
                                    new Text(item.getCommentaire())
                                   
                                    //new HBox(bt, bt1)
                            );
                            vBox.setSpacing(4);
                          
                            

                            HBox hBox = new HBox( vBox);
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
        });
//       rating.ratingProperty().addListener(new ChangeListener<Number>() {
//           @Override
//            public void changed(ObservableValue<? extends Number> observable,
//                    Number oldValue, Number newValue) {
//               Value = newValue.intValue();
//                System.out.println(Value);
//            }
//
//           
//        });
    }    

    @FXML
    private void Contact(ActionEvent event) {
           Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ContactUser.fxml"));
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
    private void Profil(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfilEntreprise.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("profil");
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
    private void Listefreelancer(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/listeFreelancer.fxml"));
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
    private void Rate(ActionEvent event) {
//        Window owner = rate.getScene().getWindow();
//        RateService Rs = new RateService();
//        PortfolioService ps = new PortfolioService();
//       
//        Rate R = new Rate(Commentaire.getText(),Value,timestamp);
//        
//        if(R1 == null){
//        Rs.createPropriete(R);
//        Double avgs = Rs.selectAvg(id_prop);
//        ps.setVisites(id_prop, avgs);
    }

    @FXML
    private void Deconnection(ActionEvent event) {
    }

    
    
}
