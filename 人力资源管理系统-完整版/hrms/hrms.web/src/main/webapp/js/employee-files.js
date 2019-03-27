/**
 * 员工档案业务脚本
 */
var EmployeeFiles = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:EmployeeFiles.action.search,
					keyWordsName:"archivesName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"员工姓名"},
								{field:"archivesName",lable:"档案名称"},
								{field:"archivesNumber",lable:"档案编号"}],
							events:{
								find:EmployeeFiles.action.find,
								details:EmployeeFiles.action.details,
								select_all:"select_all()",
								remove:"EmployeeFiles.events.remove(this.id)",
								remove_all:"EmployeeFiles.events.remove_all()",
								first_search:"EmployeeFiles.events.search('first')",
								up_search:"EmployeeFiles.events.search('up')",
								nx_search:"EmployeeFiles.events.search('nx')",
								last_search:"EmployeeFiles.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:EmployeeFiles.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:EmployeeFiles.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:EmployeeFiles.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				EmployeeFiles.events.remove(ids.toString());
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
					url:EmployeeFiles.action.exists,
					callback:function(result){
						if(result.state){
							alert(result.message);
						}
					}
			};
			common.events.exists(options);
		}
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		exists: "employee/files/exists",
		insert: "employee/files/insert",
		remove: "employee/files/remove",
		update: "employee/files/save",
		find: "employee/files/find",
		details: "employee/files/details",
		search: "employee/files/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		EmployeeFiles.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		EmployeeFiles.events.update(formName);
	}
}