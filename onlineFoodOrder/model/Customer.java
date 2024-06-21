package onlineFoodOrder.model;;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer{
    private int customer_Id;
    private String customer_Name;
    private String customer_UserName;
    private String customer_Password;
    private long customer_MobileNo;
    
    public static Customer customer = null;
    
    private Customer(){
    
    }
        
     
    public Customer(String customer_Name,String customer_UserName,String customer_Password, long customer_MobileNo,int customer_Id){
          this.customer_Id = customer_Id;
          this.customer_Name = customer_Name;
          this.customer_UserName = customer_UserName;
          this.customer_Password = customer_Password;
          this.customer_MobileNo = customer_MobileNo;
    }
    
    public Customer(String customer_Name,String customer_UserName,String customer_Password, long customer_MobileNo){
          this.customer_Name = customer_Name;
          this.customer_UserName = customer_UserName;
          this.customer_Password = customer_Password;
          this.customer_MobileNo = customer_MobileNo;
   }
   
   public static Customer getCustomerInstance(){
       if(customer == null){
            customer = new Customer();
       }
       return customer;
   } 
   
   public int getCustomerId(){
       return customer_Id;
   } 
   
   public String getCustomerName(){
       return customer_Name;
   }
   
   public String getCustomerUserName(){
       return customer_UserName;
   }
   
   public String getCustomerPassword(){
       return customer_Password;
   }
   
   public long getCustomerMobileNo(){
       return customer_MobileNo;
   }
   
     public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        sb.append(String.format("| %-16s : %-20s |\n", "Customer Id is", getCustomerId()));
        sb.append(String.format("| %-16s : %-20s |\n", "Customer Name is", getCustomerName()));
        sb.append(String.format("| %-16s : %-20s |\n", "userName is", getCustomerUserName()));
        sb.append(String.format("| %-16s : %-20s |\n", "password is", "********"));
        sb.append(String.format("| %-16s : %-20s |\n", "mobileNo is", getCustomerMobileNo()));
        sb.append("------------------------------------------\n");
        return sb.toString();
    
    } 
   

    
}
     
                         
   
    
    
