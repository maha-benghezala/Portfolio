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
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.Experience;

import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class ExperienceService {
     Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterExperience(Experience e) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `experience`(`intituleposte`, `nomentreprise`, `lieu`, `moisdebut`, `moisfin`, `anneedebut`, `anneefin`, `secteur`, `description`, `id-user`) VALUES ('" 
                    +e.getIntitule() +"','"+e.getNomentreprise()+"','"+e.getLieu()+"','"+e.getMois_debut()+"','"+e.getMois_fin()+"','" +e.getAnnée_debut()+
                    "','"+e.getAnnée_fin()+"','"+e.getSecteur()+"','"+e.getDescription()+"'," + e.getId_user() + ")";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherExperience()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `experience`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`experience`"+rs.getInt(1)+","+rs.getString(2)+", "
                        +rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","
                        +rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getInt(10));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ExperienceService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferExperience(Experience e)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `experience` SET `intituleposte`=?,`nomentreprise`=?,`lieu`=?,`moisdebut`=?,`moisfin`=?,`anneedebut`=?,`anneefin`=?,`secteur`=?,`description`=? ,`id-user`=? WHERE `id`=? ");
            pt.setString(1,e.getIntitule());
            pt.setString(2,e.getNomentreprise());
            pt.setString(3,e.getLieu());
            pt.setString(4,e.getMois_debut());
            pt.setString(5,e.getMois_fin());
            pt.setString(6,e.getAnnée_debut());
            pt.setString(7,e.getAnnée_fin());
            pt.setString(8,e.getSecteur());
            pt.setString(9,e.getDescription());   
               pt.setInt(10,e.getId_user());
            pt.setInt(11,e.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerExperience(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `experience` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  public ArrayList<Experience> getByIdUser(int id) {
        ArrayList<Experience> listexperience = new ArrayList<>();
        try {
            String req = "SELECT * FROM `experience` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listexperience.add(new Experience(rs.getInt(1),
                            rs.getInt("id-user"),
                            rs.getString("intituleposte"),
                            rs.getString("nomentreprise"),
                            rs.getString("lieu"),
                            rs.getString("moisdebut"),
                            rs.getString("moisfin"),
                            rs.getString("anneedebut"),
                            rs.getString("anneefin"),
                            rs.getString("secteur"),
                            rs.getString("description")
                           
                           
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listexperience;
        
    }
  public Experience get(int id) {
        Experience a = new Experience();
            try {
                String req = "SELECT * FROM `experience` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                  
                    a.setIntitule(rs.getString("intituleposte"));
                    a.setNomentreprise(rs.getString("nomentreprise"));
                    a.setLieu(rs.getString("lieu"));
                    a.setMois_debut(rs.getString("moisdebut"));
                    a.setMois_debut(rs.getString("moisfin"));
                    a.setAnnée_debut(rs.getString("anneedebut"));
                    a.setAnnée_fin(rs.getString("anneefin"));
                    a.setSecteur(rs.getString("secteur"));
                    a.setDescription(rs.getString("description"));
                      a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
}
