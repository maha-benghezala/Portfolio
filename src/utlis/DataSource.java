/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maha
 */
public class DataSource {
      private Properties prop;
    String url ;
    String login ;
    String pw ;
    private Connection connection;
    static DataSource instance;

    private DataSource() {

        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("parameters")));
            url = prop.getProperty("url");
            login = prop.getProperty("login");
            pw = prop.getProperty("password");
            connection = DriverManager.getConnection(url, login, pw);
            System.out.println("connection Success !");
            
        } catch (SQLException | IOException e ) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, e);
        } 

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static DataSource getInstance() {

        if (instance == null) {
            instance = new DataSource();
        }
        return instance;

    }
}
