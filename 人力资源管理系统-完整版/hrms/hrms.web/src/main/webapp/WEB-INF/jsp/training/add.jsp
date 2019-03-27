<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/training.js"></script>

<div class="panel-head" id="add">
	<strong><span class="icon-pencil-square-o"></span>添加培训项目</strong>
</div>
<div class="body-content">
	<form method="post" name="insertTrainingForm" class="form-x">
		<div class="form-group">
			<div class="label">
				<label>培训项目名称: </label>
			</div>
			<div class="field">
				<input type="text" onchange="Training.events.exists(this);" class="input w50" name="projectName" data-validate="required:请输入培训项目名称"/>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>培训地址: </label>
			</div>
			<div class="field">
				<textarea rows="5" cols="50" name="trainingAddress" data-validate="required:请输入培训地址"></textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>培训内容: </label>
			</div>
			<div class="field">
			<textarea rows="5" cols="50" name="trainingContent" data-validate="required:请输入培训内容"></textarea>
				<div class="tips"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label>培训时间(天数): </label>
			</div>
			<div class="field">
				<input type="text" class="input w50" name="trainingTime" data-validate="required:请输入培训天数"/>
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
