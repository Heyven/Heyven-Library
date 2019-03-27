<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/employee-attendance.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>
<style>
.datainp{width:160px; height:40px; border:1px #ccc solid;}
</style>
<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加考勤</strong>
</div>
<div class="body-content">
	<form method="post" name="insertAttendanceForm" class="form-x">
		<div class="form-group">
			<div class="label">
				<label>员工姓名: </label>
			</div>
			<div class="field">
				<input type="text" onchange="EmployeeAttendance.events.exists(this);" class="input w50" name="employeeName" data-validate="required:请输入员工姓名" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>部门名称: </label>
			</div>
			<div class="field">
				<select name="departmentName" id="departmentName" class="datainp">
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
				<label>考勤类型: </label>
			</div>
			<div class="field">
				<select name="attendanceType" id="attendanceType" class="datainp">
					<option value="上班">上班</option>
					<option value="请假">请假</option>
					<option value="放假">放假</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>考勤开始时间: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="attendanceStartTimeTmp" name="attendanceStartTimeTmp" type="text" placeholder="请选择开始日期"  readonly>
					<input id="attendanceStartTime" name="attendanceStartTime" type="hidden">
					<input type="button" onclick="EmployeeAttendance.events.init_date_compent('#attendanceStartTimeTmp','attendanceStartTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>考勤结束时间: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="attendanceEndTimeTmp" name="attendanceEndTimeTmp" type="text" placeholder="请选择结束日期"  readonly>
					<input id="attendanceEndTime" name="attendanceEndTime" type="hidden">
					<input type="button" onclick="EmployeeAttendance.events.init_date_compent('#attendanceEndTimeTmp','attendanceEndTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>奖罚金额: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" name="sanctionMoney" data-validate="required:请输入奖罚金额" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>考勤原因: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="attendanceCause" data-validate="required:请输入考勤原因"></textarea>
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

EmployeeAttendance.events.init_date_compent('#attendanceStartTimeTmp','attendanceStartTime');
EmployeeAttendance.events.init_date_compent('#attendanceEndTimeTmp','attendanceEndTime');

</script>