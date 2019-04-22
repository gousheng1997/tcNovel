package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Tzhangjie;

/**
 * Data access object (DAO) for domain model class Tzhangjie.
 * 
 * @see com.model.Tzhangjie
 * @author MyEclipse Persistence Tools
 */

public class TzhangjieDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TzhangjieDAO.class);

	public static final String Zhangjie_Name = "zhangjiename";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Tzhangjie transientInstance)
	{
		log.debug("saving Tzhangjie instance");
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

	public void delete(Tzhangjie persistentInstance)
	{
		log.debug("deleting Tzhangjie instance");
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

	public Tzhangjie findById(java.lang.Integer id)
	{
		log.debug("getting Tzhangjie instance with id: " + id);
		try
		{
			Tzhangjie instance = (Tzhangjie) getHibernateTemplate().get(
					"com.model.Tzhangjie", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tzhangjie instance)
	{
		log.debug("finding Tzhangjie instance by example");
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
		log.debug("finding Tzhangjie instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Tzhangjie as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByZhangjiename(Object zhangjiename)
	{
		return findByProperty(Zhangjie_Name, zhangjiename);
	}


	public List findAll()
	{
		log.debug("finding all Tzhangjie instances");
		try
		{
			String queryString = "from Tzhangjie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tzhangjie merge(Tzhangjie detachedInstance)
	{
		log.debug("merging Tzhangjie instance");
		try
		{
			Tzhangjie result = (Tzhangjie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tzhangjie instance)
	{
		log.debug("attaching dirty Tzhangjie instance");
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

	public void attachClean(Tzhangjie instance)
	{
		log.debug("attaching clean Tzhangjie instance");
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

	public static TzhangjieDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TzhangjieDAO) ctx.getBean("TzhangjieDAO");
	}
}