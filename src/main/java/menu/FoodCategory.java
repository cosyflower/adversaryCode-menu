package menu;

public enum FoodCategory {
    // 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식
    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    WESTERN_FOOD(5, "양식")
    ;

    private final int foodSequence;
    private final String foodType;

    FoodCategory(int foodSequence, String foodType) {
        this.foodSequence = foodSequence;
        this.foodType = foodType;
    }
}
