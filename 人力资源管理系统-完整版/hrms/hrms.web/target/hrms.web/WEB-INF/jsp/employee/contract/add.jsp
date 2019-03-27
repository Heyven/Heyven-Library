<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/employee-contract.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>
<style>
.datainp{width:160px; height:40px; border:1px #ccc solid;}
</style>
<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加合同</strong>
</div>
<div class="body-content">
	<form method="post" name="insertEmployeeContractForm" class="form-x">
		<input type="hidden" name="employeeId" value="<%=request.getParameter("id") %>">
		<input type="hidden" name="employeeName" value="<%=request.getParameter("name") %>">
		<div class="form-group">
			<div class="label">
				<label>合同内容: </label>
			</div>
			<div class="field">
				<textarea rows="5" cols="50" name="contractContent" data-validate="required:请输入合同内容"></textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>开始日期: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="contractStartTimeTmp" name="contractStartTimeTmp" type="text" placeholder="请选择开始日期"  readonly>
					<input id="contractStartTime" name="contractStartTime" type="hidden">
					<input type="button" onclick="EmployeeContract.events.init_date_compent('#contractStartTimeTmp','contractStartTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>结束日期: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="contractEndTimeTmp" name="contractEndTimeTmp" type="text" placeholder="请选择结束日期"  readonly>
					<input id="contractEndTime" name="contractEndTime" type="hidden">
					<input type="button" onclick="EmployeeContract.events.init_date_compent('#contractEndTimeTmp','contractEndTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>合同备注: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="contractRemarks" data-validate="required:请输入合同备注"></textarea>
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

EmployeeContract.events.init_date_compent("#contractStartTimeTmp","contractStartTime");
EmployeeContract.events.init_date_compent("#contractEndTimeTmp","contractEndTime");

</script>