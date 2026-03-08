package models.inventory;

public class Inventory {
    private Item[] items;

    public Inventory(Item[] items) {
        this.items = items == null ? new Item[0] : items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items == null ? new Item[0] : items;
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

    }

    /**
     * Updates the quantity of an item in the inventory by its code.
     *
     * @param code     the item code to update
     * @param quantity the quantity to add (can be negative to subtract)
     * @throws IllegalArgumentException if code is null or empty, if quantity would
     *                                  be negative, or if item not found
     */
    public void updateItem(String code, double quantity) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Item code cannot be null or empty");
        }

        for (Item item : items) {
            if (item.getCode().equals(code)) {
                if ((item.getQuantity() + quantity) < 0) {
                    String message = String.format("You tried to consume %.2f %s %s, but you have only %.2f %s",
                            quantity, item.getName(), item.getUnit(), item.getQuantity(), item.getUnit());

                    throw new IllegalArgumentException(message);
                }
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        throw new IllegalArgumentException("Item with code '" + code + "' not found");
    }

    public void show() {
        System.out
                .println("╔════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                    INVENTORY                                          ║");
        System.out
                .println("╚════════════════════════════════════════════════════════════════════════════════════════╝");

        if (items.length == 0) {
            System.out.println("No items in inventory");
            return;
        }

        System.out.println("Total Items: " + items.length);
        System.out
                .println("┌─────┬──────────────────────────────┬──────────────────────────────┬──────────┬─────────┐");
        System.out
                .println("│ No. │ Code                         │ Name                         │ Quantity │ Unit    │");
        System.out
                .println("├─────┼──────────────────────────────┼──────────────────────────────┼──────────┼─────────┤");

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            String code = String.format("%-28s", item.getCode());
            String name = String.format("%-28s", item.getName());
            String qty = String.format("%8.2f", item.getQuantity());
            String unit = String.format("%-7s", item.getUnit());
            System.out.println("│ " + String.format("%3d", i + 1) + " │ " + code + " │ " + name + " │ " + qty + " │ "
                    + unit + " │");
        }

        System.out
                .println("└─────┴──────────────────────────────┴──────────────────────────────┴──────────┴─────────┘");
    }

}