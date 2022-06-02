package com.ganesh.shoping.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.ganesh.shoping.discount.DiscountStrategy;
import com.ganesh.shoping.model.ShoppingCart;
import com.ganesh.shoping.model.Item;
import com.ganesh.shoping.model.ItemType;
import com.ganesh.shoping.model.Product;
import com.ganesh.shoping.model.UserDetails;
import com.ganesh.shoping.model.UserType;
import com.ganesh.shoping.discount.BaselineDiscount;

public class TestDiscounts {
	private Item groceryItem;
	private Item otherItem;
	private UserDetails employee;
	private UserDetails affiliate;
	private UserDetails simpleUser;
	private UserDetails simpleUserWith2Years;
	private DiscountStrategy discountStrategy;

	@Before
	public void setUp() {
		employee = new UserDetails(UserType.EMPLOYEE, "Ganesh");
		affiliate = new UserDetails(UserType.AFFILIATE, "Manish");
		simpleUser = new UserDetails(UserType.SIMPLE, "Bob");
		simpleUserWith2Years = new UserDetails(UserType.SIMPLE, "Rakesh", LocalDateTime.of(2014, 7, 19, 6, 40, 45),"98345686");
		groceryItem = new Product("Wheat", 20, ItemType.GROCERY);
		otherItem = new Product("Computer", 222, ItemType.OTHER);
		discountStrategy = new BaselineDiscount();
	}

	@Test
	public void test_employeeWithGrocery() {
		ShoppingCart shoppingCart = new ShoppingCart(employee, discountStrategy);
		shoppingCart.add(groceryItem, 4);
		assertEquals(80, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_employeeWithOtherItem() {
		ShoppingCart shoppingCart = new ShoppingCart(employee, discountStrategy);
		shoppingCart.add(otherItem, 4);
		assertEquals(591.6, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_affiliateWithGrocery() {
		ShoppingCart shoppingCart = new ShoppingCart(affiliate, discountStrategy);
		shoppingCart.add(groceryItem, 4);
		assertEquals(80, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_affiliateWithOtherItem() {
		ShoppingCart shoppingCart = new ShoppingCart(affiliate, discountStrategy);
		shoppingCart.add(otherItem, 4);
		assertEquals(764.2, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_simpleUserWithGrocery() {
		ShoppingCart shoppingCart = new ShoppingCart(simpleUser, discountStrategy);
		shoppingCart.add(groceryItem, 4);
		assertEquals(80, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_simpleUserWithOtherItem() {
		ShoppingCart shoppingCart = new ShoppingCart(simpleUser, discountStrategy);
		shoppingCart.add(otherItem, 4);
		assertEquals(848, shoppingCart.total(), 0.01);
	}

	@Test
	public void test_simpleUserWith2YearsWithGrocery() {
		ShoppingCart shoppingCart = new ShoppingCart(simpleUserWith2Years, discountStrategy);
		shoppingCart.add(groceryItem, 4);
		assertEquals(80, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_simpleUserWith2YearsWithOtherItem() {
		ShoppingCart shoppingCart = new ShoppingCart(simpleUserWith2Years, discountStrategy);
		shoppingCart.add(otherItem, 4);
		assertEquals(803.6, shoppingCart.total(), 0.01);

	}

	@Test
	public void test_employeeWithGroceryAndOtherItem() {
		ShoppingCart shoppingCart = new ShoppingCart(employee, discountStrategy);
		shoppingCart.add(groceryItem, 4);
		shoppingCart.add(otherItem, 4);
		assertEquals(666.6, shoppingCart.total(), 0.01);

	}
}
