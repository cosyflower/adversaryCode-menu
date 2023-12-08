package menu.coach;

import menu.food.Food;

public class Coach {
    private final Name coachName;
    private final AllergicFoods allergicFoods;

    public Coach(Name coachName, AllergicFoods allergicFoods) {
        this.coachName = coachName;
        this.allergicFoods = allergicFoods;
    }

    public boolean hasAllergy(Food otherFood) {
        return allergicFoods.containFood(otherFood);
    }
}
