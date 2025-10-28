package com.java.multithread;

public class SyncThread {
	public synchronized void updatePrice(double price, int discount) {
		System.out.println("Updating price.......");
		double updatedPrice = price - (price*discount)/100;
		System.out.println("Updated price: "+updatedPrice);
	}
}
