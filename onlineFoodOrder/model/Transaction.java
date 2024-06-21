package onlineFoodOrder.model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;



public class Transaction {
    private int transaction_id;
    private String customer_userName;
    private double amount;
    private String quantity;
    private Timestamp dateAndTiming;
    private List<Integer> food_id;
    private boolean cancel;
    private String location;

    private static Transaction transaction = null;

    private Transaction() { }

    public static Transaction getTransactionInstance() {
        if (transaction == null) {
            transaction = new Transaction();
        }
        return transaction;
    }

    public Transaction(int transaction_id, String customer_userName,Timestamp dateAndTiming, String quantity, List<Integer> food_id,double amount,boolean cancel,String location) {
        this.transaction_id = transaction_id;
        this.customer_userName = customer_userName;
        this.food_id = food_id;
        this.quantity = quantity;
        this.amount = amount;
        this.dateAndTiming = dateAndTiming;
        this.cancel = cancel;
        this.location = location;
    }
    
    
   public int getTransactionId(){
        return transaction_id;
   }    
   
   public String getCustomerUserName(){
       return customer_userName;
   }    
   
   public Timestamp getDateAndTiming(){
       return dateAndTiming;
   }    
   
   public String getQuantity(){
       return quantity;
   }
   
   public List getFoodIds(){
      return food_id;
   }   
   
   public double getAmount(){
      return amount;
   }   
   
   public boolean isCanceled(){
      return  cancel;
   }      
   
   public String getLocation(){
      return location;
   }
      
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("----------------------------------------------------------------------\n");
       sb.append(String.format("| %-30s : %-35s|\n", "Transaction id is ",getTransactionId()));
       sb.append(String.format("| %-30s : %-35s|\n", "user name is",getCustomerUserName()));
       sb.append(String.format("| %-30s : %-35s|\n", "Date&Time is",getDateAndTiming()));
       sb.append(String.format("| %-30s : %-35s|\n", "quantity is",getQuantity()));
       sb.append(String.format("| %-30s : %-35s|\n", "Foodids are is",getFoodIds()));
       sb.append(String.format("| %-30s : %-35s|\n", "Amount is",getAmount()));
       sb.append(String.format("| %-30s : %-35s|\n", "Cancelled", isCanceled() ? "Yes" : "No"));
       sb.append(String.format("| %-30s : %-35s|\n", "location is",getLocation()));
       sb.append("----------------------------------------------------------------------\n");
       return sb.toString(); 
    }   
}



