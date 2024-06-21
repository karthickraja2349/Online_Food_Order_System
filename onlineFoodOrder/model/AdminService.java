package onlineFoodOrder.model;
public interface AdminService {
    boolean addAdmin(Admin admin);
    boolean authenticateAdmin(String username, String password);
    
}

