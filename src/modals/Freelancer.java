/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

/**
 *
 * @author aymen
 */
public class Freelancer extends User{
    private String nom;
    private String prenom;
    private String specialite,poste,disponible,visible;

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getCertif() {
        return certif;
    }
    private String certif;

    public Freelancer(String nom, String prenom, String specialite, String certif, int id, String nom_utilisateur, String mot_de_passe, String adresse, String mail,int tel,String poste) {
        super(id, nom_utilisateur, mot_de_passe, adresse, mail, tel);
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.certif = certif;
        this.poste=poste;
    }

    public Freelancer() {
    }
    

    public Freelancer(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public Freelancer(String nom, String prenom, String specialite, int id, String nom_utilisateur, String mot_de_passe, String adresse, String mail, int tel) {
        super(id, nom_utilisateur, mot_de_passe, adresse, mail, tel);
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String toString() {
        return "Freelancer{" + "nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", certif=" + certif + '}';
    }

  
    
            
    
}
