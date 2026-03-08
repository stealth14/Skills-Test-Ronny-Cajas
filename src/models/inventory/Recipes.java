package models.inventory;

public class Recipes {

    public static void blendedStrawberry(Inventory inventory, int quantity) {
        // Update inventory when making blendedStrawberry
        // 100g of strawberry produces 100ml of blended strawberry
        inventory.updateItem("STRAWBERRY", -100 * quantity / 100);
        inventory.updateItem("BLEND_STRAWBERRY", quantity);
    }

    public static void blendedBanana(Inventory inventory, int quantity) {
        // Update inventory when making blendedBanana
        // 120g of banana produces 100ml of blended banana
        inventory.updateItem("BANANA", -120 * quantity / 100);
        inventory.updateItem("BLEND_BANANA", quantity);
    }

    public static void blendedMango(Inventory inventory, int quantity) {
        // Update inventory when making blendedMango
        // 140g of mango produces 100ml of blended mango
        inventory.updateItem("MANGO", -140 * quantity / 100);
        inventory.updateItem("BLEND_MANGO", quantity);
    }

    public static void strawberryFruitDrink(Inventory inventory, int units) {
        int quantity = units * 3;
        // Update inventory when making strawberryFruitDrink
        // 50ml of blended strawberry, 30ml of ice, 20ml of condensed milk, and 8g of
        // sugar
        // produce 100ml of strawberry fruit drink

        Recipes.blendedStrawberry(inventory, 50 * quantity);

        inventory.updateItem("BLEND_STRAWBERRY", -50 * quantity);
        inventory.updateItem("ICE", -30 * quantity);
        inventory.updateItem("CONDENSED_MILK", -20 * quantity);
        inventory.updateItem("SUGAR", -8 * quantity);
        inventory.updateItem("DRINK_STRAWBERRY", 100 * quantity);
    }

    public static void bananaFruitDrink(Inventory inventory, int units) {
        int quantity = units * 3;

        // Update inventory when making bananaFruitDrink
        // 50ml of blended banana, 30ml of ice, 20ml of condensed milk, and 8g of sugar
        // produce 100ml of banana fruit drink

        Recipes.blendedBanana(inventory, 50 * quantity);

        inventory.updateItem("BLEND_BANANA", -50 * quantity);
        inventory.updateItem("ICE", -50 * quantity);
        inventory.updateItem("CONDENSED_MILK", -20 * quantity);
        inventory.updateItem("SUGAR", -8 * quantity);
        inventory.updateItem("DRINK_BANANA", 100 * quantity);
    }

    public static void mangoFruitDrink(Inventory inventory, int units) {
        int quantity = units * 3;

        // Update inventory when making mangoFruitDrink
        // 50ml of blended mango, 30ml of ice, 20ml of condensed milk, and 8g of sugar
        // produce 100ml of mango fruit drink

        Recipes.blendedMango(inventory, 50 * quantity);

        inventory.updateItem("BLEND_MANGO", -50 * quantity);
        inventory.updateItem("ICE", -30 * quantity);
        inventory.updateItem("CONDENSED_MILK", -20 * quantity);
        inventory.updateItem("SUGAR", -8 * quantity);
        inventory.updateItem("DRINK_MANGO", 100 * quantity);
    }

}
