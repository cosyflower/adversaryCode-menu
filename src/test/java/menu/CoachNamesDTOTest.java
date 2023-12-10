package menu;

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
            Assertions.assertThatCode(() -> new CoachNamesDTO("sunghun"))
                    .doesNotThrowAnyException();
        }

        @Test
        void flow() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("sung,hun"))
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
        void flow() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("sung hun"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력입니다.");
        }
    }

}
