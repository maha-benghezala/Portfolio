/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.Competence;
import modals.Portfolio;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class CompetenceService {
     private PreparedStatement ste;
    Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterCompetence(Competence c) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `competence`(`id-user`, `nom_Competence`) VALUES ("+c.getId_user()+",'"+c.getCompetence()+"')";
         /** String req = "INSERT INTO `portfolio`( `id-user`, `specialite`, `nom`, `prenom`, `poste_actuel`, `adresse`, `tel`, `parler`) VALUES" + p.getId_user() + ",'" 
                    +p.getSpecialite() +"','" +p.getNom() +"','" +p.getPrenom() +"','" +p.getPoste_actuel() +"','" +p.getAdresse() +"'," 
                    +p.getTel() +",'"+p.getParler()+"')";**/
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

  public void afficherCompetence()
    {
        try {
            Statement st = C.createStatement();
            String req="SELECT * FROM `competence`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`Competence"+rs.getInt(1)+"nom competence"+rs.getString(3)+"user id "+rs.getInt(2));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(PortfolioService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferCompetence(Competence c)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `competence` SET `nom_Competence`=? WHERE `id`=? ");
            pt.setString(1,c.getCompetence());
            pt.setInt(2, c.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerCompetence(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `competence` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public ArrayList<Competence> getByIdUser(int id) {
        ArrayList<Competence> listcompetence = new ArrayList<>();
        try {
            String req = "SELECT * FROM `competence` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listcompetence.add(new Competence(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString("nom_Competence")
                            
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listcompetence;
        
    }
      public Competence get(int id) {
        Competence  a = new Competence ();
            try {
                String req = "SELECT * FROM `competence` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
              a.setId(rs.getInt("id"));
              a.setCompetence(rs.getString("nom_Competence"));
              a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CompetenceService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
}
