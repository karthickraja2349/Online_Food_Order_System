package onlineFoodOrder;
import onlineFoodOrder.view.FoodyManagement;
import onlineFoodOrder.model.Admin;
import onlineFoodOrder.controller.FoodOrderSystem;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;
import java.util.InputMismatchException;


public class Foody extends FoodyManagement{
      
      
      private Admin admin = Admin.getAdminInstance();
     
      private FoodOrderSystem  foodorder = FoodOrderSystem.getFoodOrderInstance();
      private AdminAuthentication adminAuthentication =AdminAuthentication.getAdminAuthentication_Instance();
      private FoodyCatlogue foodyCatlogue = FoodyCatlogue.getFoodyCatlogueInstance();
      
      private static Scanner input = new Scanner(System.in);
      private static  Foody foody = new Foody();
      
      public static void main(String[]args)throws Exception{
         
           
          while (true) {
            displayMainMenu();
               
                while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                } 
                
                int choice = input.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    exitMenu();
                    break;
                default:
                    System.out.println("Invalid choice, Please Select Valid choice as per list. You Enter : " + choice);
            }
        }
     }    
            
          
     public static void displayMainMenu() {
        System.out.println("WELCOME TO FOODY");
        System.out.println("EAT , SLEEP ,CONQUER and Repeat");
        System.out.println("--------------------------------------------");
        System.out.println("|Option |         Mainmenu                 |");
        System.out.println("|-------+----------------------------------|");
        System.out.println("|   1   |Admin                             |");
        System.out.println("|   2   |Customer                          |");
        System.out.println("|   3   |Exit                              |");
        System.out.println("--------------------------------------------");
        System.out.println("Enter the Choice");
    }   
    
    
     public static void adminMenu() {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("| Option |          Admin Mainmenu         |");
            System.out.println("|--------+---------------------------------|");
            System.out.println("|   1    |Login Admin                      |");
            System.out.println("|   2    |Add Admin                        |");
            System.out.println("|   3    |Back to Mainmenu                 |");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the Choice");

            int adminChoice = input.nextInt();

            switch (adminChoice) {
                case 1:
                    if(LoginAdmin()){
                    adminSubMenu();
                   } 
                    break;
                case 2:
                     if(foody.getAdminLoginDetails()){
		        getAdminDetails ();
		     }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, Please Select Valid choice: " + adminChoice);
            }
        }
    }    
    
    public static void customerMenu()throws Exception {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("| Option |       Customer Mainmenu         |");
            System.out.println("|--------+---------------------------------|");
            System.out.println("|   1    |Login Customer                   |");
            System.out.println("|   2    |New Customer                     |");
            System.out.println("|   3    |Back to Mainmenu                 |");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the choice");

            int customerChoice = input.nextInt();
           

            switch (customerChoice) {
                case 1:
                    
                    customerLogin();
                  
                    break;
                case 2:
                    newCustomer();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, Please Select Valid choice: " + customerChoice);
            }
        }
    }
    
      public static void exitMenu() {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("| Option |            Exit Menu            |");
            System.out.println("|--------+---------------------------------|");
            System.out.println("|   1    |Are you Sure?(If it, press 1)    |");
            System.out.println("|   2    |Stay Here .(press 2)             |");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the choice");

            int exitChoice = input.nextInt();
           try{
            switch (exitChoice) {
              
                case 1:
                    System.out.println("Thankyou for visiting Foody ! Eat more be Strong");
                    System.exit(0);
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice, Please Select Valid choice: " + exitChoice);
            }
            
            
          }
          catch(InputMismatchException e){
              System.out.println(e);
          }      
        }
     }
                                          //Ensure root admin
    public static  boolean getAdminLoginDetails (){
        input.nextLine();
	System.out.println ("--------------------");
	System.out.println ("Enter the User Name: ");
	String userName = input.nextLine();
	System.out.println ("Enter the Password: ");
	String password = input.nextLine();
	System.out.println ("--------------------");
	boolean adminCheck =foody.foodorder.authenticateAdmin (userName,password);
	if(adminCheck){                                                                                                   //foody
	     System.out.println("Welcome : "+ foody.admin.getRootName());
	}
	else{
	     System.out.println("Invalid login credentials");
	     return false;
	}
	return true;      
   }
                                        //Ensure other admins
   public static boolean LoginAdmin(){
        input.nextLine();
        System.out.println ("--------------------");
	System.out.println ("Enter the User Name: ");
	String userName = input.nextLine();
	System.out.println ("Enter the Password: ");
	String password = input.nextLine();
	System.out.println ("--------------------");
	boolean checkAdmin = foody.foodorder.adminCheck(userName,password);
	if(checkAdmin){
	      System.out.println("Welcome : "+ userName);
	}
	else{
	      System.out.println("Invalid login credentials");
	      foody.adminAuthentication.checking();
	      return false;
	} 
	return true;
   }	              
   
                                      
   
    
   
   
    public static void adminSubMenu() {
      
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("| Option |          Description            |");
            System.out.println("|--------+---------------------------------|");
            System.out.println("|   1    |Add Hotel                        |");
            System.out.println("|   2    |Add Food                         |");
            System.out.println("|   3    |Add Employee                     |");
            System.out.println("|   4    |view Hotel List                  |");
            System.out.println("|   5    |view Customer Details            |");
            System.out.println("|   6    |view Admin Details               |");
            System.out.println("|   7    |view Food Details                |");
            System.out.println("|   8    |view Employee Details            |");
            System.out.println("|   9    |view Transaction Details         |");
            System.out.println("|  10    |view particular Transaction      |");
            System.out.println("|  11    |view particular Food             |");
            System.out.println("|  12    |Delete food                      |");
            System.out.println("|  13    |Delete Hotel                     |");
            System.out.println("|  14    |Delete Employee                  |");
            System.out.println("|  15    |Back to Admin Menu               |");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the Choice: ");
           
            int Choice = input.nextInt();
            input.nextLine();
           
            switch (Choice) {
                case 1:
                    getHotelDetails();
                    break;
                case 2 :
                     getFoodDetails();
                     break; 
                case 3 : 
                     getEmployeeDetails();
                     break;      
                case 4:
                    showHotels();
                    break;
                case 5:
                    viewCustomers();
                    break;
                case 6:
                    viewAdmin();
                    break;
                case 7:
                    showFood();
                    break;     
                case 8 :
                    showEmployees();
                    break;    
                case 9 :
                    showTransaction();
                    break;
                case 10 :
                    System.out.println();
                    System.out.println("Enter the username of the customer");
                    String userName = input .nextLine();
                    foody.foodyManagement.showUserTransaction(userName); 
                    break;   
                 case 11 :
                     System.out.println();
                     System.out.println("Enter the food name without any spaces");
                     String food = input.nextLine().toUpperCase().trim();
                     showFood(food);   
                     break;
                case 12:
                    foodDeletion(); 
                    break;   
                case 13:
                    hotelDeletion();
                    break;
                case 14:
                    employeeDeletion();
                    break;        
                case 15 :                             
                     return;         
                default:
                    System.out.println("Invalid choice, Please Select Valid choice: You select " + Choice);
            }
        }
    }
    
    
                                                    //customer login
  public static boolean customerLogin()throws Exception {
     input.nextLine();
     System.out.println("--------------------");
     System.out.println("1.LOGIN");
     System.out.println("Enter user name"); 
     String userName = input.nextLine();
     System.out.println("Enter password");      
     String password = input.nextLine();                                                            
     try {    
        boolean check = foody.foodorder.customerCheck(userName, password); 
        if (check) {
            System.out.println("Welcome " + userName);
            customerSubMenu(userName);
        } else {
            System.out.println("Invalid username or password, please check before login");
            
            return false;
        }
    } 
    catch (Exception e) {
         e.getMessage();
    }  
    return true;
  }
    
     public static void customerSubMenu(String userName) {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("| Option |          Description            |");
            System.out.println("|--------+---------------------------------|");
            System.out.println("|   1    |welcome menu                     |");
            System.out.println("|   2    |Help menu                        |");
            System.out.println("|   3    |Food Menu                        |");
            System.out.println("|   4    |Search Food                      |");
            System.out.println("|   5    |Search Food with id              |");
            System.out.println("|   6    |Hotel Menu                       |");
            System.out.println("|   7    |Order food                       |");
            System.out.println("|   8    |Cancel food                      |");
            System.out.println("|   9    |orderHistory                     |");
            System.out.println("|  10    |Back to Customer Menu            |");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the Choice: ");
            
            int customerChoice = input.nextInt();
            
            switch(customerChoice){
                  case 1:
                     foody.foodyCatlogue.userMenu();
                     break;
                  case 2:
                     foody.foodyCatlogue.helpMenu();
                     break;   
                  case 3 :
                     showFood();
                     System.out.println("If you want to taste it , press 7 to make it available at your doors");
                     input.nextLine();
                     break;
                  case 4 :
                     input.nextLine();
                     System.out.println("Enter the food name without any spaces");
                     String food = input.nextLine().toUpperCase().trim();
                    
                     showFood(food);
                     System.out.println("If you want to taste it , press 7 to make it knock on your doors");
                     break;
                     
                  case 5 :
                     System.out.println("Enter the Food id to search");
                     int foodId = input.nextInt();
                     showFood(foodId);
                     System.out.println("If you want to taste it , press 7 to make it knock on your doors");
                     break;   
                  case 6 :
                    showHotels();
                     break;
                     
                  case 7 :
                   
                     foody.foodyManagement.foodChoosing(userName);
                     break;
                  case 8:
                      foody.foodyManagement.cancelOrder(userName); 
                      break;
                  case 9:
                      foody.foodyManagement.showUserTransaction(userName);
                      break;    
                  
                  case 10:
                      return;
                      
                  default:
                      System.out.println("Invalid choice, Please Select Valid choice: " + customerChoice);
                        
           }                               

      }
   }  


}
  

   
       

     

 

