package com.ganesh.shoping.model;

public interface Item {
	double getUnitPrice();

	double priceForQuantity(int quantity);

	String getName();

	ItemType getType();
}
