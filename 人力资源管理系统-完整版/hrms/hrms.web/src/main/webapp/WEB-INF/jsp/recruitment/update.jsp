<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="js/recruitment.js"></script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>更新招聘</strong>
</div>
<div class="body-content">
	<form method="post" name="updateRecruitmentForm" class="form-x">
		<input type="hidden" name="id" value="${data.id}">
		<div class="form-group">
			<div class="label">
				<label>招聘部门: </label>
			</div>
			<div class="field">
				<select name="recruitmentDeparment" id="recruitmentDeparment" class="datainp">
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
				<label>招聘职位: </label>
			</div>
			<div class="field">
				<select name="recruitmentJob" id="recruitmentJob" class="datainp">
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
				<label>任职要求: </label>
			</div>
			<div class="field">
				<textarea rows="5" cols="50" name="jobRequirements" data-validate="required:请输入任职要求">
				${data.jobRequirements}
				</textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>工作内容: </label>
			</div>
			<div class="field">
				<textarea rows="5" cols="50" name="jobContent" data-validate="required:请输入工作内容">
				${data.jobContent}
				</textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>招聘人数: </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" value="${data.recruitmentNumber}" name="recruitmentNumber" data-validate="required:请输入招聘人数"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>最低学历: </label>
			</div>
			<div class="field">
				<select name="minimumEducation" id="minimumEducation" class="datainp">
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
				<label>招聘公司: </label>
			</div>
			<div class="field">
				<select name="recruitmentAgency" id="recruitmentAgency" class="datainp">
					<option value="广州总公司">广州总公司</option>
					<option value="上海分公司">上海分公司</option>
					<option value="北京分公司">北京分公司</option>
					<option value="深圳分公司">深圳分公司</option>
					<option value="天津分公司">天津分公司</option>
					<option value="长沙分公司">长沙分公司</option>
					<option value="厦门分公司">厦门分公司</option>
				</select>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>公司地址: </label>
			</div>
			<div class="field">
				<input type="text" value="${data.companyAddress}" name="companyAddress" data-validate="required:请输入公司地址"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>工作性质: </label>
			</div>
			<div class="field">
				<select name="workingProperty" id="workingProperty" class="datainp">
					<option value="兼职">兼职</option>
					<option value="全职">全职</option>
				</select>
				<div class="tips"></div>
			</div>
			</div>
		<div class="form-group">
			<div class="label">
				<label>招聘状态: </label>
			</div>
			<div class="field">
	     		<select name="recruitmentState" id="recruitmentState" class="datainp">
					<option value="正在招聘">正在招聘</option>
					<option value="结束招聘">结束招聘</option>
				</select>
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

	// 页面加载自动选择
	common.events.selected("recruitmentDeparment","${data.recruitmentDeparment}");
	common.events.selected("recruitmentJob","${data.recruitmentJob}");
	common.events.selected("minimumEducation","${data.minimumEducation}");
	common.events.selected("recruitmentAgency","${data.recruitmentAgency}");
	common.events.selected("workingProperty","${data.workingProperty}");
	common.events.selected("recruitmentState","${data.recruitmentState}");
</script>