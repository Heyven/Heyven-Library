<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/apply.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>更新应聘</strong>
</div>
<div class="body-content">
	<form method="post" name="updateApplyForm" class="form-x">
		<input type="hidden" name="id" value="${data.id }"/>
		<div class="form-group">
			<div class="label">
				<label>应聘人姓名: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Apply.events.exists(this);" value="${data.applyName }" class="input w50" name="applyName" data-validate="required:请输入应聘人姓名"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人性别: </label>
			</div>
			<div class="field" style="padding-top: 10px;">
				&nbsp;&nbsp;
				<input type="radio" checked="checked" name="applySex" value="男" />男
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="applySex" value="女" />女
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人出生日期: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="applyBirthdayTmp" name="applyBirthdayTmp" type="text" placeholder="请选择出生日期"  readonly>
					<input id="applyBirthday" name="applyBirthday" value="${data.applyBirthday }" type="hidden">
					<input type="button" onclick="Apply.events.init_date_compent('#applyBirthdayTmp','applyBirthday');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人联系电话: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" value="${data.applyPhone}" name="applyPhone" data-validate="required:请输入联系电话"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人邮箱地址: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" value="${data.applyEmail }" name="applyEmail" data-validate="required:请输入邮箱"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘部门: </label>
			</div>
			<div class="field">
				<select name="applyDepartment" id="applyDepartment" class="datainp">
					<option value="餐饮部">餐饮部</option>
					<option value="研发部">研发部</option>
					<option value="运输部">运输部</option>
					<option value="行政部">行政部</option>
					<option value="财务部">财务部</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘职位: </label>
			</div>
			<div class="field">
				<select name="applyJob" id="applyJob" class="datainp">
					<option value="厨师">厨师</option>
					<option value="工程师">工程师</option>
					<option value="司机">司机</option>
					<option value="文员">文员</option>
					<option value="会计">会计</option>
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
				<button class="button bg-main icon-check-square-o" type="submit">
					提交</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">

common.events.checked("applySex","${data.applySex}");
common.events.selected("applyDepartment","${data.applyDepartment}");
common.events.selected("applyJob","${data.applyJob}");
Apply.events.init_date_compent('#applyBirthdayTmp','applyBirthday');

</script>