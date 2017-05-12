<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/header/styles.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">		
		function exit()
		{
				top.location.href="login.html";
		}
		
		function toggle(targetid){
		
		    if (document.getElementById){
		
		        target=document.getElementById(targetid);
		
		            if (target.style.display=="block"){
		
		                target.style.display="none";
		
		            } else {
		
		                target.style.display="block";
		
		            }
		
		    }
		
		}

		function MM_over(mmObj) {
			var mSubObj = mmObj.getElementsByTagName("div")[0];
			mSubObj.style.display = "block";
		}
		function MM_out(mmObj) {
			var mSubObj = mmObj.getElementsByTagName("div")[0];
			mSubObj.style.display = "none";
			
		}
	</script>
</head>

<body>
	<div id="head">
		<div id="head1"><span>爱婴岛后台管理系统</span></div>	
		<s:if test="#session.user==null">
			<jsp:forward page="login.html"></jsp:forward>
		</s:if>
		<s:else>
			<div onmouseover="MM_over(this)" onmouseout="MM_out(this)" style="width:100px;float:right" >
				<img src="images/user.png" id="img1" style="width:60px;height:60px; margin-right: 100px;float:right">
				<div id="admin" style="margin-top: 5px;position: absolute;">
					<table>
						<tr>							
							<td align="center"><a href="logout" onclick="exit()">注销</a></td>
						</tr>
					</table>		
				</div>
			</div>
		</s:else>
	</div>
</body>
</html>
