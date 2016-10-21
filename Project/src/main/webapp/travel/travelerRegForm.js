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

/*var a = $("#map").find('a').attr('href')
var b = a.split("=")[1];
var c = b.split("&")[0];
var llet = c.split(",")[0];
var lot = c.split(",")[1];

console.log(llet)
console.log(lot)*/
