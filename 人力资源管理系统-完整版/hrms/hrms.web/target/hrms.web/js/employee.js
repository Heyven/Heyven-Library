/**
 * 员工业务脚本
 */
var Employee = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:Employee.action.search,
					keyWordsName:"employeeName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"姓名"},
								{field:"employeePhoto",lable:"照片"},
								{field:"employeeSex",lable:"性别"},
								{field:"employeeBirthday",lable:"出生日期"},
								{field:"employeePhone",lable:"手机"},
								{field:"departmentName",lable:"部门"}],
							events:{
								find:Employee.action.find,
								details:Employee.action.details,
								select_all:"select_all()",
								remove:"Employee.events.remove(this.id)",
								remove_all:"Employee.events.remove_all()",
								first_search:"Employee.events.search('first')",
								up_search:"Employee.events.search('up')",
								nx_search:"Employee.events.search('nx')",
								last_search:"Employee.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:Employee.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:Employee.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:Employee.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				Employee.events.remove(ids.toString());
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
					url:Employee.action.exists,
					callback:function(result){
						if(result.state){
							alert(result.message);
						}
					}
			};
			common.events.exists(options);
		},
		upload:function(th,outputElementId){
			// 上传照片
			common.events.upload({url:Employee.action.upload,fileElementId:th.id,outputElementId:outputElementId});
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
		exists: "employee/exists",
		insert: "employee/insert",
		remove: "employee/remove",
		update: "employee/save",
		find: "employee/find",
		details: "employee/details",
		search: "employee/search",
		upload: "employee/upload"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		Employee.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		Employee.events.update(formName);
	}
}