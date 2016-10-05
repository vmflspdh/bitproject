$("#addBtn").click(function(event) {
	var qna = {
	no: $("#no").val(),
	title: $("#title").val(),
	  contents: $("#contents").val()
	}
	ajaxAddQna(qna)
});

$("#updateBtn").click(function(event) {
  var qna = {
	title: $("#title").val(),
	 contents: $("#contents").val(),
    qno: $("#qno").val()
  }
  ajaxUpdateQna(qna)
});

$("#deleteBtn").click(function(event) {
  ajaxDeleteQna(
		 $("#qno").val())
});


function ajaxAddQna(qna) {
	console.log(qna)
	$.post("qnaadd.json", qna, function(result) {
		if (result.state != "success") {
			console.log(result.data)
	    	 alert("등록 실패입니다.")
	    	 return
	    }
	    window.location.href = "qnaApp.html"
	}, "json")
}


function ajaxLoadQna(qno) {
	$.getJSON("qnadetail.json?qno=" + qno, function(result) {
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
	$("#qno").val(result.data.qno);
      $("#no").val(result.data.no);
      $("#title").val(result.data.title);
      $("#contents").val(result.data.contents);
      $("#createDate").val(result.data.createDate2);
      $("#viewCount").val( result.data.viewCount);
    })
}
   
function ajaxUpdateQna(qna) {
	$.post("qnaupdate.json", qna, function(result) {
		if (result.state != "success") {
			alert("변경 실패입니다.")
			return
		}
		window.location.href = "qnaApp.html"
	}, "json")
}

function ajaxDeleteQna(qno) {
	$.getJSON("qnadelete.json", {
		qno: qno
	}, function(result) {
		if (result.state != "success") {
			alert("삭제 실패입니다.")
			return
		}
		location.href = "qnaApp.html"
	})
}
