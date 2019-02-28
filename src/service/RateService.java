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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modals.Rate;
import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class RateService {
      Connection C = MyConnection.getInstance().getConnection();
       public void ajouterRate(Rate r) {
           try{
        String req ="INSERT INTO `rate`(`id-user`, `commentaire`, `avis`) VALUES (?,?,?)";
          PreparedStatement st = C.prepareStatement(req);
            
            st.setInt(1, r.getIduser());
           
            st.setString(2, r.getCommentaire());
            st.setInt(3, r.getAvis());
           
                st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
public void delete(int id) {
        try {
            String req= "DELETE FROM `rate` WHERE `id-user` = ? ";
            PreparedStatement st = C.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public double count(int id) {
         double count = 0;
        try {
            String req = "SELECT AVG(avis) FROM `rate` WHERE `id-user` = ?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                count = rs.getDouble("AVG(avis)");
                System.out.println(count);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
    }
      public ArrayList<Rate> getByIdUser(int id) {
        ArrayList<Rate> listRate = new ArrayList<>();
        try {
            String req = "SELECT * FROM `rate` WHERE user_id = ?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                listRate.add(new Rate(rs.getInt(1),
                            rs.getInt("id-user"),
                            rs.getString("commentaire"),
                           
                            rs.getString("role"),
                             rs.getInt("avis")
                            
                            
                ));
            }
            
            System.out.println(listRate.toString());
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listRate;
    }
   public void update(Rate r) {
        try {
            String req = "UPDATE `rate` SET `commentaire`=?,`avis`=? WHERE `id-user` = ?";
            PreparedStatement st = C.prepareStatement(req);
           
             st.setString(1, r.getCommentaire());
          
            st.setInt(2, r.getAvis());
          
            st.setInt(3, r.getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PortfolioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void deleteRate(int id) {
        try {
            String req= "DELETE FROM `rate` WHERE `id` = ? ";
            PreparedStatement st = C.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
