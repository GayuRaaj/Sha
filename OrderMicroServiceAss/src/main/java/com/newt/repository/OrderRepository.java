package com.newt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.newt.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
	public <S extends Order> List<S> save(Iterable<S> order);
	public Order findOne(String fName);
	public List<Order> findAll();
	public void delete(String fName);
	public List<Order> findBycFirstName(String fName);
}
