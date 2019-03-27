<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/jt" prefix="jt"%>
<script type="text/javascript" src="js/employee.js"></script>
<style>
.label{
margin: 10px; margin-left: 30px;
}
.contract_files_a{
margin-right: 0px;
float:right;
}
</style>
<div class="panel-head" id="add">
	<strong>
	<span class="icon-pencil-square-o"></span>员工详情
	</strong>
	<div class="contract_files_a">
		<strong>
		<a href="employee/files/add?id=${data.id}&name=${data.employeeName}">添加档案</a>
		</strong>
		<strong>
		<a href="employee/contract/add?id=${data.id}&name=${data.employeeName}">添加合同</a>
		</strong>
	</div>
</div>
<div class="body-content">
	  <div class="form-group">
			<div class="label">
				<label>&nbsp;&nbsp;&nbsp;ID: &nbsp;&nbsp;${data.id}</label>
			</div>
			
		</div>
		<div class="form-group">
			<div class="label">
				<label>姓名: ${data.employeeName}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>学号: ${data.employeeNumber}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>头像：</label><img id="preview_img" src="${data.employeePhoto}" width="200px" height="200px">
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>性别: ${data.employeeSex}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>出生日期: <jt:dft date="${data.employeeBirthday}"/></label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>手机: ${data.employeePhone}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>邮箱: ${data.employeeEmail}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>学历: ${data.employeeEducation}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>部门: ${data.departmentName}</label>
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label>职位: ${data.employeeJob}</label>
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label>职称等级: ${data.gradeGrade}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>基本工资: ${data.basicPay}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>状态: ${data.state}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>入职时间: <jt:dft date="${data.inductionTime}"/></label>
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
