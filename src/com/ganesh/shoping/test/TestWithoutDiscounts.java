package com.ganesh.shoping.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ganesh.shoping.model.ShoppingCart;
import com.ganesh.shoping.model.Item;
import com.ganesh.shoping.model.ItemType;
import com.ganesh.shoping.model.Product;
import com.ganesh.shoping.model.UserDetails;
import com.ganesh.shoping.model.UserType;

public class TestWithoutDiscounts {

    private ShoppingCart shoppingCart;
    private Item item;

    @Before
    public void setUp() {
    	UserDetails userDetails = new UserDetails(UserType.SIMPLE, "Ganesh");
        shoppingCart = new ShoppingCart(userDetails);
        item = new Product("something", 1000, ItemType.OTHER);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, shoppingCart.total(), 0.01);
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        shoppingCart.addItem(item);
        assertEquals(item.getUnitPrice(), shoppingCart.total(), 0.01);
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        shoppingCart.add(item, howMany);
        assertEquals(howMany * item.getUnitPrice(), shoppingCart.total(), 0.01);
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            shoppingCart.addItem(item);
        }
        assertEquals(howMany * item.getUnitPrice(), shoppingCart.total(), 0.01);
    }
}
