package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long fk_item_id;
	private long fk_customer_id;
	
	public Order() {
		
	}
	public Order(long order_id, long fk_item_id, long fk_customer_id) {
		this.order_id = order_id;
		this.fk_item_id = fk_item_id;
		this.fk_customer_id = fk_customer_id;
	}
}
