
$("#messageBtn").click(function(event) {

	var message = {
			contents: $("#messageContents").val()
	}
	console.log(message)
	ajaxAddMessage(message)
})

$("#mainMessageBtn").click(function(event) {

	var message = {
			contents: $("#detailpageContents").val()
	}
	console.log(message)
	ajaxAddChattingMessage(message)
})

function chattingMemberList() {
	$.getJSON(serverAddr + "/travel/messageMemberList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		var contents = "";
	    var arr = result.data
	    if (arr == "") {
	    	contents = '<div class="chattingList">받은 메세지가 없습니다.</div>'
	    } else {
	    for (var i in arr) {
	    	if (i == 0) {
	    		contents +=
	    			'<div class="chattingList">최근 메세지 요청</div>'
	    	}
	    	contents += 
	    		'<a class="titleLink" href="#" data-sendMemberNo="' + arr[i].sendMemberNo + '">' +
	    		'<div class="chattingList">' +
	    		'<div style="width:45px; height:45px; overflow: hidden; display:inline-block; float: left;">' +
	    		'<img src="' + arr[i].myPhoto + '">' +
	    		'</div>' +
	    		'<div style="display:inline-block; float: left; font-weight: bold;">&nbsp;&nbsp;<span id="chattingName">' + arr[i].receiveUser + '</span></div>' +
	    		'<div style="display:inline-block; color: gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="chattingMessage">' + arr[i].contents + '</span></div>' +
	    		'<div id="sendDate" style="display:inline-block; float: right; font-size: small; color: gray">' + arr[i].sendDate + '</div>' +
	    		'</div>' +
	    		'</a>'
	      }
	    }
	    $(".chanchatting").html(contents)
	    $(".titleLink").click(function(event) {
	    	var no = $(this).attr("data-sendMemberNo")
	    	loadDetailMessageList(no)
	    })
    })
}

function loadDetailMessageList(no) {
	$.getJSON(serverAddr + "/travel/myMessageList.json", {no: no}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		var contents = "";
		var arr = result.data
		for (var i in arr) {
			if (arr[i].sendMemberNo == no) {
				contents +=
					'<div class="chattingDetail">' +
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: left;">' +
					'<img src="' + arr[i].myPhoto + '"></div>' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>'
			} else {
				contents +=
					'<div class="chattingDetail" style="background-color: white;">' +
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: right;">' +
					'<img src="' + arr[i].myPhoto + '"></div>' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>'
			}
/*			if (i == arr.length - 1) {
				contents +=
					'<textarea id="detailpageContents" cols="50" rows="3" style="width: 400px;" placeholder="내용을 입력하세요"></textarea>' +
					'<button id="mainMessageBtn" style="float:right;">입력</button>'
			}*/
		}
		$(".chanchattingList").html(contents)
    })                  
}

function ajaxAddMessage(message) {
	$.post(serverAddr + "/travel/messageAdd.json", message, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("등록 실패입니다.")
			return
		}
		

		window.location.reload(true)
	}, "json")
}

function ajaxAddChattingMessage(message) {
	$.post(serverAddr + "/travel/messageAdd.json", message, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("등록 실패입니다.")
			return
		}
		window.location.reload(true)

	}, "json")
}
