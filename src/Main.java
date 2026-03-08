import models.inventory.Inventory;
import models.inventory.Item;
import models.inventory.Recipes;
import java.util.Scanner;

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
                new Item("SUGAR", "sugar", 1000, "g"),
                new Item("DRINK_STRAWBERRY", "Strawberry fruit drink", 0, "ml"),
                new Item("DRINK_BANANA", "Banana fruit drink", 0, "ml"),
                new Item("DRINK_MANGO", "Mango fruit drink", 0, "ml"),
        };

        Inventory inventory = new Inventory(items);

        inventory.show();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Recipe Menu ===");
            System.out.println("1. Create Strawberry Fruit Drink");
            System.out.println("2. Create Banana Fruit Drink");
            System.out.println("3. Create Mango Fruit Drink");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    executeRecipeAction(() -> Recipes.strawberryFruitDrink(inventory, 1), inventory);
                    break;
                case "2":
                    executeRecipeAction(() -> Recipes.bananaFruitDrink(inventory, 1), inventory);
                    break;
                case "3":
                    executeRecipeAction(() -> Recipes.mangoFruitDrink(inventory, 1), inventory);
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void executeRecipeAction(Runnable action, Inventory inventory) {
        try {
            action.run();
            System.out.println("Order completed successfully.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Not possible to complete the order: " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Unexpected error: " + exception.getMessage());
        } finally {
            inventory.show();
        }
    }
}