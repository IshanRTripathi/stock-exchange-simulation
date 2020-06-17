package com.mthree.models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
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
	
	private String type;
	

	public OrderTable() {}
	
	public OrderTable(BigInteger id, String client, String stock, BigDecimal quantity, BigDecimal price,
			String type) {
		super();
		this.id = id;
		this.client = client;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "OrderTable [id=" + id + ", client=" + client + ", stock=" + stock + ", quantity=" + quantity
				+ ", price=" + price + ", type=" + type + "]";
	}
	

	
}
