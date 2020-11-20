package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;
	public ItemDAO itemDAO;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter your Customer ID");
		long id = utils.getLong();
		Order order = orderDAO.create(new Order(new Customer(id, null, null)));

		String result; 
		do {
			LOGGER.info("Please enter your Order ID");
			long order_id = utils.getLong();
			LOGGER.info("Please enter the item ID");
			int item_id = utils.getInt();
			LOGGER.info("Please enter the quantity");
			int quantity = utils.getInt();
			orderDAO.addItems(new Order(order_id, item_id, quantity));
			LOGGER.info(" You have added: " + " Item no. " + item_id + " x " + quantity + " units");

			LOGGER.info("Would you like to add another item?");
			result = utils.getString();
		} while (result.equalsIgnoreCase("yes"));

		return order;
	}

	@Override
	public Order update() {

		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("Would you like to delete an Order or Item from your Order? (Please type Order or Item)");
		String result = utils.getString();
		
		if (result.equalsIgnoreCase("Item")) {
			LOGGER.info("Please enter the ID of the Item you would like to delete");
			Long item_id = utils.getLong();
			LOGGER.info("Item deleted from Order");
			return orderDAO.delete(item_id);
			
		} else if (result.equalsIgnoreCase("Order")){
			
			LOGGER.info("Please enter the ID of the Order you would like to delete");
			Long order_id = utils.getLong();
			LOGGER.info("Order deleted");
			return orderDAO.deleteFromOrder(order_id);
		

		}
		return 0;
		
	}

}
