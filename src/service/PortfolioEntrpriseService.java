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
import modals.Entreprise;
import modals.PortfolioEntreprise;
import modals.User;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class PortfolioEntrpriseService {
      Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterPortfolioEntrprise(User u) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `user`( `adresse`, `mail`, `tel`, `nomSC`, `image`, `specialite`, `role`, `poste`, `ville`) VALUES('"+u.getAdresse()+"','"+u.getMail()+"',"+u.getTel()+",'"+u.getNomSc()+"','"+u.getImage()+"','"+u.getSpecialite()+"','"+u.getRole()+"','"+u.getVille()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherPortfolioEntrprise()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `user`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`user`"+rs.getInt(1)+","+rs.getInt(6)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(7)+rs.getString(8));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferPortfolioEntrprise(Entreprise e)
    {
        try {
              Statement st = C.createStatement();
             String req="UPDATE `user` SET `adresse`=?,`mail`=?,`tel`=?,`nomSC`=?,`image`=?,`specialite`=?,`role`=?,`poste`=?,`ville`=? WHERE`iduser`=? ";
        
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerPortfolioEntrprise(int id)
    {
        try {
               Statement st = C.createStatement();
             String req="DELETE FROM `user` WHERE `iduser`=3";
           
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public ArrayList<Entreprise> selectEntreprise()
{
    Entreprise user = new Entreprise();
  ArrayList<Entreprise> E = new ArrayList<>();
    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user` WHERE `role`='entreprise'";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
               user.setNomSc(rs.getString("nomSc"));
               user.setImage(rs.getString("image"));
                user.setAdresse(rs.getString("adresse"));
                user.setVille(rs.getString("ville"));
                user.setDescription(rs.getString("description"));
                user.setRole(rs.getString("role"));
                user.setSpecialite(rs.getString("specialite"));
                user.setTel(rs.getInt("tel"));
           E.add(user);
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return E;
    
}
  
  public User getById(int id)
{
  User user = new User();

    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user` WHERE  `iduser` =4";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
                user.setId(rs.getInt(1));
                user.setNomSc(rs.getString("nomSC"));
                user.setAdresse(rs.getString("adresse"));
                user.setMail(rs.getString("mail"));
                user.setTel(rs.getInt("tel"));
                user.setRole(rs.getString("role"));
                user.setSpecialite(rs.getString("specialite"));
                user.setVille(rs.getString("ville"));
                user.setImage(rs.getString("image"));
                user.setDescription(rs.getString("description"));
               
     
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioEntrpriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return user;
    
}   
   
}
