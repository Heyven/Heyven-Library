<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
    
<%-- 引入JSTL标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="js/authority.js"></script>
<title>更新权限</title>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>更新权限</strong>
		</div>
		<div class="body-content">
			<form name="updateAuthForm" class="form-x">
				<div class="form-group">
					<div class="label">
						<label>权限名称: </label>
					</div>
					<div class="field">
						<input type="hidden" name="id" value="${data.id}" >
						<input type="text" value="${data.authorityName}" class="input w50"
							name="authorityName"
							data-validate="required:请输入权限名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限代码: </label>
					</div>
					<div class="field">
						<input type="text" value="${data.authorityCode}" class="input w50"
							name="authorityCode"
							data-validate="required:请输入权限代码" />
						<div class="tips"></div>
					</div>
				</div>
				
			<div class="form-group">
					<div class="label">
						<label>权限路径: </label>
					</div>
					<div class="field">
						<input type="text" value="${data.authorityUrl}" class="input w50"
							name="authorityUrl"
							data-validate="required:请输入权限路径" />
						<div class="tips"></div>
					</div>
				</div>
				
			<div class="form-group">
					<div class="label">
						<label>权限状态: </label>
					</div>
					<div class="field">
						<select name="state">
							<c:choose>
								<c:when test="${data.state eq 'ENABLED'}">
									<option selected="selected" value="ENABLED">启用</option>
									<option value="DISABLED">禁用</option>	
								</c:when>
								<c:otherwise>
									<option value="ENABLED">启用</option>
									<option selected="selected" value="DISABLED">禁用</option>
								</c:otherwise>
							</c:choose>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="clear"></div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	