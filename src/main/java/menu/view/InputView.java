package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCoachNames() {
        System.out.println("코치들의 이름을 입력해주세요");
        return Console.readLine();
    }
}
