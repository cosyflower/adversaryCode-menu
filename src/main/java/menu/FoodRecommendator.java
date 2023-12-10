package menu;

import java.util.List;
import menu.coach.AllergicFoods;
import menu.coach.Coach;
import menu.coach.CoachNames;
import menu.coach.Name;
import menu.dto.CoachAllergicFoodsDTO;
import menu.dto.CoachNamesDTO;
import menu.initialization.Initialization;
import menu.repository.FoodRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class FoodRecommendator {
    private final InputView inputView;
    private final OutputView outputView;

    public FoodRecommendator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        FoodRepository foodRepository = setAllFoods();
        recommendFoods(foodRepository);
        terminate();
    }

    private FoodRepository setAllFoods() {
        // Foods 정보를 저장 먼저 하고
        FoodRepository foodRepository = Initialization.setAllMenus();
        return foodRepository;
    }

    private void recommendFoods(FoodRepository foodRepository) { // 110 분 남음
        // 핵심 로직을 수행한다 (입력을 받고, 메뉴를 추천한다
        // 1. 코치를 입력 받는다
        CoachNamesDTO coachNamesDTO = new CoachNamesDTO(inputView.inputCoachNames());
        CoachNames coachNames = coachNamesDTO.toCoachNames();

        // 2. 각 코치별 먹지 못하는 음식을 등록한다
        List<String> registeredCoachNames = coachNames.getCoachNames();
        for (String registeredCoachName : registeredCoachNames) {
            CoachAllergicFoodsDTO coachAllergicFoodsDTO =
                    new CoachAllergicFoodsDTO(inputView.inputCoachAllergicFoods(registeredCoachName));
            AllergicFoods allergicFoods = coachAllergicFoodsDTO.toAllergicFoods(foodRepository);
            new Coach(new Name(registeredCoachName), allergicFoods);
        }

        // 코치들을 형성한다

        // RandomGenerator -> WeekendCategories 를 먼저 형성한다
        // RandomGenerator -> RecommendedFoods에 추가한다

        // 결과를 출력한다
    }

    private void terminate() {
        // 종료한다
    }


}
