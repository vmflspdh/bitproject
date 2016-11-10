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
											'<span>18 Nov</span>'+
				'</div>'+
				'<div class="content-perspective">'+
					'<div class="content">'+
						'<div class="content-inner">'+
							'<h5>'+
								'서울 &nbsp;/ &nbsp;대한민국 <br> <i'+
									'class="fa fa-calendar fa-fw w3"></i>'+arr[i].startDate+' ~ '+arr[i].endDate+''+
							'</h5>'+
							'<p>'+arr[i].content+''+
								
							'</p>'+
						'</div>'+
					'</div>'+
				'</div>'+
				'<hr>'+
				'</li>'

		}
		//html 원래 위치
		$(".timeline").html(contents);
	})
}