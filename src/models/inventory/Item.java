package models.inventory;

import java.util.UUID;

public class Item {
    private final String id;
    private String code;
    private String name;
    private double quantity;
    private double unitQuantity;
    private String unit;

    private Ingredient[] ingredients;

    public Item(String name, double quantity, String unit) {
        this(deriveDefaultCode(name), name, quantity, 0, unit, (Ingredient[]) null);
    }

    public Item(String name, double quantity, double unitQuantity, String unit) {
        this(deriveDefaultCode(name), name, quantity, unitQuantity, unit, (Ingredient[]) null);
    }

    public Item(String name, double quantity, String unit, Ingredient[] ingredients) {
        this(deriveDefaultCode(name), name, quantity, 0, unit, ingredients);
    }

    public Item(String name, double quantity, double unitQuantity, String unit, Ingredient[] ingredients) {
        this(deriveDefaultCode(name), name, quantity, unitQuantity, unit, ingredients);
    }

    public Item(String code, String name, double quantity, String unit) {
        this(code, name, quantity, 0, unit, (Ingredient[]) null);
    }

    public Item(String code, String name, double quantity, double unitQuantity, String unit) {
        this(code, name, quantity, unitQuantity, unit, (Ingredient[]) null);
    }

    public Item(String code, String name, double quantity, String unit, Ingredient[] ingredients) {
        this(code, name, quantity, 0, unit, ingredients);
    }

    public Item(String code, String name, double quantity, double unitQuantity, String unit, Ingredient[] ingredients) {
        this.id = UUID.randomUUID().toString();
        setCode(code);
        this.name = name;
        this.quantity = quantity;
        setUnitQuantity(unitQuantity);
        setUnit(unit);
        setIngredients(ingredients);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code is required");
        }

        this.code = code.trim().toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(double unitQuantity) {
        if (unitQuantity < 0) {
            throw new IllegalArgumentException("Unit quantity cannot be negative");
        }

        this.unitQuantity = unitQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients == null ? new Ingredient[0] : ingredients;
    }

    public void setUnit(String unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit must be 'ml' or 'g'");
        }

        String normalizedUnit = unit.trim().toLowerCase();
        if (!normalizedUnit.equals("ml") && !normalizedUnit.equals("g")) {
            throw new IllegalArgumentException("Unit must be 'ml' or 'g'");
        }

        this.unit = normalizedUnit;
    }

    private static String deriveDefaultCode(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "ITEM";
        }

        String normalizedName = name.trim().toUpperCase().replaceAll("[^A-Z0-9]", "");
        if (normalizedName.isEmpty()) {
            return "ITEM";
        }

        return normalizedName.length() > 6 ? normalizedName.substring(0, 6) : normalizedName;
    }

    public boolean canBeProduced(Inventory inventory, int units) {
        boolean canBeProduced = true;

        for (Item invItem : inventory.getItems()) {

            for (Ingredient ingredient : this.getIngredients()) {
                Item ingredientItem = ingredient.getItem();
                if (ingredientItem.getCode().equals(invItem.getCode())) {

                    double neededQuantity = ingredientItem.getQuantity() * units;

                    if (invItem.getQuantity() <= neededQuantity) {
                        canBeProduced = false;
                    }
                }
            }
        }

        return canBeProduced;
    }

    public void produce(Inventory inventory, int units) {

        if (!canBeProduced(inventory, units)) {
            throw new IllegalArgumentException(
                    "Cannot produce " + units + " units of " + this.name + ": insufficient ingredients");
        }

        for (Ingredient ingredient : this.getIngredients()) {
            Item ingredientItem = ingredient.getItem();
            double neededQuantity = ingredientItem.getQuantity() * units;

            inventory.updateItem(ingredientItem.getCode(), -neededQuantity);
        }

        inventory.updateItem(this.code, units * this.unitQuantity);
        System.out.println("Successfully produced " + units + " units of " + this.name);
    }

}