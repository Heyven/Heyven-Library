<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/employee-transfer.js"></script>
<script type="text/javascript" src="jedate/jedate.js"></script>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 人事调动报表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        	<li>
          	<div class="form-group">
			<div class="field">
			<form method="post" name="generateReportForm" class="form-x">
					<p class="datep">
					起始日期:&nbsp;&nbsp;<input class="datainp" id="startTimeTmp" name="startTimeTmp" type="text" placeholder="请选择起始日期"  readonly>
					<input id="startTime" name="startTime" type="hidden">
					<input type="button" onclick="EmployeeTransfer.events.init_date_compent('#startTimeTmp','startTime','YYYY-MM');" value="选择">
					&nbsp;&nbsp;&nbsp;&nbsp;
					截止日期:&nbsp;&nbsp;<input class="datainp" id="endTimeTmp" name="endTimeTmp" type="text" placeholder="请选择截止日期"  readonly>
					<input id="endTime" name="endTime" type="hidden">
					<input type="button" onclick="EmployeeTransfer.events.init_date_compent('#endTimeTmp','endTime','YYYY-MM');" value="选择">
					&nbsp;&nbsp;
					<button class="button bg-main icon-check-square-o" type="submit">创建报表</button>
					</p>
					</form>
				<div class="tips"></div>
			</div>
		</div>
          </li>
      </ul>
    </div>
    <img id="reportImg" style="display:none;margin-left:50px;" />
  </div>