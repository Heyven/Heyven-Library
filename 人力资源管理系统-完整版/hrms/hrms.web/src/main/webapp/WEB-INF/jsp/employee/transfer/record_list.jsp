<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/employee-transfer.js"></script>
<style>
.label{
margin: 10px; margin-left: 30px;
}
.contract_files_a{
margin-right: 0px;
float:right;
}
</style>
  <div class="panel admin-panel">
    <div class="panel-head">
    <strong class="icon-reorder"> 人事调动记录</strong>
     	<div class="contract_files_a">
		<strong>
		<a href="employee/transfer/report">生成报表</a>
		</strong>
	</div>
    </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        	<li>
          <input type="text" placeholder="请输入搜索关键字" id="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="EmployeeTransfer.events.record_search('first')" > 搜索</a>
          </li>
      </ul>
    </div>
    <table id="dataList" class="table table-hover text-center">
    	
    </table>
  </div>