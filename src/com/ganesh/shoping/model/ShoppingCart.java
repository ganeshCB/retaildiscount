package com.ganesh.shoping.model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ganesh.shoping.discount.DiscountStrategy;
import com.ganesh.shoping.discount.item.ModeratePriced;



public class ShoppingCart {

    private Map<Item, Integer> quantities;
    private DiscountStrategy discountStrategy;
    private UserDetails userDetails;

    public ShoppingCart(UserDetails userDetails) {
        quantities = new LinkedHashMap<Item, Integer>();
        this.userDetails = userDetails;
    }
    
    public ShoppingCart(UserDetails userDetails, DiscountStrategy discountStrategy) {
        quantities = new LinkedHashMap<Item, Integer>();
        this.userDetails = userDetails;
        this.discountStrategy = discountStrategy;
    }

    public double total() {
        double result = 0;
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
        }
        
        if (discountStrategy != null) {
        	result = discountStrategy.applyDiscount(result);
        }
        
        return result;
    }

    public void addItem(Item itemToBuy) {    	
        add(itemToBuy, 1);
    }
    

    public void add(Item itemToBuy, int howMany) {
    	Item item;
    	
    	if (userDetails.getType() == UserType.EMPLOYEE) {
    		item = new ModeratePriced(itemToBuy, 30);
    	}
    	else if (userDetails.getType() == UserType.AFFILIATE) {
    		item = new ModeratePriced(itemToBuy, 10);
    	}
    	else if (userDetails.getType() == UserType.AFFILIATE) {
    		item = new ModeratePriced(itemToBuy, 5);
    	}
    	
    	else if (userDetails.getType() == UserType.SIMPLE && 
    			ChronoUnit.YEARS.between(userDetails.getJoiningDate(), LocalDateTime.now()) >= 2) {
    		item = new ModeratePriced(itemToBuy, 5);
    	}
    	
    	else {
    		item = itemToBuy;
    	}
    	
        int previousQuantity = quantities.containsKey(item)
                ? quantities.get(item)
                : 0;
        quantities.put(item, previousQuantity + howMany);
    }
}