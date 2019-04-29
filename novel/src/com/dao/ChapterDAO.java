package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Chapter;

/**
 * Data access object (DAO) for domain model class Chapter.
 * 
 * @see com.model.Chapter
 * @author MyEclipse Persistence Tools
 */

public class ChapterDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(ChapterDAO.class);

	public static final String Chapter_Name = "chaptername";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Chapter transientInstance)
	{
		log.debug("saving Chapter instance");
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

	public void delete(Chapter persistentInstance)
	{
		log.debug("deleting Chapter instance");
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

	public Chapter findById(java.lang.Integer id)
	{
		log.debug("getting Chapter instance with id: " + id);
		try
		{
			Chapter instance = (Chapter) getHibernateTemplate().get(
					"com.model.Chapter", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Chapter instance)
	{
		log.debug("finding Chapter instance by example");
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
		log.debug("finding Chapter instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Chapter as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChaptername(Object chaptername)
	{
		return findByProperty(Chapter_Name, chaptername);
	}


	public List findAll()
	{
		log.debug("finding all Chapter instances");
		try
		{
			String queryString = "from Chapter";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chapter merge(Chapter detachedInstance)
	{
		log.debug("merging Chapter instance");
		try
		{
			Chapter result = (Chapter) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chapter instance)
	{
		log.debug("attaching dirty Chapter instance");
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

	public void attachClean(Chapter instance)
	{
		log.debug("attaching clean Chapter instance");
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

	public static ChapterDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (ChapterDAO) ctx.getBean("ChapterDAO");
	}
}