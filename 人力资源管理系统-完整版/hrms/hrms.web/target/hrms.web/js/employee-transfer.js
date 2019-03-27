/**
 * 员工调动业务脚本
 */
var EmployeeTransfer = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:EmployeeTransfer.action.search,
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
								transfer:EmployeeTransfer.action.transfer,
								first_search:"EmployeeTransfer.events.search('first')",
								up_search:"EmployeeTransfer.events.search('up')",
								nx_search:"EmployeeTransfer.events.search('nx')",
								last_search:"EmployeeTransfer.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		record_search:function(operate){
			var options = {
					operate: operate,
					url:EmployeeTransfer.action.record_search,
					keyWordsName:"employeeName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"姓名"},
								{field:"originalDepartment",lable:"原部门"},
								{field:"originalJob",lable:"原职位"},
								{field:"newDepartment",lable:"新部门"},
								{field:"newJob",lable:"新职位"},
								{field:"transferTime",lable:"调动时间"}],
							events:{
								first_search:"EmployeeTransfer.events.record_search('first')",
								up_search:"EmployeeTransfer.events.record_search('up')",
								nx_search:"EmployeeTransfer.events.record_search('nx')",
								last_search:"EmployeeTransfer.events.record_search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:EmployeeTransfer.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		generate:function(form){
			$("#startTime").val(DateUtil.stringToTimestamp($("#startTimeTmp").val()));
			$("#endTime").val(DateUtil.stringToTimestamp($("#endTimeTmp").val()));
			var options = {
					form:form,
					url:EmployeeTransfer.action.generate,
					callback:function(result){
						if(result.state){
							document.getElementById("reportImg").src = result.data;
							document.getElementById("reportImg").style.display= "block";
						}else{
							alert(result.message);	
						}
					}
			}
			common.events.insert_or_update(options);
		},
		init_date_compent:function(compentElementId,outputElementId,format){
			// 初始化日期控件
			if(format === undefined){
				format = "YYYY-MM-DD";
			}
			common.events.init_date_compent({
				dateCell:compentElementId,// 显示日期元素的ID
				format:format,// 日期格式
				outputElementId:outputElementId//日期时间戳元素ID
			});
		},
		update_time:function(th,outputElementId){
			var time = DateUtil.stringToTimestamp(th.value);
			console.log(time);
			document.getElementById(outputElementId).value = time;
		}
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		insert: "employee/transfer/insert",
		transfer: "employee/transfer",
		search: "employee/search",
		record_search: "employee/transfer/search",
		generate: "employee/transfer/generate",
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		EmployeeTransfer.events.insert(formName);
	}else if(formName.indexOf("generate") >= 0){
		EmployeeTransfer.events.generate(formName);
	}
}