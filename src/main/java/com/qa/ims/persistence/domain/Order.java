package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long fk_item_id;
	private long fk_customer_id;
	private Double unit_price;
	private int quantity;
	
	public Order() {
		
	}
	public Order(long order_id, long fk_item_id, long fk_customer_id, Double unit_price, int quantity) {
		this.order_id = order_id;
		this.fk_item_id = fk_item_id;
		this.fk_customer_id = fk_customer_id;
		this.unit_price = unit_price;
		this.quantity = quantity;
		
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public long getFk_customer_id() {
		return fk_customer_id;
	}
	public void setFk_customer_id(long fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}
	public Double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
