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

public class novelAction extends ActionSupport
{
	private int novelId;
	private int novelCatelogId;
	private String novelName;
	private String novelMiaoshu;
	private String fujian;
	private String novelYanse;
	private int novelLikeNum;
	private int novelRecommendWeight;
	
	private int catelogId;
	private String novelKucun;
	
	private String message;
	private String path;
	
	private NovelDAO novelDAO;
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
	
	
	public String novelNoRecommendWeightAdd()
	{
		Novel novel=new Novel();
		novel.setNovelCatelogId(novelCatelogId);
		novel.setNovelName(novelName);
		novel.setNovelMiaoshu(novelMiaoshu);
		novel.setNovelPic(fujian);
		novel.setNovelLikeNum(novelLikeNum);
		if(novelRecommendWeight==0)//特格为0表示没有特价
		{
			novel.setNovelRecommendWeight(novelLikeNum);// 如果不是特价商品。把这个商品的特价设置为市场价格
			novel.setNovelIsrecommend("no");
		}
		else
		{
			novel.setNovelRecommendWeight(novelRecommendWeight);
			novel.setNovelIsrecommend("yes");
		}
		
		novel.setNovelKucun(novelKucun);
		novel.setNovelDel("no");
		
		novelDAO.save(novel);
		this.setMessage("操作成功");
		this.setPath("novelManaNoRecommendWeight.action");
		return "succeed";
		
	}
	
	public String novelNoRecommendWeightDel()
	{
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelDel("yes");
		novelDAO.attachDirty(novel);
		this.setMessage("操作成功");
		this.setPath("novelManaNoRecommendWeight.action");
		return "succeed";
	}
	
	public String novelManaNoRecommendWeight()
	{
		String sql="from Novel where novelDel='no' order by novelIsrecommend";
		List novelList=novelDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<novelList.size();i++)
		{
			Novel novel=(Novel)novelList.get(i);
			System.out.println(novel.getNovelCatelogId());
			novel.setNovelCatelogName(catelogDAO.findById(novel.getNovelCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("novelList", novelList);
		return ActionSupport.SUCCESS;
	}
	
	public String novelShezhiRecommendWeight()
	{
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelIsrecommend("yes");
		novel.setNovelRecommendWeight(novelRecommendWeight);
		novelDAO.attachDirty(novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelKucun()
	{
		String sql="from Novel where novelDel='no' order by novelIsrecommend";
		List novelList=novelDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("novelList", novelList);
		return ActionSupport.SUCCESS;
	}
	
	public String novelRuku()
	{
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelKucun(novel.getNovelKucun()+rukushuliang);
		novel.setNovelRecommendWeight(novelRecommendWeight);
		novelDAO.attachDirty(novel);
		return ActionSupport.SUCCESS;
	}
	
	/*public String novelYesRecommendWeightAdd()
	{
		Novel novel=new Novel();
		novel.setNovelCatelogId(novelCatelogId);
		novel.setNovelName(novelName);
		novel.setNovelMiaoshu(novelMiaoshu);
		novel.setNovelPic(fujian);
		novel.setNovelYanse(novelYanse);
		novel.setNovelLikeNum(novelLikeNum);
		novel.setNovelRecommendWeight(novelRecommendWeight);
		novel.setNovelIsrecommend("yes");
		novel.setNovelDel("no");
		novelDAO.save(novel);
		this.setMessage("操作成功");
		this.setPath("novelManaYesRecommendWeight.action");
		return "succeed";
		
	}
	
	public String novelYesRecommendWeightDel()
	{
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelDel("yes");
		novelDAO.attachDirty(novel);
		this.setMessage("操作成功");
		this.setPath("novelManaYesRecommendWeight.action");
		return "succeed";
	}
	
	
	public String novelManaYesRecommendWeight()
	{
		String sql="from Novel where novelDel='no' and novelIsrecommend='yes' order by novelCatelogId";
		List novelList=novelDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<novelList.size();i++)
		{
			Novel novel=(Novel)novelList.get(i);
			novel.setNovelCatelogName(catelogDAO.findById(novel.getNovelCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("novelList", novelList);
		return ActionSupport.SUCCESS;
	}*/
	
	public String novelDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel novel=novelDAO.findById(novelId);
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	public String dianzan()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelLikeNum(novel.getNovelLikeNum()+1);
		novelDAO.attachDirty(novel);
		TCatelog catelog=catelogDAO.findById(novel.getNovelCatelogId());
		novel.setNovelCatelogName(catelog.getCatelogName());
		
		List zhangjieList=zhangjieDAO.findByProperty("novelId", novelId);
		request.put("zhangjieList", zhangjieList);
		
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel novel=novelDAO.findById(novelId);
		
		TCatelog catelog=catelogDAO.findById(novel.getNovelCatelogId());
		novel.setNovelCatelogName(catelog.getCatelogName());
		
		List zhangjieList=zhangjieDAO.findByProperty("novelId", novelId);
		request.put("zhangjieList", zhangjieList);
		
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelAllYesRecommendWeight()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from Novel where novelDel='no' and novelIsrecommend='yes' order by novelCatelogId";
		List novelYesRecommendWeightList=novelDAO.getHibernateTemplate().find(sql);
		request.put("novelYesRecommendWeightList", novelYesRecommendWeightList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelAllNoRecommendWeight()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from Novel where novelDel='no' and novelIsrecommend='no' order by novelCatelogId";
		List novelYesRecommendWeightList=novelDAO.getHibernateTemplate().find(sql);
		request.put("novelYesRecommendWeightList", novelYesRecommendWeightList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelByCatelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from Novel where novelDel='no' and novelCatelogId=? order by novelCatelogId";
		Object[] con={catelogId};
		List novelByCatelogList=novelDAO.getHibernateTemplate().find(sql,con);
		request.put("novelByCatelogList", novelByCatelogList);
		
		System.out.println(novelByCatelogList.size()+"^^^"+novelCatelogId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelSearch()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="";
		if(catelogId==0)
		{
			sql="from Novel where novelDel='no' and novelName like '%"+novelName+"%'"+" order by novelCatelogId";
		}
		else
		{
			sql="from Novel where novelDel='no' and novelCatelogId="+catelogId+" and novelName like '%"+novelName+"%'"+" order by novelCatelogId";
		}

		List novelList=novelDAO.getHibernateTemplate().find(sql);
		request.put("novelList", novelList);

		return ActionSupport.SUCCESS;
	}
	
	
	public String zhangjieAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Tzhangjie zhangjie=new Tzhangjie();
		zhangjie.setContent(content);
		zhangjie.setZhangjiename(zhangjiename);
		zhangjie.setNovelId(novelId);
		zhangjie.setPushtime(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		
		zhangjieDAO.save(zhangjie);
		this.setMessage("发布成功");
		request.put("novelId", novelId);
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
		request.put("novelId", novelId);
		request.put("zhangjie", zhangjie);
		return ActionSupport.SUCCESS;
	}
	
	public String zhangjieDetailQiantai()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
	
		Tzhangjie zhangjie=zhangjieDAO.findById(zhangjieId);
		Novel novel=novelDAO.findById(zhangjie.getNovelId());
		request.put("zhangjie", zhangjie);
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhangjieMana()
	{
		List zhangjieList=zhangjieDAO.findByProperty("novelId", novelId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		request.put("novelId", novelId);
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

	public int getNovelCatelogId()
	{
		return novelCatelogId;
	}
	public void setNovelCatelogId(int novelCatelogId)
	{
		this.novelCatelogId = novelCatelogId;
	}
	public NovelDAO getNovelDAO()
	{
		return novelDAO;
	}
	public void setNovelDAO(NovelDAO novelDAO)
	{
		this.novelDAO = novelDAO;
	}
	
	public int getRukushuliang()
	{
		return rukushuliang;
	}

	public void setRukushuliang(int rukushuliang)
	{
		this.rukushuliang = rukushuliang;
	}

	public int getNovelId()
	{
		return novelId;
	}
	public void setNovelId(int novelId)
	{
		this.novelId = novelId;
	}
	public String getNovelMiaoshu()
	{
		return novelMiaoshu;
	}
	public void setNovelMiaoshu(String novelMiaoshu)
	{
		this.novelMiaoshu = novelMiaoshu;
	}
	public String getNovelName()
	{
		return novelName;
	}
	
	public String getFujian()
	{
		return fujian;
	}

	public String getNovelKucun()
	{
		return novelKucun;
	}

	public void setNovelKucun(String novelKucun)
	{
		this.novelKucun = novelKucun;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public void setNovelName(String novelName)
	{
		this.novelName = novelName;
	}
	
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public int getNovelLikeNum()
	{
		return novelLikeNum;
	}
	public void setNovelLikeNum(int novelLikeNum)
	{
		this.novelLikeNum = novelLikeNum;
	}
	public int getNovelRecommendWeight()
	{
		return novelRecommendWeight;
	}
	public void setNovelRecommendWeight(int novelRecommendWeight)
	{
		this.novelRecommendWeight = novelRecommendWeight;
	}
	public String getNovelYanse()
	{
		return novelYanse;
	}
	public void setNovelYanse(String novelYanse)
	{
		this.novelYanse = novelYanse;
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
