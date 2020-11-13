package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long order_items_id;
	private Double unit_price;
	private int quantity;
	private Customer customer;
	private Item item;
	
	
	public Order(long order_id, long order_items_id, Double unit_price, int quantity, Customer customer, Item item) {
		this.order_id = order_id;
		this.order_items_id = order_items_id;
		this.unit_price = unit_price;
		this.quantity = quantity;
		this.customer = customer;
		this.item = item;
	}
	
	

	public Order(long order_id, long order_items_id, int quantity) {
		super();
		this.order_id = order_id;
		this.order_items_id = order_items_id;
		this.quantity = quantity;
	}



	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		if (order_id != other.order_id)
			return false;
		if (order_items_id != other.order_items_id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (customer != other.customer)
			return false;
		if (item != other.item)
			return false;
		if (unit_price == null) {
			if (other.unit_price != null)
				return false;
		} else if (!unit_price.equals(other.unit_price))
			return false;
		return true;
	}
	
	
	
	
}
