package onlineFoodOrder.controller;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Map;
import java.util.HashMap;
import java.sql.Statement;

import onlineFoodOrder.databases.DatabaseConnection;
import onlineFoodOrder.databases.StatementProvider;

import onlineFoodOrder.model.Food;
import onlineFoodOrder.model.Customer;
import onlineFoodOrder.model.Admin;
import onlineFoodOrder.model.Transaction;
import onlineFoodOrder.model.Hotel;
import onlineFoodOrder.model.Employee;
import onlineFoodOrder.model.FoodService;
import onlineFoodOrder.model.HotelService;
import onlineFoodOrder.model.AdminService;




public class FoodOrderSystem implements FoodService,HotelService,AdminService{
    private  Connection connection = DatabaseConnection.getConnection();
    private  Food food = Food.getFoodInstance();
    private  Hotel hotel =Hotel.getHotelInstance();
    private  Admin admin = Admin.getAdminInstance();
    private  Customer customer = Customer.getCustomerInstance();
    private  Employee employee = Employee.getEmployerInstance();
    
    public static FoodOrderSystem foodOrder = null; 
   

    
    
    
    private FoodOrderSystem(){
    
    }
    
    public static  FoodOrderSystem getFoodOrderInstance(){
        if(foodOrder == null){
            foodOrder = new FoodOrderSystem();
        }
        return foodOrder;
   }
                                   // create food table
   public void createFoodTable(){
      try{
         PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CREATE_FOOD_TABLE);        
         statement.execute();
         }
     catch(SQLException e){
         System.out.println("sorry"+ e.getMessage());
     }
  }            
  
                                   //create hotel table
   public void createHotelTable(){
      try{
         PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CREATE_HOTEL_TABLE);       
         statement.execute();
         }
      catch(SQLException e){
         System.out.println("sorry"+ e.getMessage());
      }
  }
  
                                  //create admin table
   public void createAdminTable() {
        try {
            PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CREATE_ADMIN_TABLE);
            statement.execute();
            }
        catch (SQLException e) {
            System.out.println("sorry"+e.getMessage());
        }
    }
    
                                //create customer table
    public void createCustomerTable(){
       try{
           PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CREATE_CUSTOMER_TABLE);
           statement.execute();
          }
       catch(SQLException e){
           System.out.println("sorry"+e.getMessage());
       }
           
   }            
                  
                                //add food object with parameters to the food table
  public boolean addFood(Food food) {
    try {
        PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.ADD_FOOD);                      
        
        statement.setString(1, food.getFoodName());
        statement.setDouble(2, food.getFoodPrice());
        statement.setString(3, food.getFoodType());
        statement.setString(4, food.getFoodNature());
        statement.setString(5, food.getQuantity());
        statement.executeUpdate();
        System.out.println("FOOD ADDED SUCCESSFULLY");
        return true;
    } 
    catch (SQLException e) {
        System.out.println("Food name already exists");
    }
    return false;      
  }

                              //add hotel object with parameters to the Hotel table
   public boolean addHotel(Hotel hotel){                                                                            
     try{                                                                                                                            //1
        PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.ADD_HOTEL);
       
        statement.setString(1,hotel.getHotelName());
        statement.setString(2,hotel.getOwnerName());
        statement.setString(3,hotel.getLocation());
        statement.setString(4, Hotel.convertListToString(Arrays.asList(1, 7, 8)));
        statement.executeUpdate();
        System.out.println("HOTEL ADDED SUCCESSFULLY");
        return true;
        }
     catch(SQLException e){
        e.getMessage();
     }
     return false;
  }
                            // check the admin
    public boolean authenticateAdmin(String userName ,String password){                                          
        if(userName.equals(admin.getRootUserName())&& password.equals(admin.getRootPassword())){                                    
              return true;
        }
        else{
            return false;
       }  
    }
                          
                          //add admin to the admin table 
  public boolean addAdmin(Admin admin) {
     try {
     
        PreparedStatement existenceStatement = StatementProvider.getPreparedStatement(SQLQueries.CHECK_ADMIN_EXISTENCE);
        existenceStatement.setString(1, admin.getAdminName());
        ResultSet resultSet = existenceStatement.executeQuery();
        resultSet.next();                                                                                                             
        int count = resultSet.getInt(1);

        if (count > 0) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }

       
        PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.ADD_ADMIN);
      
        statement.setString(1, admin.getAdminName());
        statement.setString(2, admin.getAdminUserName());
        statement.setString(3, admin.getAdminPassword());
        statement.executeUpdate();

        System.out.println("ADMIN ADDED SUCCESSFULLY");
        return true;
    } catch (SQLException e) {
        System.out.println(e);
    }
    return false;
  }
  
                            //add customer to the customer table
  public boolean addCustomer(Customer customer) {
    try {
        PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.ADD_CUSTOMER);
        statement.setString(1, customer.getCustomerName());
        statement.setString(2, customer.getCustomerUserName());
        statement.setString(3, customer.getCustomerPassword());
        statement.setLong(4, customer.getCustomerMobileNo());
        statement.executeUpdate();
        System.out.println("CUSTOMER ADDED SUCCESSFULLY");
        return true;
    } catch (SQLException e) {
          System.out.println("customer might be present already or please check username or mobile number before inserting");
    }
    return false;
  }
  
                               //add employee to the employee table
  public boolean addEmployee(Employee employee){
    try(PreparedStatement statement = connection.prepareStatement(SQLQueries.ADD_EMPLOYEE ,Statement.RETURN_GENERATED_KEYS)){
      statement.setString (1,employee.getName());
      statement.setLong(2,employee.getAadhaarNumber());
      statement.setLong(3,employee.getMobileNumber());
      statement.setString(4,employee.getLocation());
      int rowsInserted = statement.executeUpdate();
      if(rowsInserted > 0){
         ResultSet generatedKeys = statement.getGeneratedKeys();
         if (generatedKeys.next()) {
                int employeeId = generatedKeys.getInt(1);
                System.out.println("------------------------------------------------------");
                System.out.println("Employee ID of the current employee is : " + employeeId);
                System.out.println("------------------------------------------------------");
                System.out.println("EMPLOYEE ADDED SUCCESSFULLY");
        }
        else{
           System.out.println("Failed to retrive employee id");
        }
        return true;
     }
     else{
         System.out.println("Failed to add employee");
     }                  
   }
   catch(SQLException e){
        e.getMessage();
       
    }
    return false;
  }   
  
                          
      
      
       
        
                                
                              // display the food menu                                                                                                
   public List<Food> getFoodMenu(){
         List<Food> foodMenu = new ArrayList<>();
         try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_FOOD_MENU);ResultSet resultSet = statement.executeQuery()){
         
              while(resultSet.next()){
                  foodMenu.add(new Food(resultSet.getInt("food_id"),resultSet.getString("food_name"),resultSet.getDouble("food_price"),
                             resultSet.getString("food_type"),resultSet.getString("food_nature"),resultSet.getString("quantity")));
               }
        }
        catch(SQLException e){
            e.getMessage();
        }
        return foodMenu;
   }
                             
                             
                             //display particular food
   public List<Food> getParticularFood(String foodName) {
       List<Food> food = new ArrayList<>();
       try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.FOOD_SELECTION)) {
         statement.setString(1, foodName);
          try (ResultSet resultSet = statement.executeQuery()) {
             while (resultSet.next()) {
                 food.add(new Food(
                    resultSet.getInt("food_id"),
                    resultSet.getString("food_name"),
                    resultSet.getDouble("food_price"),
                    resultSet.getString("food_type"),
                    resultSet.getString("food_nature"),
                    resultSet.getString("quantity")
                ));
            }
        }
     } 
     catch (SQLException e) {
        e.getMessage();
    }
    return food;
  }
                             //display food with id
  public List<Food> getParticularFood(int foodId){
     List<Food> food = new ArrayList<>();
     try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.FOOD_SELECTION_WITH_ID)){
       statement.setInt(1,foodId);
       try(ResultSet resultSet = statement.executeQuery()){
          while (resultSet.next()){
                    food.add(new Food(
                    resultSet.getInt("food_id"),
                    resultSet.getString("food_name"),
                    resultSet.getDouble("food_price"),
                    resultSet.getString("food_type"),
                    resultSet.getString("food_nature"),
                    resultSet.getString("quantity")
                ));
            }
        }
     }
     catch(SQLException e){
         e.getMessage();
     }
     return food;
  }      
                         //display hotel with location
 public List<Hotel> getParticularHotel(String location) {
    List<Hotel> hotelList = new ArrayList<>();
    try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_HOTEL_WITH_LOCATION)) {
        statement.setString(1, location);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String hotelName = resultSet.getString("hotel_name");
                String ownerName = resultSet.getString("owner_name");
                String location_of_hotel = resultSet.getString("location");
                String availableFoodsString = resultSet.getString("available_foods");

                List<Integer> availableFoods = Hotel.convertStringToList(availableFoodsString);

                hotelList.add(new Hotel(hotelId, hotelName, ownerName, location_of_hotel, availableFoods));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hotelList;
 }
 
  
                    
                            //delete food with id
   public void deleteFood(int food_id){
     if(foodCheck(food_id)){  
        try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.DELETE_FOOD)){
          statement.setInt(1,food_id);
          statement.executeUpdate();
          System.out.println("Food deleted Successfully");
        }
        catch(SQLException e){
          e.getMessage();
        } 
    }
    else{
       System.out.println("Food id does not match");
    }
  } 
   
                           //delete hotel with id
  public void deleteHotel(int hotel_id){
     if(hotelCheck(hotel_id)){
         try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.DELETE_HOTEL)){ 
           statement.setInt(1,hotel_id);
           statement.executeUpdate();
           System.out.println("Hotel deleted successfully");
         }
         catch(SQLException e){
           e.getMessage();
         }
     }
     else{
       System.out.println("Hotel id does not match");
     }
  }    
  
                       //delete employee with id
  public void deleteEmployee(int employee_id){
     if(employeeCheck(employee_id)){
        try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.DELETE_EMPLOYEE)){
            statement.setInt(1,employee_id);
            statement.executeUpdate();
            System.out.println("Employee removed successfully");
        }
        catch(SQLException e){
            e.getMessage();
        }
    }
    else{
       System.out.println("Employee id doed not match");
    }
  }                 
           
   /* public List<Hotel> getHotelsByFoodId(int foodId) {
    List<Hotel> hotelList = new ArrayList<>();
    try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_HOTELS_BY_FOOD_ID)) {
        statement.setString(1, "%" + foodId + "%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String hotelName = resultSet.getString("hotel_name");
                String ownerName = resultSet.getString("owner_name");
                String location = resultSet.getString("location");
                String availableFoodsString = resultSet.getString("available_foods");

                List<Integer> availableFoods = Hotel.convertStringToList(availableFoodsString);

                hotelList.add(new Hotel(hotelId, hotelName, ownerName, location, availableFoods));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hotelList;
 }
*/
         
         
         
                                  
                           //get hotel list                                                                                                
  public List<Hotel> getHotelList() {
    List<Hotel> hotelList = new ArrayList<>();
    try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_HOTEL_LIST);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int hotelId = resultSet.getInt("hotel_id");
            String hotelName = resultSet.getString("hotel_name");
            String ownerName = resultSet.getString("owner_name");
            String location = resultSet.getString("location");
            String availableFoodsString = resultSet.getString("available_foods");

            List<Integer> availableFoods = Hotel.convertStringToList(availableFoodsString);

            hotelList.add(new Hotel(hotelId, hotelName, ownerName, location, availableFoods));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hotelList;
 }

    
                          //display customer details
    public List<Customer> getCustomerDetails(){
        List<Customer> customerDetail = new ArrayList<>();
        try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_CUSTOMER_DETAILS);ResultSet resultSet = statement.executeQuery()){
        
             while(resultSet.next()){
                 customerDetail.add(new Customer(resultSet.getString("customer_name"),resultSet.getString("customer_username"),
                          resultSet.getString("customer_password"),resultSet.getLong("customer_mobileno"),resultSet.getInt("customerid")));
             }
       }      
       catch(SQLException e){
           e.getMessage();
       } 
       return customerDetail;
    }                   
    
      
                         //display admin details
    public List<Admin> getAdminDetails(){
         List<Admin> AdminDetail = new ArrayList<>();
         try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_ADMIN_DETAILS);ResultSet resultSet = statement.executeQuery()){
              
              while(resultSet.next()){
                  AdminDetail.add(new Admin(resultSet.getInt("admin_id"), resultSet.getString("admin_name"), resultSet.getString("admin_username"),
                         resultSet.getString("admin_password")));
              }
         }
         catch(SQLException e){
             e.getMessage();
         }
         return AdminDetail;
    }
    
    
                      //disply employee details
    public List<Employee> getEmployeeDetails(){
         List<Employee> employeeDetail = new ArrayList<>();
         try(PreparedStatement statement  = StatementProvider.getPreparedStatement(SQLQueries.GET_EMPLOYEE_DETAILS);ResultSet resultSet =  statement.executeQuery()){
             
             while(resultSet.next()){
                  employeeDetail.add(new Employee(resultSet.getInt("employee_id"), resultSet.getString("name"), resultSet.getLong("aadhaar_number"), 
                       resultSet.getLong("mobile_number"), resultSet.getString("location")));
             }
         }
         catch(SQLException e){
              e.getMessage();
         }
         return employeeDetail;
    }                        
           
    
                     //display Transaction details
   public List<Transaction> getTransactionDetails() {
      List<Transaction> transactionDetail = new ArrayList<>();
      try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_TRANSACTION_DETAILS);
         ResultSet resultSet = statement.executeQuery()) {

         while (resultSet.next()) {
            String foodIdsString = resultSet.getString("food_ids");
            String[] foodIdsArray = foodIdsString.split(",");
            List<Integer> foodIds = new ArrayList<>();

            for (String foodId : foodIdsArray) {
                foodIds.add(Integer.parseInt(foodId));
            }

            transactionDetail.add(new Transaction(resultSet.getInt("transaction_id"), resultSet.getString("customer_username"), resultSet.getTimestamp("transaction_date"),
                      resultSet.getString("quantity"), foodIds, resultSet.getDouble("price"), resultSet.getBoolean("cancel"), resultSet.getString("location")));
        }
    } 
    catch (SQLException e) {
        e.getMessage();
    }
    return transactionDetail;
  }
                                   
                                    //show particular transaction

  public List<Transaction> getTransactionDetails(String username) {
      List<Transaction> transactionDetail = new ArrayList<>();
      if (customerCheck(username)) {
         System.out.println("Customer exists: " + username);
         try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_MY_TRANSACTION_DETAIL)) {
             statement.setString(1, username);
             try (ResultSet resultSet = statement.executeQuery()) {
                 while (resultSet.next()) {
                    String foodIdsString = resultSet.getString("food_ids");
                    String[] foodIdsArray = foodIdsString.split(",");
                    List<Integer> foodIds = new ArrayList<>();
                    for (String foodId : foodIdsArray) {
                        foodIds.add(Integer.parseInt(foodId));
                    }
                    transactionDetail.add(new Transaction(resultSet.getInt("transaction_id"), resultSet.getString("customer_username"), resultSet.getTimestamp("transaction_date"),
                        resultSet.getString("quantity"), foodIds, resultSet.getDouble("price"), resultSet.getBoolean("cancel"), resultSet.getString("location")));
                 } 
                 System.out.println("Transactions found: " + transactionDetail.size());
            }
        } 
        catch (SQLException e) {
            e.getMessage();
        }
    } 
    else {
        System.out.println("Customer does not exist: " + username);
    }
    return transactionDetail;
 }

  


   
 
 

         
   
    
                        //customer check with username and password
  public boolean customerCheck(String user_Name, String password) {
     try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CUSTOMER_CHECK)) {
        statement.setString(1, user_Name); 
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String userName = resultSet.getString("customer_username");
                String passWord = resultSet.getString("customer_password");
                if (user_Name.equals(userName) && password.equals(passWord)) {
                    return true;
                }
            }
        }
    } 
    catch (SQLException e) {
        e.getMessage();
    }
    return false;
  }
  
  
                    // customerCheck with transaction_id and username
  public boolean customerCheck(int transactionId, String userName) {
     try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CUSTOMER_CHECK_WITH_TRANSACTION_ID)) {
        statement.setInt(1, transactionId);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String customerUserName = resultSet.getString("customer_username");
                return userName.equals(customerUserName);
            }
        }
    } 
    catch (SQLException e) {
         e.getMessage();
    }
    return false;
  }

                          //customer check with username
  public boolean customerCheck(String username) {
    boolean exists = false;
    try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CUSTOMER_CHECK_WITH_CUSTOMER_USERNAME)) {
        statement.setString(1, username);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        }
    } 
    catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
 }
               
           
                      
                         //check other admins
  public boolean adminCheck(String user_Name,String password){
     try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.Admin_check)){
        statement.setString(1,user_Name);
        try(ResultSet resultSet = statement.executeQuery()){
           while(resultSet.next()){
              String userName = resultSet.getString("admin_username");
              String passWord = resultSet.getString("admin_password");
              if(user_Name.equals(userName) && password.equals(passWord)){
                  return true;
              }
           }
        }
    }
    catch(SQLException e){
        e.getMessage();
    }
    return false;
  }    
                        //food check with id
  public  boolean foodCheck(int foodId){
    try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.FOOD_CHECK)){
       statement.setInt(1,foodId);
       try(ResultSet resultSet = statement.executeQuery()){
          while(resultSet.next()){
             int food_Id = resultSet.getInt("food_id");
             if(foodId == food_Id){
                 return true;
             }
          }
       }
    }
    catch(SQLException e ){
        System.out.println("Food id does not match");
    }
    return false;
  }      
  
                        //hotel check with id
  private boolean hotelCheck(int hotelId){
     try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.HOTEL_CHECK)){
       statement.setInt(1,hotelId);
       try(ResultSet resultSet = statement.executeQuery()){
         while(resultSet.next()){
           int hotel_id = resultSet.getInt("hotel_id");
           if(hotelId == hotel_id){
              return true;
           }
         }
      }
   }    
   catch(SQLException e ){
      e.getMessage();
   }
   return false;
  }               
                      //employee check with id
  private boolean  employeeCheck(int employeeId){
       try(PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.EMPLOYEE_CHECK)){
          statement.setInt(1,employeeId);
          try(ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
              int employee_Id = resultSet.getInt("employee_id");
              if(employeeId ==  employee_Id){
                 return true;
             }
           }
         }
       }
       catch(SQLException e){
           e.getMessage();
       }                          
       return false;
  }     
  
                           // amount calculation 
  public double calculateTotalAmount(Map<Integer, Integer> foodIdsWithQuantities) {
     double totalAmount = 0.0;
     for (Map.Entry<Integer, Integer> entry : foodIdsWithQuantities.entrySet()) {
        int foodId = entry.getKey();
        int quantity = entry.getValue();
        double pricePerUnit = getPricePerUnit(foodId);
        totalAmount += pricePerUnit * quantity;
     }
     return totalAmount;
  }

                         // get price based on unit
  public static double getPricePerUnit(int foodId) {
       double price = 0.0;
       try (PreparedStatement preparedStatement = StatementProvider.getPreparedStatement(SQLQueries.GET_TOTAL_AMOUNT)) {
          preparedStatement.setInt(1, foodId);
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
            price = resultSet.getDouble("food_price");
          }
       } 
       catch (SQLException e) {
         e.getMessage();
       }
       return price;
  }
                     
                     // ordering food and insert into the transaction table
public void placeOrder(String customerUserName, Map<Integer, Map<Integer, Integer>> hotelIdsWithFoodQuantities, double amount) {
    if (customerUserName == null || hotelIdsWithFoodQuantities == null || hotelIdsWithFoodQuantities.isEmpty()) {
        System.out.println("Invalid form of Transaction");
        return;
    }

    StringBuilder foodIdsBuilder = new StringBuilder();
    StringBuilder quantitiesBuilder = new StringBuilder();
    StringBuilder hotelIdsBuilder = new StringBuilder();

    for (Map.Entry<Integer, Map<Integer, Integer>> hotelEntry : hotelIdsWithFoodQuantities.entrySet()) {
        int hotelId = hotelEntry.getKey();
        Map<Integer, Integer> foodQuantities = hotelEntry.getValue();

        for (Map.Entry<Integer, Integer> entry : foodQuantities.entrySet()) {
            int foodId = entry.getKey();
            int quantity = entry.getValue();

            foodIdsBuilder.append(foodId).append(",");
            quantitiesBuilder.append(quantity).append(",");
            hotelIdsBuilder.append(hotelId).append(",");
        }
    }

    String foodIdsString = foodIdsBuilder.length() > 0 ? foodIdsBuilder.substring(0, foodIdsBuilder.length() - 1) : "";
    String quantitiesString = quantitiesBuilder.length() > 0 ? quantitiesBuilder.substring(0, quantitiesBuilder.length() - 1) : "";
    String hotelIdsString = hotelIdsBuilder.length() > 0 ? hotelIdsBuilder.substring(0, hotelIdsBuilder.length() - 1) : "";

    if (foodIdsString.isEmpty() || quantitiesString.isEmpty() || hotelIdsString.isEmpty()) {
        System.out.println("No valid food items to place order");
        return;
    }

    try (PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_TRANSACTION, Statement.RETURN_GENERATED_KEYS)) {

        statement.setString(1, customerUserName);
        statement.setString(2, foodIdsString);
        statement.setString(3, quantitiesString);
        statement.setDouble(4, amount);
        statement.setString(5, hotelIdsString);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int transactionId = generatedKeys.getInt(1);
                System.out.println("Transaction ID of the current order: " + transactionId);
            } else {
                System.out.println("Failed to retrieve transaction ID");
            }
        } else {
            System.out.println("Failed to insert order");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    System.out.println("Order placed successfully");
}


      
                  
                         //cancel food order
  public void cancelFood(int transaction_id, String userName) {
     if (customerCheck(transaction_id, userName)) {
         LocalDateTime transactionTime = getTransactionTime(transaction_id);
         LocalDateTime currentTime = LocalDateTime.now();
         
         if(transactionTime!=null && isWithInTime(transactionTime,currentTime)){
           try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.CANCEL_FOOD)) {
              statement.setInt(1, transaction_id);
              statement.executeUpdate();
              System.out.println("Order cancelled successfully");
           } 
           catch (SQLException e) {
             e.getMessage();
          }
        }
        else{
          System.out.println("cancellation time excedded . you should cancel your food within five minutes of ordering");
        }    
    } 
    else {
        System.out.println("TRANSACTION ID AND USERNAME DOES NOT MATCH. PLEASE ENTER CORRECTLY BEFORE CANCELLING THE ORDER");
    }
 }
                         
                           //get transaction time of particular id
  private LocalDateTime getTransactionTime(int transaction_id){
       try (PreparedStatement statement = StatementProvider.getPreparedStatement(SQLQueries.GET_TRANSACTION_TIME)){
          statement.setInt(1, transaction_id);
          try(ResultSet resultSet = statement.executeQuery()){
             if(resultSet.next()){
                Timestamp timestamp = resultSet.getTimestamp("transaction_date");
                return timestamp.toLocalDateTime();
             }
         }
      }
      catch(SQLException e){
         e.getMessage();
      }
      return null;
  }                  
                            //time calculation
  private boolean  isWithInTime(LocalDateTime transactiontime , LocalDateTime currentTime){
      long differenceInMillies = Duration.between(transactiontime, currentTime).toMillis();
      long timeInMillies = 5 * 60 * 1000;
                                                                                                         //1 minutes = 60,000 milliseconds
      return differenceInMillies <= timeInMillies;

  }
                  
  
                  


  public List<Hotel> getHotelsByFoodId(int foodId)  {
    String query = "SELECT hotel_id, hotel_name, owner_name, location FROM Hotel WHERE available_foods LIKE ?";
    List<Hotel> hotels = new ArrayList<>();

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, "%," + foodId + ",%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String hotelName = resultSet.getString("hotel_name");
                String ownerName = resultSet.getString("owner_name");
                String location = resultSet.getString("location");

                Hotel hotel = new Hotel(hotelId, hotelName, ownerName, location);
                hotels.add(hotel);
            }
        }
    }
    catch(SQLException e){
        e.getMessage();
    }    
    return hotels;
}
    
                        
                         
            
                                 
} 
       
                


/* String foodIdToFind = "7";
String sql = "SELECT hotel_name FROM hotel WHERE available_foods LIKE ?";

try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, "%" + foodIdToFind + "%");
    try (ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            System.out.println(rs.getString("hotel_name"));
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
}*/

  
  
            
             
          

