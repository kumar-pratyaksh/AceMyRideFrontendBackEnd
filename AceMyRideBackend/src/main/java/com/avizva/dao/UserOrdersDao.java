package com.avizva.dao;

import java.util.List;

import com.avizva.model.UserOrders;

public interface UserOrdersDao {

	public UserOrders save(UserOrders userOrders);

	public UserOrders update(UserOrders userOrders);

	public UserOrders delete(UserOrders userOrders);

	public List<UserOrders> getUserOrders(int userId);

	public UserOrders get(int id);

}
