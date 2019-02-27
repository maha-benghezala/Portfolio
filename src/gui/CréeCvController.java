/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import modals.Certification;
import modals.Competence;
import modals.Experience;
import modals.Formation;
import modals.Freelancer;
import modals.Langue;
import modals.Portfolio;
import modals.Projet;
import modals.User;
import service.CertificationService;
import service.CompetenceService;
import service.ExperienceService;
import service.FormationService;
import service.LangueService;
import service.PortfolioService;
import service.ProjetService;


/**
 * FXML Controller class
 *
 * @author Maha
 */
public class CréeCvController implements Initializable {

    @FXML
    private Button btn_apropos;
    @FXML
    private Button btn_formation;
    @FXML
    private Button btn_experience;
    @FXML
    private Button btn_projet;
    @FXML
    private Button btn_certif;
    @FXML
    private Button btn_competence;
    @FXML
    private Button btn_langue;
    @FXML
    private ImageView imgaffiche;
    @FXML
    private Label nom;
    @FXML
    private Label position;
    @FXML
    private Label email1;
    @FXML
    private Label numero;
    @FXML
    private Label adresse;
    @FXML
    private Label description;
    @FXML
    private ListView listeformation;
    @FXML
    private ListView listeExperience;
    @FXML
    private ListView listecompetence;
    @FXML
    private ListView listelangue;
    @FXML
    private ListView listecertificat;
    @FXML
    private ListView listeprojet;
    @FXML
    private AnchorPane plus;
    @FXML
    private Label linkedin;
    @FXML
    private Label gitub;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton pdf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
  
      
//            
//            Image image = new Image("plus.png");
//        ImageView imageView = new ImageView(image);
//           add = new Button("Home", imageView);
       
        test.Test.link="/gui/ProfilUser.fxml";

     
       
       PortfolioService ps =new PortfolioService();
       Portfolio p=ps.getByIdUser(1);
        System.out.println(p.toString());
       Freelancer user=ps.selectFreelancer();
       nom.setText(user.getPrenom()+" "+user.getNom());
       
       position.setText(user.getSpecialite());
       email1.setText(user.getMail());
       numero.setText(user.getTel()+"");
       adresse.setText(p.getAdresse());
       description.setText(p.getParler());
       linkedin.setText(p.getLinkedin());
       gitub.setText(p.getGithub());
        Image image=new Image("http://localhost"+p.getImage());
       imgaffiche.setImage(image);
       ExperienceService es = new ExperienceService();
       ArrayList<Experience> experience= new ArrayList<>();
       experience = es.getByIdUser(1);
        System.out.println(experience);

        ObservableList<Experience> observableList = FXCollections.observableArrayList(experience);
        listeExperience.setItems(observableList);
      
        listeExperience.setCellFactory(new Callback<ListView<Experience>, ListCell<Experience>>() {

            @Override
            public ListCell<Experience> call(ListView<Experience> arg0) {
                return new ListCell<Experience>() {

                    @Override
                    protected void updateItem(Experience item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t2 = new Text(item.getIntitule());
                            Text t = new Text(item.getNomentreprise());
                            Text t3 = new Text(item.getLieu());
                            Text t1 = new Text(item.getMois_debut()+"-"+item.getAnnée_debut()+"/"+item.getMois_fin()+"-"+item.getAnnée_fin());
                          
                            Text t4=new Text(item.getSecteur());
                            Text t5 = new Text(item.getDescription());
                            JFXButton voir = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierExperienceController.id=item.getId();
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierExperience.fxml"));
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
                              JFXButton supprimer = new JFXButton("Supprimer");
                           
                            supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                    es.SupprimerExperience(item.getId());
                  
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
          
                     }});
                           
                            VBox vBox = new VBox(t,t1,t2,t3,t4,t5);
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
        FormationService fs=new FormationService();
        ArrayList<Formation> formation= new ArrayList<>();
        formation = fs.getByIdUser(1);
        System.out.println(formation);

        ObservableList<Formation> observableList1 = FXCollections.observableArrayList(formation);
        listeformation.setItems(observableList1);
      
        listeformation.setCellFactory(new Callback<ListView<Formation>, ListCell<Formation>>() {

            @Override
            public ListCell<Formation> call(ListView<Formation> arg0) {
                return new ListCell<Formation>() {

                    @Override
                    protected void updateItem(Formation item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {

                            Text t = new Text(item.getNom_ecole());
                            Text t1 = new Text(item.getAnnée_debut());
                            Text t2=new Text(item.getDiplome());
                            Text t3 = new Text(item.getDomaine());
                          
                            Text t4 = new Text(item.getDescription());
                              JFXButton voir1 = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir1.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierFormationController.id=item.getId();
                
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierFormation.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Modifier Formation");
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
                 JFXButton supprimer = new JFXButton("Supprimer");
                           
               supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                    fs.SupprimerFormation(item.getId());
                     Stage stage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Cree CV");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                        }    });   
                            VBox vBox = new VBox(t,t1,t2,t3,t4);
                            vBox.setSpacing(4);
                            HBox hBox = new HBox(vBox,voir1,supprimer);
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
        
        CertificationService cs=new CertificationService();
        ArrayList<Certification> certification= new ArrayList<>();
        certification = cs.getByIdUser(1);
        System.out.println(certification);

        ObservableList<Certification> observableList2= FXCollections.observableArrayList( certification);
        listecertificat.setItems(observableList2);
        
        listecertificat.setCellFactory(new Callback<ListView<Certification>, ListCell<Certification>>() {

            @Override
            public ListCell<Certification> call(ListView<Certification> arg0) {
                return new ListCell<Certification>() {

                    @Override
                    protected void updateItem(Certification item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getNom_de_certification());
                            Text t2 = new Text(item.getMois_debut()+"-"+item.getAnnée_debut()+"/"+item.getMois_fin()+"-"+item.getAnnée_fin());
                           
                          
                            Text t3 = new Text(item.getId_diplome()+"");
                            Text t4 = new Text(item.getOrganisme());
                            Text t5 = new Text(item.getUrl());
                         
                           JFXButton voir5 = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir5.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierCertificatController.id=item.getId();
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierCertificat.fxml"));
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
                      JFXButton supprimer = new JFXButton("Supprimer");
                           
               supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                  cs.SupprimerCertification(item.getId());
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
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                        }    });   
                            VBox vBox = new VBox(t,t2,t3,t4);
                            vBox.setSpacing(4);
                            HBox hBox = new HBox(vBox,voir5,supprimer);
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
        LangueService ls=new LangueService();
        ArrayList<Langue> langue= new ArrayList<>();
        langue = ls.getByIdUser(1);
        System.out.println(langue);

        ObservableList<Langue> observableList3= FXCollections.observableArrayList( langue);
        listelangue.setItems(observableList3);
        
        listelangue.setCellFactory(new Callback<ListView<Langue>, ListCell<Langue>>() {

            @Override
            public ListCell<Langue> call(ListView<Langue> arg0) {
                return new ListCell<Langue>() {

                    @Override
                    protected void updateItem(Langue item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getLangue());
                            Text t1 = new Text(item.getNiveau());
                          JFXButton voir4 = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir4.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierLangueController.id=item.getId();
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierLangue.fxml"));
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
                 JFXButton supprimer = new JFXButton("Supprimer");
                           
               supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                  ls.SupprimerLangue(item.getId());
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
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                           }
                    });
                          
                            
                            t.setStyle("-fx-font-size: 25 arial;");
                                     VBox vBox = new VBox(t,t1);
                            vBox.setSpacing(4);
//                            Image image = new Image("http://127.0.0.1/MonGuide/web" + item.getImage(), true);
//                            ImageView imv = new ImageView(image);
//                            imv.setFitHeight(170);
//                            imv.setFitWidth(170);

                            HBox hBox = new HBox( vBox,voir4,supprimer);
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
        ProjetService pss=new ProjetService();
        ArrayList<Projet> projet= new ArrayList<>();
        projet = pss.getByIdUser(1);
        System.out.println(projet);

        ObservableList<Projet> observableList4= FXCollections.observableArrayList( projet);
        listeprojet.setItems(observableList4);
        
        listeprojet.setCellFactory(new Callback<ListView<Projet>, ListCell<Projet>>() {

            @Override
            public ListCell<Projet> call(ListView<Projet> arg0) {
                return new ListCell<Projet>() {

                    @Override
                    protected void updateItem(Projet item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getNom_projet());
                            Text t1 = new Text(item.getMoisdebut()+"-"+item.getAnneedebut()+"/"+item.getMoisfin()+"-"+item.getAnneefin());
                            
                            Text t2 = new Text(item.getUrl());
                            Text t3 = new Text(item.getDescription());
                          
                            
                           JFXButton voir6 = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir6.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierProjetController.id=item.getId();
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierProjet.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Modifier Projet");
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
        JFXButton supprimer = new JFXButton("Supprimer");
                supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                 pss.SupprimerProjet(item.getId());
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
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                           }
                    });
                            t.setStyle("-fx-font-size: 25 arial;");
                            VBox vBox = new VBox(t,t1,t2,t3);
                            vBox.setSpacing(4);
//                            Image image = new Image("http://127.0.0.1/MonGuide/web" + item.getImage(), true);
//                            ImageView imv = new ImageView(image);
//                            imv.setFitHeight(170);
//                            imv.setFitWidth(170);

                            HBox hBox = new HBox( vBox,voir6,supprimer);
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
         CompetenceService css=new CompetenceService();
        ArrayList<Competence> competence= new ArrayList<>();
        competence = css.getByIdUser(1);
        System.out.println(competence);

        ObservableList<Competence> observableList5= FXCollections.observableArrayList(competence);
        listecompetence.setItems(observableList5);
        
        listecompetence.setCellFactory(new Callback<ListView<Competence>, ListCell<Competence>>() {

            @Override
            public ListCell<Competence> call(ListView<Competence> arg0) {
                return new ListCell<Competence>() {

                    @Override
                    protected void updateItem(Competence item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            Text t = new Text(item.getCompetence());
                           
                             JFXButton voir2 = new JFXButton("Voir");
                            t.setStyle("-fx-font-size: 25 arial;");
                            voir2.setOnAction(new EventHandler<ActionEvent>(){
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println(item.getId());
                                    ModifierCompetenceController.id=item.getId();
                                    Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierComptence.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Modifier Competence");
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
         JFXButton supprimer = new JFXButton("Supprimer");
                supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                     public void handle(ActionEvent arg0) {
                    System.out.println(item.getId());
                 css.SupprimerCompetence(item.getId());
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
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                           }
                    });
                
                            t.setStyle("-fx-font-size: 25 arial;");
                            VBox vBox = new VBox(t);
                            vBox.setSpacing(4);
//                           
                            HBox hBox = new HBox( vBox,voir2,supprimer);
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
    private void AjouterDescription(ActionEvent event) {
        
        try {
           Stage stage = new Stage();
            Parent root ;
            
                root = FXMLLoader.load(getClass().getResource("/gui/Apropo.fxml"));
            
           
            stage.setTitle("Ajouter Profil");
            Scene scene = new Scene(root);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.centerOnScreen();
            stage.setScene(scene);
         
       
            stage.show();
            
        } catch (Exception e) {
            //showExceptionDialog(e);
        }
    }

    @FXML
    private void AjouterFormation(ActionEvent event) {
       
          
           Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Formation.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter");
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
    private void AjouterExperience(ActionEvent event) {
           Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Experience.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Experience");
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
    private void AjouterProjets(ActionEvent event) {
           Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Projet.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Projet");
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
    private void AjouterCertifications(ActionEvent event) {
           Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Certificat.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Certification");
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
    private void AjouterCompetence(ActionEvent event) {
         Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Competence.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Competence");
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
    private void AjouterLangue(ActionEvent event) {
         Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Langue.fxml"));
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


    private void Edit(ActionEvent event) {
         // TODO
           Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Experience.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Ajouter Experience");
                Scene scene = new Scene(pane);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CréeCvController.class.getName()).log(Level.SEVERE, null, ex);
            }
   }

    private void modifier(ActionEvent event) {
          Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierExperience.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Modifier Experience");
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
    private void Retour(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void update(ActionEvent event) {
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CreeCv.fxml"));
            try {
                Pane pane = (Pane) loader.load();
                stage.setTitle("Modifier Experience");
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
    private void Pdf(ActionEvent event) throws FileNotFoundException, DocumentException {
            Window owner = btn_apropos.getScene().getWindow();
            
            Node node = btn_apropos.getScene().getFocusOwner();
            PrinterJob job = PrinterJob.createPrinterJob();
            if(job != null){
                job.showPrintDialog(owner); // Window must be your main Stage
                job.printPage(node);
                
                job.endJob();
            
//         Document document = new Document();
//      try
//      {
//
//
//PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));
// 
//document.open();
 
//PdfPTable table = new PdfPTable(3);
//addTableHeader(table);
//addRows(table);
//addCustomRows(table);
// 
//document.add(table);
//document.close();


//
//    private void addTableHeader(PdfPTable table) {
//          Stream.of("column header 1", "column header 2", "column header 3")
//      .forEach(columnTitle -> {
//        PdfPCell header = new PdfPCell();
//       
//        header.setBorderWidth(2);
//        header.setPhrase(new Phrase(columnTitle));
//        table.addCell(header);
//    });
//    }

   

//
//    private void addRows(PdfPTable table) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    table.addCell("row 1, col 1");
//    table.addCell("row 1, col 2");
//    table.addCell("row 1, col 3");
//    
//    }catch(Exceprtion e){
//    
       

            }}
}