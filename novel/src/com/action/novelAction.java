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
import com.dao.ChapterDAO;
import com.model.TCatelog;
import com.model.Comment;
import com.model.Chapter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class novelAction extends ActionSupport
{
	private int novelId;
	private int novelCatelogId;
	private String novelName;
	private String novelMiaoshu;
	private String fujian;

	private int novelLikeNum;
	private int novelRecommendWeight;
	
	private int catelogId;

	private String message;
	private String path;
	
	private NovelDAO novelDAO;
	private TCatelogDAO catelogDAO;
	private CommentDAO commentDAO;

	private int chapterId;
	private String chaptername;
	private String content;
	private ChapterDAO chapterDAO;
	
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
		if(novelRecommendWeight==0)//
		{
			novel.setNovelRecommendWeight(novelLikeNum);//

		}
		else
		{
			novel.setNovelRecommendWeight(novelRecommendWeight);

		}
		

		novel.setNovelDel("no");
		
		novelDAO.save(novel);
		this.setMessage("操作成功");
		this.setPath("novelManage.action");
		return "succeed";
		
	}
	
	public String novelNoRecommendWeightDel()
	{
		Novel novel=novelDAO.findById(novelId);
		novel.setNovelDel("yes");
		novelDAO.attachDirty(novel);
		this.setMessage("操作成功");
		this.setPath("novelManage.action");
		return "succeed";
	}
	
	public String novelManage()
	{
		String sql="from Novel where novelDel='no' order by novelRecommendWeight desc";
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

		novel.setNovelRecommendWeight(novelRecommendWeight);
		novelDAO.attachDirty(novel);
		return ActionSupport.SUCCESS;
	}
	
	

	

	

	
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
		
		List chapterList=chapterDAO.findByProperty("novelId", novelId);
		request.put("chapterList", chapterList);
		
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String novelDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Novel novel=novelDAO.findById(novelId);
		
		TCatelog catelog=catelogDAO.findById(novel.getNovelCatelogId());
		novel.setNovelCatelogName(catelog.getCatelogName());
		
		List chapterList=chapterDAO.findByProperty("novelId", novelId);
		request.put("chapterList", chapterList);
		
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	//獲取推薦作品信息列表
	public String GetRecommendNovelList()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");

		String sql="from Novel where novelDel='no' and novelRecommendWeight >0 order by novelRecommendWeight desc";
		List novelRecommendList=novelDAO.getHibernateTemplate().find(sql);
		request.put("novelRecommendList", novelRecommendList);
		return ActionSupport.SUCCESS;
	}
	
	//獲取最新作品信息列表
	public String getNewestNovelList()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from Novel where novelDel='no'  order by novelId desc";
		List novelNewestList =novelDAO.getHibernateTemplate().find(sql);
		request.put("novelNewestList", novelNewestList);
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
	
	
	public String chapterAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Chapter chapter=new Chapter();
		chapter.setContent(content);
		chapter.setChaptername(chaptername);
		chapter.setNovelId(novelId);
		chapter.setPushtime(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		
		chapterDAO.save(chapter);
		this.setMessage("发布成功");
		request.put("novelId", novelId);
		this.setPath("chapterMana.action");
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
	
	
	
	public String chapterDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		Chapter chapter=chapterDAO.findById(chapterId);
		request.put("novelId", novelId);
		request.put("chapter", chapter);
		return ActionSupport.SUCCESS;
	}
	
	public String chapterDetailQiantai()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
	
		Chapter chapter=chapterDAO.findById(chapterId);
		Novel novel=novelDAO.findById(chapter.getNovelId());
		request.put("chapter", chapter);
		request.put("novel", novel);
		return ActionSupport.SUCCESS;
	}
	
	
	public String chapterMana()
	{
		List chapterList=chapterDAO.findByProperty("novelId", novelId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chapterList", chapterList);
		request.put("novelId", novelId);
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




	public ChapterDAO getChapterDAO() {
		return chapterDAO;
	}

	public void setChapterDAO(ChapterDAO chapterDAO) {
		this.chapterDAO = chapterDAO;
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
