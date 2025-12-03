import java.util.*;
public class MealPlanGeneratorDemo {
    interface MealPlan { String description(); }
    static class VegetarianMeal implements MealPlan { public String description(){ return "Vegetarian meal plan"; } }
    static class VeganMeal implements MealPlan { public String description(){ return "Vegan meal plan"; } }
    static class KetoMeal implements MealPlan { public String description(){ return "Keto meal plan"; } }
    static class Meal<T extends MealPlan> {
        private T plan;
        Meal(T plan){ this.plan = plan; }
        public T getPlan(){ return plan; }
    }
    public static <T extends MealPlan> Optional<Meal<T>> validateAndGenerate(T choice, int dailyCalories){
        if(dailyCalories <= 0) return Optional.empty();
        return Optional.of(new Meal<>(choice));
    }
    public static void main(String[] args){
        Optional<Meal<VegetarianMeal>> plan = validateAndGenerate(new VegetarianMeal(), 2000);
        plan.ifPresent(p -> System.out.println("Generated: " + p.getPlan().description()));
        Optional<Meal<KetoMeal>> bad = validateAndGenerate(new KetoMeal(), -100);
        System.out.println("Bad plan present: " + bad.isPresent());
    }
}

