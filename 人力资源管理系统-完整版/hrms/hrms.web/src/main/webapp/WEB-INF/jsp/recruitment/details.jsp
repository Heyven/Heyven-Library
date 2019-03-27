<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/jt" prefix="jt"%>
<script type="text/javascript" src="js/recruitment.js"></script>
<style>
.label{
margin: 10px; margin-left: 30px;
}
</style>
<div class="panel-head" id="add">
	<strong>
	<span class="icon-pencil-square-o"></span>招聘详情
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
				<label>招聘部门: ${data.recruitmentDeparment}</label>
			</div>
		</div>
	<div class="form-group">
			<div class="label">
				<label>招聘职位: ${data.recruitmentJob}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>任职要求：${data.jobRequirements}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>工作内容: ${data.jobContent}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>招聘人数: ${data.recruitmentNumber}人</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>最低学历: ${data.minimumEducation}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>招聘公司: ${data.recruitmentAgency}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>公司地址: ${data.companyAddress}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>工作性质: ${data.workingProperty}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>招聘状态: ${data.recruitmentState}</label>
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
