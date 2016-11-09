$("#addReviewBtn").click (function(event){
	
	var reviewArray = [];
	$('.root-schedule').each(function(index, element) {

		var tag = $(element)

		reviewArray[index] = {

			reviewBoardNo : tag.find('.bit-continent').val(),
			scheduleNo : tag.find('.bit-nation').val(),
			content : tag.find('#scheduleReview').val()
		};
	})

	//console.log(scheduleArray)
	var schedule = JSON.stringify(scheduleArray);
	
	
	
$("#reviewContentDiv > #scheduleReview").each(function(index, file) {
		
		console.log($(this).val())
	});
	
	scheduleNo(scheduleNoList)
	console.log(scheduleNoList)
	
});


function scheduleNo(scheduleNoList){
	console.log(scheduleNoList.scheduleNo)
	return scheduleNoList
}


























