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
public class Certification {
  private  int id;
  private  int id_user;
  private  String nom_de_certification;
  private  String organisme,mois_debut,mois_fin,année_debut,année_fin,url;
  private  int id_diplome;

    public Certification(int id, int id_user, String nom_de_certification, String organisme, String mois_debut, String mois_fin, String année_debut, String année_fin, String url, int id_diplome) {
        this.id = id;
        this.id_user = id_user;
        this.nom_de_certification = nom_de_certification;
        this.organisme = organisme;
        this.mois_debut = mois_debut;
        this.mois_fin = mois_fin;
        this.année_debut = année_debut;
        this.année_fin = année_fin;
        this.url = url;
        this.id_diplome = id_diplome;
    }
  




    public Certification() {
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

    public String getNom_de_certification() {
        return nom_de_certification;
    }

    public void setNom_de_certification(String nom_de_certification) {
        this.nom_de_certification = nom_de_certification;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_diplome() {
        return id_diplome;
    }

    public void setId_diplome(int id_diplome) {
        this.id_diplome = id_diplome;
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

    @Override
    public String toString() {
        return "Certification{" + "id=" + id + ", id_user=" + id_user + ", nom_de_certification=" + nom_de_certification + ", organisme=" + organisme + ", mois_debut=" + mois_debut + ", mois_fin=" + mois_fin + ", ann\u00e9e_debut=" + année_debut + ", ann\u00e9e_fin=" + année_fin + ", url=" + url + ", id_diplome=" + id_diplome + '}';
    }

 
    

    

   
          
}
