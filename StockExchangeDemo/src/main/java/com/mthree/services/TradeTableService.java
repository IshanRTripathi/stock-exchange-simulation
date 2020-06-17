package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.TradeTable;
import com.mthree.repositories.TradeTableRepository;

@Service
public class TradeTableService {
	
	@Autowired
	private TradeTableRepository tradeTableRepository;
	
	
public List<TradeTable> getTrades() {
	
		System.out.println("Request caught");
		
		return tradeTableRepository.findAll();
	}

}
