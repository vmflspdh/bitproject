$("#loginBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});

$("#logoutBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});


function ajaxQnaList() {
	$.getJSON("qnalist.json", function(result) {
		if (result.state != "success") {
	    	 alert("서버에서 데이터를 가져오는데 실패했습니다.")
	    	 return
	    }
		
		var contents = ""
	    var arr = result.data
        for (var i in arr) {
          contents += "<tr>" +
          	"<td>" + arr[i].qno + "</td>" + 
          	"<td>" + arr[i].no + "</td>" + 
          	"<td><a class='titleLink' href='#' data-qno='" + arr[i].qno + "'>" + arr[i].title + "</a></td>" +
            "<td>" + arr[i].contents + "</td>" +
            "<td>" + arr[i].createDate + "</td>" + 
            "<td>" + arr[i].viewCount + "</td>" +
            "</tr>"
    }
    
	    $("#qnaTable tbody").html(contents)
	    $(".titleLink").click(function(event) {
		    window.location.href = "qnaForm.html?qno=" + $(this).attr("data-qno")
	    })
    })
}


