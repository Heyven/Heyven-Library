<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/employee-files.js"></script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加档案</strong>
</div>
<div class="body-content">
	<form method="post" name="insertEmployeeFilesForm" class="form-x">
		<input type="hidden" name="employeeId" value="<%=request.getParameter("id") %>">
		<input type="hidden" name="employeeName" value="<%=request.getParameter("name") %>">
		<div class="form-group">
			<div class="label">
				<label>档案名称: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Employee.events.exists(this);" class="input w50" name="archivesName" value="<%=request.getParameter("name") %>" data-validate="required:请输入账号" readonly/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>档案内容: </label>
			</div>
			<div class="field">
				<textarea rows="5" cols="50" name="archivesContent" data-validate="required:请输入档案内容"></textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>档案备注: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="archivesRemarks" data-validate="required:请输入档案备注"></textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>档案摘要: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="archivesSummary" data-validate="required:请输入档案摘要"></textarea>
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
