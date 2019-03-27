<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- 面包屑导航 --%>
<ul class="bread">
  <li><a href="#" target="right" class="icon-home"><spring:message code="home"/></a></li>
  <li><a href="##" id="a_leader_txt"></a></li>
  <li>
  <b><spring:message code="current.langage" />：</b><span style="color:red;"><%=request.getAttribute("current.language") %></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <spring:message code="switch.langage"/>：
  <a href="switch?lang=zh_CN">中文</a> &nbsp;&nbsp;
  <a href="switch?lang=en_US">English</a>
  </li>
</ul>