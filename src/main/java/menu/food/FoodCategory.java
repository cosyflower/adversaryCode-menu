package menu.food;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum FoodCategory { // 35
    // 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식
    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    WESTERN_FOOD(5, "양식")
    ;

    private final int foodSequence;
    private final String foodType;
    private static Map<Integer, FoodCategory> foodCategoryMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(FoodCategory::getFoodSequence, Function.identity())
                    )
    );

    FoodCategory(int foodSequence, String foodType) {
        this.foodSequence = foodSequence;
        this.foodType = foodType;
    }

    public static FoodCategory findFoodCategoryBySequence(int foodSequence) {
        return Optional.ofNullable(foodCategoryMap.get(foodSequence))
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));
    }

    public int getFoodSequence() {
        return foodSequence;
    }
}
