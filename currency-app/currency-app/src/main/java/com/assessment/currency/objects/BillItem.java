package com.assessment.currency.objects;

import com.assessment.currency.model.ItemCategory;

public class BillItem {
    private String name;
    private ItemCategory category;
    private double price;

    public BillItem() {
    }

    public BillItem(String name, ItemCategory category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
