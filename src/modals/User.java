/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

/**
 *
 * @author Raid
 */
public class User {
    private int id;
     private String nom_utilisateur;
     private String mot_de_passe;
     private String adresse;
     private String mail,ville;
     private double tel;
     private String nomSc;
     private String role;
     private String image;
     private String specialite,poste;
     private String description;
    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String adresse, String mail, int tel,String nomSc) {
        this.id = id;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.ville=ville;
        this.nomSc=nomSc;
    }

    public String getNomSc() {
        return nomSc;
    }

    public void setNomSc(String nomSc) {
        this.nomSc = nomSc;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom_utilisateur=" + nom_utilisateur + ", mot_de_passe=" + mot_de_passe + ", adresse=" + adresse + ", mail=" + mail + ", ville=" + ville + ", tel=" + tel + ", nomSc=" + nomSc + ", role=" + role + ", image=" + image + ", specialite=" + specialite + ", poste=" + poste + '}';
    }
    

    
    public User(int id, String nom_utilisateur, String mot_de_passe, String adresse, String mail, double tel) {
        this.id = id;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public double getTel() {
        return tel;
    }
     
    
}
