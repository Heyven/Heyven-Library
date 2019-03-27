
/**
 * 员工薪酬业务脚本
 */
var EmployeePay = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:EmployeePay.action.search,
					keyWordsName:"employeeName",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"employeeName",lable:"员工姓名"},
								{field:"basePay",lable:"基本工资"},
								{field:"meritPay",lable:"绩效工资"},
								{field:"bonus",lable:"奖金"},
								{field:"fine",lable:"罚款"},
								{field:"pay",lable:"薪酬"},
								{field:"giveTime",lable:"获取时间"}],
							events:{
								select_all:"select_all()",
								first_search:"EmployeePay.events.search('first')",
								up_search:"EmployeePay.events.search('up')",
								nx_search:"EmployeePay.events.search('nx')",
								last_search:"EmployeePay.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		}
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		search: "employee/pay/search"
	}
}