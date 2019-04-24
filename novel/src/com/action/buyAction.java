package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.NovelDAO;
import com.dao.TOrderDAO;
import com.dao.TOrderItemDAO;
import com.model.Novel;
import com.model.TOrder;
import com.model.TOrderItem;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Cart;

public class buyAction extends ActionSupport
{
	private int novelId;
	private int quantity;
	
	private int orderId;
	
	private NovelDAO novelDAO;
	private TOrderDAO orderDAO;
	private TOrderItemDAO orderItemDAO;
	
	private String message;
	private String path;
	
	private String odderSonghuodizhi;
	private String odderFukuangfangshi;
	
	public String addToCart()
	{
		Novel novel=novelDAO.findById(novelId);
		TOrderItem orderItem=new TOrderItem();
		orderItem.setNovel(novel);
		orderItem.setNovelQuantity(quantity);
		
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		cart.addNovel(novelId, orderItem);
		session.put("cart",cart);
		//this.setMessage("");
		this.setPath("myCart.action");
		return "succeed";
	}
	
	
	
	public String myCart()
	{
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderQueren()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderSubmit()
	{
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		TUser user=(TUser)session.get("user");
		TOrder order=new TOrder();
		order.setOrderBianhao(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		order.setOrderZhuangtai("no");//未受理
		order.setOrderUserId(user.getUserId());
		order.setOrderJine(cart.getTotalPrice());
		System.out.println(odderFukuangfangshi+"%%%%%%%%%");
		order.setOdderFukuangfangshi(odderFukuangfangshi);
		order.setOdderSonghuodizhi(odderSonghuodizhi);
		
		orderDAO.save(order);
		
		for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
		{

			TOrderItem orderItem = (TOrderItem) it.next();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setNovelId(orderItem.getNovel().getNovelId());
	//		novelDAO.getHibernateTemplate().bulkUpdate("update Novel set novelKucun=novelKucun-"+orderItem.getNovelQuantity() +" where novelId="+orderItem.getNovel().getNovelId());
			orderItemDAO.save(orderItem);
		}
		
		cart.getItems().clear();
		session.put("cart", cart);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("order", order);
		
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	public String myOrder()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String sql="from TOrder where orderUserId="+user.getUserId();
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderMana()
	{
		String sql="from TOrder order by orderUserId";
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderDel()//用户自己删除订单
	{
		TOrder order=orderDAO.findById(orderId);
		orderDAO.delete(order);
		
		
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		this.setMessage("删除成功");
		this.setPath("myOrder.action?userId="+user.getUserId());
		return "succeed";
	}
	
	public String orderDelByAd()//管理员删除订单
	{
		TOrder order=orderDAO.findById(orderId);
		orderDAO.delete(order);
		String sql="delete from TOrderItem where orderId="+orderId;
		orderItemDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("删除成功");
		this.setPath("orderMana.action");
		return "succeed";
	}
	
	
	public String orderShouli()
	{
		TOrder order=orderDAO.findById(orderId);
		order.setOrderZhuangtai("yes");//已经受理订单
		orderDAO.attachDirty(order);
		this.setMessage("受理订单成功");
		this.setPath("orderMana.action");
		return "succeed";
	}
	
	
	
	public String orderDetail()
	{
		String sql="from TOrderItem where orderId="+orderId;
		List orderItemList=orderItemDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<orderItemList.size();i++)
		{
			TOrderItem orderItem=(TOrderItem)orderItemList.get(i);
			orderItem.setNovel(novelDAO.findById(orderItem.getNovelId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderItemList", orderItemList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String caiwuMana()
	{
		String sql="from TOrder";
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	public String caiwuTongji()
	{
		HttpServletRequest request1=ServletActionContext.getRequest();
		String shijian_sta=request1.getParameter("shijian_sta");
		String shijian_end=request1.getParameter("shijian_end");
		
		String sql="from TOrder where orderDate >=? and orderDate<=?";
		Object[] o={shijian_sta,shijian_end};
		List orderList=orderDAO.getHibernateTemplate().find(sql,o);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String testCart()
	{
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		Map items=cart.getItems();
		
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{

			TOrderItem orderItem = (TOrderItem) it.next();
			Novel novel = orderItem.getNovel();
			System.out.println(novel.getNovelName()+"：商品名称");
			int quantity = orderItem.getNovelQuantity();
			System.out.println(quantity+"：商品数量");
			System.out.println("--------------------------------------------------");
			
		}
		return null;
	}
	
	
	public NovelDAO getNovelDAO()
	{
		return novelDAO;
	}
	
	public String getOdderFukuangfangshi()
	{
		return odderFukuangfangshi;
	}



	public void setOdderFukuangfangshi(String odderFukuangfangshi)
	{
		this.odderFukuangfangshi = odderFukuangfangshi;
	}



	public String getOdderSonghuodizhi()
	{
		return odderSonghuodizhi;
	}



	public void setOdderSonghuodizhi(String odderSonghuodizhi)
	{
		this.odderSonghuodizhi = odderSonghuodizhi;
	}



	public void setNovelDAO(NovelDAO novelDAO)
	{
		this.novelDAO = novelDAO;
	}
	public int getNovelId()
	{
		return novelId;
	}
	
	public int getOrderId()
	{
		return orderId;
	}



	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}






	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}


	public void setNovelId(int novelId)
	{
		this.novelId = novelId;
	}
	public TOrderDAO getOrderDAO()
	{
		return orderDAO;
	}
	public void setOrderDAO(TOrderDAO orderDAO)
	{
		this.orderDAO = orderDAO;
	}
	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}
	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	

}
