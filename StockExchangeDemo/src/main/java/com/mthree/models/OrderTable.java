package com.mthree.models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class OrderTable {
	
	@Id
	@GeneratedValue
	private BigInteger id;
	
   
    private String client;
    private String stock;
    private BigDecimal quantity;
	private BigDecimal price;
	private String orderType;
	

	public OrderTable(BigInteger id, String client, String stock, BigDecimal quantity, BigDecimal price,
			String orderType) {
		super();
		this.id = id;
		this.client = client;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
	}
	
	
	public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

	
}
