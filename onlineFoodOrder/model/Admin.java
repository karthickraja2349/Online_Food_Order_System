package onlineFoodOrder.model;
public class Admin{
	
	private String name;
	private String user_Name;
	private String password;
	private int Admin_id;
	
	private final String main_Admin_name = "root";
	private final String main_Admin_User_Name = "MainAdmin";
	private final String main_Admin_Password = "MainAdmin123";
	
	public static Admin admin = null;
	
	public Admin(int id,String name, String user_Name,String password){
	        this.Admin_id =id;
		this.name = name;
		this.user_Name = user_Name;
		this.password = password;
	}
	
	public Admin(String name, String user_Name,String password){
	        this.name = name;
		this.user_Name = user_Name;
		this.password = password;
	}
		
	private Admin(){
	
	}
	
	public static Admin getAdminInstance(){
		if(admin == null){
			admin = new Admin();
		}
		return admin;
	}
	
	public String getRootName(){
	        return main_Admin_name ;
	}
	
	public String getRootUserName(){
	        return main_Admin_User_Name;
	}
	
	public String getRootPassword(){
	         return main_Admin_Password ;
	}
	
	public void setNewUser(String newName){
	          this.name = newName;
	}
	
	public void setId(int id){
	          this.Admin_id =id;
	}
	          
	public void setNewUserName(String userName){
	         this.user_Name = userName;
	}
	
	public void setPassword(String newPassword){
	        this.password =  newPassword;
	}
	
	public int getAdminId(){
	    return Admin_id;
	}
	    
	public String getAdminName(){
	        return name;
	}
	
	public String getAdminUserName(){
	       return  user_Name;
	}
	
	public String getAdminPassword(){
	      return  password;
       } 
       
       public String toString(){
          StringBuilder sb = new StringBuilder();
          sb.append("-------------------------------------------\n");
          sb.append(String.format("| %-16s : %-20s |\n", "Admin  Id is", getAdminId()));
          sb.append(String.format("| %-16s : %-20s |\n", "Admin Name is", getAdminName()));
          sb.append(String.format("| %-16s : %-20s |\n", "userName is", getAdminUserName()));
          sb.append(String.format("| %-16s : %-20s |\n", "password is", "********"));
          sb.append("-------------------------------------------\n");
          return sb.toString();
       }   
    
}
