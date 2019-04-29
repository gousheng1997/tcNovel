package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.AnnouncementDAO;
import com.model.Admin;
import com.model.Announcement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class announcementAction extends ActionSupport
{
	private int announcementId;
	private String announcementTitle;
	private String announcementContent;
	private String announcementData;

	
	private String message;
	private String path;
	
	private AnnouncementDAO announcementDAO;
	
	public String announcementAdd()
	{
		Announcement announcement=new Announcement();
		announcement.setAnnouncementTitle(announcementTitle);
		announcement.setAnnouncementContent(announcementContent);
		announcement.setAnnouncementData(new Date().toLocaleString());
		announcementDAO.save(announcement);
		this.setMessage("公告添加完毕");
		this.setPath("announcementMana.action");
		return "succeed";
	}
	
	
	public String announcementMana()
	{
		List announcementList =announcementDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("announcementList", announcementList);
		return ActionSupport.SUCCESS;
	}
	
	public String announcementDel()
	{
		Announcement announcement=announcementDAO.findById(announcementId);
		announcementDAO.delete(announcement);
		this.setMessage("公告删除完毕");
		this.setPath("announcementMana.action");
		return "succeed";
	}
	
	
	public String announcementDetail()
	{
		Announcement announcement=announcementDAO.findById(announcementId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("announcement", announcement);
		return ActionSupport.SUCCESS;
	}
	
	public String announcementDetailQian()
	{
		Announcement announcement=announcementDAO.findById(announcementId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("announcement", announcement);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String announcementQian5()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		List announcementList=announcementDAO.findAll();
		if(announcementList.size()>5)
		{
			announcementList=announcementList.subList(0, 5);
		}
		request.put("announcementList", announcementList);
		return ActionSupport.SUCCESS;
	}

	public String getAnnouncementContent()
	{
		return announcementContent;
	}

	public void setAnnouncementContent(String announcementContent)
	{
		this.announcementContent = announcementContent;
	}

	public AnnouncementDAO getAnnouncementDAO()
	{
		return announcementDAO;
	}

	public void setAnnouncementDAO(AnnouncementDAO announcementDAO)
	{
		this.announcementDAO = announcementDAO;
	}

	public String getAnnouncementData()
	{
		return announcementData;
	}

	public void setAnnouncementData(String announcementData)
	{
		this.announcementData = announcementData;
	}



	public int getAnnouncementId()
	{
		return announcementId;
	}

	public void setAnnouncementId(int announcementId)
	{
		this.announcementId = announcementId;
	}

	public String getAnnouncementTitle()
	{
		return announcementTitle;
	}

	public void setAnnouncementTitle(String announcementTitle)
	{
		this.announcementTitle = announcementTitle;
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
	
}
