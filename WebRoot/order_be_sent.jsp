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

<title>My JSP 'adm_LearningFile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="./css/table.css">

</head>

<body>
<div id="table">
	<table>
		<tr>
			<th>序号</th>
			<th>订单号</th>
			<th>下单时间</th>
			<th>用户ID</th>
			<th>商店ID</th>
			<th colspan="2" id="send">发货</th>
		<tr>
			<%
				int i = 1;
			%>
			<s:iterator id="list" value="#request['orders']" >
				<tr>
					<td id="num"><%=i++%></td>
					<td id="orderNumber"><s:property value="#list.orderNumber" /></td>
					<td id="createTime"><s:property value="#list.createTime" /></td>				
					<td id="userId"><s:property value="#list.userId" /></td>		
					<td id="shopId"><s:property value="#list.shopId" /></td>			
					<td id="send">
						<s:if test="#session.user == null">
								<s:else>
									发货
								</s:else>
						</s:if>
						<s:else>
							<form action="deletefile.action">
									<input type="submit" value="发货">
							</form>	
						</s:else>
					</td>
				</tr>
			</s:iterator>
	</table>
	</div>
	<%-- <div id="page">
			共
			<s:property value="pageBean.totalPage" />
			页&nbsp;&nbsp;&nbsp;&nbsp; 共
			<s:property value="pageBean.allRow" />
			条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 当前第
			<s:property value="pageBean.currentPage" />
			页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="%{pageBean.currentPage== 1}">第一页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
			<s:else>
				<a href="getLeaning?page=1">第一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a
					href="getLeaning?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</s:else>
			<s:if test="%{pageBean.currentPage!= pageBean.totalPage}">
				<a
					href="getLeaning?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a href="getLeaning?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
			</s:if>
			<s:else>下一页&nbsp;&nbsp;&nbsp;&nbsp;最后一页</s:else>
		</div> --%>
</body>
</html>
