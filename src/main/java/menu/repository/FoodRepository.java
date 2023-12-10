package menu.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import menu.food.Food;
import menu.food.FoodCategory;

public class FoodRepository {
    private final Map<FoodCategory, List<Food>> foodRepository;

    public FoodRepository() {
        this.foodRepository = new EnumMap<FoodCategory, List<Food>>(FoodCategory.class);
        initFoodRepository();
    }

    public void addFoodsByCategory(List<Food> foods) {
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

    private void initFoodRepository() {
        Arrays.stream(FoodCategory.values())
                .forEach(foodCategory -> foodRepository.put(foodCategory, new ArrayList<>()));
    }

    public boolean containSameFoodName(String allergicFoodName) {
        // Category 별 모든 Food를 조회한다
        // Food의 이름을 파악한다
        Set<Entry<FoodCategory, List<Food>>> entries = foodRepository.entrySet();
        for (Entry<FoodCategory, List<Food>> entry : entries) {
            List<Food> foodsPerCategory = entry.getValue();
            if (isExistedFood(foodsPerCategory, allergicFoodName)) {
                return true;
            }
        }
        return false;
    }

    public FoodCategory findFoodCategory(String allergicFoodName) {
        // 더 생각해 볼 구 간 -> 보장을 어떻게 표현해야 하는지?
        FoodCategory findingFoodCategory = FoodCategory.JAPANESE_FOOD;
        Set<Entry<FoodCategory, List<Food>>> entries = foodRepository.entrySet();
        for (Entry<FoodCategory, List<Food>> entry : entries) {
            List<Food> foodsPerCategory = entry.getValue();
            // 이름이 존재하면 해당 FoodCategory를 반환한다
            // 존재하는지 검증한 이후 -> 무조건 존재하는 Category 있음
            List<String> foodNamesPerCategory = getFoodNamesPerCategory(foodsPerCategory);
            if (foodNamesPerCategory.contains(allergicFoodName)) {
                findingFoodCategory = entry.getKey();
            }
        }
        return findingFoodCategory;
    }

    private boolean isExistedFood(List<Food> foodsPerCategory, String allergicFoodName) {
        List<String> foodNamesPerCategory = getFoodNamesPerCategory(foodsPerCategory);
        return foodNamesPerCategory.contains(allergicFoodName);
    }

    private List<String> getFoodNamesPerCategory(List<Food> foodsPerCategory) {
        return foodsPerCategory.stream()
                .map(Food::getFoodNameValue)
                .collect(Collectors.toList());
    }
}
