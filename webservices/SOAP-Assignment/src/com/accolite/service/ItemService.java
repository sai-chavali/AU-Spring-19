package com.accolite.service;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.accolite.beans.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ItemService {
	
	@WebMethod
	public void addItem(Item item);
	
	@WebMethod
	public void deleteItem(int id);
	
	@WebMethod
	public Item getItem(int id);
	
	@WebMethod
	public Item[] getItems();
}
