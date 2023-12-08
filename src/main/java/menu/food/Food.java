package menu.food;

public class Food {
    private final FoodCategory foodCategory;
    private final FoodName foodName;

    public Food(FoodCategory foodCategory, FoodName foodName) {
        this.foodCategory = foodCategory;
        this.foodName = foodName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public String getFoodNameValue() {
        return foodName.getFoodNameValue();
    }
}
