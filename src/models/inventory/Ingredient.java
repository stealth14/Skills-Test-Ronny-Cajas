package models.inventory;

public class Ingredient {
    private Item item;
    private double quantity;

    public Ingredient(Item item, double quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
