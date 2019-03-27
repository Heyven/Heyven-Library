<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/authority.js"></script>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 权限列表</strong> <a href="authority/add" style="float:right; display:none;">添加权限</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="authority/add"> 添加权限</a> </li>
        	<li>
          <input type="text" placeholder="请输入搜索关键字" id="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="Authority.events.search('first')" > 搜索</a>
          </li>
      </ul>
    </div>
    <table id="dataList" class="table table-hover text-center">
    	
    </table>
  </div>