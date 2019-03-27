<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/jt" prefix="jt"%>
<script type="text/javascript" src="js/employee-contract.js"></script>
<style>
.label{
margin: 10px; margin-left: 30px;
}
</style>
<div class="panel-head" id="add">
	<strong>
	<span class="icon-pencil-square-o"></span>${data.employeeName}合同详情
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
				<label>员工姓名: ${data.employeeName}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>合同编号: ${data.contractNumber}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>合同内容：${data.contractContent}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				
				<label> 开始日期: <jt:dft date="${data.contractStartTime}"/></label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>结束日期: <jt:dft date="${data.contractEndTime}"/></label>
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
