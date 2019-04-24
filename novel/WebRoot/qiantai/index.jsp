<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>狗剩妙妙屋</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
	     <script type="text/javascript">
 
 
  </script>
	    
	    <!-- 轮播CSS -->
	    <style type="text/css">
  body,div,ul,li,a,img{margin: 0;padding: 0;}
  ul,li{list-style: none;}
  a{text-decoration: none;}
 
  #wrapper{position: relative;margin: 30px auto;width: 940px;height: 300px;}
  #banner{position:relative;width: 940px;height: 300px;overflow: hidden;}
  .imgList{position:relative;width:1000000px;height:300px;z-index: 10;overflow: hidden;}
  .imgList li{float:left;display: inline;}
  #prev,
  #next{position: absolute;top:80px;z-index: 20;cursor: pointer;opacity: 0.2;filter:alpha(opacity=20);}
  #prev{left: 10px;}
  #next{right: 10px;}
  #prev:hover,
  #next:hover{opacity: 0.5;filter:alpha(opacity=50);}
  .bg{position: absolute;bottom: 0;width: 940px;height: 40px;z-index:20;opacity: 0.4;filter:alpha(opacity=40);background: black;}
  .infoList{position: absolute;left: 10px;bottom: 10px;z-index: 30;}
  .infoList li{display: none;}
  .infoList .infoOn{display: inline;color: white;}
  .indexList{position: absolute;right: 10px;bottom: 5px;z-index: 30;}
  .indexList li{float: left;margin-right: 5px;padding: 2px 4px;border: 2px solid black;background: grey;cursor: pointer;}
  .indexList .indexOn{background: red;font-weight: bold;color: white;}
</style>
	    
	    <!-- 轮播CSS -->
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
					
			
			<!-- 图片轮播-->
			
			<div id="wrapper" style="width:100%;overflow:hidden;white-space:nowrap;"><!-- 最外层部分 -->
    <div id="banner"><!-- 轮播部分 -->
      <ul class="imgList"><!-- 图片部分 -->
       <s:iterator value="#request.novelYesRecommendWeightList" id="novel">
      <li>
      <a href="<%=path %>novelDetail.action?novelId=<s:property value="#novel.novelId"/>">
	<img width="940px" height="300px"  src="<%=path %><s:property value="#novel.novelPic"/>"/>
	</a>
      </li>
      </s:iterator>
      </ul>
    
      <div class="bg"></div> <!-- 图片底部背景层部分-->
      <ul class="infoList"><!-- 图片左下角文字信息部分 -->
       <s:iterator value="#request.novelYesRecommendWeightList" id="novel" >
        <li> <s:property value="#novel.novelName"/></li>
       </s:iterator>
      </ul>
         <img src="/img/prev.png" width="40px" height="80px" id="prev">
      <img src="/img/next.png" width="40px" height="80px" id="next">
      <div class="bg"></div> <!-- 图片底部背景层部分-->
      <ul class="indexList"><!-- 图片右下角序号部分 -->
      <% int i=1; %>
       <s:iterator value="#request.novelYesRecommendWeightList" id="novel" >
            <li><%=i++ %> </li>
        </s:iterator>
       
      </ul>
    </div>
  </div>
	
			
			
			<!-- 图片轮播-->
		
		
		
		    <!--左边的 -->
			<div class="page_main_msg left">
				
				<!-- 排行榜 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							排行榜
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.novelList" id="novel">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>novelDetail.action?novelId=<s:property value="#novel.novelId"/>">
																   <img width="105" height="100" src="<%=path %><s:property value="#novel.novelPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#novel.novelName"/>
															</dt>
															<dt>
																作者：<s:property value="#novel.novelAuthor"/>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 排行榜 -->
				<!-- 推荐 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							 <span style="float:left">热门推荐</span>
							 <span style="float:right"><a href="<%=path %>novelAllYesRecommendWeight.action">更多>></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.novelYesRecommendWeightList" id="novel">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>novelDetail.action?novelId=<s:property value="#novel.novelId"/>">
																   <img width="105" height="100" src="<%=path %><s:property value="#novel.novelPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#novel.novelName"/>
															</dt>
															<dt>
																作者:<s:property value="#novel.novelAuthor"/>
															
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 推荐 -->
				<!-- 新品上市 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							 <span style="float:left">最新作品</span>
							 <span style="float:right"><a href="<%=path %>novelNewest.action">更多>></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.novelNewestList" id="novel">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>novelDetail.action?novelId=<s:property value="#novel.novelId"/>">
																   <img width="105" height="100" src="<%=path %><s:property value="#novel.novelPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#novel.novelName"/>
															</dt>
															<dt>
																作者:<s:property value="#novel.novelAuthor"/>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 新品上市 -->
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
				        <div class="list_bar">资讯查看</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										 <s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
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
	    
	      <script type="text/javascript">
  var curIndex = 0, //当前index
      imgArr = getElementsByClassName("imgList")[0].getElementsByTagName("li"), //获取图片组
      imgLen = imgArr.length,
      infoArr = getElementsByClassName("infoList")[0].getElementsByTagName("li"), //获取图片info组
      indexArr = getElementsByClassName("indexList")[0].getElementsByTagName("li"); //获取控制index组
     // 定时器自动变换5.5秒每次
  var autoChange = setInterval(function(){ 
    if(curIndex < imgLen -1){ 
      curIndex ++; 
    }else{ 
      curIndex = 0;
    }
    //调用变换处理函数
    changeTo(curIndex); 
  },5500);
 
  //清除定时器时候的重置定时器--封装
  function autoChangeAgain(){ 
      autoChange = setInterval(function(){ 
      if(curIndex < imgLen -1){ 
        curIndex ++;
      }else{ 
        curIndex = 0;
      }
    //调用变换处理函数
      changeTo(curIndex); 
    },5500);
    }
 
  //调用添加事件处理
  addEvent();
 
  //给左右箭头和右下角的图片index添加事件处理
 function addEvent(){
  for(var i=0;i<imgLen;i++){ 
    //闭包防止作用域内活动对象item的影响
    (function(_i){ 
    //鼠标滑过则清除定时器，并作变换处理
    indexArr[_i].onmouseover = function(){ 
      clearTimeout(autoChange);
      changeTo(_i);
      curIndex = _i;
    };
    //鼠标滑出则重置定时器处理
    indexArr[_i].onmouseout = function(){ 
      autoChangeAgain();
    };
     })(i);
  }
 
  //给左箭头prev添加上一个事件
  var prev = document.getElementById("prev");
  prev.onmouseover = function(){ 
    //滑入清除定时器
    clearInterval(autoChange);
  };
  prev.onclick = function(){ 
    //根据curIndex进行上一个图片处理
    curIndex = (curIndex > 0) ? (--curIndex) : (imgLen - 1);
    changeTo(curIndex);
  };
  prev.onmouseout = function(){ 
    //滑出则重置定时器
    autoChangeAgain();
  };
 
   //给右箭头next添加下一个事件
  var next = document.getElementById("next");
  next.onmouseover = function(){ 
    clearInterval(autoChange);
  };
  next.onclick = function(){ 
    curIndex = (curIndex < imgLen - 1) ? (++curIndex) : 0;
    changeTo(curIndex);
  };
  next.onmouseout = function(){ 
    autoChangeAgain();
  };
}
 
  //左右切换处理函数
  function changeTo(num){ 
    //设置image
    var imgList = getElementsByClassName("imgList")[0];
    goLeft(imgList,num*940); //左移一定距离
    //设置image 的 info
    var curInfo = getElementsByClassName("infoOn")[0];
    removeClass(curInfo,"infoOn");
    addClass(infoArr[num],"infoOn");
    //设置image的控制下标 index
    var _curIndex = getElementsByClassName("indexOn")[0];
    removeClass(_curIndex,"indexOn");
    addClass(indexArr[num],"indexOn");
  }
 
 
  //图片组相对原始左移dist px距离
  function goLeft(elem,dist){ 
    if(dist == 940){ //第一次时设置left为0px 或者直接使用内嵌法 style="left:0;"
      elem.style.left = "0px";
    }
    var toLeft; //判断图片移动方向是否为左
    dist = dist + parseInt(elem.style.left); //图片组相对当前移动距离
    if(dist<0){  
      toLeft = false;
      dist = Math.abs(dist);
    }else{ 
      toLeft = true;
    }
    for(var i=0;i<= dist/20;i++){ //这里设定缓慢移动，10阶每阶40px
      (function(_i){ 
        var pos = parseInt(elem.style.left); //获取当前left
        setTimeout(function(){ 
          pos += (toLeft)? -(_i * 20) : (_i * 20); //根据toLeft值指定图片组位置改变
          //console.log(pos);
          elem.style.left = pos + "px";
        },_i * 25); //每阶间隔50毫秒
      })(i);
    }
  }
 
  //通过class获取节点
  function getElementsByClassName(className){ 
    var classArr = [];
    var tags = document.getElementsByTagName('*');
    for(var item in tags){ 
      if(tags[item].nodeType == 1){ 
        if(tags[item].getAttribute('class') == className){ 
          classArr.push(tags[item]);
        }
      }
    }
    return classArr; //返回
  }
 
  // 判断obj是否有此class
  function hasClass(obj,cls){  //class位于单词边界
    return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
   }
   //给 obj添加class
  function addClass(obj,cls){ 
    if(!this.hasClass(obj,cls)){ 
       obj.className += cls;
    }
  }
  //移除obj对应的class
  function removeClass(obj,cls){ 
    if(hasClass(obj,cls)){ 
      var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
         obj.className = obj.className.replace(reg,'');
    }
  }
 
  </script>
	</body>
</html>
