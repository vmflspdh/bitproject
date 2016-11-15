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
		$("#detailMemberName").html(result.data.membername)
	})
}