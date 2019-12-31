$(".loginBtn").click(function(){
	var user = new Object();
	 // $.trim删除字符串开始末尾的空格
	logPhone = $.trim($(".logPhone").val());
	logPass = $.trim($(".logPass").val());
	var mylog=/^[1][3,4,5,7,8][0-9]{9}$/;
	//前台的非空验证
	if(logPhone == "" || logPhone == null){
		$(".logPhone").focus;
		$(".login-tip").css("color","red");
		$(".login-tip").html("对不起，登录账号不能为空。");
	// }else if(!mylog.test(logPhone)){
	// 	$(".login-tip").css("color","red");
	// 	$(".login-tip").html("对不起，请填写正确的手机号。");
	}else if(password == "" ||logPass == null){
		$(".logPass").focus;
		$(".login-tip").css("color","red");
		$(".login-tip").html("对不起，登录密码不能为空。");
	}else{
		$(".logTip").html("");
		//如果账号和密码都不为空，就进行 ajax 异步提交
		$.ajax({
			type:'POST',  //提交方法是POST
			url:'/login.html', //请求的路径
			data:{
				// username: "",
				password: logPass,
				// code: "",		//验证码
				phone: logPhone
				
			}, //以JSON字符串形式把 user 传到后台
			dataType:'json', //后台返回的数据类型是json文本
			timeout:1000,  //请求超时时间，毫秒
			error:function(){  //请求失败的回调方法
				// $(".login-tip").css("color","red");
				$(".login-tip").html("登录失败！请重试。");
			},
			success:function(result){	//请求成功的回调方法
				if(result != "" && result == "success"){
					window.location.href='/main.html';				//若登录成功，跳转到"/main.html"
				}else if(result == "failed"){						//if里面条件由后台提供
					// $(".login-tip").css("color","red");
					$(".login-tip").html("登录失败！请重试。");
					$(".logPhone").val('');
					$(".logPass").val('');
				}else if(result == "nologincode"){
					// $(".login-tip").css("color","red");
					$(".login-tip").html("登录账号不存在！请重试。");
				}else if(result == "pwderror"){
					// $(".login-tip").css("color","red");
					$(".login-tip").html("登录密码错误！请重试。");
				}else if("nodata" == result){
					$(".login-tip").css("color","red");
					$(".login-tip").html("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});
// 注册
$('.regBtn').click(function(){
	var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
	var mypass =/^\w{4,10}$/;
	var user = new Object();
	regPhone = $.trim($(".regPhone").val());
	regPass = $.trim($(".regPass").val());
	//前台的非空验证
	if(regPhone == "" || regPhone == "undefined" || regPhone == null || regPhone == "null"){
		$(".regPhone").focus;
		$(".regTip").css("color","red");
		$(".regTip").html("对不起，账号不能为空。");
	}else if(!myreg.test(regPhone)){
		$(".regTip").css("color","red");
		$(".regTip").html("对不起，请填写正确的手机号。");
	}else if(regPass == "" ||regPass == null){
		$(".regPass").focus;
		$(".regTip").css("color","red");
		$(".regTip").html("对不起，密码不能为空。");
	}else if(!mypass.test(regPass)){
		$(".regTip").css("color","red");
		$(".regTip").html("对不起，密码格式错误。");
	}else if($(".login-again input[type='checkbox']").is(':checked')){
		
	}
	else{
		$(".regTip").html("");
	}
})

