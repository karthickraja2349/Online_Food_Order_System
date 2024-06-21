package onlineFoodOrder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;

public class FoodyCatlogue{
     
     public static FoodyCatlogue foodyCatlogue = null;
     
     private FoodyCatlogue(){
     
     }
     
     public static FoodyCatlogue getFoodyCatlogueInstance(){
         if(foodyCatlogue == null){
             foodyCatlogue = new FoodyCatlogue();
         }
         return  foodyCatlogue;
     }
     
     public void userMenu(){
           FileInputStream fileInputStream = null;
           BufferedInputStream bufferedInputStream = null;
           try{
               fileInputStream = new FileInputStream("/home/zoho/atman/onlineFoodOrder/foody.txt");
               bufferedInputStream = new BufferedInputStream(fileInputStream);
               int i = 0;
               while ((i = bufferedInputStream.read()) != -1){
                  char ch =(char)i;
                  System.out.print(ch);
               }
          }
          catch(IOException e){
             e.getMessage();
          }
          finally{
              try{
                if (bufferedInputStream != null) {
                  bufferedInputStream.close();
                }
              }
              catch(IOException e){
                  e.getMessage();
             }   
        }
    }
    
    public void helpMenu(){
         FileInputStream fileInputStream = null;
         BufferedInputStream bufferedInputStream = null;
           try{
               fileInputStream = new FileInputStream("/home/zoho/atman/onlineFoodOrder/Help.txt");
               bufferedInputStream = new BufferedInputStream(fileInputStream);
               int i = 0;
               while ((i = bufferedInputStream.read()) != -1){
                  char ch =(char)i;
                  System.out.print(ch);
               }
          }
          catch(IOException e){
             e.getMessage();
          }
          finally{
              try{
                if (bufferedInputStream != null) {
                  bufferedInputStream.close();
                }
              }
              catch(IOException e){
                  e.getMessage();
             }   
        }
    }
    
    
 }                   
