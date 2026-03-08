package models.inventory;

import java.util.UUID;

public class LineItem {
    private final String id;
    private final double quantity;

    public LineItem(Item item, double quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Item is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity is required and must be greater than 0");
        }

        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }
}