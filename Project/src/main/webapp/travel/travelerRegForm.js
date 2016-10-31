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
			lat: $(".bit-latitude1").val(),
			lng: $(".bit-longitude1").val()
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




	var scheduleArray = [];
	$('.root-schedule').each(function(index, element) {

		var tag = $(element)

		scheduleArray[index] = {

			continent : tag.find('.bit-continent').val(),
			nation : tag.find('.bit-nation').val(),
			city : tag.find('.bit-city').val(),
			startDate1 : tag.find('.bit-startDate').val(),
			endDate1 : tag.find('.bit-endDate').val(),
			lat: tag.find('.bit-latitude').val(),
			lng: tag.find('.bit-longitude').val()
		};
	})

	//console.log(scheduleArray)
	var schedule = JSON.stringify(scheduleArray)
	console.log(schedule)

	/*ajaxAddTravelMain(travelMain)*/

	/*여행글 사진업로드 파일 부분*/

	var formData = new FormData();

	formData.append("title", $("#title").val())
	formData.append("selfIntroduce", $("#selfIntroduce").val())
	formData.append("styleNo", $("input[name='chk_info']:checked").val())
	formData.append("schedule", schedule)
	$($("#multiFile")[0].files).each(function(index, file) {
		formData.append("file", file); });
	

	ajaxAddTravelMain(formData)



});



function ajaxAddTravelMain(formData) {
	
	console.log(formData)
	
	$.ajax({
		url : "travelMainAdd.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
				alert("등록 실패입니다.")
				return
		}
			window.location.reload(true)
		}
	});
	
	
	/*$.post(serverAddr + "/travel/travelMainAdd.json", 
			travelMain, function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("등록 실패입니다.")
			return
		}*/
}


