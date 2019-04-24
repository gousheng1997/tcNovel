package com.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.NovelDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private NovelDAO novelDAO;

	
	
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		
		String sql="from Novel where novelDel='no' and novelIsrecommend='yes' order by novelId desc";
		List novelYesRecommendWeightList=novelDAO.getHibernateTemplate().find(sql);
		if(novelYesRecommendWeightList.size()>5)
		{
			novelYesRecommendWeightList=novelYesRecommendWeightList.subList(0, 5);
		}
		request.put("novelYesRecommendWeightList", novelYesRecommendWeightList);
		
		
		
		sql="from Novel where novelDel='no' and novelIsrecommend='no' order by novelId desc";
		List novelNoRecommendWeightList=novelDAO.getHibernateTemplate().find(sql);
		if(novelNoRecommendWeightList.size()>5)
		{
			novelNoRecommendWeightList=novelNoRecommendWeightList.subList(0, 5);
		}
		request.put("novelNoRecommendWeightList", novelNoRecommendWeightList);

		//paihangbang
		List novelList=new ArrayList();
		sql="from Novel where novelDel='no'  order by novelLikeNum desc";
		 novelList=	novelDAO.getHibernateTemplate().find(sql);
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

}
