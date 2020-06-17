package com.mthree.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.OrderTable;
import com.mthree.models.User;
import com.mthree.repositories.OrderTableRepository;

@Service
public class OrderTableService {
	
	@Autowired
	private OrderTableRepository orderTableRepository;
	
	
public OrderTable addOrder(OrderTable o) {
		
		return orderTableRepository.save(o);
	}

}
