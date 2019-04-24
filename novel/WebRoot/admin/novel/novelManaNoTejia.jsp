<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function novelDetailHou(novelId)
           {
                 var url="<%=path %>/novelDetailHou.action?novelId="+novelId;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
           function novelNoTejiaDel(novelId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/novelNoTejiaDel.action?novelId="+novelId;
               }
           }
           
           function novelNoTejiaAdd()
           {
                 var url="<%=path %>/admin/novel/novelNoTejiaAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function novelShezhiTejia(novelId)
           {
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/admin/novel/novelShezhiTejia.jsp?novelId="+novelId);
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }		
		   
		   function kefangComment(id)
	       {
	            var url="<%=path %>/commentMana.action?kefangId="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:650,height:450});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","评论管理");
	            pop.build();
	            pop.show();
	       }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;小说管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				
					<td width="10%">小说名称</td>
					<td width="10%">小说描述</td>
					<td width="10%">分类</td>
					<td width="10%">小说封面</td>
					<td width="10%">小说作者</td>
					<td width="10%">推荐设置</td>
					<td width="10%">小说热度</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.novelList" id="novel">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#novel.novelName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="novelDetailHou(<s:property value="#novel.novelId"/>)" class="pn-loperator">小说描述</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#novel.novelCatelogName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/<s:property value="#novel.novelPic"/>')" onmouseout = "out()" style="cursor:hand;">
								查看图片
					   </div>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#novel.novelAuthor"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:if test="#novel.novelIsnottejia=='no'">无推荐&nbsp;&nbsp;&nbsp;
					         <a href="#" style="color: red" onclick="novelShezhiTejia(<s:property value="#novel.novelId"/>)">设为推荐</a>
					     </s:if>
					     <s:if test="#novel.novelIsnottejia=='yes'">
					        <s:property value="#novel.novelTejia"/>
					     </s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#novel.novelLikeNum"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="novelNoTejiaDel(<s:property value="#novel.novelId"/>)" class="pn-loperator">删除</a>
						<a style="color: red" href="#" onclick="kefangComment(<s:property value="#novel.novelId"/>)" class="pn-loperator">评论管理</a>
							<a style="color: red" href="<%=path %>/zhangjieMana.action?novelId=<s:property value="#novel.novelId"/>"  class="pn-loperator">章节管理</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="novelNoTejiaAdd()" />
			    </td>
			  </tr>
		    </table>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
	</body>
</html>
