/**
 * 员工考勤业务脚本
 */
var EmployeeAttendance = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:EmployeeAttendance.action.search,
					keyWordsName:"employeeName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"员工姓名"},
								{field:"departmentName",lable:"部门名称"},
								{field:"attendanceType",lable:"考勤类型"},
								{field:"attendanceStartTime",lable:"开始时间"},
								{field:"attendanceEndTime",lable:"结束时间"},
								{field:"sanctionMoney",lable:"奖罚金额"}],
							events:{
								find:EmployeeAttendance.action.find,
								details:EmployeeAttendance.action.details,
								select_all:"select_all()",
								remove:"EmployeeAttendance.events.remove(this.id)",
								remove_all:"EmployeeAttendance.events.remove_all()",
								first_search:"EmployeeAttendance.events.search('first')",
								up_search:"EmployeeAttendance.events.search('up')",
								nx_search:"EmployeeAttendance.events.search('nx')",
								last_search:"EmployeeAttendance.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:EmployeeAttendance.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:EmployeeAttendance.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:EmployeeAttendance.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				EmployeeAttendance.events.remove(ids.toString());
				ids.splice(0,ids.length);
				index = 0;
			}else{
				alert("未选中");
			}
		},
		exists: function(th){
			var options = {
					field:{
						name:th.name,
						value:th.value
					},
					url:EmployeeAttendance.action.exists,
					callback:function(result){
						if(!result.state){
							alert(result.message);
						}
					}
			};
			common.events.exists(options);
		},
		init_date_compent:function(compentElementId,outputElementId){
			// 初始化日期控件
			common.events.init_date_compent({
				dateCell:compentElementId,// 显示日期元素的ID
				format:"YYYY-MM-DD hh:mm:ss",// 日期格式
				outputElementId:outputElementId//日期时间戳元素ID
			});
		}
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		exists: "employee/exists",
		insert: "employee/attendance/insert",
		remove: "employee/attendance/remove",
		update: "employee/attendance/save",
		find: "employee/attendance/find",
		details: "employee/attendance/details",
		search: "employee/attendance/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		EmployeeAttendance.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		EmployeeAttendance.events.update(formName);
	}
}