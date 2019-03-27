<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<%response.setStatus(HttpServletResponse.SC_OK);%>  
<%  
/** *//**  
* 本页面是在客户查找的页面无法找到的情况下调用的  
*/  
response.setStatus(HttpServletResponse.SC_OK);  
%>  
<body>  
正在制作 <a href="javascript:history.go(-1)">返回</a>  
<br/>  
也可能页面连接更改了，请按 F5 键刷新整个页面看看，特别是菜单！  
</body> 
</html>