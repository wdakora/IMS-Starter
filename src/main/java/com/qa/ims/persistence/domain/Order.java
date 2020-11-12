package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long fk_item_id;
	private long fk_customer_id;
	private long fk_order_id;
	private long order_items_id;
	private Double unit_price;
	private int quantity;
	
	
	public Order(long order_id, long fk_item_id, long fk_customer_id, long fk_order_id, long order_items_id, Double unit_price, int quantity) {
		this.order_id = order_id;
		this.fk_item_id = fk_item_id;
		this.fk_customer_id = fk_customer_id;
		this.fk_order_id = fk_order_id;
		this.order_items_id = order_items_id;
		this.unit_price = unit_price;
		this.quantity = quantity;
	}

	public long getFk_order_id() {
		return fk_order_id;
	}

	public void setFk_order_id(long fk_order_id) {
		this.fk_order_id = fk_order_id;
	}

	public long getOrder_items_id() {
		return order_items_id;
	}

	public void setOrder_items_id(long order_items_id) {
		this.order_items_id = order_items_id;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (fk_customer_id != other.fk_customer_id)
			return false;
		if (fk_item_id != other.fk_item_id)
			return false;
		if (order_id != other.order_id)
			return false;
		if (fk_order_id != other.fk_order_id)
			return false;
		if (order_items_id != other.order_items_id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (unit_price == null) {
			if (other.unit_price != null)
				return false;
		} else if (!unit_price.equals(other.unit_price))
			return false;
		return true;
	}
	
	
	
	
}
