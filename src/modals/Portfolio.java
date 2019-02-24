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
public class Portfolio extends Freelancer{
    private int id;
    private int id_user;
    private String image;
   
  
    private String titre;
    private String adresse;
 
    private String parler;

    public Portfolio(int id, int id_user,String titre, String adresse, String parler) {
        this.id = id;
        this.id_user = id_user;
       
      
        this.titre=titre;
        this.adresse = adresse;
    
        this.parler = parler;
    }

    public Portfolio(int id, int id_user, String image,  String poste_actuel, String adresse, String parler) {
        this.id = id;
        this.id_user = id_user;
        this.image = image;
  
        
        this.titre = titre;
        this.adresse = adresse;
  
        this.parler = parler;
    }
    
   

 

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  
   

  

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

 

    public String getParler() {
        return parler;
    }

    public void setParler(String parler) {
        this.parler = parler;
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

   

    public Portfolio(int id_user) {
        this.id_user = id_user;
    }

    

    public Portfolio(int id, int id_user) {
        this.id = id;
        this.id_user = id_user;
    }
  
  

    public Portfolio() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Portfolio{" + "id=" + id + ", id_user=" + id_user + ", image=" + image + ", titre=" + titre + ", adresse=" + adresse + ", parler=" + parler + '}';
    }

   
   

  

    
}
