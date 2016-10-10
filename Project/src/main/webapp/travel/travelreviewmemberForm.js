

function ajaxBoardList(no) {
	
	$.getJSON("rvdetail2.json?no="+no, function(result) {
		if(result.state!="success"){
			
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		
		var contents="";
		var arr = result.data
		for ( var i in arr) {

			contents += "<tr>"+
			"<td>"+arr[i].reviewboardno+"</td>"+
			"<td>"+arr[i].travelno+"</td>"+
			"<td>"+arr[i].membername+"</td>"+
			"<td>"+arr[i].title+"</td>"+
			"<td>"+arr[i].content+"</td>"+
			"<td>"+arr[i].createdDate+"</td>"+
			"</tr>";

		}
		$("#boardTable tbody").html(contents);
		
		//console.log(contents)
		
		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(".titleLink").click(function(event) {
				window.location.href = "reviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
			});
		$(".titleLink2").click(function(event) {
			window.location.href = "reviewmemberForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
		});
		});
		
	
		
	
	
	
	
}
