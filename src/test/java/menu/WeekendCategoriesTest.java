package menu;

import java.util.stream.IntStream;
import menu.food.FoodCategory;
import org.junit.jupiter.api.Test;

public class WeekendCategoriesTest {
    @Test
    void 최대_2회_벗어나면_예외() {
        WeekendCategories weekendCategories = new WeekendCategories();
        IntStream.range(0, 2)
                .forEach(num -> weekendCategories.addCategory(FoodCategory.ASIAN_FOOD));
        boolean b = weekendCategories.hasValidSize(FoodCategory.ASIAN_FOOD);
        System.out.println(b);

    }
}
