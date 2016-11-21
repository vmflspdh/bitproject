$(".reviewBtn").click (function(event){
	
		
	
	window.location.href = "travelreviewForm.html";
});




function ajaxLoadRegistForm(no) {
	$.getJSON(serverAddr + "/travel/formDetail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
		$("#title").text(result.data.title);
	    $("#selfIntroduce").text(result.data.selfIntroduce);
	    $("#styleName").text(result.data.styleName);
	})
}

$("#togetherRequest").click(function(event) {
	console.log(no)
	$.getJSON(serverAddr + "/travel/formDetail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	    	console.log(result.data)
	    	return
	    }
	  var requestMember=result.data
	  inviteAdd(requestMember)
	})
	
});
function inviteAdd(requestMember){
	console.log(requestMember.memberNo)
	console.log(requestMember.travelMainNo)
	requestMemberNo=requestMember.memberNo
	requesetMemberTravelMainNo=requestMember.travelMainNo
	$.post(serverAddr + "/travel/invadd.json" , 
			{no:requestMemberNo,no2:requesetMemberTravelMainNo},
		function(result) {
		//var result = obj.jsonResult
		console.log(requestMember)
		if (result.state == "exist") {
			swal(
					  '이미 요청한 회원입니다.',
					  'Something went wrong!',
					  'error'
					)
	    return
	    }
		if (result.state == "success") {
			swal(
					  '동행 요청 성공!',
					  'You clicked the button!',
					  'success'
					)
	    return
	    }
		//alert("동행추가되었습니다.")
		//if()
	 
	})
	console.log(requestMember)
	
}