/*
$("#messageinviteBtn").click(function(event) {

	var message = {
			contents: $("#messageContents").val()
	}
	console.log(message)
	ajaxAddinviteMessage(message)
})*/

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
var memberLength = 4;
function chattingMemberList() {
	$.getJSON(serverAddr + "/travel/messageMemberList.json",{memberLength: memberLength}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			swal(
					'로그인 후 이용해 주세요!',
					'Please, use to after login!',
					'error'
			)
		       return
		}
		var contents = "";
	    var arr = result.data
	    if (arr == "") {
	    	contents = '<div class="chattingList"style="border:1px solid #A196A4;">받은 메세지가 없습니다.</div>'
	    } else {
	    for (var i in arr) {
	    	if (i == 0) {
	    		contents +=
	    			'<div class="chattingList" style="border:1px solid #A196A4;">최근 메세지 요청</div>'
	    	}
	    	contents += 
	    		'<a class="titleLink" href="#" data-sendMemberNo="' + arr[i].sendMemberNo + '">' +
	    		'<div class="chattingList">' +
	    		'<div style="width:45px; height:45px; overflow: hidden; display:inline-block; float: left;">'
	    		if (arr[i].myPhoto == null) {
	    			contents += '<img src="img/iconmonstr-user-20-240.png">'
	    		} else if (arr[i].myPhoto.substring(0,1) == 'h') {
	    			contents += '<img src="' + arr[i].myPhoto + '">'
	    		} else {
	    		    contents += '<img src="../upload/' + arr[i].myPhoto + '">'
	    		}
	    	contents +=
	    		'</div>' +
	    		'<div style="display:inline-block; float: left; font-weight: bold;">&nbsp;&nbsp;<span id="chattingName">' + arr[i].receiveUser + '</span></div>' +
	    		'<div style="max-width:200px; display:inline-block; color: gray; text-overflow: ellipsis; white-space:nowrap; overflow:hidden;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="chattingMessage">' + arr[i].contents + '</span></div>' +
	    		'<div id="sendDate" style="display:inline-block; float: right; font-size: small; color: gray">' + arr[i].sendDate + '</div>' +
	    		'</div>' +
	    		'</a>'
	    		if (i == arr.length-1 && i > 2) {
					contents += '<a class="debogimember" href="#" style="color:black"><div style="border: 1px solid #A196A4;margin:0 auto;width:400px;text-align:center;color:#736378;">더보기</div></a>'
				}
	      }
	    }
	    $(".chanchatting").html(contents)
	    var detailMessageNo = arr[0].sendMemberNo
	    loadDetailMessageList(detailMessageNo)
	    loadProfileInfo(arr[0].sendMemberNo)
	    $('#detailpageContents').css("display", "inherit")
	    $('#mainMessageBtn').css("display", "inherit")
	    $(".titleLink").click(function(event) {
	    	var detailMessageNo = $(this).attr("data-sendMemberNo")
	    	console.log(detailMessageNo)
	    	loadDetailMessageList(detailMessageNo)
	    	loadProfileInfo(detailMessageNo)
	        $('#detailpageContents').css("display", "inherit")
	        $('#mainMessageBtn').css("display", "inherit")
	    })
	    $(".debogimember").click(function(event) {
	    	memberLength += 4
			chattingMemberList()
		})
    })
}
var length = 7;
function loadDetailMessageList(detailMessageNo) {
	$.getJSON(serverAddr + "/travel/myMessageList.json", {no: detailMessageNo, length: length}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			swal(
					'로그인 후 이용해 주세요!',
					'Please, use to after login!',
					'error'
			)
		       return
		}
		var contents = "";
		var arr = result.data
		for (var i in arr) {
			if (arr[i].sendMemberNo != detailMessageNo) {
				if (i > 0 && arr[i - 1].sendMemberNo != detailMessageNo) {
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
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: right;">'
					if (arr[i].myPhoto == null) {
						contents += '<img src="img/iconmonstr-user-20-240.png"></div>'
					} else if (arr[i].myPhoto.substring(0,1) == 'h') {
		    			contents += '<img src="' + arr[i].myPhoto + '"></div>'
		    		} else {
		    		    contents += '<img src="../upload/' + arr[i].myPhoto + '"></div>'
		    		}
				contents +=
					'<div style="border:0px solid black; width: 280px; float: left; background-color: #F5F2F5; padding:10px; border-radius: 15px 15px 15px 15px;">' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>' +
					'</div>'
				}
			} else {
				if (i > 0 && arr[i - 1].sendMemberNo == detailMessageNo) {
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
					'<div style="width:50px; height:50px; border-radius: 25px 25px 25px 25px; overflow: hidden; float: left;">'
					if (arr[i].myPhoto == null) {
						contents += '<img src="img/iconmonstr-user-20-240.png"></div>'
					} else if (arr[i].myPhoto.substring(0,1) == 'h') {
		    			contents += '<img src="' + arr[i].myPhoto + '"></div>'
		    		} else {
		    		    contents += '<img src="../upload/' + arr[i].myPhoto + '"></div>'
		    		}
				contents +=
					'<div style="border:0px solid black; width:280px; float: right; background-color: #DCE6F2; padding:10px; border-radius: 15px 15px 15px 15px;">' +
					'<div>' + arr[i].contents + '</div>' +
					'<div style="font-size: x-small;">' + arr[i].sendDate + '</div>' +
					'</div>' +
					'</div><br>'
				}
			}
			if (i == arr.length-1 && i > 5) {
				contents += '<br><br><a class="debogilist" href="#" style="color:black"><div style="margin:0 auto;font-size:medium;width:380px;text-align:center;border-radius: 6px;background-color: #DDDDDD;color:black">더보기</div></a>'
			}
		}
		$(".chanchattingList").html(contents)
		$(".debogilist").click(function(event) {
			length += 7
			loadDetailMessageList(detailMessageNo)
		})
    })                  
}

function loadProfileInfo(detailMessageNo) {
	$.getJSON(serverAddr + "/travel/profiledetail.json", {no: detailMessageNo}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			swal(
					'로그인 후 이용해 주세요!',
					'Please, use to after login!',
					'error'
			)
		       return
		}
		var arr = result.data
			
		var contents = 
			'<div style="width:200px;">' +
			'<div style="width:200px; height:200px; border-radius: 50% 50% 50% 50%; overflow: hidden;">'
			if (arr[0].myPhoto == null) {
				contents += '<img src="img/iconmonstr-user-20-240.png" style="width:200px;">'
			} else if (arr[0].myPhoto.substring(0,1) == 'h') {
				contents += '<img src="' + arr[0].myPhoto + '" style="width:200px;">'
			} else {
				contents += '<img src="../upload/' + arr[0].myPhoto + '" style="width:200px;">'
			}
		contents +=
			'</div><br>' +
			'<div style="font-size: large; font-weight: bold;"><center>' + arr[0].receiveUser + '</center></div><br>' +
			'<div style="font-size: medium;"><center style="text-overflow: ellipsis; white-space:nowrap; overflow:hidden;">' + arr[0].contents + '</center></div><br>' +
			'<div style="font-size: medium;"><a class="travelMainLink" href="#" data-travelMainBoard=' + arr[0].travelMainNo + '><center>상세페이지로 이동</center></a></div>' +
			'</div>'
		  
		$(".chanProfile").html(contents)
		$(".travelMainLink").click(function(event) {
	    	var no = $(this).attr("data-travelMainBoard")
	    	if (no == 0) {
	    		swal(
						'등록한 글이 없습니다!',
						'',
						'error'
				)
	    	} else {
	    		checkToNo(no)
	    	}
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

/*function ajaxAddinviteMessage(message) {
	$.post(serverAddr + "/travel/messageAdd3.json", message, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("등록 실패입니다.")
			return
		}
		window.location.reload(true)

	}, "json")
}
*/