/**
 * 培训项目业务脚本
 */
var Training = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:Training.action.search,
					keyWordsName:"projectName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"projectName",lable:"培训项目名称"},
								{field:"trainingAddress",lable:"培训地址"},
								{field:"trainingTime",lable:"培训时间"}],
							events:{
								find:Training.action.find,
								details:Training.action.details,
								select_all:"select_all()",
								remove:"Training.events.remove(this.id)",
								remove_all:"Training.events.remove_all()",
								first_search:"Training.events.search('first')",
								up_search:"Training.events.search('up')",
								nx_search:"Training.events.search('nx')",
								last_search:"Training.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:Training.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:Training.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:Training.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				Training.events.remove(ids.toString());
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
					url:Training.action.exists,
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
		exists: "training/exists",
		insert: "training/insert",
		remove: "training/remove",
		update: "training/save",
		find: "training/find",
		details: "training/details",
		search: "training/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		Training.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		Training.events.update(formName);
	}
}