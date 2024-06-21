package onlineFoodOrder.model;

public class Employee {
    private int employeeId;
    private String name;
    private long aadhaarNumber;
    private long mobileNumber;
    private String location;

    public static Employee employee =  null;
    
    private Employee() {}
    
    public static Employee getEmployerInstance(){
        if(employee == null){
           employee = new Employee();
        }
        return  employee;
    }      
   
    public Employee(int employeeId, String name, long aadhaarNumber, long mobileNumber,String location) {
        this.employeeId = employeeId;
        this.name = name;
        this.aadhaarNumber = aadhaarNumber;
        this.mobileNumber = mobileNumber;
        this.location = location;
    }
    
    public Employee(String name, long aadhaarNumber, long mobileNumber,String location) {
      
        this.name = name;
        this.aadhaarNumber = aadhaarNumber;
        this.mobileNumber = mobileNumber;
        this.location = location;
    }
    

    
    public int getEmployeeId() {
        return employeeId;
    }

   

    public String getName() {
        return name;
    }

   

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    
    public String getLocation() {
        return location;
    }
    
    public long getMobileNumber(){
         return mobileNumber;
    }     

   
   
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------------------------\n");
        sb.append(String.format("| %-30s : %-25s |\n", "Employee name", getName())); 
        sb.append(String.format("| %-30s : %-25s |\n", "Employee id", getEmployeeId())); 
        sb.append(String.format("| %-30s : %-25s |\n", "Employee aadharNumber", getAadhaarNumber())); 
        sb.append(String.format("| %-30s : %-25s |\n", "Employee mobileNumber",getMobileNumber()));
        sb.append(String.format("| %-30s : %-25s |\n", "Employee location", getLocation())); 
        sb.append("-------------------------------------------------------------\n");
        return sb.toString();
    }
    
}

