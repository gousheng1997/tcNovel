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

	
	//��퓷���
	public String index()
	{

		Map request=(Map)ServletActionContext.getContext().get("request");

		//���а�
		List novelList=new ArrayList();
		String sql="from Novel where novelDel='no'  order by novelLikeNum desc";
		novelList=	novelDAO.getHibernateTemplate().find(sql);
		if(novelList.size()>5)
		{
			novelList=novelList.subList(0, 5);
		}
		request.put("novelList", novelList);

		//���]��Ŀ
        sql="from Novel where novelDel='no' and novelRecommendWeight >0 order by novelRecommendWeight desc";
		List novelRecommendList=novelDAO.getHibernateTemplate().find(sql);
		if(novelRecommendList.size()>5)
		{
            novelRecommendList=novelRecommendList.subList(0, 5);
		}
		request.put("novelRecommendList", novelRecommendList);
		
		
		//������Ʒ
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
