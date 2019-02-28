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
public class Rate {
        private int id ;
    private int iduser;
    private String role ;
    private String Commentaire ;
    private int avis;

    public Rate(int id, int iduser, String role, String Commentaire, int avis) {
        this.id = id;
        this.iduser = iduser;
        this.role = role;
        this.Commentaire = Commentaire;
        this.avis = avis;
    }

    public Rate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Rate{" + "id=" + id + ", iduser=" + iduser + ", role=" + role + ", Commentaire=" + Commentaire + ", avis=" + avis + '}';
    }
    
}
