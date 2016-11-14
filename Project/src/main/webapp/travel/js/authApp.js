



$("#loginBtn").click(function(event) {

	var user = {
			email: $("#email").val(),
			password: $("#password").val(),
			saveEmail: $("#saveEmail").is(":checked")

	}
	console.log(user)
	ajaxLogin(user)

});



$("#logoutBtn").click(function(event) {
	ajaxLogout()
window.location.reload(true)
});




function ajaxLogin(user) {


	$.ajax({
		url: "login.json",
		method: "POST",
		dataType: "json",
		data: user,
		success: function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
				alert("로그인 실패입니다.\n이메일 또는 암호를 확인하세요")
				return;
			}
			window.location.reload(true) /*href = "travel.html"*/
		},
		error: function(msg) {
			alert(msg)
		}
	})
}


function ajaxLogout() {

	$.getJSON("logout.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success")
			console.log("로그아웃 실패입니다.")
			return;
	})
	FB.logout();
}

window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '1845325399037691',
	    cookie     : true,  // enable cookies to allow the server to access 
	    state      : true,             // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.5' // use graph api version 2.5
	  });

	  
	  FB.getLoginStatus(function(response) {
	    //statusChangeCallbackafter(response);
	  });

	};

function ajaxLoginUser() {

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
		$("#requestCountAll").text(result.data.memberRequest)
		console.log(result.data.memberRequest)
		
		if (result.data.memberPhoto == null) {
			$(".mainImg").attr("src",result.data.memberPhoto);
		} else {
		$(".mainImg").attr("src","../upload/" + result.data.memberPhoto);
		}
//		$("#detailUserImage").attr("src","../upload/" + result.data.memberPhoto);

		$("#myInfo").click(function(event) {
			ajaxLoginUser()

			window.location.href = "memb_regForm.html?no=" + result.data.no;
		});

	})

}








function init() {

	if (document.cookie != "") { 
		var cookieMap = bit.cookieToObject()
		console.log(cookieMap)

		//if (cookieMap["email"]) { // cookieMap 객체에 email 이름으로 저장된 값이 있는가?
		if ("email" in cookieMap) { // cookieMap 객체에 email 이라는 이름의 프로퍼티가 있는가?
			$("#email").val(cookieMap["email"])
			$("#saveEmail").attr("checked", true)
		}
	}

}


/* 페이지링크 영역*/

$("#travelerPage").click(function(event) {

	window.location.href = "mainhtml.html";
});

$("#reviewPage").click(function(event) {

	window.location.href = "reviewApp.html";
});

$("#qnaPage").click(function(event) {

	window.location.href = "qnaApp.html";
});

$("#travelerRegForm").click(function(event) {

	window.location.href = "travelerRegForm.html";
});

$("#travelerMessage").click(function(event) {

	window.location.href = "chatting.html";
});



