package models.inventory;

import java.util.UUID;

public class Order {
    private final String id;
    private LineItem[] lineItems;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.lineItems = new LineItem[0];
    }

    public String getId() {
        return id;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems == null ? new LineItem[0] : lineItems;
    }
}