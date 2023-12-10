package menu.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.coach.AllergicFoods;
import menu.food.Food;
import menu.food.FoodName;
import menu.repository.FoodRepository;
import menu.util.Regex;

public class CoachAllergicFoodsDTO {
    private final String coachAllergicFoodsDTO;

    public CoachAllergicFoodsDTO(String inputCoachAllergicFoods) {
        validateCoachAllergicFoodsDTO(inputCoachAllergicFoods);
        this.coachAllergicFoodsDTO = inputCoachAllergicFoods;
    }

    private void validateCoachAllergicFoodsDTO(String inputCoachAllergicFoods) {
        isNullOrEmpty(inputCoachAllergicFoods);
        hasAllergicFoodsPattern(inputCoachAllergicFoods);
    }

    private void isNullOrEmpty(String inputCoachAllergicFoods) {
        if (inputCoachAllergicFoods == null || inputCoachAllergicFoods.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요.");
        }
    }

    private void hasAllergicFoodsPattern(String inputCoachAllergicFoods) {
        if (Regex.ALLERGIC_FOODS_PATTERN.matcher(inputCoachAllergicFoods).matches()) {
            return;
        }
        throw new IllegalArgumentException("잘못된 형식으로 입력했습니다. 다시 입력해주세요.");
    }

    public AllergicFoods toAllergicFoods(FoodRepository foodRepository) {
        // 존재하는 메뉴는 이미 한정되어 있다고 생각하자
        String[] splitAllergicFoods = coachAllergicFoodsDTO.split(",");

        for (String allergicFoodName : splitAllergicFoods) {
            if (foodRepository.containSameFoodName(allergicFoodName)) {
                throw new IllegalArgumentException("존재하지 않은 메뉴를 입력했습니다. 다시 입력해주세요.");
            }
        }

        List<Food> mappedFoods = Arrays.stream(splitAllergicFoods)
                .map(allergicFoodName -> new Food(foodRepository.findFoodCategory(allergicFoodName),
                        new FoodName(allergicFoodName)))
                .collect(Collectors.toList());

        return new AllergicFoods(mappedFoods);
    }
}
