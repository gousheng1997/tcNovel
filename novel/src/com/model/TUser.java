package com.model;

import java.util.Date;

/**
 * TUser generated by MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable
{

	// Fields

	private Integer userId;

	private String userName;

	private String userPw;



	private String userRealname;

	private String userAddress;

	private String userSex;

	private String userTel;

	private String userEmail;

	private String userQq;



	private String userAge;

	private String userBirthday;

	private String userXueli;
	
	private String userDel;
	


	// Constructors

	/** default constructor */
	public TUser()
	{
	}

	/** full constructor */
	public TUser(String userName, String userPw,
			String userRealname, String userAddress, String userSex,
			String userTel, String userEmail, String userQq,
			String userAge, String userBirthday, String userXueli
			)
	{
		this.userName = userName;
		this.userPw = userPw;

		this.userRealname = userRealname;
		this.userAddress = userAddress;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userQq = userQq;

		this.userAge = userAge;
		this.userBirthday = userBirthday;
		this.userXueli = userXueli;

	}

	// Property accessors

	public Integer getUserId()
	{
		return this.userId;
	}
	

	public String getUserDel()
	{
		return userDel;
	}

	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}



	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return this.userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}


	public String getUserRealname()
	{
		return this.userRealname;
	}

	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}

	public String getUserAddress()
	{
		return this.userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getUserSex()
	{
		return this.userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserTel()
	{
		return this.userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	public String getUserEmail()
	{
		return this.userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getUserQq()
	{
		return this.userQq;
	}

	public void setUserQq(String userQq)
	{
		this.userQq = userQq;
	}



	public String getUserAge()
	{
		return this.userAge;
	}

	public void setUserAge(String userAge)
	{
		this.userAge = userAge;
	}

	public String getUserBirthday()
	{
		return this.userBirthday;
	}

	public void setUserBirthday(String userBirthday)
	{
		this.userBirthday = userBirthday;
	}

	public String getUserXueli()
	{
		return this.userXueli;
	}

	public void setUserXueli(String userXueli)
	{
		this.userXueli = userXueli;
	}



}