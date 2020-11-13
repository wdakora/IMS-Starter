package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

private OrderDAO orderDAO;
private Utils utils;

public OrderController(OrderDAO orderDAO, Utils utils) {
	super();
	this.orderDAO = orderDAO;
	this.utils = utils;
}

@Override
public List<Order> readAll(){
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
	LOGGER.info("Please enter the item ID");
	long item_id = utils.getLong();
	LOGGER.info("Please enter the quantity");
	int quantity = utils.getInt();
	Order order = orderDAO.create(new Order(id,item_id,quantity));
	return order;
}

@Override
public Order update() {
	// TODO Auto-generated method stub
	return null;
}



@Override
public int delete() {
	LOGGER.info("Please enter the ID of the Order you would like to delete");
	Long order_id = utils.getLong();
	return orderDAO.delete(order_id);
}




}
