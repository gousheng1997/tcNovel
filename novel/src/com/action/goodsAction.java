package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.model.Novel;
import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.NovelDAO;
import com.dao.CommentDAO;
import com.dao.TzhangjieDAO;
import com.model.TCatelog;
import com.model.Comment;
import com.model.Tzhangjie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private int goodsId;
	private int goodsCatelogId;
	private String goodsName;
	private String goodsMiaoshu;
	private String fujian;
	private String goodsYanse;
	private int goodsShichangjia;
	private int goodsTejia;
	
	private int catelogId;
	private String goodsKucun;
	
	private String message;
	private String path;
	
	private NovelDAO goodsDAO;
	private TCatelogDAO catelogDAO;
	private CommentDAO commentDAO;
	private int rukushuliang;
	
	
	private int zhangjieId;
	private String zhangjiename;
	private String content;
	private TzhangjieDAO zhangjieDAO;
	
	public String commentAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		Comment comment=new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setShijian(new Date().toLocaleString());
		comment.setKefangId(Integer.parseInt(request.getParameter("kefangId")));
		
		commentDAO.save(comment);
		request.setAttribute("msg", "评论成功");
		return "msg";
	}
	
	public String commentAll()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from Comment where kefangId="+Integer.parseInt(request.getParameter("kefangId"));
		List commentList=commentDAO.getHibernateTemplate().find(s);
		request.setAttribute("commentList", commentList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String commentMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from Comment where kefangId="+Integer.parseInt(request.getParameter("kefangId"));
		List commentList=commentDAO.getHibernateTemplate().find(s);
		request.setAttribute("commentList", commentList);
		return ActionSupport.SUCCESS;
	}
	
	public String commentDel()
	{
        HttpServletRequest request=ServletActionContext.getRequest();
		
        String s="delete from Comment where id="+Integer.parseInt(request.getParameter("id"));
		commentDAO.getHibernateTemplate().bulkUpdate(s);
		request.setAttribute("msg", "删除成功");
		return "msg";
	}
	
	
	//评论end
	
	
	public String goodsNoTejiaAdd()
	{
		Novel goods=new Novel();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		if(goodsTejia==0)//特格为0表示没有特价
		{
			goods.setGoodsTejia(goodsShichangjia);// 如果不是特价商品。把这个商品的特价设置为市场价格
			goods.setGoodsIsnottejia("no");
		}
		else
		{
			goods.setGoodsTejia(goodsTejia);
			goods.setGoodsIsnottejia("yes");
		}
		
		goods.setGoodsKucun(goodsKucun);
		goods.setGoodsDel("no");
		
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
		
	}
	
	public String goodsNoTejiaDel()
	{
		Novel goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
	}
	
	public String goodsManaNoTejia()
	{
		String sql="from Novel where goodsDel='no' order by goodsIsnottejia";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			Novel goods=(Novel)goodsList.get(i);
			System.out.println(goods.getGoodsCatelogId());
			goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsShezhiTejia()
	{
		Novel goods=goodsDAO.findById(goodsId);
		goods.setGoodsIsnottejia("yes");
		goods.setGoodsTejia(goodsTejia);
		goodsDAO.attachDirty(goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsKucun()
	{
		String sql="from Novel where goodsDel='no' order by goodsIsnottejia";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsRuku()
	{
		Novel goods=goodsDAO.findById(goodsId);
		goods.setGoodsKucun(goods.getGoodsKucun()+rukushuliang);
		goods.setGoodsTejia(goodsTejia);
		goodsDAO.attachDirty(goods);
		return ActionSupport.SUCCESS;
	}
	
	/*public String goodsYesTejiaAdd()
	{
		Novel goods=new Novel();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsTejia);
		goods.setGoodsIsnottejia("yes");
		goods.setGoodsDel("no");
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
		
	}
	
	public String goodsYesTejiaDel()
	{
		Novel goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
	}
	
	
	public String goodsManaYesTejia()
	{
		String sql="from Novel where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			Novel goods=(Novel)goodsList.get(i);
			goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}*/
	
	public String goodsDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	public String dianzan()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel goods=goodsDAO.findById(goodsId);
		goods.setGoodsShichangjia(goods.getGoodsShichangjia()+1);
		goodsDAO.attachDirty(goods);
		TCatelog catelog=catelogDAO.findById(goods.getGoodsCatelogId());
		goods.setGoodsCatelogName(catelog.getCatelogName());
		
		List zhangjieList=zhangjieDAO.findByProperty("goodsId", goodsId);
		request.put("zhangjieList", zhangjieList);
		
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel goods=goodsDAO.findById(goodsId);
		
		TCatelog catelog=catelogDAO.findById(goods.getGoodsCatelogId());
		goods.setGoodsCatelogName(catelog.getCatelogName());
		
		List zhangjieList=zhangjieDAO.findByProperty("goodsId", goodsId);
		request.put("zhangjieList", zhangjieList);
		
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsAllYesTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from Novel where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsYesTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsAllNoTejia()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from Novel where goodsDel='no' and goodsIsnottejia='no' order by goodsCatelogId";
		List goodsYesTejiaList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsByCatelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from Novel where goodsDel='no' and goodsCatelogId=? order by goodsCatelogId";
		Object[] con={catelogId};
		List goodsByCatelogList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsByCatelogList", goodsByCatelogList);
		
		System.out.println(goodsByCatelogList.size()+"^^^"+goodsCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodSearch()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="";
		if(catelogId==0)
		{
			sql="from Novel where goodsDel='no' and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}
		else
		{
			sql="from Novel where goodsDel='no' and goodsCatelogId="+catelogId+" and goodsName like '%"+goodsName+"%'"+" order by goodsCatelogId";
		}

		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);

		return ActionSupport.SUCCESS;
	}
	
	
	public String zhangjieAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Tzhangjie zhangjie=new Tzhangjie();
		zhangjie.setContent(content);
		zhangjie.setZhangjiename(zhangjiename);
		zhangjie.setGoodsId(goodsId);
		zhangjie.setPushtime(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		
		zhangjieDAO.save(zhangjie);
		this.setMessage("发布成功");
		request.put("goodsId", goodsId);
		this.setPath("zhangjieMana.action");
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
	
	
	
	public String zhangjieDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Tzhangjie zhangjie=zhangjieDAO.findById(zhangjieId);
		request.put("goodsId", goodsId);
		request.put("zhangjie", zhangjie);
		return ActionSupport.SUCCESS;
	}
	
	public String zhangjieDetailQiantai()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
	
		Tzhangjie zhangjie=zhangjieDAO.findById(zhangjieId);
		Novel goods=goodsDAO.findById(zhangjie.getGoodsId());
		request.put("zhangjie", zhangjie);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhangjieMana()
	{
		List zhangjieList=zhangjieDAO.findByProperty("goodsId", goodsId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		request.put("goodsId", goodsId);
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




	public TzhangjieDAO getZhangjieDAO() {
		return zhangjieDAO;
	}

	public void setZhangjieDAO(TzhangjieDAO zhangjieDAO) {
		this.zhangjieDAO = zhangjieDAO;
	}
	
	public int getCatelogId()
	{
		return catelogId;
	}

	public void setCatelogId(int catelogId)
	{
		this.catelogId = catelogId;
	}

	public int getGoodsCatelogId()
	{
		return goodsCatelogId;
	}
	public void setGoodsCatelogId(int goodsCatelogId)
	{
		this.goodsCatelogId = goodsCatelogId;
	}
	public NovelDAO getGoodsDAO()
	{
		return goodsDAO;
	}
	public void setGoodsDAO(NovelDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	
	public int getRukushuliang()
	{
		return rukushuliang;
	}

	public void setRukushuliang(int rukushuliang)
	{
		this.rukushuliang = rukushuliang;
	}

	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public String getGoodsMiaoshu()
	{
		return goodsMiaoshu;
	}
	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	
	public String getFujian()
	{
		return fujian;
	}

	public String getGoodsKucun()
	{
		return goodsKucun;
	}

	public void setGoodsKucun(String goodsKucun)
	{
		this.goodsKucun = goodsKucun;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
	
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public int getGoodsShichangjia()
	{
		return goodsShichangjia;
	}
	public void setGoodsShichangjia(int goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}
	public int getGoodsTejia()
	{
		return goodsTejia;
	}
	public void setGoodsTejia(int goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}
	public String getGoodsYanse()
	{
		return goodsYanse;
	}
	public void setGoodsYanse(String goodsYanse)
	{
		this.goodsYanse = goodsYanse;
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

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	
}
