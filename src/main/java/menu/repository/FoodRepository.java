package menu.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import menu.food.Food;
import menu.food.FoodCategory;

public class FoodRepository {
    private final Map<FoodCategory, List<Food>> foodRepository;

    public FoodRepository() {
        this.foodRepository = new EnumMap<FoodCategory, List<Food>>(FoodCategory.class);
        initFoodRepository();
    }

    private void initFoodRepository() {
        Arrays.stream(FoodCategory.values())
                .forEach(foodCategory -> foodRepository.put(foodCategory, new ArrayList<>()));
    }

    public void addFoodsByCategory(List<Food> foods) {
        // foods 꺼내서
        // Food - FoodCategory에 맞게 넣어야 한다
        for (Food food : foods) {
            FoodCategory foodCategory = food.getFoodCategory();
            List<Food> foundFoodList = foodRepository.get(foodCategory);
            foundFoodList.add(food);
        }
    }

    public List<Food> findFoodsWithCategory(FoodCategory foodCategory) {
        return Optional.ofNullable(foodRepository.get(foodCategory))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }
}
