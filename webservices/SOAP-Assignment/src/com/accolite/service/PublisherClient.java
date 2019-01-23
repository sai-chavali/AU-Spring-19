package com.accolite.service;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.accolite.beans.Item;

public class PublisherClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:9999/service/item?wsdl");
		QName qname = new QName("http://service.accolite.com/", "ItemServiceImpService"); 
		
		Service service = Service.create(wsdlURL, qname);  
		
		ItemService itemservice = service.getPort(ItemService.class);
		
		Item item1 = new Item();
		item1.setName("Maggi");
		item1.setId(0);
		item1.setPrice(30);
		item1.setQuantity((float) 1.0);
		
		Item item2 = new Item();
		item2.setName("Fry");
		item2.setId(1);
		item2.setPrice(20);
		item2.setQuantity((float) 1.0);
		
		itemservice.addItem(item1);
		itemservice.addItem(item2);

		System.out.println(itemservice.getItem(1));
		
		System.out.println(Arrays.asList(itemservice.getItems()));
		itemservice.deleteItem(1);
		System.out.println(Arrays.asList(itemservice.getItems()));
		
	}

}
