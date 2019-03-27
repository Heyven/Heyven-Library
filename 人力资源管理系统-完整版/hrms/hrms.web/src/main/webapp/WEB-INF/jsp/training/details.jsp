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
	<span class="icon-pencil-square-o"></span>培训项目详情
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
				<label>培训项目名称: ${data.projectName}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>培训地址: ${data.trainingAddress}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>培训内容：${data.trainingContent}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label> 培训时间: ${data.trainingTime}天</label>
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
