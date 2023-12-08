package menu;

import java.util.List;
import java.util.stream.Collectors;
import menu.food.Food;

public class Converter {
    public static List<String> convertToFoodNameValues(List<Food> foods) {
        return foods.stream()
                .map(Food::getFoodNameValue)
                .collect(Collectors.toList());
    }

}
