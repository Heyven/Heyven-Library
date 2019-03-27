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
	<span class="icon-pencil-square-o"></span>${data.employeeName}档案详情
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
				<label>档案名称: ${data.archivesName}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>档案编号: ${data.archivesNumber}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>档案内容：${data.archivesContent}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label> 档案备注: ${data.archivesRemarks}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>档案摘要: ${data.archivesSummary}</label>
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
