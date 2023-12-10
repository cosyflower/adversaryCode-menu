package menu.generator.nameGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ShuffleNameGenerator implements RandomNameGenerator {
    public static final int FIRST_INDEX = 0;

    @Override
    public String generateRandomName(List<String> names) {
        return Randoms.shuffle(names).get(FIRST_INDEX);
    }
}
