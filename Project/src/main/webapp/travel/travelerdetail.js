$("#addBtn").click(function(event) {
	var board = {
			title: $("#title").val(),
			contents: $("#contents").val(),
			password: $("#password").val()
	}
	ajaxAddBoard(board)
});

$("#updateBtn").click(function(event) {
  var board = {
      title: $("#title").val(),
      contents: $("#contents").val(),
      password: $("#password").val(),
      no: $("#no").val()
  }
  ajaxUpdateBoard(board)
});

$("#deleteBtn").click(function(event) {
  ajaxDeleteBoard(
		  $("#no").val(),
		  $("#password").val())
});

function ajaxAddBoard(board) {
	$.post("add.json", board, function(result){
		if (result.state != "success") {
	       console.log(result.data)
	       alert("등록 실패입니다.")
	       return
	      }
	      
	      window.location.href = "boardApp.html"
	}, "json")
}

function ajaxLoadRegistForm(no) {
	$.getJSON("formDetail.json?no=" + no, function(result) {
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
	    $("#selfIntroduce").text(result.data.selfIntroduce);
	    $("#styleName").text(result.data.styleName);
	    $("#city").text(result.data.city);
	    $("#nation").text(result.data.nation);
	    $("#startDate").text(result.data.startDate);
	    $("#endDate").text(result.data.endDate);
	})
}

function ajaxUpdateBoard(board) {
	$.post("update.json", board, function(result) {
		if (result.state != "success") {
		       alert("변경 실패입니다.")
		       return
		      }
		      
		      window.location.href = "boardApp.html"
	}, "json")
}
	
	
function ajaxDeleteBoard(no, password) {
	$.getJSON("delete.json", {
		no: no,
		password: password 
	 }, function(result) {
		if (result.state != "success") {
	        console.log(result.state)
	        alert("삭제 실패 입니다.")
	        return
	      }
	      
	      location.href = "boardApp.html"
	})
}