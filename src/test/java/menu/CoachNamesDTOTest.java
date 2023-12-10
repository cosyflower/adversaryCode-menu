package menu;

import menu.dto.CoachNamesDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CoachNamesDTOTest {
    @Nested
    class 성공 {
        @Test
        void 단독입력_성공() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("성훈"))
                    .doesNotThrowAnyException();
        }

        @Test
        void flow() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("성훈,혜림"))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    class 예외 {
        @ParameterizedTest
        @NullAndEmptySource
        void flow2(String nothingInput) {
            Assertions.assertThatCode(() -> new CoachNamesDTO(nothingInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("아무것도 입력하지 않았습니다.");
        }

        @Test
        void 구분자가_존재하지_아니한_경우() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("성훈 혜림"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력입니다.");
        }
    }

}
