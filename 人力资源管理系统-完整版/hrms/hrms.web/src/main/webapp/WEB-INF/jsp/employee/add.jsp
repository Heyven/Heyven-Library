<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/employee.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>

<style>
.datainp{width:160px; height:40px; border:1px #ccc solid;}
#loading {
	display: none;
	width: 20px;
	height: 20px;
}
</style>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加员工</strong>
</div>
<div class="body-content">
	<form method="post" name="insertEmployeeForm" class="form-x">
		<div class="form-group">
			<div class="label">
				<label>姓名: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Employee.events.exists(this);" class="input w50" name="employeeName" data-validate="required:请输入账号" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>头像：</label>
			</div>
			<div class="field">
			
				<div id="preview_div">
					<img alt="" src="images/loding.gif" id="loading">
					<img id="preview_img" src="images/x.jpg">
				</div>
				<a href="javascript:;" class="file">选择照片 <input
					class="serverImg" type="text" id="headImg" name="employeePhoto" /> 
					<input type="file" id="img" name="img" onchange="previewImage(this,'headImg'),Employee.events.upload(this,'headImg');">
				</a>
				<div class="tipss">尺寸: 200*200 大小:0-50KB</div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>性别: </label>
			</div>
			<div class="field" style="padding-top: 10px;">
				&nbsp;&nbsp;
				<input type="radio" checked="checked" name="employeeSex" value="男" />男
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="employeeSex" value="女" />女
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>出生日期: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="employeeBirthdayTmp" name="employeeBirthdayTmp" type="text" placeholder="请选择出生日期"  readonly>
					<input id="employeeBirthday" name="employeeBirthday" type="hidden">
					<input type="button" onclick="Employee.events.init_date_compent('#employeeBirthdayTmp','employeeBirthday');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>手机: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" name="employeePhone"
					data-validate="required:请输入手机" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>邮箱: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" name="employeeEmail"
					data-validate="required:请输入邮箱" />
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>学历: </label>
			</div>
			<div class="field">
				<select name="employeeEducation" id="employeeEducation" class="datainp">
					<option value="初中">初中</option>
					<option value="高中">高中</option>
					<option value="大专">大专</option>
					<option value="本科">本科</option>
					<option value="研究生">研究生</option>
					<option value="博士">博士</option>
					<option value="大师">大师</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>部门: </label>
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
				<label>职位: </label>
			</div>
			<div class="field">
				<select name="employeeJob" id="employeeJob" class="datainp">
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
				<label>职称等级: </label>
			</div>
			<div class="field">
				<select name="gradeGrade" id="gradeGrade" class="datainp">
					<option value="一级">一级</option>
					<option value="二级">二级</option>
					<option value="三级">三级</option>
					<option value="特级">特级</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label>入职时间: </label>
			</div>
			<div class="field">
					<p class="datep">
					<input class="datainp" id="inductionTimeTmp" name="inductionTimeTmp" type="text" placeholder="请选择入职时间" readonly>
					<input id="inductionTime" name="inductionTime" type="hidden">
					<input type="button" onclick="Employee.events.init_date_compent('#inductionTimeTmp','inductionTime');" value="选择">
					</p>
				<div class="tips"></div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label>基本工资: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" name="basicPay"
					data-validate="required:请输入基本工资" />
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

	Employee.events.init_date_compent("#inductionTimeTmp","inductionTime");
	Employee.events.init_date_compent("#employeeBirthdayTmp","employeeBirthday");

</script>
