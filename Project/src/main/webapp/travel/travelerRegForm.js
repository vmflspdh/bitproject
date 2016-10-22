/*$(document.body).on('click', '.selectAddBtn', function(event) {

	var lastrootschedule = $(".root-addSelect form:last")

	lastrootschedule.after(
			lastrootschedule.clone()
			.find(".select").attr("selected value", "").end()
			.find(".bit-startDate").val("").end()
			.find(".bit-endDate").val("").end()
	);

	var clickedRow = $(this).parent().index();
	console.log(clickedRow)

	$(".root-select").append(lastrootschedule);
	console.log($("#root-select").eq(clickedRow));
	$("#root-select").eq(clickedRow).append(lastrootschedule);


	var tags = $(".bit-startDate",".bit-endDate")
	.removeClass('hasDatepicker')
	.datepicker({dateFormat: 'yy-mm-dd'});

});*/

$(".selectAddBtn").click(function(event) {

	var selectSchedule = {
			city: $(".bit-city1").val(),
			startDate: $(".bit-startDate1").val(),
			endDate: $(".bit-endDate1").val(),
			latitude: $(".bit-latitude1").val(),
			longitude: $(".bit-longitude1").val()
	}
	console.log(selectSchedule)
	
	var template = Handlebars.compile($('#trTemplateText').html())
	$("#selectTable .root-select").append($(template(selectSchedule)))

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
			endDate1 : tag.find('.bit-endDate').val(),
			latitude: tag.find('.bit-latitude').val(),
			longitude: tag.find('.bit-longitude').val()
		};
	})

	//console.log(scheduleArray)
	var schedule = JSON.stringify(scheduleArray)
	console.log(schedule)
	travelMain.schedule = schedule;

/*	ajaxAddTravelMain(travelMain)*/


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


