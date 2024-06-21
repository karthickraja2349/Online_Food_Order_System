package onlineFoodOrder.view;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

import onlineFoodOrder.model.Food;
import onlineFoodOrder.model.Customer;
import onlineFoodOrder.model.Admin;
import onlineFoodOrder.model.Transaction;
import onlineFoodOrder.model.Hotel;
import onlineFoodOrder.model.Employee;
import onlineFoodOrder.model.ValidationCheck;
import onlineFoodOrder.controller.FoodOrderSystem;

public class FoodyManagement extends ValidationCheck{
       
       private static Scanner input = new Scanner(System.in);
       private static FoodOrderSystem foodorder =  FoodOrderSystem.getFoodOrderInstance();
       private Customer customer = 	Customer.getCustomerInstance();
       private List<Hotel> hotels;
       public static FoodyManagement foodyManagement = new FoodyManagement();
     
     
     
                                   //Insert food into the table
   public static void getFoodDetails() {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter details for the given fields");
      System.out.println("-----------------------");

      System.out.println("Enter the name of the Food without any spaces");
      String foodName = input.nextLine().toUpperCase();

      System.out.println("Enter the price of the Food");
      double foodPrice = input.nextDouble();
      input.nextLine(); 

      String foodType = "";
      while (true) {
         System.out.println("Enter the type of the food (veg or Non veg)");
         foodType = input.nextLine();
         if (foodType.equalsIgnoreCase("veg") || foodType.equalsIgnoreCase("Non veg")) {
            break;
         }
        System.out.println("Enter the correct type of the food");   
     }

     System.out.println("Enter the Nature of the food");
     String foodNature = input.nextLine();

     System.out.println("Enter the quantity of the food");
     String foodQuantity = input.nextLine();

     Food food = new Food(foodName, foodPrice, foodType, foodNature, foodQuantity);
     foodyManagement.foodorder.addFood(food); 

     System.out.println("----------------------------");
  }
   
      
        
                                     
                                    
                                     //Insert hotel into the table
  public static void getHotelDetails() {

     System.out.println("Enter details for the given fields. All names should contain a minimum of 4 and a maximum of 30 characters. The name should only be within A-Z/a-z.");
     System.out.println("----------------------");

     String hotelName = foodyManagement.getValidatedInput("Enter the Hotel Name: ");
     String ownerName = foodyManagement.getValidatedInput("Enter the Owner Name: ");
     String location  = foodyManagement.getValidatedInput("Enter the Exact location of the Hotel: ");
     System.out.println("Enter available foods (comma separated food IDs):");
     String availableFoodsInput = input.nextLine();
     List<Integer> availableFoods = Hotel.convertStringToList(availableFoodsInput);

     System.out.println("Hotel Name: " + hotelName);
     System.out.println("Owner Name: " + ownerName);
     System.out.println("Location: " + location);

     Hotel hotel = new Hotel(hotelName, ownerName, location, availableFoods);
     foodyManagement.foodorder.addHotel(hotel);

     System.out.println("-------------------------");
  }

                                     //insert admin into the table
     public static  void getAdminDetails () {
     
       System.out.println("Enter details for the given fields. All names should contain a minimum of 4 and a maximum of 30 characters. The name should only be within A-Z/a-z.The password must start with alphabets may or may not contains numbers but must contain atleast one special character");
	System.out.println ("--------------------");
	
	String AdminName  = foodyManagement.getValidatedInput("Enter the Admin Name");
	String AdminUserName = foodyManagement.getValidatedInput("Enter the userName of the Admin");
	String password = foodyManagement.getValidatedPassword("Enter the password");
	
	Admin admin = new Admin(AdminName,AdminUserName,password);
	foodyManagement.foodorder.addAdmin(admin);
	
	System.out.println("-------------------------");
    }
   
            
                                     //show food 
    public static void showFood(){
         List<Food> foodmenu = foodyManagement.foodorder.getFoodMenu();
         System.out.println("--------------THE AVAILABLE FOODS ARE--------------");
         for(Food food : foodmenu){
              System.out.println(food);
         }
         System.out.println("--------------THESE ARE THE AVAILABLE FOODS IN OUR FOODY---------");
    }
                                    // show particular food
    public static void showFood(String foodName) {
        List<Food> foods = foodyManagement.foodorder.getParticularFood(foodName);
        if (foods.isEmpty()) {
           System.out.println("No food there. If you are Hungry please try to search for another food and");
        } 
        else {
            System.out.println("---------------------------");
            for (Food food : foods) {
               System.out.println(food);
            }
            System.out.println("---------------------------");
       }
   }
                                  //show particular food with id
   public static void showFood(int foodId){
       List<Food> foods = foodyManagement.foodorder.getParticularFood(foodId);
       if(foods.isEmpty()){
          System.out.println("No food there. If you are Hungry please try to search for another food and");
       }
       else{
             System.out.println("---------------------------");
            for (Food food : foods) {
               System.out.println(food);
            }
            System.out.println("----------------------------");
       }
   }   
      
    
                                          // show hotels
    public static void showHotels(){
        List<Hotel> hotelList = foodyManagement.foodorder.getHotelList();
           System.out.println("--------THE AVAILABLE HOTELS UNDER FOODY MANAGEMENT ARE---------");
             for (Hotel hotel : hotelList) {                                                                                     //foodymanagement
                 System.out.println(hotel);
              }    
           System.out.println("-----------THESE ARE THE HOTELS COOPERATE WITH OUR FOODY MANAGEMENT---------------------");   
    }   
    
                      
                      
                                            //show customers
   
    public static  void viewCustomers() {
        List<Customer> customers = foodyManagement.foodorder.getCustomerDetails();
        System.out.println("---------THE CUSTOMERS USING OUR FOODY MANAGEMENT ARE--------");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } 
        else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
         System.out.println("---------THESE ARE THE CUSTOMERS USING OUR FOODY MANAGEMENT--------");
    }            
         
         
                                         //show Admin
     public static void viewAdmin(){
        List<Admin> adminDetails =  foodyManagement.foodorder.getAdminDetails();
        System.out.println("----------THE ADMIN MANAGING OUR FOODY MANAGEMENT ARE---------");
        for(Admin admin : adminDetails){
            System.out.println(admin);
        }
        System.out.println("---------THESE ARE THE ADMINS WORKING IN OUR FOODY MANAGEMENT----");
     }        
      
      
                                        //show Transaction
     public static void showTransaction(){
        List<Transaction> transactionDetails = foodyManagement.foodorder.getTransactionDetails();
        System.out.println("---------------THE TRANSACTIONS MADE IN OUR FOODY MANAGEMENT ARE-----------");
        for(Transaction transaction : transactionDetails){
             System.out.println(transaction);
        }
        System.out.println("---------------THESE ARE THE TRANSACTIONS DONE IN OUR FOODY MANAGEMENT-------");
     }         
     
                                       
                                       //show usertransaction     
    public static void showUserTransaction(String username) {
       List<Transaction> transactionDetails = foodyManagement.foodorder.getTransactionDetails(username);
       if (transactionDetails.isEmpty()) {
          System.out.println("No Order made by you");
       } 
       else {
         System.out.println("---------------THE TRANSACTIONS MADE BY YOU ARE --------------------------");
         for (Transaction transaction : transactionDetails) {
            System.out.println(transaction);
         }
         System.out.println("-----------------THESE ARE THE TRANSACTIONS DONE BY YOU WITH THE FOOOY MANAGEMENT---------");
      }
    }
                                     
                                     //show employees
    public static void showEmployees(){
        List<Employee> employeeDetails = foodyManagement.foodorder.getEmployeeDetails();
        System.out.println("----------------THE EMPLOYEES WORKING IN OUR FOODY MANAGEMENT ARE --------------");
        for(Employee employee : employeeDetails){
             System.out.println(employee);
        }
        System.out.println("---------------THESE ARE THE EMPLOYEES WORKING IN OUR FOODY MANAGEMENT-----------------");
    }          
        
        
         
                                           // name validation 
    public  String getValidatedInput(String prompt) {
        
        System.out.println(prompt);
      
        String inputString = input.nextLine();
        while (!ValidateName(inputString)) {
            System.out.println("Invalid input.please  correctly " + prompt);
            inputString = input.nextLine();
        }
        return inputString;
    }
                                          //password validation
   public String getValidatedPassword(String prompt){
      System.out.println(prompt);
      String password = input.nextLine();
      while(!ValidatePassword(password)){
          System.out.println("Invalid password.please  correctly" + prompt);
          password = input.nextLine();
     }
     return password;
   }         
                                          //mobilenumber validation
   public String getValidatedMobileNumber(String prompt){
       System.out.println(prompt);
       long mobileNumber = input.nextLong();
       while(!validateNumber(mobileNumber)){
         System.out.println("Invalid syntax for mobile number.please correctly " + prompt);
         mobileNumber=input.nextLong();
       }
       return Long.toString(mobileNumber);
   }
                                        //aadhar validation
   public String getValidatedAadharNumber(String prompt){
       System.out.println(prompt);
       long aadharNumber = input.nextLong();
       while(!validateAadhar(aadharNumber)){
         System.out.println("Invalid syntax for Aadhar number.please correctly " + prompt); 
         aadharNumber = input.nextLong();
         
       }
       return Long.toString(aadharNumber);
   }         
      
   
                                              //new customer
  
  public static void newCustomer(){
            System.out.println ("--------------------");
            System.out.println("1.SIGN UP");
            System.out.println("Welcome to our Foody Management");
            System.out.println("------------------------------");
            System.out.println("Enter details for the given fields. All names should contain a minimum of 4 and a maximum of 30 characters. The name should only be within A-Z/a-z.The password must start with alphabets may or may not contains numbers but must contain atleast one special character. The Mobile Number should be contains 10digit");
            System.out.println("---------------------------------");
            
            String customerName  = foodyManagement.getValidatedInput("Enter the customer Name");
            String userName      = foodyManagement.getValidatedInput("Enter the userName of the customer");
            String password      = foodyManagement.getValidatedPassword("Enter the password");
            String mobileNo      = foodyManagement.getValidatedMobileNumber("Enter the mobile number");
            
            long MobileNumber = Long.parseLong(mobileNo);
            
            Customer customer  = new Customer(customerName,userName,password,MobileNumber);
            foodyManagement.foodorder.addCustomer(customer);
            
            System.out.println("REGISTRATION SUCCESSFULL");
            System.out.println("------------------------------");
          
    }
                                           //new Employee
    public static void getEmployeeDetails(){
            System.out.println("---------------------------");
            System.out.println("Enter details for the given fields. All names should contains a minimum of 4 and maximum 0f 30 characters.The name should only be within A-Z/a-z.The Mobile Number should be contains 10 digit. The aadhar numer should be contains 12 digit");
            System.out.println("--------------------------");
            
            String EmployeeName = foodyManagement.getValidatedInput("Enter the Employee name");
            String location =foodyManagement.getValidatedInput("Enter the location you preferred to work");
            String MobileNo = foodyManagement.getValidatedMobileNumber("Enter the mobile number");
            String AadharNo = foodyManagement.getValidatedAadharNumber("Enter the Aadhar number");
          
            
            long EmployeeMobileNo = Long.parseLong(MobileNo);
            long EmployeeAadharNo = Long.parseLong(AadharNo);
            
            System.out.println("Aadhar and mobile number successfully entered");
            
            
            Employee employee = new Employee(EmployeeName, EmployeeAadharNo, EmployeeMobileNo, location);
            
            if(foodyManagement.foodorder.addEmployee(employee)){
            
             System.out.println("REGISTRATION SUCCESSFULL");
             System.out.println("-------------------------------");
           }
           else{
             System.out.println("some issues be arise.May be the employee already exists");
           }   
    }        
            
               
                                           //location details
   public static void getLocation(String location){
            input.nextLine();
            input.nextLine();
            if(location.equalsIgnoreCase("gcetly") || location.equalsIgnoreCase("NGOColony")){
                System.out.println("Your food will knock your door on 10 to 20 minutes");
            }
            else if(location.equalsIgnoreCase("highground") || location.equalsIgnoreCase("palayankotai")){
                System.out.println("Your food will knock your door on 30 to 45 minutes");
            }
            else if(location.equalsIgnoreCase("palayapettai") || location.equalsIgnoreCase("vannarapettai")){
                 System.out.println("Your food will knock your door on 20 to 30 minutes");
            }
            else if(location.equalsIgnoreCase("Newbusstand") || location.equalsIgnoreCase("melapalayam")){
                 System.out.println("Your food will knock your door on 25 to 30 minutes");
            }
            else if(location.equalsIgnoreCase("thisayanvilai") || location.equalsIgnoreCase("tuckerammalpuram")){
                 System.out.println("Your food will knock your door on approximately 45 minutes");
            }
            else{
                System.out.println("Your food will knock your door on approximately 35 minutes to 50 minutes, sorry for the inconvinience .We will make it as soon as faster");
            }
   }                                   
           
  
       
   
                                //food choosing
public void foodChoosing(String userName) {
    Map<Integer, Map<Integer, Integer>> hotelIdsWithFoodQuantities = new HashMap<>();

    showFood();
    System.out.println("--------------------");
    String location = getValidatedInput("Enter your location inside the Thirunelveli district. Make sure while spelling the word");

    System.out.println("-----");

    System.out.println("Please enter the food IDs and quantities you wish to select (enter 0 for the foodId to finish):");

    while (true) {
        System.out.print("Enter Food ID: ");
        int foodId = input.nextInt();
        if (foodId == 0) {
            if (hotelIdsWithFoodQuantities.isEmpty()) {
                System.out.println("No food selected. Exiting selection.");
                return;
            }
            break;
        }

        boolean foodCheck = foodorder.foodCheck(foodId);
        if (!foodCheck) {
            System.out.println("Food ID does not exist. Please try again.");
            continue;
        }

        int quantity;
        while (true) {
            System.out.print("Enter Quantity: ");
            quantity = input.nextInt();
            if (quantity > 0) {
                break;
            } else {
                System.out.println("Please enter a valid quantity greater than 0.");
            }
        }

        List<Hotel> hotelsWithFood = foodorder.getHotelsByFoodId(foodId);
        if (hotelsWithFood.isEmpty()) {
            System.out.println("No hotels found with the given food ID. Please try another food ID.");
            continue;
        }

        System.out.println("Hotels with the selected food:");
        for (Hotel hotel : hotelsWithFood) {
            System.out.println(hotel);
        }

        System.out.print("Enter the Hotel ID to select: ");
        int hotelId = input.nextInt();

        Hotel selectedHotel = getHotelById(hotelId, hotelsWithFood);
        if (selectedHotel == null) {
            System.out.println("Invalid Hotel ID selected. Exiting food selection.");
            return;
        }

        Map<Integer, Integer> foodQuantities = hotelIdsWithFoodQuantities.getOrDefault(hotelId, new HashMap<>());
        if (foodQuantities.containsKey(foodId)) {
            foodQuantities.put(foodId, foodQuantities.get(foodId) + quantity);
        } else {
            foodQuantities.put(foodId, quantity);
        }
        hotelIdsWithFoodQuantities.put(hotelId, foodQuantities);
    }

    double totalAmount = 0.0;
    for (Map.Entry<Integer, Map<Integer, Integer>> entry : hotelIdsWithFoodQuantities.entrySet()) {
        totalAmount += foodorder.calculateTotalAmount(entry.getValue());
    }

    System.out.println("Total Amount: " + totalAmount);
    System.out.println("!!!!!hurrah!!!!!!");
    System.out.println("press enter(ok) to continue");

    foodorder.placeOrder(userName, hotelIdsWithFoodQuantities, totalAmount, location); // Pass the location

    System.out.println("Your food will knock your door in 10 to 20 minutes");
}


 





public Hotel getSelectedHotel() {
    Scanner scanner = new Scanner(System.in);
    
    // Display available hotels to the user
    List<Hotel> hotels = showHotelss();
    if (hotels == null || hotels.isEmpty()) {
        System.out.println("No hotels available.");
        return null;
    }
    
    // Prompt user to select a hotel
    System.out.print("Enter the Hotel ID to select: ");
    int selectedHotelId = scanner.nextInt();
    
    // Find the selected hotel from the list
    for (Hotel hotel : hotels) {
        if (hotel.getHotelId() == selectedHotelId) {
            scanner.close();
            return hotel;
        }
    }
    
    scanner.close();
    System.out.println("No hotel found with ID: " + selectedHotelId);
    return null; // Return null if no hotel with the given ID is found
}


  public List<Hotel> showHotelss() {
    List<Hotel> hotels = new ArrayList<>();
    
    try {
        // Replace this with your actual logic to fetch hotels from the database
        hotels = foodorder.getHotelList(); // Assuming getHotelList() returns List<Hotel>
        
        // Display available hotels to the user
        if (hotels.isEmpty()) {
            System.out.println("No hotels available.");
        } else {
            System.out.println("Available Hotels:");
            for (Hotel hotel : hotels) {
                System.out.println(hotel);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error fetching hotels: " + e.getMessage());
    }
    
    return hotels;
}



  
  
                      //cancel order
    public static void cancelOrder(String userName){
        System.out.println("Enter your TransactionID");
        int transaction_id = input.nextInt();
        foodyManagement.foodorder.cancelFood(transaction_id,userName);
        System.out.println("THANK YOU"); 
    }    
              
              
                      //food deletion
    public static void foodDeletion(){
       System.out.println("Enter the Food id to delete");
       int foodId = input.nextInt();
       foodyManagement.foodorder.deleteFood(foodId);
    }
    
                      //hotel deletion
    public static void hotelDeletion(){
      System.out.println("Enter the hotel id to delete");
      int hotelId = input.nextInt();
      foodyManagement.foodorder.deleteHotel(hotelId);
    }   
  
                     // employee removal
    public static void employeeDeletion(){
      System.out.println("Enter the EmployeeId to delete");
      int employeeId = input.nextInt();
      foodyManagement.foodorder.deleteEmployee(employeeId);
    }  
 
  private Hotel getHotelById(int hotelId, List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelId() == hotelId) {
                return hotel;
            }
        }
        return null;
    }
           


  
}
