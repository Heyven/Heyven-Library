/**
 * 权限业务脚本
 */

var Authority = {
		events:{
			search:function(operate){
				var options = {
						operate: operate,
						url:Authority.action.search,
						keyWordsName:"authorityName",
						callback:function(result){
							common.events.show_list_data({
								datas:result.data,
								pageing:result.pageing,
								lables:[
									{field:"authorityName",lable:"权限名称"},
									{field:"authorityCode",lable:"权限代码"},
									{field:"authorityUrl",lable:"权限路径"}],
								events:{
									find:Authority.action.find,
									details:Authority.action.details,
									select_all:"select_all()",
									remove:"Authority.events.remove(this.id)",
									remove_all:"Authority.events.remove_all()",
									first_search:"Authority.events.search('first')",
									up_search:"Authority.events.search('up')",
									nx_search:"Authority.events.search('nx')",
									last_search:"Authority.events.search('last')"
								}
							});
						}
				};
				common.events.search(options);
			},
			insert:function(){
				var options = {
						url:Authority.action.insert,
						callback:function(result){
							alert(result.message);
						}
				}
				common.events.insert_or_update(options);
			},
			update:function(){
				var options = {
						url:Authority.action.update,
						callback:function(result){
							alert(result.message);
						}
				}
				common.events.insert_or_update(options);
			},
			remove:function(id){
				common.events.remove({
					id:id,
					url:Authority.action.remove,
					callback:function(result){
						alert(result.message);
					}
				});
			},
			remove_all:function(){
				if(ids.length >0){
					Authority.events.remove(ids.toString());
					ids.splice(0,ids.length);
					index = 0;
				}else{
					alert("未选中");
				}
			},
			exists:function(th){
				common.events.exists({
					field:{
						name:th.name,
						value:th.value
					},
					url:Authority.action.exists,
					callback:function(result){
						if(result.state){
							alert(result.message);
						}
					}
				});
			}
		},
		action: {
			exists: "authority/exists",
			insert: "authority/insert",
			remove: "authority/remove",
			update: "authority/save",
			find: "authority/find",
			details: "authority/details",
			search: "authority/search"
		}
};

/**
 * 表单验证通过后默认调用该行数(必须定义该函数) 
 */
function process(formName){
	if(formName.indexOf("insert") != -1){
		Authority.events.insert(formName);
	}else{
		Authority.events.update(formName);
	}
}