<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- 引入Sitemesh标签库 --%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="d" %>

<%-- 引入Spring标签库 --%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<base href="<%=basePath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title><spring:message code="website.name"/>-<d:title></d:title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/pintuer.js"></script>
    <script type="text/javascript" src="js/tool.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
</head>
<body style="background-color:#f2f9fd;">

<%-- 包含头部内容页面 --%>
<jsp:include page="header_content.jsp"/>

<%-- 包含菜单内容页面 --%>
<jsp:include page="left_nav.jsp"/>

<%-- 包含菜单内容页面 --%>
<jsp:include page="bread.jsp"/>

<div class="admin">
  
<%-- 使用Sitemash装饰 --%>
<d:body></d:body>
</div>
</body>
</html>