import java.util.*;

public class Transactions {
    public static void main(String[] args) {
        Member mem = new Member();
        mem.members();

        System.out.println("Enter your library card id");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        
        Member libMember = mem.getMember(id);
        if (libMember != null) {
            System.out.println("Enter the book id");
        } else {
            System.out.println("Invalid");
        }
    }
}
