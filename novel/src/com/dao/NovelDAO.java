package com.dao;

import java.util.List;

import com.model.Novel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Data access object (DAO) for domain model class Novel.
 * 
 * @see Novel
 * @author MyEclipse Persistence Tools
 */

public class NovelDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(NovelDAO.class);

	// property constants
	public static final String NOVEL_NAME = "novelName";

	public static final String NOVEL_MIAOSHU = "novelMiaoshu";

	public static final String NOVEL_PIC = "novelPic";

	public static final String NOVEL_YANSE = "novelYanse";

	public static final String NOVEL_SHICHANGJIA = "novelLikeNum";

	public static final String NOVEL_RECOMMENDWEIGHT = "novelRecommendWeight";

	public static final String NOVEL_ISRECOMMEND = "novelIsrecommend";



	public static final String NOVEL_CATELOG_ID = "novelCatelogId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Novel transientInstance)
	{
		log.debug("saving Novel instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Novel persistentInstance)
	{
		log.debug("deleting Novel instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Novel findById(java.lang.Integer id)
	{
		log.debug("getting Novel instance with id: " + id);
		try
		{
			Novel instance = (Novel) getHibernateTemplate().get(
					"com.model.Novel", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Novel instance)
	{
		log.debug("finding Novel instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Novel instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from novel as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNovelName(Object novelName)
	{
		return findByProperty(NOVEL_NAME, novelName);
	}

	public List findByNovelMiaoshu(Object novelMiaoshu)
	{
		return findByProperty(NOVEL_MIAOSHU, novelMiaoshu);
	}

	public List findByNovelPic(Object novelPic)
	{
		return findByProperty(NOVEL_PIC, novelPic);
	}

	public List findByNovelYanse(Object novelYanse)
	{
		return findByProperty(NOVEL_YANSE, novelYanse);
	}

	public List findByNovelLikeNum(Object novelLikeNum)
	{
		return findByProperty(NOVEL_SHICHANGJIA, novelLikeNum);
	}

	public List findByNovelRecommendWeight(Object novelRecommendWeight)
	{
		return findByProperty(NOVEL_RECOMMENDWEIGHT, novelRecommendWeight);
	}

	public List findByNovelIsrecommend(Object novelIsrecommend)
	{
		return findByProperty(NOVEL_ISRECOMMEND, novelIsrecommend);
	}


	public List findByNovelCatelogId(Object novelCatelogId)
	{
		return findByProperty(NOVEL_CATELOG_ID, novelCatelogId);
	}

	public List findAll()
	{
		log.debug("finding all Novel instances");
		try
		{
			String queryString = "from novel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Novel merge(Novel detachedInstance)
	{
		log.debug("merging Novel instance");
		try
		{
			Novel result = (Novel) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Novel instance)
	{
		log.debug("attaching dirty Novel instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Novel instance)
	{
		log.debug("attaching clean Novel instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NovelDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (NovelDAO) ctx.getBean("NovelDAO");
	}
}