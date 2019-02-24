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
import modals.Freelancer;

import modals.Projet;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class ProjetService {
     Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterProjet(Projet p) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `projet`( `id-user`, `nomprojet`, `moisdebut`, `moisfin`, `anneedebut`, `anneefin`, `url`, `description`) VALUES("+p.getId_user() +",'"
                    +p.getNom_projet() +"','"+p.getMoisdebut()+"','"+p.getMoisfin()+"','"+p.getAnneedebut()+"','"+p.getAnneefin()+"','"+p.getUrl()+"','"+p.getDescription()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherProjet()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `projet`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`projet`"+rs.getInt(1)+","+rs.getString(3)+", "
                        +rs.getString(4)+","+rs.getInt(2)+","+rs.getString(5));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(CertificationService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferprojet(Projet p)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `projet` SET `nomprojet`=?,`moisdebut`=?,`moisfin`=?,`anneedebut`=?,`anneefin`=?,`url`=?,`description`=? WHERE  id =?");
           pt.setString(1,p.getNom_projet());
           pt.setString(2,p.getMoisdebut());
           pt.setString(3,p.getMoisfin());
           pt.setString(4,p.getAnneedebut());
           pt.setString(5,p.getAnneefin());
           pt.setString(6,p.getUrl());
           pt.setString(7,p.getDescription());
           pt.setInt(8,p.getId());
           pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerProjet(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `projet` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public ArrayList<Projet> getByIdUser(int id) {
        ArrayList<Projet> listprojet= new ArrayList<>();
        try {
            String req = "SELECT * FROM `projet` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listprojet.add(new Projet(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString("nomprojet"),
                            rs.getString("moisdebut"),
                            rs.getString("moisfin"),
                            rs.getString("anneedebut"),
                            rs.getString("anneefin"),
                            rs.getString("url"),
                            rs.getString("description")
                          
                        
                            
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listprojet;
        
    }
   public Projet get(int id) {
        Projet a = new Projet();
            try {
                String req = "SELECT * from `projet` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
              a.setId(rs.getInt("id"));
              a.setNom_projet(rs.getString("nomprojet"));
              a.setMoisdebut(rs.getString("moisdebut"));
              a.setMoisfin(rs.getString("moisfin"));
              a.setAnneedebut(rs.getString("anneedebut"));
              a.setAnneefin(rs.getString("anneefin"));
              a.setUrl(rs.getString("url"));
              a.setDescription(rs.getString("description"));
              
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
   public int nbProjet(Freelancer f)
    {
        int nb = 0;
        try {
            Statement st = C.createStatement();
            String req="SELECT COUNT(*) FROM `projet` WHERE `id-user`="+f.getId();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            nb=rs.getInt(1);}
               } catch (SQLException ex) {
            Logger.getLogger(CertificationService .class.getName()).log(Level.SEVERE, null, ex);
        }
       return nb;
    }
}
