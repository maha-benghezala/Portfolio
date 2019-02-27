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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.Certification;

import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class CertificationService {
     Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterCertification(Certification c) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `certification`( `id-user`, `nomdecertification`, `organisme`, `moisd`, `moisf`, `anneed`, `anneef`, `iddi`, `url`) VALUES  ("+c.getId_user() +",'"
                    +c.getNom_de_certification() +"','"+c.getOrganisme()+"','"+c.getMois_debut()+"','"+c.getMois_fin()+"','"
                    +c.getAnnée_debut()+"','"+c.getAnnée_fin()+"',"+c.getId_diplome()+",'"+c.getUrl()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CertificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherCertification()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `certification`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`experience`"+rs.getInt(1)+","+rs.getString(3)+", "
                        +rs.getString(4)+","+rs.getInt(2)+","+rs.getInt(5)+","+rs.getString(6)+","+rs.getString(7)+","
                        +rs.getString(8)+","+rs.getString(9)+","+rs.getString(10));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(CertificationService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferCertification(Certification c)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `certification` SET `nomdecertification`=?,`organisme`=?,`moisd`=?,`moisf`=?,`anneed`=?,`anneef`=?,`iddi`=?,`url`=? WHERE `id`=?");
            pt.setString(1,c.getNom_de_certification());
            pt.setString(2,c.getOrganisme());
            pt.setString(3,c.getMois_debut());
            pt.setString(4,c.getMois_fin());
            pt.setString(5,c.getAnnée_debut());
            pt.setString(6,c.getAnnée_fin());
            pt.setInt(7,c.getId_diplome());
            pt.setString(8,c.getUrl());
            
            pt.setInt(9,c.getId());
           
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerCertification(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `certification` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public ArrayList<Certification> getByIdUser(int id) {
        ArrayList<Certification> listcertificat = new ArrayList<>();
        try {
            String req = "SELECT * FROM `certification` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listcertificat.add(new Certification(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString("nomdecertification"),
                           rs.getString("organisme"),
                            rs.getString("moisd"),
                             rs.getString("moisf"),
                         rs.getString("anneed"),
                         rs.getString("anneef"),
                          rs.getString("url"),
                         rs.getInt("iddi")
                            
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listcertificat;
        
    }
         public Certification get(int id) {
        Certification a = new Certification();
            try {
                String req = "SELECT * FROM `certification` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
              a.setId(rs.getInt("id"));
              a.setNom_de_certification(rs.getString("nomdecertification"));
              a.setOrganisme(rs.getString("organisme"));
              a.setMois_debut(rs.getString("moisd"));
              a.setMois_fin(rs.getString("moisf"));
              a.setAnnée_debut( rs.getString("anneed"));
              a.setAnnée_fin(rs.getString("anneef"));
              a.setId_diplome(rs.getInt("iddi"));
              a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
}
