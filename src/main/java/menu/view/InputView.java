package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.coach.Coach;

public class InputView {
    public String inputCoachNames() {
        System.out.println("코치들의 이름을 입력해주세요");
        return Console.readLine();
    }

    public String inputCoachAllergicFoods(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
