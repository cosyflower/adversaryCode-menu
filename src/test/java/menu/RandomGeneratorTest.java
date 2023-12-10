package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import menu.generator.RandomGenerator;
import menu.generator.nameGenerator.ShuffleNameGenerator;
import menu.generator.numberGenerator.NumberInRangeGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    @Test
    void flow() {
        List<String> names = Arrays.asList(
                "성훈", "헤림", "선영"
        );
        String randomName = RandomGenerator.generateRandomName(new ShuffleNameGenerator(), names);
        IntStream.range(0, 5)
                .forEach(num -> System.out.println(
                        RandomGenerator.generateRandomName(new ShuffleNameGenerator(), names)));
    }

    @Test
    void flow2() {
        int randomNumber = RandomGenerator.generateRandomNumber(() -> 1);
        Assertions.assertThatCode(
                () ->
                        Assertions.assertThat(RandomGenerator.generateRandomNumber(new NumberInRangeGenerator()))
                                .isEqualTo(1)
        ).doesNotThrowAnyException();
    }
}
