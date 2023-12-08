package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.coach.Coach;
import menu.food.Food;

public class RecommendedFoods {
    private final Map<Coach, List<Food>> coachAndFoodsMap;

    public RecommendedFoods(List<Coach> coaches) {
        this.coachAndFoodsMap = new HashMap<>();
        initCoachAndFoodsMap(coaches);
    }

    private void initCoachAndFoodsMap(List<Coach> coaches) {
        coaches.stream()
                .forEach(coach -> coachAndFoodsMap.put(coach, new ArrayList<>()));
    }

    public void addRecommendedFood(Coach coach, Food otherFood) {
        List<Food> foods = coachAndFoodsMap.get(coach);
        if (coach.hasAllergy(otherFood)) {
            throw new IllegalArgumentException("먹지 못하는 메뉴입니다. 메뉴를 다시 정합니다.");
        }

        if (hasDuplicatedFood(foods, otherFood)) {
            throw new IllegalArgumentException("중복된 메뉴입니다. 메뉴를 다시 정합니다.");
        }

        foods.add(otherFood);
        coachAndFoodsMap.replace(coach, foods);
    }

    private boolean hasDuplicatedFood(List<Food> foods, Food otherFood) {
        return foods.contains(otherFood);
    }

    public Map<Coach, List<Food>> getCoachAndFoodsMap() {
        return coachAndFoodsMap;
    }
}
