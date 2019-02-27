/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maha
 */
public class MyConnection {
    private static Connection con;
     public static MyConnection inst;
   private MyConnection (){
    
} 
   public static Connection getConnection() {
     if(con==null){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/smartstart","root","");
       } catch (ClassNotFoundException ex) {
          Logger.getLogger(MyConnection .class.getName()).log(Level.SEVERE,null,ex);
       }catch (SQLException ex) {
          Logger.getLogger(MyConnection .class.getName()).log(Level.SEVERE,null,ex);
       }}
       return con;
       
      
     
   }
   public static MyConnection getInstance()
    {
        if(inst==null)
            inst = new MyConnection();
        
        return inst;
    }
public static void disconnect(){
    if(con!=null){
        con=null;
    }
}
    
}
