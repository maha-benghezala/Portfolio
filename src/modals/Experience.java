/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import java.util.Calendar;

/**
 *
 * @author Maha
 */
public class Experience {
    private int id;
    private int id_user;
    private String nomentreprise;
    private String intitule;
    private String secteur;
    private String mois_debut;
    private String mois_fin;
    private String année_debut;
    private String année_fin;
    private String lieu;
    private String description;

    public Experience(int id, int id_user, String nomentreprise, String intitule, String secteur, String mois_debut, String mois_fin, String année_debut, String année_fin, String lieu, String description) {
        this.id = id;
        this.id_user = id_user;
        this.nomentreprise = nomentreprise;
        this.intitule = intitule;
        this.secteur = secteur;
        this.mois_debut = mois_debut;
        this.mois_fin = mois_fin;
        this.année_debut = année_debut;
        this.année_fin = année_fin;
        this.lieu = lieu;
        this.description = description;
    }

   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Experience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

  

    public String getMois_debut() {
        return mois_debut;
    }

    public void setMois_debut(String mois_debut) {
        this.mois_debut = mois_debut;
    }

    public String getMois_fin() {
        return mois_fin;
    }

    public void setMois_fin(String mois_fin) {
        this.mois_fin = mois_fin;
    }

 

    public String getAnnée_debut() {
        return année_debut;
    }

    public void setAnnée_debut(String année_debut) {
        this.année_debut = année_debut;
    }

    public String getAnnée_fin() {
        return année_fin;
    }

    public void setAnnée_fin(String année_fin) {
        this.année_fin = année_fin;
    }

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", id_user=" + id_user + ", nomentreprise=" + nomentreprise + ", intitule=" + intitule + ", secteur=" + secteur + ", mois_debut=" + mois_debut + ", mois_fin=" + mois_fin + ", ann\u00e9e_debut=" + année_debut + ", ann\u00e9e_fin=" + année_fin + ", lieu=" + lieu + ", description=" + description + '}';
    }

 
   
    
}
