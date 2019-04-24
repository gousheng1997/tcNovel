package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.model.Novel;
import com.model.TOrderItem;

public class Cart
{

	protected Map<Integer, TOrderItem> items;

	public Cart()
	{

		if (items == null)
		{
			items = new HashMap<Integer, TOrderItem>();
		}
	}

	public void addNovel(Integer novelId, TOrderItem orderItem)
	{

		if (items.containsKey(novelId))
		{

			TOrderItem _orderitem = items.get(novelId);
			_orderitem.setNovelQuantity(_orderitem.getNovelQuantity()+ orderItem.getNovelQuantity());
			items.put(novelId, _orderitem);
		} else
		{

			items.put(novelId, orderItem);
		}
	}
	
	public void delNovel(Integer novelId)
	{
		items.remove(novelId);
	}
	

	public void updateCart(Integer novelId, int quantity)
	{

		TOrderItem orderItem = items.get(novelId);
		orderItem.setNovelQuantity(quantity);
		items.put(novelId, orderItem);
	}

	public int getTotalPrice()
	{

		int totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{

			TOrderItem orderItem = (TOrderItem) it.next();
			Novel novel = orderItem.getNovel();
			int quantity = orderItem.getNovelQuantity();
			totalPrice += novel.getNovelTejia() * quantity;
		}
		return totalPrice;
	}

	public Map<Integer, TOrderItem> getItems()
	{
		return items;
	}

}
