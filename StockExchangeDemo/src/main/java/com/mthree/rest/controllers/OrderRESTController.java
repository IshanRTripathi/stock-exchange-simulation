package com.mthree.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.SpringWebAndDataJpaApplication;
import com.mthree.models.OrderTable;
import com.mthree.services.OrderTableService;

@RestController
@CrossOrigin("*")
public class OrderRESTController {
	
	@Autowired
	private OrderTableService orderTableService;
	
	
	@PostMapping("/addOrder")
	public String  placeOrder(@RequestBody OrderTable o) {
		
		orderTableService.addOrder(o);
		SpringWebAndDataJpaApplication obj=new SpringWebAndDataJpaApplication();
		obj.runTask();
		
		return "Order Placed";
	}

}
