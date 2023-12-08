package menu;

import java.util.ArrayList;
import java.util.List;
import menu.food.FoodCategory;

public class WeekendCategories {
    private final List<FoodCategory> weekendCategories;

    public WeekendCategories() {
        this.weekendCategories = new ArrayList<>();
    }

    public void addCategory(FoodCategory foodCategory) {
        if (hasValidSize(foodCategory)) {
            weekendCategories.add(foodCategory);
            return;
        }
        throw new IllegalArgumentException("카테고리의 중복이 2회를 넘었습니다. 카테고리를 다시 선정합니다.");
    }

    public boolean hasValidSize(FoodCategory foodCategory) {
        return checkCategoryCondition(foodCategory);
    }

    private boolean checkCategoryCondition(FoodCategory foodCategory) {
        return getEachCategoryCount(foodCategory) < 2;
    }

    private int getEachCategoryCount(FoodCategory otherFoodCategory) {
        return (int) weekendCategories.stream()
                .filter(foodCategory -> foodCategory == otherFoodCategory)
                .count();
    }

    public List<FoodCategory> getWeekendCategories() {
        return new ArrayList<>(weekendCategories);
    }
}
