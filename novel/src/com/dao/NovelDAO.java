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
	public static final String GOODS_NAME = "goodsName";

	public static final String GOODS_MIAOSHU = "goodsMiaoshu";

	public static final String GOODS_PIC = "goodsPic";

	public static final String GOODS_YANSE = "goodsYanse";

	public static final String GOODS_SHICHANGJIA = "goodsShichangjia";

	public static final String GOODS_TEJIA = "goodsTejia";

	public static final String GOODS_ISNOTTEJIA = "goodsIsnottejia";

	public static final String GOODS_ISNOTTUIJIAN = "goodsIsnottuijian";

	public static final String GOODS_CATELOG_ID = "goodsCatelogId";

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

	public List findByGoodsName(Object goodsName)
	{
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List findByGoodsMiaoshu(Object goodsMiaoshu)
	{
		return findByProperty(GOODS_MIAOSHU, goodsMiaoshu);
	}

	public List findByGoodsPic(Object goodsPic)
	{
		return findByProperty(GOODS_PIC, goodsPic);
	}

	public List findByGoodsYanse(Object goodsYanse)
	{
		return findByProperty(GOODS_YANSE, goodsYanse);
	}

	public List findByGoodsShichangjia(Object goodsShichangjia)
	{
		return findByProperty(GOODS_SHICHANGJIA, goodsShichangjia);
	}

	public List findByGoodsTejia(Object goodsTejia)
	{
		return findByProperty(GOODS_TEJIA, goodsTejia);
	}

	public List findByGoodsIsnottejia(Object goodsIsnottejia)
	{
		return findByProperty(GOODS_ISNOTTEJIA, goodsIsnottejia);
	}

	public List findByGoodsIsnottuijian(Object goodsIsnottuijian)
	{
		return findByProperty(GOODS_ISNOTTUIJIAN, goodsIsnottuijian);
	}

	public List findByGoodsCatelogId(Object goodsCatelogId)
	{
		return findByProperty(GOODS_CATELOG_ID, goodsCatelogId);
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