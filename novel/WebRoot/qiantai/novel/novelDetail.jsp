<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
				<script type="text/javascript" src="<%=path %>/js/popup_shuaxin_no.js"></script>
		<script type="text/javascript">
	        function buy1()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            <s:else>
	            if(document.buy.quantity.value=="")
	            {
	                alert("请输入购买数量");
	                return false;
	            }
	          
	            
	            document.buy.submit();
	            </s:else>
	        }
	 
	
	        
	        function commentAll(id)
	        {
	            var url="<%=path %>/commentAll.action?kefangId="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:650,height:450});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","评论");
	            pop.build();
	            pop.show();
	        }
       
	       function commentAdd(id)
	       {
	            var url="<%=path %>/qiantai/novel/commentAdd.jsp?kefangId="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:700,height:400});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","写评论");
	            pop.build();
	            pop.show();
	       }
	       
	     
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<!--左边的 -->
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;详情</div>
						  	<form action="<%=path %>/addToCart.action" method="post" name="buy">
                                  <table border="0" cellpadding="6">
                                      <tr><td width="30"></td><td style="font-size: 11px;" width="60">小说名：</td><td style="font-size: 11px;"><s:property value="#request.novel.novelName"/></td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">简介：</td><td style="font-size: 11px;"><s:property value="#request.novel.novelMiaoshu" escape="false"/></td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">作者：</td><td style="font-size: 11px;"><s:property value="#request.novel.novelAuthor"/></td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">类别：</td><td style="font-size: 11px;"><s:property value="#request.novel.novelCatelogName"/></td></tr>
                                        <tr><td width="30"></td><td style="font-size: 11px;">点赞：</td><td style="font-size: 11px;"><s:property value="#request.novel.novelLikeNum"/></td></tr>

                                      <tr><td width="30"></td><td style="font-size: 11px;"> <a href="#" style="color: red" onclick="commentAll(<s:property value="#request.novel.novelId"/>)">查看评论</a></td>
                                      
                                    <td style="font-size: 11px;"> <a href="#" style="color: red" onclick="commentAdd(<s:property value="#request.novel.novelId"/>)">我要评论</a>   <a href="<%=path %>/dianzan.action?novelId=<s:property value="#request.novel.novelId"/>" style="color: red" >点赞</a></td></tr>
                                    
                                  </table>
                            </form>
                            
                             <table border="0" cellpadding="6">
                             
                             <s:iterator value="#request.chapterList" id="chapter"  status="status">
                             <s:if test="#status.index % 4==0">
                      			  <tr>
                  				  </s:if>
                  				  
                  				  <td style="font-size: 11px;">   <a href="<%=path %>/chapterDetailQiantai.action?chapterId=<s:property value="#chapter.id"/>"> [ <s:property value="#chapter.chaptername"/>--<s:property value="#chapter.pushtime"/>]</a></td>
                  				  
                             <s:if test="#status.index % 4 == 3||#status.last">
                       			 </tr>
                       		 </s:if>
               				 </s:iterator>

                                  </table>
		             </div>
		         </div>	
	        </div>
			<!--左边的 -->
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							用户登录
						</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
             <div class="left_row">
				    <div class="list">
				        <div class="list_bar">小说分类</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										     <s:action name="catelogAll" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div> 
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										 <s:action name="announcementQian5" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
