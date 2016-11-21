var reviewContent=[];
$("#reviewContentUpdateBtn").click (function(event){
	$.getJSON(serverAddr + "/travel/rvclist.json?no=" + no, function(result) {
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
		var contents="";
		var arr = result.data
		for ( var i in arr) {
			reviewContent.push(arr[i])
			contents += 
				'<li class="event"><input type="radio" name="tl-group" /> <label></label>'+
				'<div class="thumb user-2">'+
				'<img width=100% height=100% src="../upload/'+arr[i].reviewBoardContentPhotoName+'" alt="...">'+
				'</div>'+
				'<div class="content-perspective">'+
					'<div class="content">'+
						'<div class="content-inner">'+
							'<h5>'+
								''+arr[i].city+' &nbsp;/ &nbsp;'+arr[i].nation+ '<br>'+
									'<i class="fa fa-calendar fa-fw w3"></i>'+arr[i].startDate2+' ~ '+arr[i].endDate2+''+
							'</h5>'+
							'<input id="contentInput'+i+'" value="'+arr[i].content+'">'+
							'<input  name="file" id="file'+i+'" type="file">'+
						'</div>'+
					'</div>'+
				'</div>'+
				'<hr>'+
				'</li>'
				
		}
		// html 원래 위치
		$(".timeline").html(contents);
	})
	
});

$("#reviewContentDeleteBtn").click (function(event){
	$.post(serverAddr + "/travel/rvdelete.json?no="+no,{no:no}, function(result) {
		if (result.state != "success") {
			swal(
					  '삭제 실패.',
					  'Something went wrong!',
					  'error'
					)
			return
		} else{
		console.log(no)
		swal(
					  '삭제 성공!',
					  'You clicked the button!',
					  'success'
					)
		}
		location.href = "reviewApp.html"
	});
});




$("#reviewContentConfirmBtn").click (function(event){
	//console.log(reviewContent);
	var formData = new FormData();
	
	for(var j=0; j<reviewContent.length;j++){
		console.log(j)
		no=reviewContent[j].reviewBoardContentNo;
		content=$("#contentInput"+j+"").val()
		console.log(no)
		console.log(content)
		$($("#file"+j+"")[0].files).each(function(index, file) {
		console.log(index)
		console.log(file)
	formData.append("files", file); 
	});
		formData.append("reviewBoardContentNo", no);
		formData.append("content", content);
		
		
		console.log(formData)
		reviewUpdate(formData,no)
		formData.delete("reviewBoardContentNo");
		formData.delete("content");
		formData.delete("files");
	}
	window.location.reload(true);
});

function reviewUpdate(formData,no){
	$.ajax({
		url : "rvcupdate.json?no="+no,
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(result) {
			if (result.state != "success") {
				console.log(result.data)
				console.log(result.state)
//				alert("변경 실패입니다.")
				return
			}
		//window.location.href = "travelreviewApp.html";
		}
	});
}

function reviewPhotoUpdate(formData,no){
	$.ajax({
		url : "rvcupdate.json?no="+no,
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(result) {
			if (result.state != "success") {
				console.log(result.data)
				console.log(result.state)
				alert("변경 실패입니다.")
				return
			}
		//window.location.href = "travelreviewApp.html";
		}
	});
}

function ajaxReviewContentList(no) {
	console.log(no)
	$.getJSON(serverAddr + "/travel/rvclist.json?no=" + no, function(result) {
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
		var contents="";
		var arr = result.data
		for ( var i in arr) {
			/*if (arr[i].reviewBoardContentPhotoName == null) {
				arr[i].reviewBoardContentPhotoName = "1.jpg"
			} */
		
			contents += 
				'<li class="event"><input type="radio" name="tl-group" /> <label></label>'+
				'<div class="thumb user-2">'+
				'<img width=100% height=100% src="../upload/'+ arr[i].reviewBoardContentPhotoName+'" alt="...">'+
				'</div>'+
				'<div class="content-perspective">'+
					'<div class="content">'+
						'<div class="content-inner">'+
							'<h5>'+
								''+arr[i].city+' &nbsp;/ &nbsp;'+arr[i].nation+ '<br>'+
									'<i class="fa fa-calendar fa-fw w3"></i>'+arr[i].startDate2+' ~ '+arr[i].endDate2+''+
							'</h5>'+
							'<p>'+arr[i].content+''+
								
							'</p>'+
						'</div>'+
					'</div>'+
				'</div>'+
				'<hr>'+
				'</li>'
		}
		// html 원래 위치
		$(".timeline").html(contents);
	})
	//console.log(aaabb.length);
	reviewPhotoList()
}

function reviewPhotoList() {
	$.getJSON(serverAddr + "/travel/reviewPhotoList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
	});
}





function ajaxReviewTitleList(no) {
	console.log(no)
	$.getJSON(serverAddr + "/travel/rvdetail.json?no=" + no, function(result) {
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
		// html 원래 위치
		$("#reviewtitle").html(result.data.title);
		$("#reviewcontent").html(result.data.content);
		$("#detailMemberName").html(result.data.membername)
	})
}