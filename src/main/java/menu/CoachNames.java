package menu;

import java.util.ArrayList;
import java.util.List;

public class CoachNames {
    private final List<String> coachNames; // Coach의 이름들을 저장하는 클래스 역할

    public CoachNames(List<String> coachNames) {
        validateCoachNames(coachNames);
        this.coachNames = new ArrayList<>(coachNames);
    }

    private void validateCoachNames(List<String> coachNames) {
        // 2 - 4 자의 이름만 허용한다고 했다
        // , 로 나눴을 때 2 - 5 명이 가능하다
        haveProperTotal(coachNames);
        hasValidNameLength(coachNames);
    }

    private void haveProperTotal(List<String> coachNames) {
        // 2- 5 명 만 가능하다
        if (coachNames.size() >= 2 && coachNames.size() <= 5) {
            return;
        }
        throw new IllegalArgumentException("코치는 최소 2명, 최대 5명만 가능합니다. 다시 입력해주세요.");
    }

    private void hasValidNameLength(List<String> coachNames) {
        boolean validNameLengthConditition = coachNames.stream()
                .filter(coachName -> coachName.length() < 2 || coachName.length() > 4)
                .findAny()
                .isPresent();
        if (validNameLengthConditition) {
            throw new IllegalArgumentException("코치의 이름은 최소 2자에서 최대 4자만 가능합니다. 다시 입력해주세요.");
        }
    }
}
