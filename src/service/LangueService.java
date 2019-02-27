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
import modals.Certification;
import modals.Langue;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class LangueService {
      Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterLangue(Langue l) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `langue`(`id-user`, `langue`, `niveau`) VALUES ("+l.getId_user() +",'"
                    +l.getLangue() +"','"+l.getNiveau()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(LangueService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherLangue()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `langue`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`langue`"+rs.getInt(1)+","+rs.getInt(2)+", "
                        +rs.getString(3)+","+rs.getString(4));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(LangueService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferLangue(Langue l)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `langue` SET `langue`=?,`niveau`=? WHERE id=?");
           pt.setString(1,l.getLangue());
           pt.setString(2,l.getNiveau());
           pt.setInt(3,l.getId());
           
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LangueService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerLangue(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `langue` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LangueService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Langue> getByIdUser(int id)
    {
        ArrayList<Langue> listlangue=new ArrayList<>();
        try {
            String req = "SELECT * FROM `langue` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listlangue.add(new Langue(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString("langue"),
                            rs.getString("niveau")
                           
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LangueService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listlangue;
    }
     public Langue get(int id) {
         Langue a = new  Langue();
            try {
                String req = "SELECT * FROM `langue` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setLangue(rs.getString("langue"));
                    a.setNiveau(rs.getString("niveau"));
                      a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
}
