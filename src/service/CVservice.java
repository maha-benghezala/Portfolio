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
import modals.Cv;
import modals.Portfolio;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class CVservice {
       Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterCV(Cv c) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `cv` VALUES ("+c.getId()+","+ c.getId_user()+")";
          
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherCV()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `cv`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`cv`"+rs.getInt(1)+"user id "+rs.getInt(1));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(CVservice .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferPortfolio(int id,String nom)
    {
        try {
            PreparedStatement pt = C.prepareStatement("update `cv` set id = ? where id-user =?");
          
            pt.setInt(2,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CVservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerPortfolio(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `cv` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CVservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
