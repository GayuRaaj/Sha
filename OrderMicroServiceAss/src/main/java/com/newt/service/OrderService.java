package com.newt.service;

import java.util.List;


import com.newt.model.Order;

public interface OrderService {
	public Order addOrder(Order order);
	public Order getOrderByFName(String fName);
	public List<Order> getAllOrders();
	public Order updateOrder(Order order);
	public void deleteOrder(String fName);
	public List<Order> getOrderBycFname(String fName);
}
