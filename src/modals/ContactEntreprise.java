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
public class ContactEntreprise {
   private int id,id_user,tel,fax;
   private String nomSc,adresse,ville,email,nom,sujet,message;

    public ContactEntreprise(int id, int id_user, int tel,String adresse, String ville, String email) {
        this.id = id;
        this.id_user = id_user;
        this.tel = tel;
      
        this.nomSc = nomSc;
        this.adresse = adresse;
        this.ville = ville;
        this.email = email;
    }

    public ContactEntreprise(int id, int id_user, int tel, int fax, String nomSc, String adresse, String ville, String email, String nom, String sujet, String message) {
        this.id = id;
        this.id_user = id_user;
        this.tel = tel;
        this.fax = fax;
        this.nomSc = nomSc;
        this.adresse = adresse;
        this.ville = ville;
        this.email = email;
        this.nom = nom;
        this.sujet = sujet;
        this.message = message;
    }
    

    public ContactEntreprise() {
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public String getNomSc() {
        return nomSc;
    }

    public void setNomSc(String nomSc) {
        this.nomSc = nomSc;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactEntreprise{" + "id=" + id + ", id_user=" + id_user + ", tel=" + tel + ", fax=" + fax + ", nomSc=" + nomSc + ", adresse=" + adresse + ", ville=" + ville + ", email=" + email + ", nom=" + nom + ", sujet=" + sujet + ", message=" + message + '}';
    }

  
        
    
    
    
    
    
}
