package menu;

import menu.dto.CoachNamesDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachNamesTest {
    @Nested
    class 성공 {
        @ParameterizedTest
        @ValueSource(strings = {"토미,제임스,포코"})
        void flow2(String rightInput) {
            Assertions.assertThatCode(() -> new CoachNamesDTO(rightInput).toCoachNames())
                    .doesNotThrowAnyException();
        }

        @Test
        void 단독_입력() {
            Assertions.assertThatCode(() -> new CoachNamesDTO("토미,그레텔").toCoachNames())
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    class 예외 {
        @ParameterizedTest
        @ValueSource(strings = {"성훈", "성훈,훈성,김선응,선응,혜성,형주"})
        void 인원수가_잘못된_경우(String wrongTotal) {
            Assertions.assertThatCode(() -> new CoachNamesDTO(wrongTotal).toCoachNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("코치는 최소 2명, 최대 5명만 가능합니다. 다시 입력해주세요");
        }

        @ParameterizedTest
        @ValueSource(strings = {"성훈,성", "훈,성훈", "성훈성훈성,성", "성,성"})
        void 이름_글자_수_범위에서_벗어난_경우(String wrongRangeInput) {
            Assertions.assertThatCode(() -> new CoachNamesDTO(wrongRangeInput).toCoachNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("코치의 이름은 최소 2자에서 최대 4자만 가능합니다. 다시 입력해주세요.");
        }
    }
}
