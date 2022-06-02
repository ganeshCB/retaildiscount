package com.ganesh.shoping.discount.item;

import com.ganesh.shoping.model.Item;
import com.ganesh.shoping.model.ItemType;

public class ModeratePriced extends PricingStrategy {

    private final double priceFactor;

    public ModeratePriced(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("moderatePriced must be in [0,100]");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public double priceForQuantity(int quantity) {
    	if (super.getType() == ItemType.GROCERY) {
    		return super.priceForQuantity(quantity);
    	}
    	
        return (super.priceForQuantity(quantity) * priceFactor);
    }
}
