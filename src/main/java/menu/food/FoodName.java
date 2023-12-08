package menu.food;

import java.util.Objects;

public class FoodName {
    private final String foodNameValue;

    public FoodName(String foodNameValue) {
        this.foodNameValue = foodNameValue;
    }

    public String getFoodNameValue() {
        return foodNameValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodName foodName = (FoodName) o;
        return Objects.equals(getFoodNameValue(), foodName.getFoodNameValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFoodNameValue());
    }
}
