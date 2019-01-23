package com.accolite.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.accolite.beans.Item;

@WebService(endpointInterface = "com.accolite.service.ItemService")

public class ItemServiceImp implements ItemService{
	private static Map<Integer,Item> items = new HashMap<Integer,Item>();
	@Override
	public void addItem(Item item) {
		if(items.get(item.getId()) != null) return;
		items.put(item.getId(), item);
	}

	@Override
	public void deleteItem(int id) {
		if(items.get(items.get(id)) != null) return;
		items.remove(id);
	}

	@Override
	public Item getItem(int id) {
		return items.get(id);
	}

	@Override
	public Item[] getItems() {
		Set<Integer> keys = items.keySet();
		Item[] resItems = new Item[keys.size()];
		int i=0;
		for(Integer key : keys){
			resItems[i] = items.get(key);
			i++;
		}
		return resItems;
	}
	

}
