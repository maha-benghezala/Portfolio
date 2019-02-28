/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

/**
 *
 * @author Jasser
 */
public class ContactUser {
    private int id;
    private int id_user;
    private String objet,commentaire;

    public ContactUser(int id, int id_user, String objet, String commentaire) {
        this.id = id;
        this.id_user = id_user;
        this.objet = objet;
        this.commentaire = commentaire;
    }

    public ContactUser() {
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "ContactUser{" + "id=" + id + ", id_user=" + id_user + ", objet=" + objet + ", commentaire=" + commentaire + '}';
    }
    
    
    
    
    
    
    
}
