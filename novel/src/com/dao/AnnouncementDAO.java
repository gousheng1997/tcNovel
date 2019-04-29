package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Announcement;

/**
 * Data access object (DAO) for domain model class Announcement.
 * 
 * @see com.model.Announcement
 * @author MyEclipse Persistence Tools
 */

public class AnnouncementDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(AnnouncementDAO.class);

	// property constants
	public static final String ANNOUNCEMENT_TITLE = "announcementTitle";

	public static final String ANNOUNCEMENT_CONTENT = "announcementContent";





	protected void initDao()
	{
		// do nothing
	}

	public void save(Announcement transientInstance)
	{
		log.debug("saving Announcement instance");
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

	public void delete(Announcement persistentInstance)
	{
		log.debug("deleting Announcement instance");
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

	public Announcement findById(java.lang.Integer id)
	{
		log.debug("getting Announcement instance with id: " + id);
		try
		{
			Announcement instance = (Announcement) getHibernateTemplate().get(
					"com.model.Announcement", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Announcement instance)
	{
		log.debug("finding Announcement instance by example");
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
		log.debug("finding Announcement instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Announcement as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnnouncementTitle(Object announcementTitle)
	{
		return findByProperty(ANNOUNCEMENT_TITLE, announcementTitle);
	}

	public List findByAnnouncementContent(Object announcementContent)
	{
		return findByProperty(ANNOUNCEMENT_CONTENT, announcementContent);
	}





	public List findAll()
	{
		log.debug("finding all Announcement instances");
		try
		{
			String queryString = "from Announcement order by announcementId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Announcement merge(Announcement detachedInstance)
	{
		log.debug("merging Announcement instance");
		try
		{
			Announcement result = (Announcement) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Announcement instance)
	{
		log.debug("attaching dirty Announcement instance");
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

	public void attachClean(Announcement instance)
	{
		log.debug("attaching clean Announcement instance");
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

	public static AnnouncementDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (AnnouncementDAO) ctx.getBean("AnnouncementDAO");
	}
}