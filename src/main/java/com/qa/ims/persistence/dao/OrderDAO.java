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
import com.qa.ims.utils.DBUtils;

public static final Logger LOGGER = LogManager.getLogger();
public class OrderDAO implements Dao<Order>{

}

@Override
public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
	// TODO Auto-generated method stub
	return null;


@Override
public int delete(long order_id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();) {
		return statement.executeUpdate("delete from customers where id = " + id);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return 0;
}




@Override
public List<Order> readAll() {
	// TODO Auto-generated method stub
	return null;
}




@Override
public Order create(Order t) {
	// TODO Auto-generated method stub
	return null;
}




@Override
public Order update(Order t) {
	// TODO Auto-generated method stub
	return null;
}





}