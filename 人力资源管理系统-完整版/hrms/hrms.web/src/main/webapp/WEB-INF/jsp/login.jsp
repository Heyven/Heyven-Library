<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title><spring:message code="login" /></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/tool.js"></script>    
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:80px;">
            <br/>
            	<b><spring:message code="current.langage" />：</b><span style="color:red;"><%=request.getAttribute("current.language") %></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <spring:message code="switch.langage"/>：
  <a href="switch?lang=zh_CN">中文</a> &nbsp;&nbsp;
  <a href="switch?lang=en_US">English</a>
            </div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form name="loginForm" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1><spring:message code="website.name"/></h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="account" id="account" onchange="login.checkAccount(this)" value="root" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" value="root" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input id="code" type="text" onchange="login.checkCode(this)" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img id="codeImg" src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="login.code()">  
                                                   
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                        	<strong id="message" style="color: red;">
                        		
                        	</strong>
                        </div>
                    </div>
                </div>
                <div style="padding:30px;">
                <input type="submit" class="button button-block bg-main text-big input-big" value="<spring:message code='login' />">
                </div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>

</body>
</html>