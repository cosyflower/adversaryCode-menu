package menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import menu.food.Food;
import menu.food.FoodCategory;
import menu.initialization.Initialization;
import menu.repository.FoodRepository;
import org.junit.jupiter.api.Test;

public class InitializationTest {
    @Test
    void flow() {
        FoodRepository foodRepository = Initialization.setAllMenus();
        List<Food> koreanFoods = foodRepository.findFoodsWithCategory(FoodCategory.KOREAN_FOOD);
        List<String> koreanFoodNameValues = koreanFoods.stream()
                .map(Food::getFoodNameValue)
                .collect(Collectors.toList());

        assertThat(koreanFoodNameValues).contains("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기",
                "떡볶이", "제육볶음");
    }
}
