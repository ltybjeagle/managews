$(document).ready(function() {
	getCookie();
	onfocus();
	$('.tip a ').tipsy({
		gravity : 'sw'
	});
	$('.logo').show().animate({
		opacity : 1,
		top : '32%'
	}, 800, function() {
		$('.logo').show().delay(1200).animate({
			opacity : 1,
			top : '1%'
		}, 300, function() {
			$('.formLogin').animate({
				opacity : 1,
				left : '0'
			}, 300);
		});
	});
});

// 点击登录
$('#but_login').click(function(e) {
	submit();
});

// 回车登录
$(document).keydown(function(e) {
	if (e.keyCode == 13) {
		submit();
	}
});

// 表单提交
function submit() {
	var submit = true;
	$("input[nullmsg]").each(function() {
		if ($("#" + this.name).val() == "") {
			showError($("#" + this.name).attr("nullmsg"), 500);
			jrumble();
			setTimeout('hideTop()', 3000);
			submit = false;
			return false;
		}
	});
	if (submit) {
		hideTop();
		loading('核实中..', 1);
		setTimeout("Login()", 2500);
	}
}

// 登录处理函数
function Login() {
	var checkurl = $('form').attr('check'); // 验证路径
	var formData = new Object();
	var data = $(":input").each(function() {
		 formData[this.name] = $("#" + this.name ).val();
	});
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : checkurl, // 请求的action路径
		data : formData,
		error : function() { // 请求失败处理函数
			alert('错误');
		},
		success : function(data) {
			if (data.success) {
				setCookie();
				setTimeout("window.location.href='" + urls['msPath'] + urls['msUrl'] + "/sysMain/main.shtml'", 100);
			} else {
				showError(data.msg);
				setTimeout("window.location.href='" + urls['msPath'] + urls['msUrl'] + "/sysMain/login.shtml'", 3000);
			}
		}
	});
}

// 设置cookie
function setCookie() {
	$("input[iscookie='true']").each(function() {
		$.cookie(this.name, $("#" + this.name).val(), "/", 24);
		$.cookie("COOKIE_NAME", "true", "/", 24);
	});
}

// 读取cookie
function getCookie() {
	var COOKIE_NAME = $.cookie("COOKIE_NAME");
	if (COOKIE_NAME != null) {
		$("input[iscookie='true']").each(function() {
			$($("#" + this.name).val( $.cookie(this.name)));
		});
	} 
}

// 点击消息关闭提示
$('#alertMessage').click(function() {
	hideTop();
});

// 显示错误提示
function showError(str) {
	$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);
}

function showSuccess(str) {
	$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);
}

function onfocus() {
	if ($(window).width() > 480) {
		$('.tip input').tipsy({
			trigger : 'focus',
			gravity : 'w',
			live : true
		});
	} else {
		$('.tip input').tipsy("hide");
	}
}

function hideTop() {
	$('#alertMessage').animate({
		opacity : 0,
		right : '-20'
	}, 500, function() {
		$(this).hide();
	});
}

// 加载信息
function loading(name, overlay) {
	$('body').append('<div id="overlay"></div><div id="preloader">' + name + '..</div>');
	if (overlay == 1) {
		$('#overlay').css('opacity', 0.1).fadeIn(function() {
			$('#preloader').fadeIn();
		});
		return false;
	}
	$('#preloader').fadeIn();
}

// 表单晃动
function jrumble() {
	$('.inner').jrumble({
		x : 4,
		y : 0,
		rotation : 0
	});
	$('.inner').trigger('startRumble');
	setTimeout('$(".inner").trigger("stopRumble")', 500);
}