package com.ganesh.shoping;

import com.ganesh.shoping.discount.DiscountStrategy;
import com.ganesh.shoping.model.ShoppingCart;
import com.ganesh.shoping.model.Item;
import com.ganesh.shoping.model.ItemType;
import com.ganesh.shoping.model.Product;
import com.ganesh.shoping.model.UserDetails;
import com.ganesh.shoping.model.UserType;
import com.ganesh.shoping.discount.BaselineDiscount;

public class MainClass {
public static void main(String[] args) {

	UserDetails employee = new UserDetails(UserType.EMPLOYEE, "Ganesh");
    Item groceryItem = new Product("Wheat", 20, ItemType.GROCERY);
    Item otherItem = new Product("Computer", 222, ItemType.OTHER);
    DiscountStrategy discountStrategy = new BaselineDiscount();
    ShoppingCart shoppingCart = new ShoppingCart(employee, discountStrategy);
    shoppingCart.add(groceryItem, 4);
    shoppingCart.add(otherItem, 4);
    System.out.println(shoppingCart.total());        
}
}

