package com.newt.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newt.controller.OrderController;
import com.newt.exception.OrderException;
import com.newt.model.Order;
import com.newt.repository.OrderRepository;
import com.newt.service.OrderService;
import com.newt.service.OrderServiceImp;

public class ControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger( ControllerTest.class);
	@InjectMocks
	Order order;
	
	OrderController orderController;

	@InjectMocks
	OrderServiceImp orderService;
	@Mock
	OrderRepository orderrepo;

	@Before
	public void  setUp(){
		MockitoAnnotations.initMocks(this);     
		Order order=new Order();
		order.setcFirstName("gayu");
		order.setcLastName("raaj");
		order.setcPhone(967780989L);
		order.setOrderDate("07/10/2014");
		order.setSoldBy("15/02/2017");
		Mockito.when(orderrepo.findOne("gayu")).thenReturn(order);
		
		//LOGGER.debug("order");
		//Mockito.when(orderController.getOrderByFName("gayu")).thenReturn(order);
		
	}
	@Test
	public void Test_002(){
		
		orderService=new OrderServiceImp();
		orderService.setOrderRepo(orderrepo);
		Order order1=orderService.getOrderByFName("gayu");
		
		LOGGER.debug(order.getcFirstName());
		LOGGER.debug("order");
		assertSame("raaj",orderrepo.findOne("gayu").getcLastName());
	}
	/*@Test
	public void Test_001(){
		orderController=new OrderController();
		orderController.setOrderService(orderService);
		assertSame(order.getcFirstName(),orderController.getOrderByFName("gayu").getcFirstName());

	}*/
	
	
	
}
