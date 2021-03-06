package com.model;

/**
 * TCatelog generated by MyEclipse Persistence Tools
 */

public class TCatelog implements java.io.Serializable
{

	// Fields

	private Integer catelogId;

	private String catelogName;

	private String catelogDescription;
	
	private String catelogDel;

	// Constructors

	/** default constructor */
	public TCatelog()
	{
	}

	/** full constructor */
	public TCatelog(String catelogName, String catelogDescription)
	{
		this.catelogName = catelogName;
		this.catelogDescription = catelogDescription;
	}

	// Property accessors

	public Integer getCatelogId()
	{
		return this.catelogId;
	}
	

	public String getCatelogDel()
	{
		return catelogDel;
	}

	public void setCatelogDel(String catelogDel)
	{
		this.catelogDel = catelogDel;
	}

	public void setCatelogId(Integer catelogId)
	{
		this.catelogId = catelogId;
	}

	public String getCatelogName()
	{
		return this.catelogName;
	}

	public void setCatelogName(String catelogName)
	{
		this.catelogName = catelogName;
	}

	public String getCatelogDescription()
	{
		return this.catelogDescription;
	}

	public void setCatelogDescription(String catelogDescription)
	{
		this.catelogDescription = catelogDescription;
	}

}