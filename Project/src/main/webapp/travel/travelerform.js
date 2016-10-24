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

	$(".root-select").append(lastrootschedule);
	/*console.log($("#root-select").eq(clickedRow));
	$("#root-select").eq(clickedRow).append(lastrootschedule);*/


	var tags = $(".bit-startDate",".bit-endDate")
	.removeClass('hasDatepicker')
	.datepicker({dateFormat: 'yyyy-mm-dd'});
});

$(document.body).on('click', '.selectDelBtn', function(event) {
	var clickedRow = $(this).parent();

	clickedRow.remove();
});

$("#addTMBtn").click(function(event) {

	var travelMain = {
			title: $("#title").val(),
			selfIntroduce: $("#selfIntroduce").val(),
			styleNo: $("input[name='chk_info']:checked").val()
	}
	console.log(travelMain)



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
			/*scheduleNo: $("#no").val(),*/
			travelMainNo: $("#travelNo").val(),
			/*	locationNo: $("#locationNo").val(),*/
			title: $("#title").val(),
			selfIntroduce: $("#selfIntroduce").val(),
			styleNo: $("input[name='chk_info']:checked").val()
	}

	console.log(travelMain)

	var scheduleArray = [];
	$('.root-schedule').each(function(index, element) {

		var tag = $(element)

		scheduleArray[index] = {

			travelMainNo: $("#travelNo").val(),
			locationNo : tag.find(".bit-locationNo").val(),
			continent: tag.find(".bit-continent option:selected").val(),
			nation: tag.find(".bit-nation option:selected").val(),
			city: tag.find(".bit-city option:selected").val(),
			scheduleNo : tag.find(".bit-scheduleNo").val(),
			startDate1: tag.find(".bit-startDate").val(),
			endDate1: tag.find(".bit-endDate").val(),
			lat : tag.find(".bit-latitude").val(),
			lng : tag.find(".bit-longitude").val()

		};
	})
	var schedule = JSON.stringify(scheduleArray)
	console.log(schedule)
	travelMain.schedule = schedule;

	/*ajaxUpdateTravelMain(travelMain)*/
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
		$("#no").val(result.data.no);
		$("#memberNo").val(result.data.memberNo);
		$("#title").val(result.data.title);
		$("#travelNo").val(result.data.travelMainNo);
		$("#styleNo").val(result.data.styleNo);
		$("#selfIntroduce").val(result.data.selfIntroduce);
		$("#styleName").val(result.data.styleNo);

		favorChecked(result)
		scheduleList()


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
		/*		var contents = "";
		var arr = result.data
		for (var i in arr) {

			contents += '<td style="color: green; font-weight: bold; font-size: large;">' +
	     '<div>가고싶은</div>' + 
	     '<div>여행지</div>' +
	    '</td>' +
				 '<td id="root-select">' +
				'<form class="form-inline root-schedule" onsubmit="return false">' +
				'<input type="text" class="form-control bit-locationNo" style="display: none;" value="' + arr[i].locationNo + '">' +
				'<select style="width:100px;" class="form-control bit-continent">' +
				'<option selected value="'+ arr[i].continent + '">'+ arr[i].continent + '</option>' +
				'<option value="아시아">아시아</option>' +
				'<option value="유럽">유럽</option>' +
				'<option value="북아메리카">북아메리카</option>' +
				'</select>' +
				'<select style="width:100px;" class="form-control bit-nation">' +
				'<option selected value="'+ arr[i].nation + '">'+ arr[i].nation + '</option>' +
				'<option value="대한민국">대한민국</option>' +
				'<option value="일본">일본</option>' +
				' <option value="영국">영국</option>' +
				'</select>' +
				'<select style="width:100px;" class="form-control bit-city">' +
				'<option selected value="'+ arr[i].city + '">'+ arr[i].city + '</option>' +
				'<option value="서울">서울</option>' +
				'<option value="부산">부산</option>' +
				'<option value="도쿄">도쿄</option>' +
				'</select>' +
				'<input type="text" class="form-control bit-scheduleNo" style="display: none;" value="' + arr[i].scheduleNo + '">' +
				'<input type="text" placeholder="시작일" style="width:100px;" value="'+ arr[i].startDate +'" class="form-control bit-startDate">' +
				'<input type="text" placeholder="종료일" style="width:100px;" value="'+ arr[i].endDate +'" class="form-control bit-endDate">' +
				'<button class="btn btn-default selectAddBtn">+</button>' +
				'<button class="btn btn-default selectDelBtn">-</button>' +
				'</form>' +
   '</td>'
		}

		$("#selectTable .root-select").html(contents)*/




		var template = Handlebars.compile($('#trTemplateText').html())
		$("#selectTable .root-select").html(template(result))

		initMap(result);
	})
}

function favorChecked(result) { 
	$('input:checkbox[name="chk_info"]').each(function() {

		if(result.data.styleNo == "1"){ //값 비교
			$(".check-food").attr("checked", true)
		} 

		if (result.data.styleNo == "2"){ //값 비교
			$(".check-culture").attr("checked", true)
		} 

		if (result.data.styleNo == "3"){ //값 비교
			$(".check-sports").attr("checked", true)
		}

	});
}

function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 37.49, lng: 127.02},
		zoom: 2
	});



	var flightPlanCoordinates = [];
	$('.root-schedule').each(function(index, element){
		var tag = $(element)

		flightPlanCoordinates[index] = {
			lat: parseFloat(tag.find('.bit-latitude').val()),
			lng: parseFloat(tag.find('.bit-longitude').val())
		}
	});

	console.log(flightPlanCoordinates)
	/*
	$.each(flightPlanCoordinates, function(key, value){
		console.log('key:' + key + ' / ' + 'value:' + value);
		$.each(value, function(key, value) {
			console.log('key:' + key + ' / ' + 'value:' + value);
		});
	});
	 */

	/*	$.each(flightPlanCoordinates, function(key, value){
		console.log('key:' + key + ' / ' + 'value:' + value);
		$.each(value, function(key, value) {
				console.log('key:' + key + ' / ' + 'value:' + value);
			});
		});
	 */


	/*var flightPlanCoordinates = [
	                             {lat: 37.772, lng: -122.214},
	                             {lat: 21.291, lng: -157.821},
	                             {lat: -18.142, lng: 178.431},
	                             {lat: -27.467, lng: 153.027}
	                             ];*/


	var flightPath = new google.maps.Polyline({
		path: flightPlanCoordinates,
		geodesic: false,
		strokeColor: '#FF0000',
		strokeOpacity: 1.0,
		strokeWeight: 2
	});

	flightPath.setMap(map);
	
	function setMarkers(map) {
		
		
	
		for (var i = 0; i < flightPlanCoordinates.length; i++) {
			var marker = new google.maps.Marker({
				position: {lat: flightPlanCoordinates[i]['lat'], lng: flightPlanCoordinates[i]['lng']},
				icon : {
					url : 'http://chart.apis.google.com/chart?chst=d_map_spin&chld=1|0|FF6C6C|20|b|' + (i+1),
				    scaledSize: new google.maps.Size(25, 40)
				},
				map: map,
				animation: google.maps.Animation.DROP
			});
		}
	}
	setMarkers(map);
}




