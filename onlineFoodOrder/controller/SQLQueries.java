package onlineFoodOrder.controller;
public  final class SQLQueries {
    public static final String CREATE_FOOD_TABLE =
        "CREATE TABLE IF NOT EXISTS Food (" +
        "food_id BIGSERIAL PRIMARY KEY NOT NULL, " +
        "food_name VARCHAR(20) UNIQUE NOT NULL, " +
        "food_price DECIMAL NOT NULL, " +
        "food_type VARCHAR(20) NOT NULL, " +
        "food_nature VARCHAR(20) NOT NULL, " +
        "quantity VARCHAR(20) NOT NULL)";

    public static final String CREATE_HOTEL_TABLE =
        "CREATE TABLE IF NOT EXISTS Hotel (" +
        "hotel_id BIGSERIAL PRIMARY KEY NOT NULL, " +
        "hotel_name VARCHAR(20) NOT NULL, " +
        "owner_name VARCHAR(20) NOT NULL, " +
        "location VARCHAR(20) NOT NULL)," +
        "available_foods TEXT NOT NULL)";
        
    public static final String CREATE_ADMIN_TABLE =
	"CREATE TABLE IF NOT EXISTS Admin("+
	"Admin_Id BIGSERIAL primary key NOT NULL,"+ 
	"Admin_Name VARCHAR(20) NOT NULL,"+
	"Admin_UserName VARCHAR(20) UNIQUE NOT NULL,"+
	"Admin_Password  VARCHAR(15) NOT NULL)";   
	 
    public static final String CREATE_CUSTOMER_TABLE =
       "CREATE TABLE IF NOT EXISTS Customer("+
       "customer_id BIGSERIAL PRIMARY KEY NOT NULL,"+
       "customer_name 	VARCHAR(20) NOT NULL,"+
       "customer_userName VARCHAR(20) UNIQUE NOT NULL,"+
       "customer_password VARCHAR(15) NOT NULL,"+
       "customer_mobileNo BIGINT UNIQUE NOT NULL)";
       
       
     public static final String CREATE_TRANSACTION_TABLE =
        "CREATE TABLE IF NOT EXISTS Transaction (" +
        "transaction_id BIGSERIAL PRIMARY KEY NOT NULL, " +
        "food_id VARCHAR NOT NULL, " +
        "customer_id INT NOT NULL, " +
        "transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
        "quantity VARCHAR NOT NULL, " +
        "price DECIMAL NOT NULL, " +
        "hotel_id VARCHAR NOT NULL, " +
        "cancel BOOLEAN DEFAULT FALSE, " +
        "FOREIGN KEY(customer_id) REFERENCES Customer(customer_id))";

        
     public static final String CREATE_EMPLOYEE_TABLE =
         "CREATE TABLE IF NOT EXISTS Employee (" +
         "employee_id SERIAL PRIMARY KEY," +
         "name VARCHAR(100) NOT NULL,"  +
         "aadhaar_number BIGINT UNIQUE NOT NULL," +
         "mobile_number  BIGINT UNIQUE NOT NULL," +
         "location VARCHAR(100) NOT NULL)";
   
        
  
	 

    public static final String ADD_FOOD =
        "INSERT INTO Food (food_name, food_price, food_type, food_nature, quantity) VALUES (?, ?, ?, ?, ?)";

    public static final String ADD_HOTEL =
        "INSERT INTO Hotel (hotel_name, owner_name, location, available_foods) VALUES (?, ?, ?, ?)";
        
    public static final String ADD_ADMIN =
         "INSERT INTO admin(admin_name,admin_username,admin_password)VALUES(?,?,?)";
         
    public static final String CHECK_ADMIN_EXISTENCE =
	"SELECT COUNT(*) FROM admin WHERE admin_UserName = ?"; 
	
    public static final String ADD_CUSTOMER =
       "INSERT INTO Customer (customer_name, customer_username, customer_password, customer_mobileno) VALUES (?, ?, ?, ?)";
    
    public static final String ADD_EMPLOYEE =
       "INSERT INTO Employee (name, aadhaar_number, mobile_number ,location) VALUES (?, ?, ?, ?) RETURNING employee_id";
       
    public static final String GET_FOOD_MENU =
       "SELECT food_id, food_name, food_price, food_type, food_nature, quantity FROM food ORDER BY food_id ";
     
    public static final String GET_HOTEL_LIST =
       "SELECT hotel_id, hotel_name, owner_name, location,available_foods FROM Hotel";
       
    public static final String GET_CUSTOMER_DETAILS =
       "SELECT customerid, customer_name, customer_userName, customer_password, customer_mobileNo FROM Customer";   
       
    public static final String GET_ADMIN_DETAILS =
       "SELECT admin_id , admin_name, admin_username, admin_password  FROM admin"; 
       
    public static final String CUSTOMER_CHECK =
      "SELECT customer_username, customer_password FROM customer WHERE customer_username = ?";
   
    public static final String CUSTOMER_CHECK_WITH_TRANSACTION_ID = 
      "SELECT customer_username, transaction_id FROM Transaction WHERE transaction_id = ?";
    
    public static final String CUSTOMER_CHECK_WITH_CUSTOMER_USERNAME =
      "SELECT COUNT(*) FROM Customer WHERE customer_username = ?"; 

   
    public static final String Admin_check =
      "SELECT admin_username, admin_password FROM admin WHERE admin_username = ?";
      
    public static final String FOOD_CHECK =
      "SELECT food_id FROM Food where food_id = ?";  
    
        
   public static final String INSERT_TRANSACTION =
        "INSERT INTO Transaction (customer_id, food_id, transaction_date, quantity, price, location, hotel_ids) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";     
   
   
   public static final String GET_TRANSACTION_DETAILS =
        "SELECT transaction_id, customer_username, transaction_date, quantity, food_ids, price, cancel , location FROM Transaction";

   public static final String GET_MY_TRANSACTION_DETAIL =
        "SELECT transaction_id, customer_username, transaction_date, quantity, food_ids, price, cancel , location FROM transaction WHERE customer_username = ?";
        
   public static final String GET_TOTAL_AMOUNT =
        "SELECT food_price FROM Food WHERE food_id = ?"; 
            
   public static final String CANCEL_FOOD = 
       "UPDATE Transaction SET cancel = TRUE WHERE transaction_id = ?";
       
   public static final String GET_TRANSACTION_TIME =
        "SELECT transaction_date FROM Transaction WHERE transaction_id = ?"; 
            
   public static final String FOOD_SELECTION =
        "SELECT food_id, food_name, food_price, food_type, food_nature, quantity FROM food  WHERE food_name = ? ";  
   
   public static final String FOOD_SELECTION_WITH_ID =
        "SELECT food_id, food_name, food_price, food_type, food_nature, quantity FROM food WHERE food_id = ? ";       
        
   public static final String DELETE_FOOD = 
        "DELETE FROM Food WHERE food_id = ?";     
   
   public static final String HOTEL_CHECK =
        "SELECT hotel_id FROM Hotel WHERE hotel_id = ?";  
    
   public static final String DELETE_HOTEL =
        "DELETE FROM Hotel WHERE hotel_id = ?";      
        
   public static final String GET_EMPLOYEE_DETAILS = 
        "SELECT employee_id , name , aadhaar_number, mobile_number, location FROM Employee";   
   
   public static final String EMPLOYEE_CHECK = 
        "SELECT employee_id FROM Employee WHERE employee_id = ?";
   
   public static final String DELETE_EMPLOYEE =
        "DELETE FROM Employee WHERE employee_id = ?";            
       
   public static final String GET_HOTEL_WITH_LOCATION =
        "SELECT hotel_name FROM Hotel WHERE location = ?";
            
   
   public static final String SET_AVAILABLE_FOODS =
        "UPDATE Hotel SET available_foods = CONCAT(available_foods,'2') WHERE hotel_id = ?";
   
   public static final String DELETE_AVAILABLE_FOODS = 
        "UPDATE Hotel SET available_foods = TRIM(',' FROM REPLACE(CONCAT(',',available_foods,','),?,',')) WHERE hotel_id = ?";     

     
   public static final String GET_HOTELS_BY_FOOD_ID = 
        "SELECT * FROM hotel WHERE available_foods LIKE ?";

    	
	        
}

