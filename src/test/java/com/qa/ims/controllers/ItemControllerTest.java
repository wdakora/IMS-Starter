package com.qa.ims.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO itemdao;
	
	@InjectMocks
	private ItemController controller;
	
	@Test
	public void testCreate() {
		String item_name = "bread" ;
		Double price = 2.50;
		Item itemCreate = new Item(item_name, price);
		
		when(utils.getString()).thenReturn(item_name);
		when(utils.getDouble()).thenReturn(price);
		when(itemdao.create(itemCreate)).thenReturn(itemCreate);
		
		assertEquals(itemCreate, controller.create());
		
		verify(utils,times(1)).getString();
		verify(utils,times(1)).getDouble();
		verify(itemdao,times(1)).create(itemCreate);
	}

	@Test
	public void testReadAll() {
		List <Item> items = new ArrayList<>();
		items.add(new Item(1L, "cheese",3.99));
		when(itemdao.readAll()).thenReturn(items);
		assertEquals(items, controller.readAll());
		verify(itemdao,times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
	Item itemUpdate = new Item (1L, "Water", 1.50);
	
	when(utils.getLong()).thenReturn(1L);
	when(utils.getString()).thenReturn(itemUpdate.getItem_name());
	when(utils.getDouble()).thenReturn(itemUpdate.getPrice());
	when(itemdao.update(itemUpdate)).thenReturn(itemUpdate);
	
	assertEquals(itemUpdate, this.controller.update());
	
	verify(utils,times(1)).getLong();
	verify(utils,times(1)).getString();
	verify(utils,times(1)).getDouble();
	verify(itemdao,times(1)).update(itemUpdate);
	}
	
	@Test
	public void testDelete() {
		Item itemDelete = new Item (1L, "Eggs", 2.20);
		long item_id = 1L;
		
		when(utils.getLong()).thenReturn(item_id);
		when(itemdao.delete(item_id)).thenReturn(1);
		
		assertEquals(1L,controller.delete());

		verify(utils,times(1)).getLong();
		verify(itemdao,times(1)).delete(item_id);
		
		
	}
}
