/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jasser
 */
public class Mail {


    private String username = "smartcitytunisie@gmail.com";
    private String password = "so what00112233";

    public void envoyer(String M, String objet,String description) {
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
// Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("monguide07@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(M));
            message.setSubject("marche");
            message.setText("ok");
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


}
