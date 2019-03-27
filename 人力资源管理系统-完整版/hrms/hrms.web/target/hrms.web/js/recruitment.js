/**
 * 招聘业务脚本
 */
var Recruitment = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:Recruitment.action.search,
					keyWordsName:"recruitmentJob",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"recruitmentDeparment",lable:"招聘部门"},
								{field:"recruitmentJob",lable:"招聘职位"},
								{field:"minimumEducation",lable:"最低学历"},
								{field:"recruitmentNumber",lable:"招聘人数"},
								{field:"recruitmentState",lable:"招聘状态"}
								],
							events:{
								find:Recruitment.action.find,
								details:Recruitment.action.details,
								select_all:"select_all()",
								remove:"Recruitment.events.remove(this.id)",
								remove_all:"Recruitment.events.remove_all()",
								first_search:"Recruitment.events.search('first')",
								up_search:"Recruitment.events.search('up')",
								nx_search:"Recruitment.events.search('nx')",
								last_search:"Recruitment.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:Recruitment.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:Recruitment.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:Recruitment.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				Recruitment.events.remove(ids.toString());
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
					url:Recruitment.action.exists,
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
		exists: "recruitment/exists",
		insert: "recruitment/insert",
		remove: "recruitment/remove",
		update: "recruitment/save",
		find: "recruitment/find",
		details: "recruitment/details",
		search: "recruitment/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		Recruitment.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		Recruitment.events.update(formName);
	}
}