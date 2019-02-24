/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
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
    private Label description;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                            Text t = new Text(item.getNomSc());
                             Text t1 = new Text(item.getDescription());
                           
                            JFXButton voir = new JFXButton("Voir plus");
                            t.setStyle("-fx-font-size: 20 arial;");
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ListeEntrepriseController.id=item.getId();
                   
                                }
                                
                            });
                        
                           
                            VBox vBox = new VBox(t,
                            new Text(item.getNom_sc()),
                            new Text(item.getSpecialite()),
                            new Text(item.getAdresse()),
                            new Text(item.getTel()+""),
                            new Text(item.getVille()),
                            new Text(item.getDescription()));
                            vBox.setSpacing(4);
                       Image image=new Image("http://localhost"+item.getImage(),true);
                       ImageView img=new ImageView(image);
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
    
}
