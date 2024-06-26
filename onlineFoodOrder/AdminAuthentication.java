package onlineFoodOrder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;
import onlineFoodOrder.controller.FoodOrderSystem;

public class AdminAuthentication {

  private static FoodOrderSystem foodorder = FoodOrderSystem.getFoodOrderInstance();
  private static AdminAuthentication adminAuthentication = null;
  
  
  private AdminAuthentication(){
  
  }
  
  public static AdminAuthentication getAdminAuthentication_Instance(){
       if(adminAuthentication == null){
           adminAuthentication = new AdminAuthentication();
       }
       return adminAuthentication;
  }     
          

  
  public void checking() {
         System.out.println("Unauthorized access!");
          playSound("/home/zoho/atman/onlineFoodOrder/TF043.WAV");
  
  }

 /*private static boolean authenticateAdmin(String username, String password) {
       
        return adminAuthentication.foodorder.authenticateAdmin(username,password);
  }*/

   private static void playSound(String filename) {
    try {
        File file = new File(filename);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.drain();
        clip.close();
    } catch (Exception e){
        System.out.println("Error playing sound: " + e.getMessage());
    }
  }
}
