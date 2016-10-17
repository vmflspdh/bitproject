$(document.body).on('click', '.selectAddBtn', function(event) {
	
  var lastrootschedule = $("#root-select form:eq(0)").clone();
  $("#root-select").append(lastrootschedule);
});

$(document.body).on('click', '.selectDelBtn', function(event) {
	var clickedRow = $(this).parent().parent();
	clickedRow.remove();

});

$("#addTMBtn").click(function(event) {
	
	var travelMain = {
			title: $("#title").val(),
			selfIntroduce: $("#selfIntroduce").val(),
			styleNo: $("input[name='chk_info']:checked").val()
	}
	console.log(travelMain.styleNo)
	

	
	var scheduleArray = [];
	$('.root-schedule').each(function(index, element) {
	
		var tag = $(element)
		
		scheduleArray[index] = {
			  
			  continent : tag.find('.bit-continent').val(),
				nation : tag.find('.bit-nation').val(),
				city : tag.find('.bit-city').val(),
				startDate1 : tag.find('.bit-startDate').val(),
				endDate1 : tag.find('.bit-endDate').val()
			};
		})
		
	//console.log(scheduleArray)
	var schedule = JSON.stringify(scheduleArray)
	console.log(schedule)
	travelMain.schedule = schedule;
	ajaxAddTravelMain(travelMain)
	

});



$("#updateTMBtn").click(function(event) {
	var travelMain = {
			memberNo: $("#userNo").val(),
			scheduleNo: $("#no").val(),
			travelMainNo: $("#travelNo").val(),
			locationNo: $("#locationNo").val(),
			title: $("#title").val(),
			selfIntroduce: $("#selfIntroduce").val(),
			startDate: $("#startDate").val(),
			endDate: $("#endDate").val(),
			continent: $("#continent option:selected").val(),
			nation: $("#nation option:selected").val(),
			city: $("#city option:selected").val(),
			styleNo: $("#styleName option:selected").val()
			
  }
  ajaxUpdateTravelMain(travelMain)
});

$("#deleteTMBtn").click(function(event) {
	var travelMain = {
			memberNo: $("#userNo").val(),
			scheduleNo: $("#no").val(),
			travelMainNo: $("#travelNo").val(),
			locationNo: $("#locationNo").val()
  }
  ajaxDeleteTravelMain(travelMain)
});

function ajaxAddTravelMain(travelMain) {
	$.post(serverAddr + "/travel/travelMainAdd.json", travelMain, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
	       console.log(result.data)
	       alert("등록 실패입니다.")
	       return
	      }
	      
	      window.location.href = "traveler.html"
	}, "json")
}

function ajaxLoadTravelMain(no) {
	$.getJSON(serverAddr + "/travel/formDetail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	    	console.log(result.data)
	    	alert("조회 실패 입니다.")
	    	return
	    }
	    $("#memberNo").val(result.data.memberNo);
	    $("#no").val(result.data.no);
	    $("#travelNo").val(result.data.travelMainNo);
	    $("#locationNo").val(result.data.locationNo);
	    $("#styleNo").val(result.data.styleNo);
	    $("#title").val(result.data.title);
	    $("#selfIntroduce").val(result.data.selfIntroduce);
	    $(".bit-startDate").val(result.data.startDate);
	    $(".bit-endDate").val(result.data.endDate);
	    $(".bit-continent").val(result.data.continent);
	    $(".bit-nation").val(result.data.nation);
	    $(".bit-city").val(result.data.city);
	    $("#styleName").val(result.data.styleNo);
	})
}

function ajaxUpdateTravelMain(travelMain) {
	$.post(serverAddr + "/travel/travelMainUpdate.json", travelMain, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
		       alert("변경 실패입니다.")
		       return
		      }
		      
		      window.location.href = "traveler.html"
	}, "json")
}
	
	
function ajaxDeleteTravelMain(travelMain) {
	$.getJSON(serverAddr + "/travel/travelMainDelete.json", travelMain, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	        console.log(result.state)
	        alert("삭제 실패 입니다.")
	        return
	      }
	      
	      location.href = "traveler.html"
	})
}



