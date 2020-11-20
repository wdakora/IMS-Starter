package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {


	private final OrderDAO orderdao = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "QATraining2020");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	
	
	@Test
	public void createTest() {
	final Customer customer = new Customer(1L,null,null);
	final Order created = new Order(customer);
	assertEquals(created,orderdao.create(created));
	}
	
	@Test
	public void addItemsTest() {
		
	
	final Order created = new Order(1L, 5.98D, 2, 1L, 1);
	
	assertEquals(created,orderdao.addItems(created));
	}
	
	@Test
	public void addItemsTestFail() {
	
	assertNull(orderdao.addItems(null));
	}

	
	
	@Test
	public void updateTest() {
		assertNull(orderdao.update(null));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, orderdao.delete(1));

	}
	
	@Test
	public void testDeleteFromOrder() {
		assertEquals(1, orderdao.deleteFromOrder(1));

	}
	@Test
	public void testDeleteFail() {
		assertEquals(0, orderdao.deleteFromOrder(3));
	}
}
