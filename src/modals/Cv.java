/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import java.util.ArrayList;

/**
 *
 * @author Maha
 */
public class Cv {
    private int id ;
    private int id_user;
    private ArrayList<Formation> formation;
    private ArrayList<Experience> experience;
    private ArrayList<Langue> langue;
    private ArrayList<Competence> competence;
    private ArrayList<Certification> certification;
    private ArrayList<Projet> projet;
    private Portfolio portfolio;

    public Cv(int id, int id_user,Portfolio portfolio) {
        this.id = id;
        this.id_user = id_user;
        formation=new ArrayList<Formation>();
        experience=new ArrayList<Experience>();
        langue=new ArrayList<Langue>();
       certification=new ArrayList<Certification>();
        projet=new ArrayList<Projet>();
        this.portfolio=portfolio;
        
    }

    public Cv() {
        formation=new ArrayList<Formation>();
        experience=new ArrayList<Experience>();
        langue=new ArrayList<Langue>();
        certification=new ArrayList<Certification>();
        projet=new ArrayList<Projet>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Cv{" + "id=" + id + ", id_user=" + id_user + ", portfolio=" + portfolio + '}';
    }
    

 
    
}
