import models.inventory.Inventory;
import models.inventory.Item;
import models.inventory.Recipes;

public class Main {
    public static void main(String[] args) {

        Item[] items = new Item[] {
                new Item("STRAWBERRY", "strawberries", 1000, "g"),
                new Item("BANANA", "bananas", 1000, "g"),
                new Item("MANGO", "mango", 1000, "g"),
                new Item("BLEND_BANANA", "blended bananas", 0, "ml"),
                new Item("BLEND_MANGO", "blended mangos", 0, "ml"),
                new Item("BLEND_STRAWBERRY", "blended strawberries", 0, "ml"),
                new Item("ICE", "ice", 1000, "ml"),
                new Item("CONDENSED_MILK", "condensed milk", 1000, "ml"),
                new Item("SUGAR", "sugar", 500, "g"),
                new Item("DRINK_STRAWBERRY", "Strawberry fruit drink", 0, "ml"),
                new Item("DRINK_BANANA", "Banana fruit drink", 0, "ml"),
                new Item("DRINK_MANGO", "Mango fruit drink", 0, "ml"),
        };

        Inventory inventory = new Inventory(items);

        inventory.show();

        Recipes.strawberryFruitDrink((inventory), 1);
        Recipes.bananaFruitDrink((inventory), 1);
        Recipes.mangoFruitDrink((inventory), 1);

        inventory.show();
    }
}