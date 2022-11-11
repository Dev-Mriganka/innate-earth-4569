package com.healthyswad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.healthyswad.exception.OrderDetailsException;
import com.healthyswad.model.Customer;
import com.healthyswad.model.OrderDetails;
import com.healthyswad.model.Restaurant;
import com.healthyswad.repository.OrderDetailsRepo;

public class OrderDetailsImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsRepo odr;

	@Override
	public OrderDetails addDetails(OrderDetails order) throws OrderDetailsException {
		
		OrderDetails ord= odr.save(order);
		
		return ord;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderDetailsException {
		
		odr.findById(order.getOrderId()).orElseThrow(() -> new OrderDetailsException("Order not available with this id " ));
		
		return odr.save(order);
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderDetailsException {
		
		OrderDetails ord = odr.findById(order.getOrderId())
				.orElseThrow(() -> new OrderDetailsException("No record exists..."));
		
		odr.delete(order);
		
		return ord;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderDetailsException {
		
		OrderDetails ods = odr.findById(order.getOrderId()).orElseThrow(() -> new OrderDetailsException("No records found ....."));
		
		return ods;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderDetailsException {
		
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderDetailsException {
		
		return null;
	}

}