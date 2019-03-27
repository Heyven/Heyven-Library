<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 引入Spring标签库 --%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- 导航菜单内容 --%>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"><spring:message code="menu"/></strong></div>
  <h2><span class="icon-user"></span><spring:message code="security.manager"/></h2>
  <ul style="display:block">
    <li><a href="account/change_password"><span class="icon-caret-right"></span><spring:message code="change.password"/></a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span><spring:message code="system.manager"/></h2>
  <ul>
    <li><a href="account/list"><span class="icon-caret-right"></span><spring:message code="account.manager"/></a></li>
    <li><a href="authority/list"><span class="icon-caret-right"></span><spring:message code="auth.manager"/></a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span><spring:message code="emploeye.manager"/></h2>
  <ul>
    <li><a href="employee/list"><span class="icon-caret-right"></span><spring:message code="emploeye.info.manager"/></a></li>
    <li><a href="employee/files/list"><span class="icon-caret-right"></span><spring:message code="emploeye.file.manager"/></a></li>
    <li><a href="employee/contract/list"><span class="icon-caret-right"></span><spring:message code="emploeye.file.contract"/></a></li>
  </ul>
  
  <h2><span class="icon-pencil-square-o"></span><spring:message code="personnel.matter.manager"/></h2>
  <ul>
    <li><a href="employee/transfer/list"><span class="icon-caret-right"></span><spring:message code="personnel.matter.move"/></a></li>
    <li><a href="employee/transfer/record_list"><span class="icon-caret-right"></span><spring:message code="personnel.matter.move.record"/></a></li>
  </ul>
  
  <h2><span class="icon-pencil-square-o"></span><spring:message code="train.manager"/></h2>
  <ul>
    <li><a href="training/list"><span class="icon-caret-right"></span><spring:message code="train.project"/></a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span><spring:message code="attendance.management"/></h2>
  <ul>
    <li><a href="employee/attendance/list"><span class="icon-caret-right"></span><spring:message code="attendance.record"/></a></li>
    <li><a href="employee/pay/list"><span class="icon-caret-right"></span><spring:message code="money.record"/></a></li>
  </ul> 
  
  <h2><span class="icon-pencil-square-o"></span><spring:message code="recruitment.management"/></h2>
  <ul>
    <li><a href="recruitment/list"><span class="icon-caret-right"></span><spring:message code="recruitment.record"/></a></li>
    <li><a href="apply/list"><span class="icon-caret-right"></span><spring:message code="apply.record"/></a></li>
  </ul>    
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>