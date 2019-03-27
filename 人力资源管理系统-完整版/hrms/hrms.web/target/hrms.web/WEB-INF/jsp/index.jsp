<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> <spring:message code="alert" /></strong></div>
  <div class="body-content" style="text-align :center;">
    	<h3>
    	<spring:message code="welcome" /> ${accountRequest.account}
    	</h3>
  </div>
</div>