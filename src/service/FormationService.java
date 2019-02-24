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
import modals.Formation;

import utlis.MyConnection;

/**
 *
 * @author Maha
 */
public class FormationService {
      Connection C = MyConnection.getInstance().getConnection();
    //Connection C = MyConnection.getConn();

    public void ajouterFormation(Formation f) {
        try {
            Statement st = C.createStatement();
            String req = "INSERT INTO `formation`( `id-user`, `nomecole`, `diplome`, `domaine`, `anneedebut`,  `description`) VALUES("+ f.getId_user() + ",'" 
                    +f.getNom_ecole() +"','"+f.getDiplome()+"','"+f.getDomaine()+"','"+f.getAnnée_debut()+"','" +f.getDescription()+"')";
           st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void afficherFormation()
    {
        try {
            Statement st = C.createStatement();
            String req="select * from `formation`";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                System.out.println("`formation`"+rs.getInt(1)+","+rs.getString(3)+","+rs.getInt(2)+","
                        +rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(FormationService .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modiferFormation(Formation f)
    {
        try {
            PreparedStatement pt = C.prepareStatement("UPDATE `formation` SET `nomecole`=?,`diplome`=?,`domaine`=?,`anneedebut`=?,`description`=? WHERE  id =?");
            pt.setString(1,f.getNom_ecole());
            pt.setString(2,f.getDiplome());
            pt.setString(3,f.getDomaine());
            pt.setString(4,f.getAnnée_debut());
            pt.setString(5,f.getDescription());
            pt.setInt(6,f.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  void SupprimerFormation(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from `formation` where id =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public ArrayList<Formation> getByIdUser(int id) {
        ArrayList<Formation> listformation = new ArrayList<>();
        try {
            String req = "SELECT * From `Formation` WHERE `id-user`=?";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs = ste.executeQuery();
                
            while (rs.next()) {
                listformation.add(new Formation(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString("nomecole"),
                            rs.getString("diplome"),
                            rs.getString("domaine"),
                            rs.getString("anneedebut"),
                            
                            rs.getString("description")
                           
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listformation;
        
    }
  public Formation get(int id) {
        Formation a = new Formation();
            try {
                String req = "SELECT * FROM `formation` WHERE `id` = ?  ";
                PreparedStatement ste = C.prepareStatement(req);
                ste.setInt(1, id);
               ResultSet rs = ste.executeQuery();
                if (rs.next()) {
              a.setId(rs.getInt("id"));
              a.setNom_ecole(rs.getString("nomecole"));
              a.setDomaine(rs.getString("diplome"));
              a.setDiplome(rs.getString("domaine"));
              a.setDescription(rs.getString("anneedebut"));
            
              a.setAnnée_debut( rs.getString("description"));
              a.setId_user(rs.getInt("id-user"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return a;
    }
}
