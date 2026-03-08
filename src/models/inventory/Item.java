package models.inventory;

import java.util.UUID;

public class Item {
    private final String id;
    private String code;
    private String name;
    private double quantity;
    private String unit;

    public Item(String name, double quantity, String unit) {
        this(deriveDefaultCode(name), name, quantity, unit);
    }

    public Item(String code, String name, double quantity, String unit) {
        this.id = UUID.randomUUID().toString();
        setCode(code);
        this.name = name;
        this.quantity = quantity;
        setUnit(unit);
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

    public String getUnit() {
        return unit;
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
}