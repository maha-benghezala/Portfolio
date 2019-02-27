/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import modals.User;

/**
 *
 * @author Raid
 */
public class Entreprise extends User{

    public Entreprise() {
    }
    private String nom_sc;

    public String getCertif() {
        return certif;
    }
    private String post;
    private String description;

    public Entreprise(String nom_sc, String post, String specialite, String certif, int id, String nom_utilisateur, String mot_de_passe, String adresse, String mail,int tel) {
        super(id, nom_utilisateur, mot_de_passe, adresse, mail, tel);
        this.nom_sc = nom_sc;
        this.post = post;
        this.specialite = specialite;
        this.certif = certif;
    }
    private String specialite;
    private String certif;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entreprise(String nom_sc, String post, String specialite) {
        this.nom_sc = nom_sc;
        this.post = post;
        this.specialite = specialite;
    }

    public Entreprise(String nom_sc, String post, String specialite, int id, String nom_utilisateur, String mot_de_passe, String adresse, String mail, int tel) {
        super(id, nom_utilisateur, mot_de_passe, adresse, mail, tel);
        this.nom_sc = nom_sc;
        this.post = post;
        this.specialite = specialite;
    }

    public String getNom_sc() {
        return nom_sc;
    }

    public void setNom_sc(String nom_sc) {
        this.nom_sc = nom_sc;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPost() {
        return post;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "nom_sc=" + nom_sc + ", post=" + post + ", specialite=" + specialite + '}';
    }
    
    
}
