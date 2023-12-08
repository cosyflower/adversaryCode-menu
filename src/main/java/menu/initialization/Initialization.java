package menu;

import java.util.ArrayList;
import java.util.List;
import menu.food.Food;
import menu.food.FoodCategory;
import menu.food.FoodName;
import menu.repository.FoodRepository;

public class Initialization {
    // 기존의 Food 정보를 모두 초기화 한다
    public static FoodRepository setAllMenus() {
        FoodRepository foodRepository = new FoodRepository();
        foodRepository.addFoodsByCategory(registerAllFoods());
        return foodRepository;
    }

    private static List<Food> registerAllFoods() {
        List<Food> registeringFoods = new ArrayList<>();

        // Category 별로 등록해야 한다
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("규동")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("우동")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("미소시루")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("스시")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("가츠동")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("오니기리")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("하이라이스")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("라멘")));
        registeringFoods.add(new Food(FoodCategory.JAPANESE_FOOD, new FoodName("라멘")));


        return registeringFoods;
    }
}
