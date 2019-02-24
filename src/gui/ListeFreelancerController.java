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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import modals.Experience;
import modals.Freelancer;
import modals.Portfolio;
import service.ExperienceService;
import service.PortfolioService;

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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          PortfolioService es = new PortfolioService();
       ArrayList<Freelancer> p= new ArrayList<>();
       p = es.SelectFreelancer();
        System.out.println(p);

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
                           
                            JFXButton voir = new JFXButton("Voir plus");
                            t.setStyle("-fx-font-size: 20 arial;");
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ListeFreelancerController.id=item.getId();
                                    Stage stage = new Stage();
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
    
}
