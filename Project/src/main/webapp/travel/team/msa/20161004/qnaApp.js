$("#loginBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});

$("#logoutBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});


function ajaxQnaList() {
	$.getJSON("list.json", function(result) {
		if (result.state != "success") {
	    	 alert("서버에서 데이터를 가져오는데 실패했습니다.")
	    	 return
	    }
		
		var content = ""
	    var arr = result.data
        for (var i in arr) {
          content += "<tr>" +
          	"<td>" + arr[i].qno + "</td>" + 
          	"<td>" + arr[i].no + "</td>" + 
          	"<td><a class='titleLink' href='#' data-qno='" + arr[i].qno + "'>" + arr[i].title + "</a></td>" +
            "<td>" + arr[i].content + "</td>" +
            "<td>" + arr[i].createDate + "</td>" + 
            "<td>" + arr[i].viewCount + "</td>" +
            "</tr>"
    }
    
	    $("#qnaTable tbody").html(content)
	    $(".titleLink").click(function(event) {
		    window.location.href = "qnaForm.html?qno=" + $(this).attr("data-qno")
	    })
    })
}

function ajaxLoginUser() {
	$.getJSON("../auth/loginUser.json", function(result) {
	    if (result.state != "success") { // 로그아웃 상태일 경우 로그인 상태와 관련된 태그를 감춘다.
	         $('.my-login').css("display", "none")
	         return
	    }
	      
	    $('.my-logout').css("display", "none")
	      
	 $("#userName").text(result.data.name);
    })
}

