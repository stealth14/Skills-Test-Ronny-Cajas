import models.inventory.Ingredient;
import models.inventory.Inventory;
import models.inventory.Item;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Ingredient[] BLEND_STRAWBERRY_INGREDIENTS = new Ingredient[] {
                new Ingredient(new Item("STRAWBERRY", "strawberries", 100, "g"), 100)
        };

        final Ingredient[] BLEND_BANANA_INGREDIENTS = new Ingredient[] {
                new Ingredient(new Item("BANANA", "bananas", 120, "g"), 120)
        };

        final Ingredient[] BLEND_MANGO_INGREDIENTS = new Ingredient[] {
                new Ingredient(new Item("MANGO", "mango", 140, "g"), 140)
        };

        final Ingredient[] DRINK_STRAWBERRY_INGREDIENTS = new Ingredient[] {
                new Ingredient(
                        new Item("BLEND_STRAWBERRY", "blended strawberries", 150, "g", BLEND_STRAWBERRY_INGREDIENTS),
                        150),
                new Ingredient(new Item("ICE", "ice", 90, "g"), 90),
                new Ingredient(new Item("CONDENSED_MILK", "condensed milk", 60, "g"), 60),
                new Ingredient(new Item("SUGAR", "sugar", 24, "g"), 24)
        };

        final Ingredient[] DRINK_BANANA_INGREDIENTS = new Ingredient[] {
                new Ingredient(new Item("BLEND_BANANA", "blended bananas", 150, "g", BLEND_BANANA_INGREDIENTS), 150),
                new Ingredient(new Item("ICE", "ice", 90, "g"), 90),
                new Ingredient(new Item("CONDENSED_MILK", "condensed milk", 60, "g"), 60),
                new Ingredient(new Item("SUGAR", "sugar", 24, "g"), 24)
        };

        final Ingredient[] DRINK_MANGO_INGREDIENTS = new Ingredient[] {
                new Ingredient(new Item("BLEND_MANGO", "blended mangos", 150, "g", BLEND_MANGO_INGREDIENTS), 150),
                new Ingredient(new Item("ICE", "ice", 90, "g"), 90),
                new Ingredient(new Item("CONDENSED_MILK", "condensed milk", 60, "g"), 60),
                new Ingredient(new Item("SUGAR", "sugar", 24, "g"), 24)
        };

        Item[] items = new Item[] {
                new Item("STRAWBERRY", "strawberries", 1000, 100, "g"),
                new Item("BANANA", "bananas", 1000, 120, "g"),
                new Item("MANGO", "mango", 1000, 140, "g"),
                new Item("BLEND_BANANA", "blended bananas", 1000, 100, "ml", BLEND_BANANA_INGREDIENTS),
                new Item("BLEND_MANGO", "blended mangos", 1000, 100, "ml", BLEND_MANGO_INGREDIENTS),
                new Item("BLEND_STRAWBERRY", "blended strawberries", 1000, 100, "ml", BLEND_STRAWBERRY_INGREDIENTS),
                new Item("ICE", "ice", 1000, "ml"),
                new Item("CONDENSED_MILK", "condensed milk", 1000, "ml"),
                new Item("SUGAR", "sugar", 1000, "g"),
                new Item("DRINK_STRAWBERRY", "Strawberry fruit drink", 0, "ml", DRINK_STRAWBERRY_INGREDIENTS),
                new Item("DRINK_BANANA", "Banana fruit drink", 0, "ml", DRINK_BANANA_INGREDIENTS),
                new Item("DRINK_MANGO", "Mango fruit drink", 0, "ml", DRINK_MANGO_INGREDIENTS),
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
                    executeRecipeAction(() -> {
                        items[9].produce(inventory, 1);

                        boolean canBeProduced = items[9].canBeProduced(inventory, 4);

                        if (!canBeProduced) {
                            System.out
                                    .println("Warning: There is insufficient ingredients for " + 4 + " units of "
                                            + items[9].getName());
                        }

                    }, inventory);
                    break;
                case "2":
                    executeRecipeAction(() -> {
                        items[10].produce(inventory, 1);

                        boolean canBeProduced = items[10].canBeProduced(inventory, 4);

                        if (!canBeProduced) {
                            System.out
                                    .println("Warning: There is insufficient ingredients for " + 4 + " units of "
                                            + items[10].getName());
                        }

                    }, inventory);
                    break;
                case "3":
                    executeRecipeAction(() -> {
                        items[11].produce(inventory, 1);

                        boolean canBeProduced = items[11].canBeProduced(inventory, 4);

                        if (!canBeProduced) {
                            System.out.println("Warning: There is insufficient ingredients for " + 4 + " units of "
                                    + items[11].getName());
                        }

                    }, inventory);
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