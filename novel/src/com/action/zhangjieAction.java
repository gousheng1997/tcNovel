package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TzhangjieDAO;
import com.model.TAdmin;
import com.model.Tzhangjie;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class zhangjieAction extends ActionSupport
{
	private int zhangjieId;
	private String zhangjiename;
	private String content;
	private Integer goodsId;
	private TzhangjieDAO zhangjieDAO;
	private String message;
	private String path;
	
	
	
	public String zhangjieMana()
	{
		List zhangjieList=zhangjieDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		return ActionSupport.SUCCESS;
	}
	
	public String zhangjieAdd()
	{
		Tzhangjie zhangjie=new Tzhangjie();
		zhangjie.setContent(content);
		zhangjie.setZhangjiename(zhangjiename);
		zhangjie.setGoodsId(goodsId);
		zhangjie.setPushtime(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		
		zhangjieDAO.save(zhangjie);
		this.setMessage("发布成功");
		this.setPath("zhangjieAll.action");
		return "succeed";
	}
	
	
	public String zhangjieDel()
	{
		Tzhangjie zhangjie=zhangjieDAO.findById(zhangjieId);
		zhangjieDAO.delete(zhangjie);
		this.setMessage("删除成功");
		this.setPath("zhangjieMana.action");
		return "succeed";
	}
	
	
	public String zhangjieAll()
	{
		List zhangjieList=zhangjieDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		return ActionSupport.SUCCESS;
	}
	


	public int getZhangjieId() {
		return zhangjieId;
	}

	public void setZhangjieId(int zhangjieId) {
		this.zhangjieId = zhangjieId;
	}

	public String getZhangjiename() {
		return zhangjiename;
	}

	public void setZhangjiename(String zhangjiename) {
		this.zhangjiename = zhangjiename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public TzhangjieDAO getZhangjieDAO() {
		return zhangjieDAO;
	}

	public void setZhangjieDAO(TzhangjieDAO zhangjieDAO) {
		this.zhangjieDAO = zhangjieDAO;
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
