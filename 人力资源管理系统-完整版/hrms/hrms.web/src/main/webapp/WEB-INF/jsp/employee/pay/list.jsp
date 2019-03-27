<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/employee-pay.js"></script>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 薪酬记录列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        	<li>
          <input type="text" placeholder="请输入搜索关键字" id="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="EmployeePay.events.search('first')" > 搜索</a>
          </li>
      </ul>
    </div>
    <table id="dataList" class="table table-hover text-center">
    	
    </table>
  </div>