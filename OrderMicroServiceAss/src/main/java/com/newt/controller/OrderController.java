package com.newt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.newt.model.Order;
import com.newt.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	RestTemplate restTemplate;

	String serviceName = "CustomerMicroService";
	String url = "http://" + serviceName;

	@Autowired
	OrderService orderService;
	

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Order addOrder(@RequestBody Order order) {
		String fName = order.getcFirstName();
		if (restTemplate.getForObject(url + "/customer/{fName}", Order.class, fName) != null) {
			return orderService.addOrder(order);
		}
		return null;
	}

	@RequestMapping(value = "/{cFirstName}", method = RequestMethod.GET)
	public Order getOrderByFName(@PathVariable("cFirstName") String fName) {
		return orderService.getOrderByFName(fName);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		String fName = order.getcFirstName();
		if (restTemplate.getForObject(url + "/customer/{fName}", Order.class, fName) != null) {
			return orderService.updateOrder(order);
		}
		return null;
	}

	@RequestMapping(value = "Delete/{cFirstName}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable("cFirstName") String fName) {
		orderService.deleteOrder(fName);
	}

	@RequestMapping(value = "customer/{cFirstName}", method = RequestMethod.GET)
	public List<Order> getOrdersBycFName(@PathVariable("cFirstName") String cfName) {
		return orderService.getOrderBycFname(cfName);
	}

}
