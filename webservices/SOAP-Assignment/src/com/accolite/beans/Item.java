package com.accolite.beans;
import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	private String name;
	private int price;
	private float quantity;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString(){
		return name+"::"+price+"::"+quantity;
	}

}
