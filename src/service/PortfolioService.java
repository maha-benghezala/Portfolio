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
import modals.Portfolio;
import modals.User;

import profprop.Portf;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class PortfolioService {
  private PreparedStatement ste;
    Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterPortfolio(Portfolio p) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `portfolio`(`id`, `id-user`, `image`, `titre`, `adresse`, `parler`, `github`, `likedin`)  VALUES("+ p.getId_user() +",'" +p.getImage() +"','" +p.getTitre() +"','" +p.getAdresse() +"','"+p.getParler()+"','"+p.getGithub()+"','"+p.getLinkedin()+"')";
         /** String req = "INSERT INTO `portfolio`( `id-user`, `specialite`, `nom`, `prenom`, `poste_actuel`, `adresse`, `tel`, `parler`) VALUES" + p.getId_user() + ",'" 
                    +p.getSpecialite() +"','" +p.getNom() +"','" +p.getPrenom() +"','" +p.getPoste_actuel() +"','" +p.getAdresse() +"'," 
                    +p.getTel() +",'"+p.getParler()+"')";**/
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

  public void afficherPortfolio()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `portfolio`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`portfolio`"+rs.getInt(1)+","+rs.getString(3)+","+rs.getString(4)+", "+rs.getInt(2)+","
                        +rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(PortfolioService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferPortfolio(Portfolio p)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `portfolio` SET `image`=?,`titre`=?,`adresse`=?,`parler`=?,`github`=?,`likedin`=? WHERE `id` =?");
            pt.setString(1,p.getImage());
           
            pt.setString(2,p.getTitre());
            pt.setString(3,p.getAdresse());
         
            pt.setString(4,p.getParler());
            pt.setString(5,p.getGithub());
            pt.setString(6,p.getLinkedin());
            pt.setInt(7,p.getId());
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerPortfolio(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `portfolio` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
   public Portfolio get(int id) {
        Portfolio a = new Portfolio();
            try {
                String req = "SELECT * FROM `portfolio` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setImage(rs.getString("image"));
                    a.setTitre(rs.getString("titre"));
                    a.setAdresse(rs.getString("adresse"));
                    a.setParler(rs.getString("parler"));
                    a.setGithub(rs.getString("github"));
                    a.setLinkedin(rs.getString("likedin"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
    public Portfolio getByIdUser(int id) {
        Portfolio a = new Portfolio();
            try {
                String req = "SELECT * FROM `portfolio` WHERE `id-user` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setImage(rs.getString("image"));
                     
                     a.setTitre(rs.getString("titre"));
                    a.setAdresse(rs.getString("adresse"));
                   
                   
                    a.setParler(rs.getString("parler"));
                    a.setGithub(rs.getString("github"));
                    a.setLinkedin(rs.getString("likedin"));
                  a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
//public Portfolio PortfolioUser(String nom,String prenom)
//{
//        Portfolio f = null; 
//        String request = "SELECT * FROM `user` WHERE `prenom` = ? AND `nom` = ?";
//        try {
//            ste = C.prepareStatement(request);
//            ste.setString(1, prenom);
//            ste.setString(2, nom);
//            ResultSet rs = ste.executeQuery();
//            if(rs.next()){
//           
//               
//                    System.out.println("connecter");
//            
//                   f=new Portfolio();
//                    f.setId(rs.getInt(1));
//                    f.setId_user(rs.getInt(2));
//                  
//                   
//                    f.setTitre(rs.getString(6));
//                    f.setAdresse(rs.getString(7));
//                   
//                    f.setParler(rs.getString(9));
//                   return f;
//             
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//     return f;
//}
public Freelancer selectFreelancer()
{
  Freelancer user = new Freelancer();
    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user`WHERE `iduser`=1";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
                user.setId(rs.getInt("iduser"));
                user.setAdresse(rs.getString("adresse"));
                user.setMail(rs.getString("mail"));
                user.setTel(rs.getInt("tel"));
                user.setNom(rs.getString("Nom"));
                user.setPrenom(rs.getString("prenom"));
             
                user.setSpecialite(rs.getString("specialite"));
                user.setDisponible(rs.getString("disponible"));
                user.setVisible(rs.getString("visible"));
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(ContactEntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return user;
}
public void updateDisonibilite(Freelancer p)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `user` SET `disponible`=? WHERE `iduser`=?");
            pt.setString(1,p.getDisponible());
           
            pt.setInt(2,p.getId());
           
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updatevisibilite(Freelancer p)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `user` SET `visible`=? WHERE `iduser`=?");
            pt.setString(1,p.getVisible());
           
            pt.setInt(2,p.getId());
           
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 public ArrayList<Freelancer> SelectFreelancer()
{
 
  ArrayList<Freelancer> E = new ArrayList<>();
    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user`WHERE `role`='freelancer'";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
          Freelancer user = new Freelancer();
                user.setId(rs.getInt(1));
                user.setAdresse(rs.getString("adresse"));
                user.setMail(rs.getString("mail"));
                user.setTel(rs.getInt("tel"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setSpecialite(rs.getString("specialite"));
                user.setRole(rs.getString("role"));
                user.setDisponible(rs.getString("disponible"));
                E.add(user);
         
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return E;
    
}
}
