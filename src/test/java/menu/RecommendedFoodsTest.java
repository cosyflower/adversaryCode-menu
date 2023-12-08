package menu;

import java.util.Arrays;
import menu.coach.AllergicFoods;
import menu.coach.Coach;
import menu.coach.Name;
import menu.food.Food;
import menu.food.FoodCategory;
import menu.food.FoodName;
import org.junit.jupiter.api.Test;

public class RecommendedFoodsTest {
    @Test
    void 중복이면_예외() {
        Food food = new Food(FoodCategory.JAPANESE_FOOD, new FoodName("스시"));
        Food otherFood = new Food(FoodCategory.JAPANESE_FOOD, new FoodName("오코노미야끼"));

        Coach coach = new Coach(new Name("성훈"),
                new AllergicFoods(Arrays.asList(food)));
        Coach otherCoach = new Coach(new Name("혜림"),
                new AllergicFoods(Arrays.asList(food)));

        RecommendedFoods recommendedFoods = new RecommendedFoods(Arrays.asList(coach, otherCoach));

        recommendedFoods.addRecommendedFood(coach, food);
        recommendedFoods.addRecommendedFood(coach, food);
        recommendedFoods.addRecommendedFood(otherCoach, food);
    }

    @Test
    void 중복이_아니면_성공() {
        Food food = new Food(FoodCategory.JAPANESE_FOOD, new FoodName("스시"));
        Food otherFood = new Food(FoodCategory.JAPANESE_FOOD, new FoodName("오코노미야끼"));
        Coach coach = new Coach(new Name("성훈"),
                new AllergicFoods(Arrays.asList(food)));

        RecommendedFoods recommendedFoods = new RecommendedFoods(Arrays.asList(coach));

        recommendedFoods.addRecommendedFood(coach, food);
        recommendedFoods.addRecommendedFood(coach, otherFood);
    }
}
