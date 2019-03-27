/**
 * 账号业务脚本
 */
var Account = {
	events:{
		search:function(operate){
			var options = {
					operate: operate,
					url:Account.action.search,
					keyWordsName:"account",
					callback:function(result){
						common.events.show_list_data({
							datas:result.data,
							pageing:result.pageing,
							lables:[
								{field:"head",lable:"头像"},
								{field:"account",lable:"账号"},
								{field:"state",lable:"状态"}],
							events:{
								find:Account.action.find,
								details:Account.action.details,
								select_all:"select_all()",
								remove:"Account.events.remove(this.id)",
								remove_all:"Account.events.remove_all()",
								first_search:"Account.events.search('first')",
								up_search:"Account.events.search('up')",
								nx_search:"Account.events.search('nx')",
								last_search:"Account.events.search('last')"
							}
						});
					}
			};
			common.events.search(options);
		},
		insert: function(form){
			var options = {
					form:form,
					url:Account.action.insert,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		update: function(form){
			var options = {
					form:form,
					url:Account.action.update,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		},
		remove: function(id){
			var options = {
					id:id,
					url:Account.action.remove,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.remove(options);
		},
		remove_all:function(){
			if(ids.length >0){
				Account.events.remove(ids.toString());
				ids.splice(0,ids.length);
				index = 0;
			}else{
				alert("未选中");
			}
		},
		save_password:function(form){
			var options = {
					form:form,
					url:Account.action.save_password,
					callback:function(result){
						alert(result.message);
					}
			}
			common.events.insert_or_update(options);
		
		},
		exists: function(th){
			var options = {
					field:{
						name:th.name,
						value:th.value
					},
					url:Account.action.exists,
					callback:function(result){
						if(result.state){
							alert(result.message);
						}
					}
			};
			common.events.exists(options);
		}
	},
	get_account_authoritys:function(id){
		// 获取账号权限
		console.log("accountId: " + id);
		common.events.exists({
		field:{
			name:"id",
			value:id
		},
		url:Account.action.account_authoritys,
		callback:function(result){
			if(result.state){
				Account.get_all_authoritys(result.data);
			}else{
				Account.get_all_authoritys(null);	
			}
		}
	});
	},
	get_all_authoritys: function(authoritys){
		// 获取所有权限函数
		$.ajax({
			type : "get",
			url : Account.action.all_authoritys,
			success : function(result) {
				console.log(result);
				// 将返回结果转换成对象
				var data = eval(result);
				if(data.state){
					// 显示权限
					Account.show_all_authoritys(data.data, authoritys);
				}else{
					// 提示无权限
					document.getElementById("authorityDiv").innerHTML = data.message;
				}
			}
		});
	},
	show_all_authoritys: function(data,authoritys){
		// 显示所有权限函数
		var authorityDivHtml = '';
		for(var i = 0; i < data.length; i++){
			if(i % 8 == 0){
				authorityDivHtml += '<br/>';	
			}
			
			var hasAuthority = null != authoritys ? ArrayUtil.contains(authoritys,data[i]) : false;
			var checked = hasAuthority ? "checked" : "";
			authorityDivHtml += '<input onclick="Account.authority_click(this);" type="checkbox" '+checked+' value="'+data[i].id+'" >' + data[i].authorityName + "&nbsp;&nbsp;&nbsp;";
			
			if(hasAuthority){
				var checkbox = document.createElement("input");
				checkbox.type = "checkbox";
				checkbox.value = data[i].id;
				checkbox.checked = true;
				Account.authority_click(checkbox);			
			}
		}
		document.getElementById("authorityDiv").innerHTML = authorityDivHtml;
	},
	authority_click: function(th){
		// 权限选择函数，勾选权限则记录权限ID，取消勾选权限则移除权限ID
		if(th.checked == true){
			// 勾选权限
			ids[index] = th.value;
			index++;
		}else{
			// 取消勾选权限
			for(var i = 0; i < ids.length;i++){
				if(ids[i] == th.value){
					ids.splice(i,1);
					index--;
				}
			}
		}
		document.getElementById("ids").value = ids.toString();
	},
	action: {
		// 预定义请求路径(后端控制器映射路径)
		all_authoritys: "authority/all",
		exists: "account/exists",
		insert: "account/insert",
		remove: "account/remove",
		update: "account/save",
		find: "account/find",
		details: "account/details",
		account_authoritys: "account/authoritys",
		save_password: "account/save_password",
		search: "account/search"
	}
}

var index = 0;
var ids = new Array();

function process(formName){
	if(formName.indexOf("insert") >= 0){
		Account.events.insert(formName);
	}else if(formName.indexOf("update") >= 0){
		Account.events.update(formName);
	}else if(formName.indexOf("password") >= 0){
		Account.events.save_password(formName);
	}
}