package menu.initialization;

import static menu.food.FoodCategory.ASIAN_FOOD;
import static menu.food.FoodCategory.CHINESE_FOOD;
import static menu.food.FoodCategory.JAPANESE_FOOD;
import static menu.food.FoodCategory.KOREAN_FOOD;
import static menu.food.FoodCategory.WESTERN_FOOD;

import java.util.ArrayList;
import java.util.List;
import menu.food.Food;
import menu.food.FoodCategory;
import menu.food.FoodName;
import menu.repository.FoodRepository;

public class Initialization {
    // 기존의 Food 정보를 모두 초기화 한다
    // Food 정보를 모두 넣은 레포를 하나 형성하게 된다
    public static FoodRepository setAllMenus() {
        FoodRepository foodRepository = new FoodRepository();
        foodRepository.addFoodsByCategory(registerAllFoods());
        return foodRepository;
    }

    private static List<Food> registerAllFoods() { // 75
        List<Food> registeringFoods = new ArrayList<>();

        // Category 별로 등록해야 한다
        registerJapaneseFoods(registeringFoods, JAPANESE_FOOD);
        registerKoreanFoods(registeringFoods, KOREAN_FOOD);
        registerChineseFoods(registeringFoods, CHINESE_FOOD);
        registerAsianFoods(registeringFoods, ASIAN_FOOD);
        registerWesternFoods(registeringFoods, WESTERN_FOOD);

        return registeringFoods;
    }

    private static void registerJapaneseFoods(List<Food> registeringFoods, FoodCategory foodCategory) {
        for (String japaneseFoodname : FoodNameConstants.JAPANESE_FOODNAMES) {
            registeringFoods.add(new Food(foodCategory, new FoodName(japaneseFoodname)));
        }
    }

    private static void registerKoreanFoods(List<Food> registeringFoods, FoodCategory foodCategory) {
        for (String koreanFoodName : FoodNameConstants.KOREAN_FOOD_NAMES) {
            registeringFoods.add(new Food(foodCategory, new FoodName(koreanFoodName)));
        }
    }

    private static void registerChineseFoods(List<Food> registeringFoods, FoodCategory foodCategory) {
        for (String chineseFoodName : FoodNameConstants.CHINESE_FOOD_NAMES) {
            registeringFoods.add(new Food(foodCategory, new FoodName(chineseFoodName)));
        }
    }

    private static void registerAsianFoods(List<Food> registeringFoods, FoodCategory foodCategory) {
        for (String asianFoodName : FoodNameConstants.ASIAN_FOOD_NAMES) {
            registeringFoods.add(new Food(foodCategory, new FoodName(asianFoodName)));
        }
    }

    private static void registerWesternFoods(List<Food> registeringFoods, FoodCategory foodCategory) {
        for (String westernFoodName : FoodNameConstants.WESTERN_FOOD_NAMES) {
            registeringFoods.add(new Food(foodCategory, new FoodName(westernFoodName)));
        }
    }

}
