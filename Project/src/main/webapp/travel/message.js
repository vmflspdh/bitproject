
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
	    		'<img src="../upload/' + arr[i].myPhoto + '">' +
	    		'</div>' +
	    		'<div style="display:inline-block; float: left; font-weight: bold;">&nbsp;&nbsp;<span id="chattingName">' + arr[i].receiveUser + '</span></div>' +
	    		'<div style="display:inline-block; color: gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="chattingMessage">' + arr[i].contents + '</span></div>' +
	    		'<div id="sendDate" style="display:inline-block; float: right; font-size: small; color: gray">' + arr[i].sendDate + '</div>' +
	    		'</div>' +
	    		'</a>'
	      }
	    }
	    $(".chanchatting").html(contents)
	    loadDetailMessageList(arr[0].sendMemberNo)
	    loadProfileInfo(arr[0].sendMemberNo)
	    $('#detailpageContents').css("display", "inherit")
	    $('#mainMessageBtn').css("display", "inherit")
	    $(".titleLink").click(function(event) {
	    	var no = $(this).attr("data-sendMemberNo")
	    	loadDetailMessageList(no)
	    	loadProfileInfo(no)
	        $('#detailpageContents').css("display", "inherit")
	        $('#mainMessageBtn').css("display", "inherit")
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
			if (arr[i].sendMemberNo != no) {
				if (i > 0 && arr[i - 1].sendMemberNo != no) {
					contents +=
						'<div class="chattingDetail">' +
						'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: right;">' +
						'</div>' +
						'<div style="border:0px solid black; width: 280px; float: left; background-color: #F5F2F5; padding:10px; border-radius: 15px 15px 15px 15px;">' +
						'<div>' + arr[i].contents + '</div>' +
						'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
						'</div>' +
						'</div>'
				} else {
				contents +=
					'<div class="chattingDetail">' +
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: right;">' +
					'<img src="../upload/' + arr[i].myPhoto + '" ></div>' +
					'<div style="border:0px solid black; width: 280px; float: left; background-color: #F5F2F5; padding:10px; border-radius: 15px 15px 15px 15px;">' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>' +
					'</div>'
				}
			} else {
				if (i > 0 && arr[i - 1].sendMemberNo == no) {
					contents +=
						'<div class="chattingDetail">' +
						'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: left;">' +
						'</div>' +
						'<div style="border:0px solid black; width:280px; float: right; background-color: #DCE6F2; padding:10px; border-radius: 15px 15px 15px 15px;">' +
						'<div>' + arr[i].contents + '</div>' +
						'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
						'</div>' +
						'</div>'
				} else {
				contents +=
					'<div class="chattingDetail">' +
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: left;">' +
					'<img src="../upload/' + arr[i].myPhoto + '" ></div>' +
					'<div style="border:0px solid black; width:280px; float: right; background-color: #DCE6F2; padding:10px; border-radius: 15px 15px 15px 15px;">' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>' +
					'</div><br>'
				}
			}
		}
		$(".chanchattingList").html(contents)
		
    })                  
}

function loadProfileInfo(no) {
	$.getJSON(serverAddr + "/travel/profiledetail.json", {no: no}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		var arr = result.data
		var contents = 
			'<div style="width:200px;">' +
			'<div style="width:200px; height:200px; border-radius: 50% 50% 50% 50%; overflow: hidden;">' +
			'<img src="../upload/' + arr[0].myPhoto + '" style="width:200px;">' +
			'</div><br>' +
			'<div style="font-size: large; font-weight: bold;"><center>' + arr[0].receiveUser + '</center></div><br>' +
			'<div style="font-size: medium;"><center>' + arr[0].contents + '</center></div><br>' +
			'<div style="font-size: medium;"><a class="travelMainLink" href="#" data-travelMainBoard=' + arr[0].schduleNo + '><center>상세페이지로 이동</center></a></div>' +
			'</div>'
		  
		$(".chanProfile").html(contents)
		$(".travelMainLink").click(function(event) {
	    	var no = $(this).attr("data-travelMainBoard")
	    	checkToNo(no)
	    })
    })                  
}

function checkToNo(no) {
	$.getJSON(serverAddr + "/travel/formMyList.json", {no: no}, function(obj) {
		var result = obj.jsonResult
		
		window.location.href = "newdetail.html?no=" + no
    })                  
}

function ajaxAddMessage(message) {
	$.post(serverAddr + "/travel/messageAdd2.json", message, function(obj){
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
