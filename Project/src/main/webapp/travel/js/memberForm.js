$(document).ready(function() {
      $(".col-sm-10 > #email").keyup(function() {
                if ($(".col-sm-10 > #email").val().length > 6) {
                  var email = $(this).val();
                  // ajax 실행
                  $.ajax({
                        type : 'POST',
                        dataType : "json",
                        url : "http://52.78.227.107:8000/Project/travel/emailCheck.json",
                        crossDomain : true,
                        data : {
                          email : email
                        },
                        success : function(
                            obj) {
                          if (obj.state == "success") {
                            $(".col-sm-10 > #emailCheckMsg").html('<p style="color:blue;">사용 가능한 이메일 입니다.</p>');
                          } else {
                            $(".col-sm-10 > #emailCheckMsg").html('<p style="color:red;">사용 불가능한 이메일 입니다.</p>');
                          }
                        }
                      }); // end ajax
                } else {
                  $(".col-sm-10 > #emailCheckMsg")
                      .text("");
                }
              }); // end keyup
    });

$("#signInBtn").click(function(event) {

	var member = {
			name: $("#name").val(),
			email: $(".col-sm-10 > #email").val(),
			password: $(".col-sm-10 > #password").val(),
			birthday: $("#birthday").val(),
			gender: $("#gender").val()

	}
	console.log(member)
	ajaxAddMember(member)

});



$("#updateBtn").click(function(event) {

	var formData = new FormData();
	formData.append("no", $("#bit-no").val());
	formData.append("name", $("#bit-name").val());
	formData.append("email", $("#bit-email").val());
	formData.append("password", $("#bit-password").val());
	formData.append("birthday", $("#bit-birthday").val());
	formData.append("file", $("input[name=file]")[0].files[0]);
	

	var member = {
			name: $("#bit-name").val(),
			email: $("#bit-email").val(),
			password: $("#bit-password").val(),
			birthday: $("#bit-birthday").val(),
			gender: $("#bit-gender").val(),
			registedDate: $("#registedDate").val(),
			no: $("#bit-no").val()
	}
	
	var user = {
			email: $("#bit-email").val(),
			password: $("#bit-password").val()

	}

	console.log(member)
	ajaxUpdateMember(formData)
	
});



function ajaxLogin2(user) {


	$.ajax({
		url: "login.json",
		method: "POST",
		dataType: "json",
		data: user,
		success: function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
								swal(
						  'Please check your email or password.',
						  'Something went wrong!',
						  'error'
						)
				return;
			}
			window.location.reload(true) /*href = "travel.html"*/
		},
		error: function(msg) {
			alert(msg)
		}
	})
}

$("#deleteBtn").click(function(event) {

	ajaxDeleteMember($("#no").val(),
			$("#password").val())
});

function ajaxAddMember(member) {

	$.post("add.json", member, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			swal(
				  '등록 실패.',
				  'Something went wrong!',
				  'error'
				)
			return;
		} else if (result.state == "success") {
			swal(
					  '등록 성공!',
					  'sign in success!',
					  'success'
					)
					window.location.reload(true)
		}

	}, "json")
}

function ajaxLoadMember(no) {

	$.getJSON("detail.json?no="+ no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("조회 실패입니다.")
			return;
		}

		$("#bit-no").val(result.data.no);
		$("#bit-name").val(result.data.name);
		$("#bit-email").val(result.data.email);
		$("#bit-birthday").val(result.data.birthday);

		if (result.data.gender == "1") {
			$("#bit-gender").val("여");
		} else {
			$("#bit-gender").val("남");
		}
		$("#bit-registedDate").val(result.data.registedDate);
		$("#memberPhoto").text(result.data.memberPhoto);
	})
}

function ajaxUpdateMember(formData) {
	console.log(formData)
	/*console.log(formData.get("password")=="")
	if(formData.get("password")==""){
		swal(
				  'Please enter your password.',
				  'Something went wrong!',
				  'error'
				)
	}*/

	$.ajax({
		url : "update.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(obj) {
			var result = obj.jsonResult
			if(formData.get("password")==""){
				swal(
						  'Please enter your Password.',
						  'Something went wrong!',
						  'error'
						)
						return
			}
			else if (result.state != "success") {
				console.log(result.data)
				swal(
				  '변경 실패.',
				  'Something went wrong!',
				  'error'
				)
				return
			}
			else if (result.state == "success") {
				console.log(result.data)
				swal(
					  '변경 성공!',
					  'You clicked the button!',
					  'success'
					)
					window.location.reload(true)
			}
		}
	});

	/*	$.post("update.json", member, function(obj) {
		var result = obj.jsonResult
		console.log(member)
		if (result.state != "success") {
			console.log(result.data)
			alert("변경 실패입니다.")
			return
		}
		window.location.reload(true)
	}, "json")*/
}


function ajaxDeleteMember(no, password) {

	$.getJSON("delete.json", {
		no: no, 
		password: password
	}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("삭제 실패입니다.")
			return
		}
		window.location.href = "memberApp.html"
	})

}

/*페이스북*/
function statusChangeCallback(response) {
	console.log('statusChangeCallback');
	console.log(response);
	if (response.status === 'connected') {
		getFacebookInfo();
	} else if (response.status === 'not_authorized') {
		document.getElementById('status').innerHTML = 'Please log ' +
		'into this app.';
	} else {
		document.getElementById('status').innerHTML = 'Please log ' +
		'into Facebook.';
	}
}

function checkLoginState() {
	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});
}


//Load the SDK asynchronously
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s); js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

//Here we run a very simple test of the Graph API after login is
//successful.  See statusChangeCallback() for when this call is made.




function getFacebookInfo() {
	FB.api('/me?fields=email,id,name,gender,birthday,picture.width(200).height(200).as(picture_small)', function(response) {
		console.log(JSON.stringify(response));
		var member = {
				name:response.name,
				email:response.email,
				password:response.id,
				gender: (response.gender == 'male' ? 0 : 1),
				memberPhoto: response.picture_small.data.url
		}
		console.log(member)
		ajaxAddFacebookMember(member)
	});
}

function ajaxAddFacebookMember(member) {

	$.post("add.json", member, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			ajaxFacebookLogin(member)
			window.location.reload(true)
			return
		}
		ajaxFacebookLogin(member)
		window.location.reload(true)
	}, "json")
}

function ajaxFacebookLogin(member) {
	$.ajax({
		url: "login.json",
		method: "POST",
		dataType: "json",
		data: member,
		success: function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
				return
			}
		},
		error: function(msg) {
			alert(msg)
		}
	})
}

function ajaxFacebookLoginUser() {

	$.getJSON("loginUser.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			$('.my-login').css("display", "none")
			console.log(result.data)
			return
		} else {
			$('.my-logout').css("display", "none")
		}

		$("#userName5").text(result.data.name)
		$('.aaa').css("display", "none")
		$("#userName").text(result.data.name)
		$("#userNo").val(result.data.no)
		$("#bbb").val(result.data.no)
		$("#userName").val(result.data.name)
		$("#userName2").val(result.data.name)
		$("#userName3").val(result.data.name)
		$("#inviteCount").text(result.data.memberRequest)
		console.log(result.data.memberRequest)



		$(".mainImg").attr("src",result.data.memberPhoto);

		$("#myInfo").click(function(event) {
			ajaxLoginUser()

			window.location.href = "memb_regForm.html?no=" + result.data.no;
		});

	})

}
/*페이스북*/