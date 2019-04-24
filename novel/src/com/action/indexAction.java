package com.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.NovelDAO;
import com.dao.TOrderItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private NovelDAO novelDAO;
	
	private TOrderItemDAO orderItemDAO;
	
	
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		
		String sql="from Novel where novelDel='no' and novelIsnottejia='yes' order by novelId desc";
		List novelYesTejiaList=novelDAO.getHibernateTemplate().find(sql);
		if(novelYesTejiaList.size()>5)
		{
			novelYesTejiaList=novelYesTejiaList.subList(0, 5);
		}
		request.put("novelYesTejiaList", novelYesTejiaList);
		
		
		
		sql="from Novel where novelDel='no' and novelIsnottejia='no' order by novelId desc";
		List novelNoTejiaList=novelDAO.getHibernateTemplate().find(sql);
		if(novelNoTejiaList.size()>5)
		{
			novelNoTejiaList=novelNoTejiaList.subList(0, 5);
		}
		request.put("novelNoTejiaList", novelNoTejiaList);
		
		
		//paihangbang
		List novelList=new ArrayList();
		sql="from Novel where novelDel='no'  order by novelShichangjia desc";
		 novelList=orderItemDAO.getHibernateTemplate().find(sql);
				if(novelList.size()>5)
		{
			novelList=novelList.subList(0, 5);
		}
		request.put("novelList", novelList);
		//paihangbang
		
		
		return ActionSupport.SUCCESS;
	}
	

	public NovelDAO getNovelDAO()
	{
		return novelDAO;
	}

	public void setNovelDAO(NovelDAO novelDAO)
	{
		this.novelDAO = novelDAO;
	}


	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}


	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}
	
	
}
