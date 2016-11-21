$(".reviewBtn").click (function(event){


	window.location.href = "travelreviewForm.html";
});

var calendarDetailList = [];

$(document.body).on('click', '.selectDelBtn', function(event) {
	var clickedRow = $(this).parent();

	clickedRow.remove();

});

/*일정수정(모달사용)*/

$(".selectApplyBtn").click(function(event){

	var checkIndex = $('.bit-index1').val()

	console.log(checkIndex)

	$('.root-schedule').each(function(index, element) {

		if ((checkIndex-1) == index) {

			$(element).find(".bit-nation").val($('.bit-nation1').val());
			$(element).find(".bit-city").val($('.bit-city1').val());
			$(element).find(".bit-startDate").val($('.bit-startDate1').val());
			$(element).find(".bit-endDate").val($('.bit-endDate1').val());
			$(element).find(".bit-latitude").val($('.bit-latitude1').val());
			$(element).find(".bit-longitude").val($('.bit-longitude1').val());
		}
	});
	$('.selectApplyBtn').attr("data-dismiss", "modal");
	$('#pac-input').val("")

});




$(document.body).on('click', '.selectModBtn', function(event) {


	$('.bit-nation1').val($(this).siblings('.bit-nation').val())
	$('.bit-city1').val($(this).siblings('.bit-city').val())
	$('.bit-startDate1').val($(this).siblings('.bit-startDate').val())
	$('.bit-endDate1').val($(this).siblings('.bit-endDate').val())
	$('.bit-latitude1').val($(this).siblings('.bit-latitude').val())
	$('.bit-longitude1').val($(this).siblings('.bit-longitude').val())
	$('.bit-index1').val($(this).siblings('#sch_cirNum').text())

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
			continent: tag.find(".bit-continent").val(),
			nation: tag.find(".bit-nation").val(),
			city: tag.find(".bit-city").val(),
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



	var formData = new FormData();
	formData.append("memberNo",$("#userNo").val())
	formData.append("travelMainNo",$("#travelNo").val())
	formData.append("title",$("#title").val())
	formData.append("selfIntroduce",$("#selfIntroduce").val())
	formData.append("styleNo",$("input[name='chk_info']:checked").val())
	formData.append("travelMainPNo", $("#travelMainPNo").val())
	console.log($("#travelMainPNo").val())
	formData.append("schedule",schedule)
	formData.append("file", $("#travelFile")[0].files[0])
	console.log($("#travelFile")[0].files[0])



	ajaxUpdateTravelMain(formData)
});

	
$("#deleteTMBtn").click(function(event) {
	no=$("#travelNo").val();
	console.log(no)
	ajaxDeleteTravelMain(no)
});


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
		$("#title").text(result.data.title);
		$("#travelNo").val(result.data.travelMainNo);
		$("#styleNo").val(result.data.styleNo);
		$("#detailMemberName").text(result.data.writer);
		$("#selfIntroduce").val(result.data.selfIntroduce);
		$("#selfIntroduce").text(result.data.selfIntroduce);
		$("#styleName").val(result.data.styleNo);
		if (result.data.travelPhoto == 'default') {
			$("#detailTravelImage").attr("src","img/traveldefault.jpg");
		} else {
			$("#detailTravelImage").attr("src","../upload/" + result.data.travelPhoto);
		}
		
		regPhoto(result.data.memberNo)
		favorChecked(result)
		scheduleList();
		calendarList();
		travelMainFilelist();
	})
}
function regPhoto(no){
	console.log(no)
	$.getJSON(serverAddr + "/travel/regUserPhoto.json", {no:no}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.state)
			alert("삭제 실패 입니다.")
			return
		}
		if (result.data.memberPhoto == null) {
			$("#detailUserImage").attr("src","img/iconmonstr-user-20-240.png");
		} else if (result.data.memberPhoto.substring(0,1) == 'h') {
			$("#detailUserImage").attr("src",result.data.memberPhoto);
		} else {
			$("#detailUserImage").attr("src","../upload/" + result.data.memberPhoto);	
		}


//		location.href = "mainhtml.html"
	})

}



function ajaxUpdateTravelMain(formData) {

	$.ajax({
		url : "travelMainUpdate.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(obj) {
			var result = obj.jsonResult
			if (result.state == "success") {
				swal(
						'변경 성공!',
						'modification in success!',
						'success'
				)
				window.location.reload(true);
			}
		},
		error: function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
				swal(
						'변경 실패.',
						'Something went wrong!',
						'error'
				)
				return;
			}
		}
	});
}


function ajaxDeleteTravelMain(no) {
	console.log(no)
	$.post(serverAddr + "/travel/travelMainDelete.json?no"+no, {no:no}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.state)
			alert("삭제 실패 입니다.")
			return
		} else{
			swal(
					'삭제 성공!',
					'add in success!',
					'success'
			)
		}

		location.href = "n_mainTest.html"
	})
}


function scheduleList() {
	$.getJSON(serverAddr + "/travel/scheduleList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		var arr = result.data
		var contents = "";
		console.log(arr[0].travelMainNo)
		$("#tmno").val(arr[0].travelMainNo)


		var template = Handlebars.compile($('#trTemplateText').html())
		$("#selectTable .root-select").html(template(result))

		$('.root-schedule').each(function(index, element) {

			var tag = $(element).find($('[id="sch_cirNum"]'));
			tag.html(index+1);
		});


		initMap();
	})
}


function travelMainFilelist() {
	$.getJSON(serverAddr + "/travel/travelMainFilelist.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}

		var contents = '<a>기존 업로드 파일</a><br/>';
		var arr = result.data
		for (var i in arr) {
			contents +=  '<a>' + arr[i].fileName + "</a><br/>" +
		'<input type="text" id="travelMainPNo" style="display:none" value="'+ arr[i].travelMainPNo+'">' 
			console.log(arr[i].fileName)
			if (arr[i].fileName == 'default') {
				$('#boardImg').css("background-image", "url(img/traveldefault.jpg)");
			} else {
				
				$('#boardImg').css("background-image", "url(../upload/" + arr[i].fileName +")");
			}
			$('#reviewThumbImg').css("background-image", "url(../upload/" + arr[i].fileName +")");

		}

		$("#selectTable .fileList .innerFileList").html(contents)


	});
}


function favorChecked(result) { 


	$('input:checkbox[name="chk_info"]').each(function() {
		console.log(result.data.styleNo)
		$("input[id="+result.data.styleNo+"]").attr("checked",true);
	});


	$('.checkbox-inline').each(function() {

		if(result.data.styleNo == "1"){ //값 비교
			$(".check-food").css("filter", "grayscale(0%)")
			$('.check-food').css("font-weight", "bold");
		} 

		if (result.data.styleNo == "2"){ //값 비교
			$(".check-culture").css("filter", "grayscale(0%)")
			$('.check-culture').css("font-weight", "bold");
		} 

		if (result.data.styleNo == "3"){ //값 비교
			$(".check-sports").css("filter", "grayscale(0%)")
			$('.check-sports').css("font-weight", "bold");
		}

	});
}



function ajaxReviewBoardList(no) {
	console.log(no)
	$.getJSON("tvlReviewList.json",{no:no},function(obj) {
		result = obj.jsonResult;

		if(result.state!="success"){

			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		var contents="";
		var arr = result.data
		for ( var i in arr) {
			var b = arr[i].reviewboardno
			console.log(b)
			contents += 
				'<tr>' +
				'<td style="width:100px;">' +
				'<img src="img/yang/travelphoto2.jpg" id="reviewThumbImg" style="width:120px; height: 15%; border-radius: 5px 5px 5px 5px;">' +
				'</td>' +
				'<td style="width:65%;">' +
				'<div style="height:50px;">' +
				'<div style="font-size:large; font-weight: bold; color:#13919A;"><a class="titleLink2" href="#" data-no2="'+arr[i].memberno+'"><span>' + arr[i].membername + '</span></a>님의 Travel Review</div>' +
				'<div style="font-size:medium; font-weight: bold;">' +
				'<a class="titleLink33" href="#" style="color: #BBBABC; line-height: 3px;" data-no="' + arr[i].reviewboardno + '"><span class="reviewTitle">' + arr[i].title +" "+(arr[i].commentCount==0?"":"("+arr[i].commentCount+")") + '</span>' +
				'</div></a>' +
				'</div>' +
				'</td>' +
				'<td style="width:110px; color: #BBBABC;">' +
				'<div style="font-size: 15px; font-weight: normal;">' + arr[i].createdDate + '</div>' +
				'<div style="font-size: 15px; font-weight: normal;">' +
				'<span style="float: right;">&nbsp; &nbsp;</span>' +
				'<span style="float: right;">' + arr[i].viewcount + '</span>' +
				'<span style="float: right;">조회수 :&nbsp;</span>' +
				'</div>' +
				'</td>' +
				'</tr>' +
				'<tr><td style="height: 30px;"></tr>'
		}
		$("#newReviewTable").html(contents);

		//console.log(contents)

		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(".titleLink33").click(function(event) {
			ajaxUpdateViewCount($(this).attr("data-no"))
			window.location.href = "testReviewDetail.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다.
		});
		$(".titleLink2").click(function(event) {
			window.location.href = "travelreviewmemberForm.html?no="+$(this).attr("data-no2");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
		});

		pageNo = result.pageNo;
		totalPage = result.totalPage;
		console.log(pageNo)
		console.log(totalPage)
		var cont="<li><a id='prevBtn' href='#'><span class='glyphicon glyphicon-chevron-left'></span></a></li>"
			for(var i=1; i<=totalPage;i++){
				var a=console.log(i)
				//$('ul>li:first').after.html(a);
				//$('ul>li:first').append("<li><a href='#'> "+i+"</a></li>");
//				$('#asd').append("<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>");
				cont+="<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>"


//				$('#asd').html("<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>");

			}
		cont +="<li><a id='nextBtn' href='#'><span class='glyphicon glyphicon-chevron-right'></span></a></li>"
			$('#asd').html(cont);

		$(document).on("click","#abc",function(event) {
			console.log($(this).attr("data-no"))
			console.log($(this))
//			$("li").addClass("active")
			pageNo=$(this).attr("data-no")
			ajaxBoardList();
		});





		$("#prevBtn").click(function(event) {
			pageNo--;
			ajaxBoardList();
		});

		$("#nextBtn").click(function(event) {
			pageNo++;
			console.log(pageNo)
			ajaxBoardList();
		});
//		$('#pageNo').text(pageNo);
		// 페이지 번호가 1이면 [이전] 버튼을 비활성화시킨다.
		if (pageNo <= 1) {
			$('#prevBtn').attr('disabled', true);
		} else {
			$('#prevBtn').removeAttr('disabled');
		} 

		// 페이지 번호가 마지막 페이지라면 [다음] 버튼을 비활성화시킨다.
		if (pageNo >= totalPage) {
			$('#nextBtn').attr('disabled', true);
		} else {
			$('#nextBtn').removeAttr('disabled');
		}
	});


}


function ajaxUpdateViewCount(no){
	console.log(no)
	$.post("rvviewupdate.json?no="+no,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		//console.log(review)

	},"json")

}
function initMap() {



	var flightPlanCoordinates = [];
	$('.root-schedule').each(function(index, element){
		var tag = $(element)

		flightPlanCoordinates[index] = {
			lat: parseFloat(tag.find('.bit-latitude').val()),
			lng: parseFloat(tag.find('.bit-longitude').val())
		}
	});

	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 37.49, lng: 127.02},
		zoom: 7,
		mapTypeControl: false
	});



	console.log(flightPlanCoordinates)


	bounds = new google.maps.LatLngBounds();
	for (var i=0; i < flightPlanCoordinates.length; i++) {
		bounds.extend(flightPlanCoordinates[i]);
	}
	map.fitBounds(bounds);


	google.maps.event.addListener(map, 'zoom_changed', function() {
		zoomChangeBoundsListener = google.maps.event.addListener(map, 'bounds_changed', function(event) {
			if (map.getZoom() > 12)
				map.setZoom(7)
				google.maps.event.removeListener(zoomChangeBoundsListener);
		});
	});



	/*	$.each(flightPlanCoordinates, function(key, value){
		console.log('key:' + key + ' / ' + 'value:' + value);
		$.each(value, function(key, value) {
				console.log('key:' + key + ' / ' + 'value:' + value);
			});
		});
	 */

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





	var infowindow = new google.maps.InfoWindow();
	var marker = new google.maps.Marker({
		map: map,
		anchorPoint: new google.maps.Point(0, -29)
	});


	var input = /** @type {!HTMLInputElement} */(
			document.getElementById('pac-input'));

	/*map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);*/


	var autocomplete = new google.maps.places.Autocomplete(input, {
		types: ['(cities)']});


	autocomplete.bindTo('bounds', map);

	autocomplete.addListener('place_changed', function() {
		infowindow.close();
		marker.setVisible(false);
		var place = autocomplete.getPlace();
		if (!place.geometry) {
			window.alert("Autocomplete's returned place contains no geometry");
			return;
		}

		// If the place has a geometry, then present it on a map.
		if (place.geometry.viewport) {
			map.fitBounds(place.geometry.viewport);
		} else {
			map.setCenter(place.geometry.location);
			map.setZoom(5); 
		}

		marker.setIcon(/** @type {google.maps.Icon} */({
			url: place.icon,
			size: new google.maps.Size(71, 71),
			origin: new google.maps.Point(0, 0),
			anchor: new google.maps.Point(17, 34),
			scaledSize: new google.maps.Size(35, 35)
		}));
		marker.setPosition(place.geometry.location);
		marker.setVisible(true);

		var address = '';
		if (place.address_components) {
			address = [
			           (place.address_components[0].short_name)
			           ].join(' ');

			/*위도 경도 추출*/
			var a = $("#map").find('a').attr('href')
			var b = a.split("=")[1];
			var c = b.split("&")[0];
			var llet = c.split(",")[0];
			var lot = c.split(",")[1];


			if (place.address_components.length == 4) {
				$(".bit-nation1").val(place.address_components[3].long_name)
			} else if (place.address_components.length == 3) {
				$(".bit-nation1").val(place.address_components[2].long_name)
			} else if (place.address_components.length == 2) {
				$(".bit-nation1").val(place.address_components[1].long_name)
			} else if (place.address_components.length == 5) {
				$(".bit-nation1").val(place.address_components[4].long_name)
			} else if (place.address_components.length == 6) {
				$(".bit-nation1").val(place.address_components[5].long_name)
			}

			$(".bit-city1").val(place.address_components[0].short_name)
			$(".bit-latitude1").val(llet)
			$(".bit-longitude1").val(lot)

			console.log(llet)
			console.log(lot)
		}

		/*		   infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
	    infowindow.open(map, marker);*/

		setMarkers(map);
	});

}


function calendarList() {
	$.getJSON(serverAddr + "/travel/calendarList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		var arr = result.data
		for (var i in arr) {
			calendarDetailList.push(arr[i])
			calendarDetailList[i].end = moment(arr[i].end, "YYYY-MM-DD").add(1, 'days');
		}
		console.log(calendarDetailList)
		showCalendar();

	})
}

function showCalendar() {


	$(document).ready(function() {


		console.log(calendarDetailList)
		$("#calendar").fullCalendar({
			height: 'auto',
			navLinks: false,
			selectable: false,
			selectHelper: false,
			disableDragging : false,
			select: function(start, end, allDay) {
				var title = prompt('일정을 입력하세요');
				if (title) {
					calendar.fullCalendar('renderEvent',
							{
						title: title,
						start: start,
						end: end
							},
							true
					);
				}
				calendar.fullCalendar('unselect');
			},
			editable: false,
			events: calendarDetailList
		})

		$('#calendar').fullCalendar('gotoDate', calendarDetailList[0].start);
	})
}
