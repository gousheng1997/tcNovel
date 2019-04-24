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

	
	//首頁方法
	public String index()
	{

		Map request=(Map)ServletActionContext.getContext().get("request");

		//排行榜
		List novelRankList=new ArrayList();
		String sql="from Novel where novelDel='no'  order by novelLikeNum desc";
        novelRankList=	novelDAO.getHibernateTemplate().find(sql);
		if(novelRankList.size()>5)
		{
            novelRankList=novelRankList.subList(0, 5);
		}
		request.put("novelRankList", novelRankList);

		//推薦欄目
        sql="from Novel where novelDel='no' and novelRecommendWeight >0 order by novelRecommendWeight desc";
		List novelRecommendList=novelDAO.getHibernateTemplate().find(sql);
		if(novelRecommendList.size()>5)
		{
            novelRecommendList=novelRecommendList.subList(0, 5);
		}
		request.put("novelRecommendList", novelRecommendList);
		
		
		//最新作品
		sql="from Novel where novelDel='no' order by novelId desc";
		List novelNewestList=novelDAO.getHibernateTemplate().find(sql);
		if(novelNewestList.size()>5)
		{
			novelNewestList=novelNewestList.subList(0, 5);
		}
		request.put("novelNewestList", novelNewestList);


		
		
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
