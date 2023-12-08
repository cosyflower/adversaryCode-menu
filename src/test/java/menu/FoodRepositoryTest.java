package menu;

import static menu.food.FoodCategory.JAPANESE_FOOD;

import java.util.Arrays;
import java.util.List;
import menu.food.Food;
import menu.food.FoodName;
import menu.repository.FoodRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FoodRepositoryTest {
    @Test
    void flow() {
        FoodRepository foodRepository = new FoodRepository();

        List<Food> japaneseFoods = Arrays.asList(
                new Food(JAPANESE_FOOD, new FoodName("규동")),
                new Food(JAPANESE_FOOD, new FoodName("우동"))
        );

        foodRepository.addFoodsByCategory(japaneseFoods);
        List<Food> foodsWithCategory = foodRepository.findFoodsWithCategory(JAPANESE_FOOD);

        List<String> foodValues = Converter.convertToFoodNameValues(foodsWithCategory);

        Assertions.assertThat(foodValues).containsExactly("규동", "우동");
    }
}
