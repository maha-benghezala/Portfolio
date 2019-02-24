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
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.ContactEntreprise;
import modals.Entreprise;
import modals.Experience;
import modals.User;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class ContactEntrepriseService {
      Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();
  public static User u;
    public void ajouterContactEntreprise(ContactEntreprise ce) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `contact`(`id-user`, `tel`, `email`, `nom`, `message`, `sujet`) VALUES (" 
                    +ce.getId_user() +"," +ce.getTel()+",'"+ce.getEmail()+"','"+ce.getMessage()+"','"+ce.getNom()+"','"+ce.getSujet()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public User selectEntrprise(Entreprise e)
{
    User user = new User();
    try {
            Statement st = C.createStatement();
            String req = "SELECT `adresse`, `mail`, `tel`,`nomSC`,`ville` FROM `user` WHERE `iduser`=3";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                user.setAdresse(rs.getString(1));
                user.setMail(rs.getString(2));
                user.setTel(rs.getInt(3));
                user.setNomSc(rs.getString(4));
                user.setVille(rs.getString(5));
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return user;
}
  public void afficherContactEntreprise()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `contact`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`contact`"+rs.getInt(2)+", "
                        +rs.getInt(3)+","+rs.getString(4)+","+rs.getString(5)+","
                       +rs.getString(6)+","+rs.getString(7));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferContactEntreprise(int id,int iduser)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `contact` SET ``tel`=?,`email`=?,`nom`=?,`message`=?,`sujet`=? WHERE `id`=?,`id-user`=?");
            pt.setInt(6, id);
            pt.setInt(7, iduser);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerContactEntreprise(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `contact` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
