<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<script type="text/javascript" src="js/account.js"></script>
<script type="text/javascript">
//进入页面时调用获取所有权限函数及账号权限
Account.get_account_authoritys(${data.id});
</script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>更新账号</strong>
</div>
<div class="body-content">
	<form method="post" name="updateAccountForm" class="form-x">
		<input type="hidden" name="ids" id="ids"> 
		<input type="hidden" name="id" value="${data.id}">
		<div class="form-group">
			<div class="label">
				<label>账号: &nbsp;&nbsp; ${data.account}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>头像：</label>
			</div>
			<div class="field">
				<div id="preview_div">
					<img id="preview_img" height="158px" width="158px"
						src="${data.head}">
				</div>
				<a href="javascript:;" class="file">选择图片 <input
					class="serverImg" type="text" id="headImg" name="head"
					value="${data.head}" /> <input type="file" id="img" name="img"
					onchange="previewImage(this,'headImg');">
				</a>
				<div class="tipss">尺寸: 200*200 大小:0-50KB</div>
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label>权限：</label>
			</div>
			<div class="field">
				<div id="authorityDiv"></div>
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
