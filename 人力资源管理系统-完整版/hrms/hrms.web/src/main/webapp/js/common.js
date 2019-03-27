/**
 * 通用CURD
 */
var common = {
		events:{
			search:function(options){
				// 查询
				//document.getElementById("listPageTable").innerHTML = '<br/><br/><img src="images/loading_1.gif"/><br/><br/><p>正在拼命查询中...<p><br/><br/>';
				// 构造查询参数
				var keyWordsValue = $("#keywords").val();
				var keyWordsObject = "{\"name\":" + "\"" + options.keyWordsName + "\",\"value\":" + "\"" + keyWordsValue + "\"}";
				var jsonData = "{\"keywords\":" + keyWordsObject + "\,\"operate\":" + "\"" + options.operate + "\"}";
				// 请求查询
				$.ajax({
					type : "post",// get查询方式
					url : options.url,// 查询URL
					data: jsonData,
					contentType : "application/json",// 查询参数内容类型
					success : function(result) {// 回调函数
						try{
							result = eval(result);
						}catch(e){
							result = JSON.parse(result);
						}
						console.log(result);
						options.callback(result);
					}
				});
			},
			show_list_data:function(options){
				// 显示列表数据
				var tableHtml = '<tr>';
				tableHtml += '<th width="100" style="text-align:left; padding-left:20px;">ID</th>';
				
				for(var i = 0; i < options.lables.length; i++){
					tableHtml += '<th>'+options.lables[i].lable+'</th>';
				}
				
				//tableHtml += '<th width="10%">'+Template.lables.update_time+'</th>';
				tableHtml += '<th width="310">操作</th>';
				tableHtml += '</tr>';
				
				for(var j = 0; j < options.datas.length; j++){
					var data = options.datas[j];
					tableHtml += '<tr>';
					tableHtml += '<td style="text-align:left; padding-left:20px;">';
					tableHtml += '<input type="checkbox" name="id[]" value="'+data.id+'" />';
					tableHtml += '</td>';
					
					for(var a = 0; a < options.lables.length; a++){
						if(options.lables[a].field == "head" || options.lables[a].field == "employeePhoto"){
							tableHtml += '<td width="10%">';
							tableHtml += '<img src="'+data[options.lables[a].field]+'" alt="" width="70" height="50" />';
							tableHtml += '</td>';
						}else{
							tableHtml += '<td>'+data[options.lables[a].field]+'</td>';	
						}
					}
					
					
					tableHtml += '<td>';
					tableHtml += '<div class="button-group"> ';
					var operate = 0;
					if(options.events.details !== undefined){
						tableHtml += '<a class="button border-main" href="'+options.events.details+'?id='+data.id+'"></span>详情</a>';
						operate = 1;
					}
					if(options.events.find !== undefined){
						tableHtml += '<a class="button border-main" href="'+options.events.find+'?id='+data.id+'"></span>更新</a>';
						operate = 1;
					}
					if(options.events.remove !== undefined){
						tableHtml += '<a class="button border-red" href="javascript:void(0)" id="'+data.id+'" onclick="'+options.events.remove+'"/><span class="icon-trash-o"></span>删除</a> ';
						operate = 1;
					}
					if(options.events.transfer !== undefined){
						operate = 1;
						tableHtml += '<a class="button border-main" href="'+options.events.transfer+'?id='+data.id+'"></span>调动</a>';
					}
					if(operate==0){
						tableHtml +='无操作';
					}
					tableHtml += '</div></td>';
					tableHtml += '</tr>';
				}
				
				if(options.events.remove !== undefined){
					tableHtml += '<tr>';
					tableHtml += '<td><input type="checkbox" onclick='+options.events.select_all+' id="checkall"/>';
					tableHtml += '全选 </td>';
					tableHtml += '<td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick='+options.events.remove_all+'>全删</a></td>';
					tableHtml += '</tr>';
				}
				tableHtml += '<tr>';
				tableHtml += '<td colspan="8">';
				tableHtml += '<div class="pagelist">';
				tableHtml += '总页数: '+options.pageing.sumPage+'&nbsp;&nbsp;';
				tableHtml += '当前第: ' + (options.pageing.currentPage + 1) + '页&nbsp;&nbsp;';
				tableHtml += '<a href="javascript:void(0)" onclick="'+options.events.first_search+'">首页</a>  ';
				tableHtml += '<a href="javascript:void(0)" onclick="'+options.events.up_search+'">上一页</a> ';
				tableHtml += '<a href="javascript:void(0)" onclick="'+options.events.nx_search+'">下一页</a>';
				tableHtml += '<a href="javascript:void(0)" onclick="'+options.events.last_search+'">尾页</a> ';
				tableHtml += '</div>';
				tableHtml += '</td>';
				tableHtml += '</tr>';
				document.getElementById("dataList").innerHTML = tableHtml;
			},
			insert_or_update:function(options){
				// 插入或更新
				var formObject = $("form").serialize();
				var jsonData = parameterToJson(formObject);
				console.log(jsonData);
				$.ajax({
					type : "post",
					url : options.url,
					data: jsonData,
					contentType : "application/json",
					success : function(result) {
						try{
							result = eval(result);
						}catch(e){
							result = JSON.parse(result);
						}
						console.log(result);
						options.callback(result);
						//location.reload();
					}
				});
				return false;
			},
			remove:function(options){
				// 删除
				if(confirm("您确定要删除吗?")){
					var jsonData = "{\"ids\":\"" + options.id + "\"}";
					// 请求查询
					$.ajax({
						type:"post",
						url:options.url,
						data:jsonData,
						contentType:"application/json",
						success:function(result) {
							try{
								result = eval(result);
							}catch(e){
								result = JSON.parse(result);
							}
							console.log(result);
							options.callback(result);
							//location.reload();
						}
					});
				}
			},
			exists:function(options){
				// 验证属性值是否存在
				var jsonData = '{\"'+options.field.name+'\":\"' + options.field.value + '\"}';
				console.log(jsonData);
				$.ajax({
					type : "post",
					url : options.url,
					data: jsonData,
					contentType : "application/json",
					success : function(result) {
						try{
							result = eval(result);
						}catch(e){
							result = JSON.parse(result);
						}
						console.log(result);
						options.callback(result);
					}
				});
			
			},
			checked:function(name,value){
				// 根据name及值匹配选择单选按钮
				var elements = document.getElementsByName(name);
				for(var i = 0; i < elements.length; i++){
					if(elements[i].value == value){
						elements[i].checked = "checked";
						break;
					}	
				}
			},
			selected:function(id,value){
				// 更加id及值匹配选择下拉框选项
				var element = document.getElementById(id);
				for(var i = 0; i < element.options.length; i++){
					if(element.options[i].value == value){
						element[i].selected = "selected";
						break;
					}	
				}
			},
			upload:function(options){
				$("#loading").ajaxStart(function() {
					$(this).show();
				}).ajaxComplete(function() {
					$(this).hide();
				});
				$.ajaxFileUpload({
					url : options.url,//'employee/upload',
					secureuri : false,
					fileElementId : options.fileElementId,//'img',//file控件id
					dataType : "json",
					success : function(result) {
						try {
							result = eval(result);
						} catch (e) {
							result = JSON.parse(result);
						}
						if (result.state == true) {
							console.log("path: " + result.data);
							// headImg
							document.getElementById(options.outputElementId).value = result.data;
						}else{
							alert(result.message);	
						}
					}
				})
			},
			init_date_compent:function(options){
				// 初始化日期控件
				jeDate({
					dateCell:options.dateCell,//"#inductionTimeTmp",
					format:options.format,//"YYYY-MM-DD",
					isinitVal:true,
					isTime:true, //isClear:false,
					//minDate:"2000-12-01",
					choosefun:function(val) {
						var outputTimes = DateUtil.stringToTimestamp(val);
						console.log("outputTimes: " + outputTimes);
						document.getElementById(options.outputElementId).value = outputTimes;
					}
				});
			}
		}
}