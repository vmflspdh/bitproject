


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


		initMap(result);
	})
}




