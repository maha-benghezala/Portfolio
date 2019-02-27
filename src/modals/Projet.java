/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

/**
 *
 * @author Maha
 */
public class Projet {
    int id,id_user;
    String nom_projet;
    String moisdebut;
    String moisfin;
    String anneedebut;
    String anneefin;
    String url;
    String description;

    public Projet(int id, int id_user, String nom_projet, String moisdebut, String moisfin, String anneedebut, String anneefin, String url, String description) {
        this.id = id;
        this.id_user = id_user;
        this.nom_projet = nom_projet;
        this.moisdebut = moisdebut;
        this.moisfin = moisfin;
        this.anneedebut = anneedebut;
        this.anneefin = anneefin;
        this.url = url;
        this.description = description;
    }
            

  

   

    public Projet() {
    }

    public String getMoisdebut() {
        return moisdebut;
    }

    public void setMoisdebut(String moisdebut) {
        this.moisdebut = moisdebut;
    }

    public String getMoisfin() {
        return moisfin;
    }

    public void setMoisfin(String moisfin) {
        this.moisfin = moisfin;
    }

    public String getAnneedebut() {
        return anneedebut;
    }

    public void setAnneedebut(String anneedebut) {
        this.anneedebut = anneedebut;
    }

    public String getAnneefin() {
        return anneefin;
    }

    public void setAnneefin(String anneefin) {
        this.anneefin = anneefin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getNom_projet() {
        return nom_projet;
    }

    public void setNom_projet(String nom_projet) {
        this.nom_projet = nom_projet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", id_user=" + id_user + ", nom_projet=" + nom_projet + ", moisdebut=" + moisdebut + ", moisfin=" + moisfin + ", anneedebut=" + anneedebut + ", anneefin=" + anneefin + ", url=" + url + ", description=" + description + '}';
    }


 
    
}
