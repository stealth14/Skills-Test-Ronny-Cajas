package models.inventory;

public class Recipe {

    public static void produce(Item item, Inventory inventory, int units) {
        Ingredient[] ingredients = item.getIngredients();

        for (Ingredient ingredient : ingredients) {
            double neededQuantity = ingredient.getQuantity() * units;

            inventory.updateItem(ingredient.getItem().getCode(), neededQuantity);
        }

    }

    public static void mangoFruitDrink(Inventory inventory, int units) {
        int quantity = units * 3;

        // Update inventory when making mangoFruitDrink
        // 50ml of blended mango, 30ml of ice, 20ml of condensed milk, and 8g of sugar
        // produce 100ml of mango fruit drink

        Recipe.blendedMango(inventory, 50 * quantity);

        inventory.updateItem("BLEND_MANGO", -50 * quantity);
        inventory.updateItem("ICE", -30 * quantity);
        inventory.updateItem("CONDENSED_MILK", -20 * quantity);
        inventory.updateItem("SUGAR", -8 * quantity);
        inventory.updateItem("DRINK_MANGO", 100 * quantity);
    }

}
