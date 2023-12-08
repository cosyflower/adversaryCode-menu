package menu;

import java.util.List;
import menu.nameGenerator.RandomNameGenerator;
import menu.numberGenerator.RandomNumberGenerator;

public class RandomGenerator {
    // 난수 생성 혹은 난수를 적용해야 하는 메서드들을 모아둔 킄래스
    public static int generateRandomNumber(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generateRandomNumber();
    }

    public static String generateRandomName(RandomNameGenerator randomNameGenerator, List<String> names) {
        return randomNameGenerator.generateRandomName(names);
    }
}
