package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	
	


	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("fk_order_id");
		int item_id = resultSet.getInt("fk_item_id");
		int quantity = resultSet.getInt("quantity");
		Double total_price = resultSet.getDouble("total_price");
		
	
		return new Order(order_id,item_id,quantity, total_price);

	}
	
	public Order addItemResultSet(ResultSet resultSet) throws SQLException {
		Long order_items_id = resultSet.getLong("order_items_id");
		Long order_id = resultSet.getLong("fk_order_id");
		int item_id = resultSet.getInt("fk_item_id");
		int quantity = resultSet.getInt("quantity");
		Double total_price = resultSet.getDouble("total_price");
		return new Order(order_items_id, total_price, quantity, order_id, item_id);

	}
	
	public Order test(ResultSet resultSet) throws SQLException {
//		Long order_id = resultSet.getLong("fk_order_id");
		int item_id = resultSet.getInt("fk_item_id");
		int quantity = resultSet.getInt("quantity");
		return new Order(item_id, quantity);

	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select order_items.fk_order_id, order_items.fk_item_id, order_items.quantity, order_items.total_price from `orders` JOIN order_items ON `orders`.order_id = `order_items`.fk_order_id");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			
			
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `order_items`");)

		{
			resultSet.next();
			return addItemResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
				statement.executeUpdate("INSERT INTO `orders`(fk_customer_id) values(" + order.getCustomer().getId()+ ")");
				ResultSet resultSet = statement.executeQuery("Select order_id from `orders` where fk_customer_id=" + order.getCustomer().getId());
				while(resultSet.next()) {
					Long order_id = resultSet.getLong("order_id");
					LOGGER.info("Order ID is: " + order_id + " Please remember your Order ID to add an Item");
				}
				return order;
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		
		return null; 
	}
		
	public Order addItems(Order orderActual) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO order_items(total_price, quantity, fk_order_id, fk_item_id) values(" + orderActual.getTotal_price() + "," + orderActual.getQuantity() + "," + orderActual.getOrder_id() + "," + orderActual.getItem_id() +  ")");
			int quantity = orderActual.getQuantity();
			ResultSet resultSet = statement.executeQuery("SELECT price FROM items WHERE item_id=" + orderActual.getItem_id());
			while (resultSet.next()) {
				double unit_price = resultSet.getDouble("price");
				orderActual.setTotal_price(unit_price*quantity);
				LOGGER.info("Total cost: "+ orderActual.getTotal_price());
				statement.executeUpdate("UPDATE order_items SET total_price="+ orderActual.getTotal_price() + " WHERE fk_order_id="+ orderActual.getOrder_id() + " AND fk_item_id=" + orderActual.getItem_id());
				return readLatest();
			}
				} catch (Exception e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
		
			return null;
		
			 

}

	

	public Order readOrder(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `order_items` where fk_order_id = " + order_id);){		
			resultSet.next();
			return test(resultSet);
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	} 
	
	@Override
	public Order update(Order t) {
	
		return null;
	}

	@Override
	public int delete(long item_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from `order_items` where fk_item_id = " + item_id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	
	public int deleteFromOrder(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from `order_items` where fk_order_id = " + order_id);
			return statement.executeUpdate("delete from `orders` where order_id = " + order_id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


}