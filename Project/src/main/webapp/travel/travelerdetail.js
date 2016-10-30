function ajaxLoadRegistForm(no) {
	$.getJSON(serverAddr + "/travel/formDetail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
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

$("#addBtn").click(function(event) {
	$.getJSON(serverAddr + "/travel/formDetail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
	  var requestMember=result.data
	  inviteAdd(requestMember)
	   alert("동행추가되었습니다.")
	})
});
function inviteAdd(requestMember){
	$.post(serverAddr + "/travel/invadd.json" , requestMember,function(obj) {
		var result = obj.jsonResult
		console.log(requestMember)
		if (result.state != "success") {
	    	console.log(result.data)
	    return
	    }
		//if()
	 
	})
	console.log(requestMember)
	
}