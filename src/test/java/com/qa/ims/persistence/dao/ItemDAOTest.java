package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO itemdao = new ItemDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "QATraining2020");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		final Item created = new Item(2L, "Milk", 2.99);
		itemdao.create(created);
	}

	@Test
	public void testCreate() {
		final Item created = new Item(3L, "Milk", 2.99);
		assertEquals(created, itemdao.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> read = new ArrayList<>();
		read.add(new Item(1L, "Bread", 2.99));
		read.add(new Item(2L, "Milk", 2.99));
		assertEquals(read, itemdao.readAll());
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(2L, "Milk", 2.99);
		assertEquals(updated, itemdao.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemdao.delete(2));
	}
	
	
	@Test
	public void testReadItemFail() {
		final Item updated = new Item(6L, "Milk", 1.99);
		assertNull( itemdao.update(updated));
	}
}
