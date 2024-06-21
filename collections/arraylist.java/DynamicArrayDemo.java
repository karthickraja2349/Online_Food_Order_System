import java.util.*;
public class DynamicArrayDemo{
   public static void main(String []args){
          int val,pos;
          Scanner input = new Scanner(System.in);
          DynamicArray list = new DynamicArray();
          
          while(true){
            System.out.println("\n -------- List Menu -----------\n");
             System.out.println("1.Insert at End");
             System.out.println("2.Display List");
             System.out.println("3.Insert at specific position");
             System.out.println("4.Delete at specific position");
             System.out.println("5.Delete at end");
             System.out.println("6.Delete at beginning");
             System.out.println("7.get Index");
             System.out.println("8.Update value");
             System.out.println("9.search");
             System.out.println("10.clear");
             System.out.println("11.Exit");
             
             
             System.out.println("------------------");
             System.out.println("Enter your choice");
             int choice = input.nextInt();
             switch(choice){
               case 1:
                  System.out.println("Enter the value ");
                  val = input.nextInt();
                  list.add(val);
                  break;
                  
              case 2:
                  list.display();
                  break;
              
              case 3:
                  System.out.println("Enter the position ");
                  pos = input.nextInt();
                  if(pos <0){
                    System.out.println("Invalid index");
                    break;
                  }
                  System.out.println("Enter the value");
                  val= input.nextInt();
                  list.insertAtIndex(pos,val);
                  break;
                  
              case 4 :
                   System.out.println("Enter the position ");
                   pos = input.nextInt();
                   if(pos <0){
                    System.out.println("Invalid index");
                    break;
                  }
                  list.deleteAtIndex(pos);
                  break;
                  
             case 5 :
                  
                  list.deleteAtEnd();
                  break;  
                  
             case 6:
                  list.deleteAtBeginning();
                  break;
                 
             case 7:
                 System.out.println("Enter the index value");
                 pos = input.nextInt();
                 
                 list.getIndex(pos);
                 break;
                 
             case 8 :
                   System.out.println("Enter the position ");
                   pos=input.nextInt();  
                   System.out.println("Enter the value ");    
                   val=input.nextInt();
                   
                   list.update(pos,val);
                   break;
                   
             case 9:
                 System.out.println("Enter the value to b e check");
                 val = input.nextInt();
                 
                 list.search(val);
                 break;
                       
                       
             case 10:
                list.clear();
                break;          
             case 11:
              
                System.exit(0);
                
             default:
                System.out.println("Invalid choice");
            }
        }
     }              
                     
 }         
 
 
          
