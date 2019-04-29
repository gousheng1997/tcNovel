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
		
        <script language="javascript">
           function chapterAdd(novelId)
           {
              var url="<%=path %>/admin/chapter/chapterAdd.jsp?novelId="+novelId;
              window.location.href=url;
           }
           
           function chapterDetail(chapterId)
           {
                 var url="<%=path %>/chapterDetailQiantai.action?chapterId="+chapterId;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/images/tbg.gif">&nbsp;小说章节列表&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">标题</td>
					<td width="25%">发布时间</td>
					<td width="25%">内容</td>
					<td width="25%">操作</td>
		        </tr>	
				<s:iterator value="#request.chapterList" id="chapter">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#chapter.chaptername"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#chapter.pushtime"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="<%=path %>/chapterDetailQiantai.action?chapterId=<s:property value="#chapter.id"/>" target="blank" class="pn-loperator">查看内容</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a class="pn-loperator" href="<%=path %>/chapterDel.action?chapterId=<s:property value="#chapter.id"/>">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加章节" style="width: 80px;" onclick="chapterAdd('${novelId}')" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>