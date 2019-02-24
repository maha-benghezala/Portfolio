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
public class Competence {
  private  int id;
  private  int id_user;
  private  String Competence;   

    public Competence(int id, int id_user, String Competence) {
        this.id = id;
        this.id_user = id_user;
        this.Competence = Competence;
    }

    public Competence() {
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

    public String getCompetence() {
        return Competence;
    }

    public void setCompetence(String Competence) {
        this.Competence = Competence;
    }

    @Override
    public String toString() {
        return "Competence{" + "id=" + id + ", id_user=" + id_user + ", Competence=" + Competence + '}';
    }
  
}
