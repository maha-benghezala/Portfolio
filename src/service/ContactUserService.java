/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.ContactEntreprise;
import modals.ContactUser;
import modals.Entreprise;
import modals.Freelancer;
import modals.User;
import utlis.MyConnection;

/**
 *
 * @author Jasser
 */
public class ContactUserService {
      Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();
  public static User u;
    public void ajouterContacFreelancer(ContactUser ce) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `contactuser`(`id-user`, `objet`, `description`) VALUES (" 
                    +ce.getId_user() +"," +ce.getObjet()+",'"+ce.getCommentaire()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ContactUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//public User selectFreelancer(Freelancer e)
//{
//    User user = new User();
//    try {
//            Statement st = C.createStatement();
//            String req = "SELECT `id-user`, `objet`, `description` FROM `user` WHERE `iduser`=1";
//            
//           
//             ResultSet rs = st.executeQuery(req);
//           while(rs.next()){
//                user.set(rs.getString(1));
//                user.setMail(rs.getString(2));
//                user.setTel(rs.getInt(3));
//                user.setNomSc(rs.getString(4));
//                user.setVille(rs.getString(5));
//    }
//                
//    
//        } catch (SQLException ex) {
//            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return user;
//}
  public void afficherContactUser()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `contact`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`contact`"+rs.getInt(1)+", "
                        +rs.getInt(2)+","+rs.getString(3)+","+rs.getString(4));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferContactUser(ContactEntreprise c)
    {
        try {
            Statement st = C.createStatement();
            String req="UPDATE `contactuser` SET `objet`=?,`description`=? WHERE `id`=?,`id-user`=?";
            
           ResultSet rs = st.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerContact(int id)
    {
        try {
             Statement st = C.createStatement();
            String req="DELETE FROM `contactuser` WHERE `id`=?";
            
          st.executeUpdate(req);;
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public  void SupprimerContactEntreprise(int id)
    {
        try {
             Statement st = C.createStatement();
            String req="DELETE FROM `concontactusertact` WHERE `id-user`=?";
            
       st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
