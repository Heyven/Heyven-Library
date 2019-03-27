<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/jt" prefix="jt"%>
<script type="text/javascript" src="js/employee-files.js"></script>
<style>
.label{
margin: 10px; margin-left: 30px;
}
</style>
<div class="panel-head" id="add">
	<strong>
	<span class="icon-pencil-square-o"></span>应聘详情
	</strong>
</div>
<div class="body-content">
	  <div class="form-group">
			<div class="label">
				<label>&nbsp;&nbsp;&nbsp;ID: &nbsp;&nbsp;${data.id}</label>
			</div>
			
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘编号: ${data.applyId}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>应聘人姓名: ${data.applyName}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人性别：${data.applySex}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label> 应聘人出生日期: <jt:dft date="${data.applyBirthday}"/></label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人联系电话: ${data.applyPhone}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘人邮箱地址: ${data.applyEmail}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘部门: ${data.applyDepartment}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>应聘职位: ${data.applyJob}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>状态: ${data.state}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>创建时间: <jt:dft date="${data.createTime}" partternKey="2"/></label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>更新时间: <jt:dft date="${data.updateTime}" partternKey="2"/></label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>操作人: ${data.creator}</label>
			</div>
		</div>
		<div class="clear"></div>
</div>
