package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long order_items_id;
	private Double total_price;
	private int quantity;
	private Customer customer;
//	private Item item;
	private int item_id;
	
	
//	public Order(Customer customer, long order_id, long order_items_id, Double total_price, int quantity, Item item) {
	public Order(long order_id, long order_items_id, Double total_price, int quantity) {
		this.order_id = order_id;
		this.order_items_id = order_items_id;
		this.total_price = total_price;
		this.quantity = quantity;
//		this.customer = customer;
//		this.item = item;
	}

	

public Order(long order_items_id, Double total_price, int quantity, long order_id, int item_id) {
	super();
	this.order_id = order_id;
	this.order_items_id = order_items_id;
	this.total_price = total_price;
	this.quantity = quantity;
	this.item_id = item_id;
}



//	public Order(Customer customer, long order_items_id, Double total_price, int quantity,  Item item) {
	public Order(long order_items_id, Double total_price, int quantity) {
		this.order_items_id = order_items_id;
		this.total_price = total_price;
		this.quantity = quantity;
//		this.customer = customer;
//		this.item = item;
	}
	
	public Order(long order_id,int item_id, int quantity,Double total_price) {
		
		this.order_id = order_id;
		this.total_price = total_price;
		this.quantity = quantity;
		this.item_id = item_id;
	}


	public Order( Customer customer, long order_items_id, Double total_price, int quantity) {
		
		this.order_items_id = order_items_id;
		this.total_price = total_price;
		this.quantity = quantity;
		this.customer = customer;
	}
	
	public Order ( int item_id, int quantity) {
		
		this.item_id = item_id;
		this.quantity = quantity;
	}


	public Order(Customer customer) {
		this.customer = customer;
	}
	
	public Order(long order_id, int item_id, int quantity ) {
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}



	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


//	public Item getItem() {
//		return item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
//
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


	public Double getTotal_price() {
		
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + order_id + "  Item id: " + item_id + "  Quantity: " + quantity + "  Total Price for Item: " + total_price;
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
		if (item_id != other.item_id )
			return false;
		if (quantity != other.quantity)
			return false;
		if (customer != other.customer)
			return false;
//		if (item != other.item)
//			return false;
		if (total_price == null) {
		if (other.total_price != null)
				return false;
		
		} else if (!total_price.equals(other.total_price))
			return false;
		return true;
	}
	
	
	
	
}
