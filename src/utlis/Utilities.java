/*
 * Class mta3 fonctions utilitaires ila5
 */
package utlis;

//import Utils.BCrypt;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author makrem
 */


public final class Utilities {
    
    
    
    public static String arrayToString(ArrayList<String> array){
        int i = 0; 
        String str = "a:" + array.size() + ":{";
            for (String s : array) {
                str+= "i:"+i+";s:" + s.length() + ':' + '"' + s + '"' +";" ;
                i++;
            }
            str+= "}";
        return str; 
    }
    
    public static ArrayList<String> stringToArray(String str){
        ArrayList<String> array = new ArrayList<>();
        int n = Integer.parseInt(str.split(":")[1]);
        String[] sp = str.split('"'+"");
        for(int i=1 ; i<sp.length ; i+=2)
        {
            array.add(sp[i]);
        }
        return array;
    }
    
    
    public static boolean validateEmail(String emailAddress) {
        Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        Matcher regMatcher = regexPattern.matcher(emailAddress);
        return regMatcher.matches();
    }
    
    //Hashing Password
//    public static String hashpw(String pw)
//    {
//        return BCrypt.hashpw(pw, BCrypt.gensalt(13));
//    }
//    
    
    //checking Password
//    public static Boolean checkpw(String plainpw, String hashed)
//    {
//        return BCrypt.checkpw(plainpw, hashed);
//    }
    
    //Generate md5
    
    public static String md5(String str)
    {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(str));   
            return String.format("%032x", new BigInteger(1, md5.digest()));

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    public static int randomToken(){
        Random rand = new Random();
        int n = rand.nextInt(9999) + 1000;
        return n;
    }
    
//    public static int smsSender(String userNumber){
//        int n = Utilities.randomToken();
//        String accountSid = "ACaef5687610f2af059b2f832284807108"; // Your Account SID from www.twilio.com/user/account
//        String authToken = "0a65f4e4e4a5a4d953a2bde564ac1f46"; // Your Auth Token from www.twilio.com/user/account
//        Twilio.init(accountSid, authToken);
//        Message message = Message.creator(
//            new PhoneNumber(userNumber),  // To number   
//            new PhoneNumber("+18605165720"),  // From number Sender 
//            "Votre Token pour reinitialiser votre mot de passe est : " + n // SMS body
//        ).create();
//
//        System.out.println(message.getSid());
//        
//        return n ;
//    }
    
    public static boolean save(String username , String pwd){
        try {
            File file = new File("userSave");
            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write("username="+username); //write the name
            bw.newLine(); //leave a new Line
            bw.write("pwd="+pwd); //write the password
            bw.close(); //close the BufferdWriter
            return true;
        } catch (IOException e) { e.printStackTrace(); }        
        return false;
    }
    
    public static SimpleEntry<String,String> getLoginAndPwd() {
        File file = new File("userSave");
        if(file.exists()) {
            try {
                //Une classe qui lit les donnees depuis un fichier 
                Properties prop = new Properties();
                prop.load(new FileInputStream(file));
                String username = prop.getProperty("username");
                String pwd = prop.getProperty("pwd");
                SimpleEntry<String,String> pair1=new SimpleEntry<>(username,pwd);
                return pair1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new SimpleEntry<>("","");
    } 

    
    //private constructor to prevent instanciation
    private Utilities() {}
}
