/**
 * 应聘业务脚本
 */
var Apply = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:Apply.action.search,
					keyWordsName:"applyName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"applyName",lable:"应聘人姓名"},
								{field:"applyDepartment",lable:"应聘部门"},
								{field:"applyJob",lable:"应聘职位"},
								{field:"applySex",lable:"应聘人性别"},
								{field:"applyPhone",lable:"应聘人联系电话"}],
							events:{
								find:Apply.action.find,
								details:Apply.action.details,
								select_all:"select_all()",
								remove:"Apply.events.remove(this.id)",
								remove_all:"Apply.events.remove_all()",
								first_search:"Apply.events.search('first')",
								up_search:"Apply.events.search('up')",
								nx_search:"Apply.events.search('nx')",
								last_search:"Apply.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:Apply.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:Apply.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:Apply.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				Apply.events.remove(ids.toString());
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
					url:Apply.action.exists,
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
		exists: "apply/exists",
		insert: "apply/insert",
		remove: "apply/remove",
		update: "apply/save",
		find: "apply/find",
		details: "apply/details",
		search: "apply/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		Apply.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		Apply.events.update(formName);
	}
}