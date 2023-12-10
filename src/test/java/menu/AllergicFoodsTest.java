package menu;

import menu.dto.CoachAllergicFoodsDTO;
import menu.initialization.Initialization;
import menu.repository.FoodRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class AllergicFoodsTest {
    private FoodRepository foodRepository = Initialization.setAllMenus();

    @Nested
    class 성공{
        @Test
        void 존재하는_메뉴면_성공() {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO("우동")
                            .toAllergicFoods(foodRepository))
                    .doesNotThrowAnyException();
        }

        @Test
        void 존재하는_메뉴_복수_성공() {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO("우동,스시")
                            .toAllergicFoods(foodRepository))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    class 예외 {
        @ParameterizedTest
        @NullAndEmptySource
        void flow2(String nothingInput) {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO(nothingInput)
                            .toAllergicFoods(foodRepository))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("아무것도 입력하지 않았습니다.");
        }

        @Test
        void 구분자를_명시하지_않은_경우() {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO(("스시 우동"))
                            .toAllergicFoods(foodRepository))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 형식으로 입력했습니다.");
        }

        @Test
        void 존재하지_않은_메뉴가_포함된_경우() {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO(("스시,마루야마"))
                            .toAllergicFoods(foodRepository))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("존재하지 않은 메뉴를 입력했습니다.");
        }
    }
}
