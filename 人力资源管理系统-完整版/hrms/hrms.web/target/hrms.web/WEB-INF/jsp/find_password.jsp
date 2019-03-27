<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/account.js"></script>
    
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<%-- 引入JSTL标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title><spring:message code="update.password"/></title>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span><spring:message code="update.password"/></strong>
		</div>
		<div class="body-content">
			<form name="passwordForm" class="form-x">
				<div class="form-group">
					<div class="label">
						<label><spring:message code="old.password"/>: </label>
					</div>
					<div class="field">
						<input type="hidden" name="id" value="${accountRequest.id}" >
						<input type="password" class="input w50"
							name="password"
							data-validate="required:<spring:message code="input.old.password"/>" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label><spring:message code="new.password"/>: </label>
					</div>
					<div class="field">
						<input type="password" class="input w50"
							name="newPassword"
							data-validate="required:<spring:message code="input.new.password"/>" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="clear"></div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit"><spring:message code="save"/></button>
						&nbsp;&nbsp;&nbsp;
						<button class="button bg-main icon-check-square-o" onclick="history.back();" type="button"><spring:message code="return"/></button>
					</div>
				</div>
			</form>
		</div>
	</div>
	