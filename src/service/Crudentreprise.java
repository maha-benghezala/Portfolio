/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import java.util.ArrayList;
import modals.Entreprise;
import modals.User;
import utlis.MyConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raid
 */
public class Crudentreprise {
      public static User user;
     Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();
    
    public void ajoutentreprise(Entreprise e)
    {
        try {
            Statement st = C.createStatement();
            String req="insert into user (nomutilisateur,mdp,adresse,mail,tel,nomSC,nom,prenom,specialite,role,poste,certif) values ('"+e.getNom_utilisateur()+"','"+e.getMot_de_passe()+"','"+e.getAdresse()+"','"+e.getMail()+"',"+e.getTel()+",'"+e.getNom_sc()+"','','','"+e.getSpecialite()+"','entreprise','"+e.getPost()+"','"+e.getCertif()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherentreprise()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from user";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("id :"+rs.getInt(1)+" Nom_utilisateur :"+rs.getString(2)+" Mot_de_passe :"+rs.getString(3)+" Adresse :"+rs.getString(4)+" Mail :"+rs.getString(5)+" tel : "+rs.getInt(6)+" Nom_sc : "+rs.getString(7));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Boolean Connexionentreprise(String nom,String mdp)
    {
        try {
            Statement st = C.createStatement();
           String req="select * from user";
            ResultSet rs = st.executeQuery(req);
          while(rs.next())
            {
               if(rs.getString(2).equals(nom)&&rs.getString(3).equals(mdp))
               {
                    user.setId(rs.getInt("iduser"));
                   return true;
               }
            }
               } catch (SQLException ex) {
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public void modiferentreprise(int id,String nom,String mdp,String adresse,String mail,int tel,String nomsc)
    {
        try {
            PreparedStatement pt = C.prepareStatement("update user set nomutilisateur = ? , mdp = ? , adresse = ? , mail = ? , tel = ? , nomSC = ? where iduser =?");
            pt.setString(1,nom);
            pt.setString(2,mdp);
            pt.setString(3,adresse);
            pt.setString(4,mail);
            pt.setInt(5,tel);
            pt.setString(6,nomsc);
            pt.setInt(7,id);

            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void Supprimerentreprise(int a)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from user  where iduser =?");
            pt.setInt(1, a);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

         public ArrayList<Entreprise> selectEntreprise()
{
  Entreprise user = new Entreprise();
  ArrayList<Entreprise> E = new ArrayList<>();
    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user`WHERE `role`=entreprise";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
                user.setId(rs.getInt(1));
                user.setAdresse(rs.getString("adresse"));
                user.setMail(rs.getString("mail"));
                user.setTel(rs.getInt("tel"));
                user.setRole(rs.getString("role"));
           E.add(user);
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    return E;
    
}
  
  public Entreprise getById(int id)
{
  Entreprise user = new Entreprise();

    
    try {
            Statement st = C.createStatement();
            String req = "SELECT * FROM `user`WHERE `iduser`=?";
            
           
             ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                
                user.setId(rs.getInt(1));
                user.setAdresse(rs.getString("adresse"));
                user.setMail(rs.getString("mail"));
                user.setTel(rs.getInt("tel"));
               
     
    }
                
    
        } catch (SQLException ex) {
            Logger.getLogger(Crudentreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    return user;
    
}   
    
    
}
