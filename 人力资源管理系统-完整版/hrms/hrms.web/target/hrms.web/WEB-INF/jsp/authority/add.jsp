<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/authority.js"></script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加权限</strong>
</div>
<div class="body-content">
	<form method="post" name="insertAuthorityForm" class="form-x">
		<div class="form-group">
			<div class="label">
				<label>权限名称: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Authority.events.exists(this);"
					class="input w50" name="authorityName" data-validate="required:请输入权限名称" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>权限代码: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Authority.events.exists(this);" class="input w50" name="authorityCode"
					data-validate="required:请输入权限代码" />
				<div class="tips"></div>
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label>权限路径: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Authority.events.exists(this);" class="input w50" name="authorityUrl"
					data-validate="required:请输入权限路径" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>默认权限: </label>
			</div>
			<div class="field" style="padding-top: 10px;">
				&nbsp;&nbsp;
				<input type="radio" checked="checked" name="defaultAuthority" value="true" />默认
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="defaultAuthority" value="false" />非默认
				<div class="tips"></div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label>访问认证: </label>
			</div>
			<div class="field" style="padding-top: 10px;">
				&nbsp;&nbsp;
				<input type="radio" checked="checked" name="accessAuthentication" value="true" />认证
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="accessAuthentication" value="false" />不认证
				<div class="tips"></div>
			</div>
		</div>
		<div class="clear"></div>

		<div class="form-group">
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<button class="button bg-main icon-check-square-o" type="submit">
					提交</button>
			</div>
		</div>
	</form>
</div>
