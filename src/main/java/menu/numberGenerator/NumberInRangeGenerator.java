package menu.numberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberInRangeGenerator implements RandomNumberGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 5;

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
