package com.ganesh.shoping.discount.item;

import com.ganesh.shoping.model.Item;
import com.ganesh.shoping.model.ItemType;

public class PricingStrategy implements Item {

    private final Item baseItem;

    public PricingStrategy(Item baseItem) {
        this.baseItem = baseItem;
    }

    public double getUnitPrice() { 
    	return baseItem.getUnitPrice();
    }

    public String getName() { 
    	return baseItem.getName(); 
    }
    
    public ItemType getType() {
    	return baseItem.getType(); 
    }

    public double priceForQuantity(int quantity) {
        return baseItem.priceForQuantity(quantity);
    }
}
