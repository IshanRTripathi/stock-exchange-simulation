package com.mthree.models;



import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TradeTable {
    private String timeStamp;
    
    @Id
    private BigInteger id;

    private String seller;
    private String buyer;
    private String stock;
    private BigDecimal quantity;
    private BigDecimal price;
    
    
    public TradeTable() {}
    
    
	public TradeTable(String timeStamp, BigInteger id, String seller, String buyer, String stock, BigDecimal quantity,
			BigDecimal price) {
		super();
		this.timeStamp = timeStamp;
		this.id = id;
		this.seller = seller;
		this.buyer = buyer;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
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
		return "Trade [timeStamp=" + timeStamp + ", id=" + id + ", seller=" + seller + ", buyer=" + buyer + ", stock="
				+ stock + ", quantity=" + quantity + ", price=" + price + "]";
	}