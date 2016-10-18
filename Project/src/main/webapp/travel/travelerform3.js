$(document.body).on('click', '.selectAddBtn', function(event) {

	var lastrootschedule = $(".root-select form:last")

	lastrootschedule.after(
			lastrootschedule.clone()
			.find(".select").attr("selected value", "").end()
			.find(".bit-startDate").val("").end()
			.find(".bit-endDate").val("").end()
	);

	var clickedRow = $(this).parent().index();
	console.log(clickedRow)
	
	$(".root-select form:last").append(lastrootschedule);
	/*console.log($("#root-select").eq(clickedRow));
	$("#root-select").eq(clickedRow).append(lastrootschedule);*/
	

	var tags = $(".bit-startDate",".bit-endDate")
	.removeClass('hasDatepicker')
	.datepicker({dateFormat: 'yyyy-mm-dd'});
});

$(document.body).on('click', '.selectDelBtn', function(event) {
	var clickedRow = $(this).parent().index();

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
	$('.root-select').each(function(index, element) {

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
		$("#travelNo").val(result.data.travelMainNo);
		$("#styleNo").val(result.data.styleNo);
		$("#selfIntroduce").val(result.data.selfIntroduce);
		$("#styleName").val(result.data.styleNo);
		scheduleList()
		
	/*	var template = Handlebars.compile($('#trTemplateText').html())
	    $("#travelerTable .root-select").html(template(result))*/
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


function scheduleList() {
	$.getJSON(serverAddr + "/travel/scheduleList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		var contents = "";
	    var arr = result.data
	    for (var i in arr) {
	    	contents += '<tr>' +
	    	'<td><img src="' + arr[i].myPhoto + '" width="350" ></td>' +
	    	"<td><a class='titleLink' href='#' data-memno='" + arr[i].memberNo + "' data-no='" + arr[i].no + "'>" + "<h3>" + arr[i].title + "</h3></a></br>" +
	    	 arr[i].writer + '</br>' +
	    	'<img src="img/yang/11101_s.gif">' + arr[i].city + ',' + arr[i].nation + ',' + arr[i].continent + '</br>' +
	    	'<img src="img/yang/2.jpg" width=14px;><a href="#"> 99</a>' +
	    	'<img src="img/yang/20.jpg"width=14px;><a href="#"> 0 </a>' +
	    	'<img src="img/yang/24.jpg"width=14px;><a href="#"> 0 </a></td>' +
	    	'</tr>'
	      }
	    <td style="color: green; font-weight: bold; font-size: large;">
	     <div>가고싶은</div>
	     <div>여행지</div>
	    </td>
	    <td id="root-select">
	    <form class="form-inline root-schedule" onsubmit="return false">
	    <select style="width:100px;" class="form-control bit-continent">
	       <option selected value="">대륙</option>
	       <option value="아시아">아시아</option>
	       <option value="유럽">유럽</option>
	       <option value="북아메리카">북아메리카</option>
	   </select>
	   <select style="width:100px;" class="form-control bit-nation">
	       <option selected value="">국가</option>
	       <option value="대한민국">대한민국</option>
	       <option value="일본">일본</option>
	       <option value="영국">영국</option>
	   </select>
	   <select style="width:100px;" class="form-control bit-city">
	       <option selected value="">도시</option>
	       <option value="서울">서울</option>
	       <option value="부산">부산</option>
	       <option value="도쿄">도쿄</option>
	   </select>
	   <input type="text" placeholder="시작일" style="width:100px;" class="form-control bit-startDate">
	   <input type="text" placeholder="종료일" style="width:100px;" class="form-control bit-endDate">
	     <button class="btn btn-default selectAddBtn">+</button>
	     <button class="btn btn-default selectDelBtn">-</button>
	   </form>
	   </td>
	   
	   
	    $("#boardTable tbody").html(contents)
	    $(".titleLink").click(function(event) {
	    })
    })
}
