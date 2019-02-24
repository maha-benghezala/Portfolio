/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import modals.Entreprise;
import modals.Freelancer;
import modals.User;
import utlis.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.Portfolio;

/**
 *
 * @author aymen
 */
public class Crudfreelancer {
    
     Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();
    public static User user;
    public void ajoutentfreelancer(Freelancer e)
    {
        try {
            Statement st = C.createStatement();
            String req="insert into user (nomutilisateur,mdp,adresse,mail,tel,nomSC,nom,prenom,specialite,role,poste,certif) values ('"+e.getNom_utilisateur()+"','"+e.getMot_de_passe()+"','"+e.getAdresse()+"','"+e.getMail()+"',"+e.getTel()+",'','"+e.getNom()+"','"+e.getPrenom()+"','"+e.getSpecialite()+"','freelancer','','"+e.getCertif()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherfreelancer()
    {

        try {
            Statement st = C.createStatement();
            String req="select * from user";
            ResultSet rs = st.executeQuery(req);
      
            while(rs.next())
            {
                System.out.println("id : "+rs.getInt(1)+" Nom_utilisateur : "+rs.getString(2)+" Mot_de_passe : "+rs.getString(3)+" Adresse :"+rs.getString(4)+" Mail : "+rs.getString(5)+" tel : "+rs.getInt(6)+" Nom: "+rs.getString(8)+"  Prenom : "+rs.getString(9)+"  specialite : "+rs.getString(10)+" role : "+rs.getString(11)+" certif : "+rs.getString(13));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    
    public Boolean Connexionfreelancer(String nom,String mdp)
    {
        try {
            Statement st = C.createStatement();
           String req="select * from user";
            ResultSet rs = st.executeQuery(req);
          while(rs.next())
            {
            
               if(rs.getString(2).equals(nom)&&rs.getString(3).equals(mdp))
               {
                 
                   PreparedStatement pt = C.prepareStatement("update user set enligne = ? where iduser =?");
                   pt.setInt(1,1);
                   pt.setInt(2,rs.getInt(1));
                   user.setId(rs.getInt("iduser"));
                   pt.executeUpdate();
                   
                   return true;
                   
               }
            }
               } catch (SQLException ex) {
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    
    
    
    
    public void modiferfreelancer(int id,String nom,String mdp,String adresse,String mail,int tel,String nomsc)
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
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void Supprimefreelancer(int a)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from user  where iduser =?");
            pt.setInt(1, a);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crudfreelancer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
            
    
    
}
