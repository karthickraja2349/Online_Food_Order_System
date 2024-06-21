package onlineFoodOrder.model;
import java.util.List;


public interface FoodService {
    boolean addFood(Food food);
    List<Food> getFoodMenu();
   
}
