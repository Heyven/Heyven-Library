
/**
 * 员工合同业务脚本
 */
var EmployeeContract = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:EmployeeContract.action.search,
					keyWordsName:"employeeName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"员工姓名"},
								{field:"contractNumber",lable:"合同编号"}],
							events:{
								find:EmployeeContract.action.find,
								details:EmployeeContract.action.details,
								select_all:"select_all()",
								remove:"EmployeeContract.events.remove(this.id)",
								remove_all:"EmployeeContract.events.remove_all()",
								first_search:"EmployeeContract.events.search('first')",
								up_search:"EmployeeContract.events.search('up')",
								nx_search:"EmployeeContract.events.search('nx')",
								last_search:"EmployeeContract.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:EmployeeContract.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:EmployeeContract.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:EmployeeContract.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				EmployeeContract.events.remove(ids.toString());
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
					url:EmployeeContract.action.exists,
					callback:function(result){
						if(result.state){
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
				format:"YYYY-MM-DD",// 日期格式
				outputElementId:outputElementId//日期时间戳元素ID
			});
		}
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		exists: "employee/contract/exists",
		insert: "employee/contract/insert",
		remove: "employee/contract/remove",
		update: "employee/contract/save",
		find: "employee/contract/find",
		details: "employee/contract/details",
		search: "employee/contract/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		EmployeeContract.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		EmployeeContract.events.update(formName);
	}
}