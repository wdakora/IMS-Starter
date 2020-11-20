package com.qa.ims.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {



	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderdao;

	@InjectMocks
	private OrderController controller;
	

	
	@Test
	public void readTest() {
		
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1, 1));

		Mockito.when(orderdao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(orderdao, Mockito.times(1)).readAll();
	}

	
	
	@Test
	public void deleteItemTest() {
		final long ID = 1L;
		final String deleteItem = "Item";
		Mockito.when(utils.getString()).thenReturn(deleteItem);
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(orderdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderdao, Mockito.times(1)).delete(ID);
	}
	
	
	@Test
	public void deleteOrderTest() {
		final long ID = 1L;
		final String deleteOrder = "Order";
		Mockito.when(utils.getString()).thenReturn(deleteOrder);
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(orderdao.deleteFromOrder(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
	}
	
}

