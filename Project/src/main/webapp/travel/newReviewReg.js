



$("#addReviewBtn").click (function(event){
	/*alert('aaa')*/
	var reviewArray = [];
	$('.root-schedule').each(function(index, element) {

		var tag = $(element)

		reviewArray[index] = {

			reviewBoardNo : tag.find('.bit-continent').val(),
			scheduleNo : tag.find('#scheduleNo').val(),
			content : tag.find('#scheduleReview').val()
		};
	})
	console.log(reviewArray)

	//console.log(scheduleArray)
	//var schedule = JSON.stringify(scheduleArray);
	
	
	
/*$("#reviewContentDiv > #scheduleReview").each(function(index, file) {
		
		console.log($(this).val())
	});
	
	scheduleNo(scheduleNoList)
	console.log(scheduleNoList)
	*/
});





























