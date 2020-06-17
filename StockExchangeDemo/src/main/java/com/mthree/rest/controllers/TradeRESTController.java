package com.mthree.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.models.TradeTable;
import com.mthree.services.TradeTableService;

@RestController
@CrossOrigin("*")
public class TradeRESTController {

	@Autowired
	private TradeTableService tradeTableService;
	
	@GetMapping("/getTrades")
	public List<TradeTable> getAllTrades(){
		return tradeTableService.getTrades();
	}
}
