/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modals.Certification;
import modals.Experience;
import modals.Formation;
import modals.Langue;
import modals.Portfolio;
import modals.Projet;
import service.CertificationService;
import service.ExperienceService;
import service.FormationService;
import service.LangueService;
import service.PortfolioService;
import service.ProjetService;

/**
 *
 * @author Maha
 */
public class SmartStart {
    public static void main(String[] args) {
        
        // TODO code application logic here
     
     // Portfolio p2=new Portfolio(2,1,"designeur","ben ali","salah","etudiant","tunis",2,"jhsgdfuqkfezkfcvk");
         
//       PortfolioService serv = new PortfolioService();
//       serv.ajouterPortfolio(p2);
//        serv.afficherPortfolio();
        //serv.SupprimerPortfolio(1);
      Formation f=new Formation();
      f.setId(1);
      f.setId_user(1);
      f.setNom_ecole("ESPRIT");
      f.setDomaine("3eme année");
      f.setAnnée_debut("2018");
  
      f.setDescription("hbvgsfdjhvbdxjfhvbs");
      FormationService formation=new FormationService();
         //formation.ajouterFormation(f);
//      formation.afficherFormation();
      Experience e1=new Experience();
//      e1.setId(1);
//      e1.setId_user(1);
//      e1.setNomentreprise("Sagem");
//      e1.setPosition("stagaire");
//    
//      e1.setAnnée_debut("2018");
//      e1.setAnnée_fin("2018");
//      e1.setDescription("gjqgdvc");
      ExperienceService esp=new ExperienceService();
//      esp.ajouterExperience(e1);
//      esp.afficherExperience();
    Certification c1=new Certification();
    CertificationService cs =new CertificationService();
   // cs.ajouterCertification(c1);
//    cs.afficherCertification();
    Langue l1=new Langue();
    l1.setId(1);
    l1.setId_user(1);
    l1.setLangue("Anglais");
    l1.setNiveau("Intermidaire");
 
    Langue l2=new Langue();
    l2.setId(2);
    l2.setId_user(2);
    l2.setLangue("Fraincais");
    l2.setNiveau("Intermidaire");
       LangueService ls=new LangueService();

//     ls.ajouterLangue(l1);
//    ls.ajouterLangue(l2);
//    ls.afficherLangue();

//    ls.SupprimerLangue(1);
//      l2.setLangue("anglais");
//      ls.modiferLangue(l2);
     Projet p=new Projet();
     p.setId(1);
     p.setId_user(1);
     p.setNom_projet("smartstart");
    
 p.setDescription("dfjvhbvjwh");
       ProjetService ps=new ProjetService();
//       ps.ajouterProjet(p);
//       ps.afficherProjet();
   // ps.SupprimerProjet(1);
   
            
     }
}
