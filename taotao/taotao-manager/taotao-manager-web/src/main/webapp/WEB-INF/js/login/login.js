// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}
    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				var username=$('#username').val();
                var password=$('#password').val();
				if(username== ''){
					show_err_msg('用户名还没填呢！');
					$('#username').focus();
				}else  if(password==''){
					show_err_msg('密码还没填呢！');
					$('#password').focus();
				}else{
                    $.ajax({
                        url:basePath+'/login/do',
                        type:'POST', //GET
                        async:false,    //或false,是否异步
                        data:{
                            username:username,
                            password:password
                        },
                        timeout:5000,    //超时时间
                        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                        success:function(data){
                            console.log(data);
                            if(data.status=="success"){
                                show_msg('登录成功咯！  正在为您跳转...',basePath+'/index');
                            }
                            if(data.status=="error"){
                                show_err_msg('用户名或密码错误！');
                            }
                        },
                        error:function(){
                            show_err_msg('系统异常请重试！');
                        },

                    });

                }
			});
		});