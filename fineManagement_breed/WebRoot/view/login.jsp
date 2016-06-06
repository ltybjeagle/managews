<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/view/resource.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>登陆系统</title>
<!--[if lt IE 9]>
<script src="<%=basePath%>/plug-in/login/js/html5.js"></script>
<![endif]-->
<!--[if lt IE 7]>
<script src="<%=basePath%>/plug-in/login/js/iepng.js" type="text/javascript"></script>
<script type="text/javascript">
EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
</script>
<![endif]-->
<link href="<%=basePath%>/plug-in/login/css/zice.style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/plug-in/login/css/learunui-login.css" rel="stylesheet" type="text/css" />
</head>
<body class="Loginbody">
<div id="alertMessage"></div><div id="successLogin"></div><div class="text_success">
<img src="<%=basePath%>/plug-in/login/images/loader_green.gif" alt="Please wait" /><span>登陆成功!请稍后....</span></div>
<div class="logo">
    <img src="<%=basePath%>/plug-in/login/images/loginlogo-1.png" />
</div>
<div class="content">
	<div class="Loginform">
	<form name="formLogin" id="formLogin" action="#" check="<%=basePath%>/sysMain/checkuser.do" method="post">
		<div class="form-message"></div>
        <div class="form-account">账户<input id="code" name="code" type="text" placeholder="请输入用户名" iscookie="true" nullmsg="请输入用户名!"/></div>
        <div class="form-password">密码<input id="pwd" name="pwd" type="password" placeholder="请输入密码" nullmsg="请输入密码!"/></div>
        <div class="form-bottom">
            <div id="but_login" class="btlogin"></div>
        </div>
    </form>
    </div>
</div>
<div class="copyright">Copyright © FH 2100</div>
<script type="text/javascript" src="<%=basePath%>/plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/login/js/jquery-jrumble.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/login/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/login/js/iphone.check.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/login/js/login.js"></script>
</body>
</html>