package com.accolite.service;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:9999/service/item", new ItemServiceImp());  
	}
}
