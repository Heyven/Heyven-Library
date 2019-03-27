/**
 * 登录脚本
 */

var login =  {
		code:function(){
			// 获取验证码函数
			$.ajax({
				type : "get",
				url : login.action.getCode,
				success : function(result) {
					console.log(result);
					document.getElementById("codeImg").src = result;
				}
			});
		},
		checkCode:function(th){
			// 检查验证码是否输入正确
			$.ajax({
				type : "post",
				url : login.action.checkCode,
				data: th.value,
				contentType : "application/text",
				success : function(result) {
					console.log(result);
					var data = eval(result);
					if(!data.state){
						document.getElementById("message").innerText = data.message;
						th.focus();
					}else{
						document.getElementById("message").innerText = "";
					}
				}
			});
		},
		checkAccount: function(th){
			// 检查登录账号是否存在
			var jsonData = '{\"'+th.name+'\":\"' + th.value + '\"}';
			console.log(jsonData);
			$.ajax({
				type : "post",
				url : login.action.checkAccount,
				data: jsonData,
				contentType : "application/json",
				success : function(result) {
					console.log(result);
					var data = eval(result);
					if(data.state){
						document.getElementById("message").innerText = data.message;
						document.getElementById("account").focus();
					}
				}
			});
		},
		login: function(form){
			// 登录
			var formObject = $("form").serialize();
			var jsonData = parameterToJson(formObject);
			console.log(jsonData);
			$.ajax({
				type : "post",
				url : login.action.login,
				data : jsonData,
				contentType : "application/json",
				success : function(result) {
					console.log(result);
					var data = eval(result);
					if(data.state){
						window.location.href=data.data;
					}else{
						document.getElementById("message").innerText = data.message;
					}
				}
			});
		},
		action:{
			getCode: "verification/code",
			checkCode: "verification/checkCode",
			checkAccount: "account/check",
			login: "account/login"
		}
}

function process(form){
	login.login(form);
}

login.code();