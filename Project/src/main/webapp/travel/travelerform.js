$("#addBtn").click(function(event) {
	var travelMain = {
			memberNo: $("#userNo").val(),
			title: $("#title").val(),
			selfIntroduce: $("#selfIntroduce").val(),
			startDate: $("#startDate").val(),
			endDate: $("#endDate").val(),
			continent: $("#continent option:selected").val(),
			nation: $("#nation option:selected").val(),
			city: $("#city option:selected").val(),
			styleNo: $("#styleName option:selected").val()
	}
	ajaxAddTravelMain(travelMain)
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

function ajaxAddTravelMain(travelMain) {
	$.post(serverAddr + "/travel/formAdd.json", travelMain, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
	       console.log(result.data)
	       alert("등록 실패입니다.")
	       return
	      }
	      
	      window.location.href = "traveler.html"
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
	$.post("formUpdate.json", board, function(result) {
		if (result.state != "success") {
		       alert("변경 실패입니다.")
		       return
		      }
		      
		      window.location.href = "boardApp.html"
	}, "json")
}
	
	
function ajaxDeleteBoard(no, password) {
	$.getJSON("formDelete.json", {
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