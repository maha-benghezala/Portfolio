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
public class PortfolioEntreprise {
    private int id ;
    private int id_user;
    private String role;
    private String nom;
    private String description;
    

    public PortfolioEntreprise(int id, int id_user, String role, String nom, String description) {
        this.id = id;
        this.id_user = id_user;
        this.role = role;
        this.nom = nom;
        this.description = description;
    }

    public PortfolioEntreprise() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PortfolioEntreprise{" + "id=" + id + ", id_user=" + id_user + ", role=" + role + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
    
    
}
