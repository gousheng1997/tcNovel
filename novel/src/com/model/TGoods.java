package com.model;

/**
 * TGoods generated by MyEclipse Persistence Tools
 */

public class TGoods implements java.io.Serializable
{

	// Fields

	private Integer goodsId;

	private String goodsName;

	private String goodsMiaoshu;

	private String goodsPic;

	private String goodsYanse;
	private String goodsAuthor;

	private Integer goodsShichangjia;

	private Integer goodsTejia;

	private String goodsIsnottejia;

	private String goodsIsnottuijian;

	private Integer goodsCatelogId;
	
	private String goodsKucun;
	
	private String goodsDel;
	
	private String goodsCatelogName;//数据库表没有，自己添加的

	// Constructors

	/** default constructor */
	public TGoods()
	{
	}

	/** full constructor */
	public TGoods(String goodsName, String goodsMiaoshu, String goodsPic,
			String goodsYanse, Integer goodsShichangjia, Integer goodsTejia,
			String goodsIsnottejia, String goodsIsnottuijian,
			Integer goodsCatelogId)
	{
		this.goodsName = goodsName;
		this.goodsMiaoshu = goodsMiaoshu;
		this.goodsPic = goodsPic;
		this.goodsYanse = goodsYanse;
		this.goodsShichangjia = goodsShichangjia;
		this.goodsTejia = goodsTejia;
		this.goodsIsnottejia = goodsIsnottejia;
		this.goodsIsnottuijian = goodsIsnottuijian;
		this.goodsCatelogId = goodsCatelogId;
	}

	// Property accessors

	public Integer getGoodsId()
	{
		return this.goodsId;
	}

	public String getGoodsDel()
	{
		return goodsDel;
	}

	public String getGoodsKucun()
	{
		return goodsKucun;
	}

	public void setGoodsKucun(String goodsKucun)
	{
		this.goodsKucun = goodsKucun;
	}

	public void setGoodsDel(String goodsDel)
	{
		this.goodsDel = goodsDel;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getGoodsName()
	{
		return this.goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public String getGoodsMiaoshu()
	{
		return this.goodsMiaoshu;
	}

	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}

	public String getGoodsPic()
	{
		return this.goodsPic;
	}

	public void setGoodsPic(String goodsPic)
	{
		this.goodsPic = goodsPic;
	}

	public String getGoodsYanse()
	{
		return this.goodsYanse;
	}

	public void setGoodsYanse(String goodsYanse)
	{
		this.goodsYanse = goodsYanse;
	}

	public Integer getGoodsShichangjia()
	{
		return this.goodsShichangjia;
	}

	public void setGoodsShichangjia(Integer goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}

	public Integer getGoodsTejia()
	{
		return this.goodsTejia;
	}

	public void setGoodsTejia(Integer goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}

	public String getGoodsIsnottejia()
	{
		return this.goodsIsnottejia;
	}

	public void setGoodsIsnottejia(String goodsIsnottejia)
	{
		this.goodsIsnottejia = goodsIsnottejia;
	}

	public String getGoodsAuthor() {
		return goodsAuthor;
	}

	public void setGoodsAuthor(String goodsAuthor) {
		this.goodsAuthor = goodsAuthor;
	}

	public String getGoodsIsnottuijian()
	{
		return this.goodsIsnottuijian;
	}

	public void setGoodsIsnottuijian(String goodsIsnottuijian)
	{
		this.goodsIsnottuijian = goodsIsnottuijian;
	}

	public Integer getGoodsCatelogId()
	{
		return this.goodsCatelogId;
	}

	public void setGoodsCatelogId(Integer goodsCatelogId)
	{
		this.goodsCatelogId = goodsCatelogId;
	}

	public String getGoodsCatelogName()
	{
		return goodsCatelogName;
	}

	public void setGoodsCatelogName(String goodsCatelogName)
	{
		this.goodsCatelogName = goodsCatelogName;
	}

}