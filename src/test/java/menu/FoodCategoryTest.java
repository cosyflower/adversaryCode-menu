package menu;

import menu.food.FoodCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FoodCategoryTest {
    @Test
    void flow() {
        Assertions.assertThatCode(() -> FoodCategory.findFoodCategoryBySequence(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("카테고리가 존재하지 않습니다.");
    }
}
