package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.ChapterDAO;
import com.model.Admin;
import com.model.Chapter;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class chapterAction extends ActionSupport
{
	private int chapterId;
	private String chaptername;
	private String content;
	private Integer novelId;
	private ChapterDAO chapterDAO;
	private String message;
	private String path;
	
	
	
	public String chapterMana()
	{
		List chapterList=chapterDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chapterList", chapterList);
		return ActionSupport.SUCCESS;
	}
	
	public String chapterAdd()
	{
		Chapter chapter=new Chapter();
		chapter.setContent(content);
		chapter.setChaptername(chaptername);
		chapter.setNovelId(novelId);
		chapter.setPushtime(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		
		chapterDAO.save(chapter);
		this.setMessage("发布成功");
		this.setPath("chapterAll.action");
		return "succeed";
	}
	
	
	public String chapterDel()
	{
		Chapter chapter=chapterDAO.findById(chapterId);
		chapterDAO.delete(chapter);
		this.setMessage("删除成功");
		this.setPath("chapterMana.action");
		return "succeed";
	}
	
	
	public String chapterAll()
	{
		List chapterList=chapterDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chapterList", chapterList);
		return ActionSupport.SUCCESS;
	}
	


	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChaptername() {
		return chaptername;
	}

	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNovelId() {
		return novelId;
	}

	public void setNovelId(Integer novelId) {
		this.novelId = novelId;
	}

	public ChapterDAO getChapterDAO() {
		return chapterDAO;
	}

	public void setChapterDAO(ChapterDAO chapterDAO) {
		this.chapterDAO = chapterDAO;
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
