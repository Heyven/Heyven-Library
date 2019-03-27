/**
 * JS工具类
 */

/**
 * 将表单参数转换成JSON格式数据
 */
function parameterToJson(parameter) {
	// account=root&password=root&verificationCode=
	var parameters = parameter.split('&');
	var ret = {};
    for(var i = 0, len = parameters.length; i < len; i++){
        var pair = parameters[i];
        if((pair = pair.split('='))[0]){
            var key   = decodeURIComponent(pair.shift());
            var value = pair.length > 1 ? pair.join('=') : pair[0];
            console.log(key+":" + value);
            if(value != undefined){
                value = decodeURIComponent(value);
            }
            if(key in ret){
                if(ret[key].constructor != Array){
                    ret[key] = [ret[key]];
                }
                ret[key].push(value);
            }else{
                ret[key] = value;
            }
        }
    }
    return JSON.stringify(ret);
}

var ArrayUtil = {
		contains:function (arr, obj) {  
		    var i = arr.length;  
		    while (i--) {  
		        if (arr[i].id === obj.id) {  
		            return true;  
		        }  
		    }  
		    return false;  
		} 
}

var DateUtil = {
		stringToTimestamp: function(stringTime){
			// 日期字符串转时间戳
			var timestamp2 = Date.parse(new Date(stringTime));
			//timestamp2 = timestamp2 / 1000;
			return timestamp2;
		},
		timestampToString:function(timestamp){
			// 时间戳转日期字符串
			var newDate = new Date();
			//newDate.setTime(timestamp * 1000);
			newDate.setTime(timestamp);
			return newDate.toLocaleDateString();
		}
}

//全选
var ids = new Array();
var index = 0;
function select_all(){
	$("input[name='id[]']").each(function(){
		  if (this.checked) {
			  this.checked = false;
			  index--;
		  }else {
			  this.checked = true;
			  ids[index] = this.value;
			  index++;
		  }
	  });
}