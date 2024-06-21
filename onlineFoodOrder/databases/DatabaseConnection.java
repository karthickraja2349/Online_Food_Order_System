package onlineFoodOrder.databases;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
       
        if (connection == null) {
          try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlinefoodordersystem","postgres","1234");
            //System.out.println("jdbc was connected successfully");
             } 
         catch (SQLException e) {
            System.out.println("Failed to register JDBC driver: " + e.getMessage());
        }
       }
       return connection;
    }
    
    
    public static void closeConnection(){
       if(connection!=null){
         try{
           connection.close();                                 
           connection = null;                                //null for gc
         }
         catch(SQLException e){
           System.out.println("Failed to close connection");
         }
      }
   }      
}



 
    

