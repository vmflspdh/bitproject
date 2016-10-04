$("#addBtn").click(function(event) {
	var qna = {
			no: $("#no").val(),
	title: $("#title").val(),
	  content: $("#content").val()
	}
	ajaxAddQna(qna)
});

$("#updateBtn").click(function(event) {
  var qna = {
	title: $("#title").val(),
	 content: $("#content").val(),
    qno: $("#qno").val()
  }
  ajaxUpdateQna(qna)
});

$("#deleteBtn").click(function(event) {
  ajaxDeleteQna(
		 $("#qno").val())
});


function ajaxAddQna(qna) {
	$.post("add.json", qna, function(result) {
		if (result.state != "success") {
			console.log(result.data)
	    	 alert("등록 실패입니다.")
	    	 return
	    }
	    window.location.href = "qnaApp.html"
	}, "json")
}


function ajaxLoadQna(qno) {
	$.getJSON("detail.json?qno=" + qno, function(result) {
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
	$("#qno").val(result.data.qno);
      $("#no").val(result.data.no);
      $("#title").val(result.data.title);
      $("#content").val(result.data.content);
      $("#createDate").val(result.data.createDate2);
      $("#viewCount").val( result.data.viewCount);
    })
}
   
function ajaxUpdateQna(qna) {
	$.post("update.json", qna, function(result) {
		if (result.state != "success") {
			alert("변경 실패입니다.")
			return
		}
		window.location.href = "qnaApp.html"
	}, "json")
}

function ajaxDeleteQna(qno, password) {
	$.getJSON("delete.json", {
		qno: qno
	}, function(result) {
		if (result.state != "success") {
			alert("삭제 실패입니다.")
			return
		}
		location.href = "qnaApp.html"
	})
}
