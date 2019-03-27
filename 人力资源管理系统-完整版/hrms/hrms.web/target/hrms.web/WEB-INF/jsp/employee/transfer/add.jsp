<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="js/employee-transfer.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>

<style>
.datainp{width:160px; height:40px; border:1px #ccc solid;}
</style>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>人事调动</strong>
</div>
<div class="body-content">
	<form method="post" name="insertEmployeeTransferForm" class="form-x">
	<input type="hidden" name="employeeId" value="${data.id}">
	<input type="hidden" name="employeeName" value="${data.employeeName}">
	<input type="hidden" name="originalDepartment" value="${data.departmentName}">
	<input type="hidden" name="originalJob" value="${data.employeeJob}">
	
		<div class="form-group">
			<div class="label">
				<label>姓名: ${data.employeeName }</label>
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label>性别: ${data.employeeSex}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>原部门: ${data.departmentName}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>原职位: ${data.employeeJob}</label>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>新部门: </label>
			</div>
			<div class="field">
				<select name="newDepartment" id="newDepartment" class="datainp">
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
				<label>新职位: </label>
			</div>
			<div class="field">
				<select name="newJob" id="newJob" class="datainp">
					<option value="厨师">厨师</option>
					<option value="工程师">工程师</option>
					<option value="司机">司机</option>
					<option value="文员">文员</option>
					<option value="会计">会计</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label>调动时间: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="transferTimeTmp" name="transferTimeTmp" type="text" placeholder="请选择调动时间" readonly>
					<input id="transferTime" name="transferTime" type="hidden">
					<input type="button" onclick="EmployeeTransfer.events.init_date_compent('#transferTimeTmp','transferTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label>调动原因: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="transferCause" data-validate="required:请输入调动原因"></textarea>
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
	EmployeeTransfer.events.init_date_compent('#transferTimeTmp','transferTime');
</script>