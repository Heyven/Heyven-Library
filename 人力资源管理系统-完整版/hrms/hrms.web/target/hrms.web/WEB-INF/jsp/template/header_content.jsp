<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>
    <img id="account_img" src="${accountRequest.head}" class="radius-circle rotate-hover" height="50"/>
    <spring:message code="website.name"/>
    </h1>
  </div>
  <div class="head-l">
  <a class="button button-little bg-green" href="account/exit" target="_blank">
  <span class="icon-home"></span> 
  <spring:message code="relogin" />
  </a> &nbsp;&nbsp;
  <%-- 
  <a href="##" class="button button-little bg-blue">
  <span class="icon-wrench"></span> 
  <spring:message code="clear.cache" />
  </a> &nbsp;&nbsp;
   --%>
  <a class="button button-little bg-red" href="account/exit">
  <span class="icon-power-off"></span> <spring:message code="exit" /></a> 
  </div>
</div>