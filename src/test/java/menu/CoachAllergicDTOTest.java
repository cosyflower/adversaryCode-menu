package menu;

import menu.dto.CoachAllergicFoodsDTO;
import menu.dto.CoachNamesDTO;
import menu.initialization.Initialization;
import menu.repository.FoodRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CoachAllergicDTOTest {
    private FoodRepository foodRepository;
    @BeforeEach
    void setUp() {
        FoodRepository foodRepository = Initialization.setAllMenus();
    }

    @Nested
    class 성공 {
        @Test
        void 하나만_입력한_경우() {
            // Repo 세팅 부터
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO("스시"))
                    .doesNotThrowAnyException();
        }

        @Test
        void 복수개를_입력한_경우() {
            // Repo 세팅 부터
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO("스시,우동"))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    class 예외 {
        @ParameterizedTest
        @NullAndEmptySource
        void flow2(String nothingInput) {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO(nothingInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("아무것도 입력하지 않았습니다.");
        }

        @Test
        void 구분자가_존재하지_아니한_경우() {
            Assertions.assertThatCode(() -> new CoachAllergicFoodsDTO(("스시 우동")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 형식으로 입력했습니다.");
        }
    }
}
