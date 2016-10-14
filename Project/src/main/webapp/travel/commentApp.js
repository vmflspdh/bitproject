$("#comtaddBtn").click(function(event){
	
	var comment = { 
			//reviewboardNo :$("#crbno").val(),
			reviewboardNo : no,
			memberNo :$("#cmno").val(),
			content : $("#cmcontent").val()
	}

	console.log(comment)
	ajaxAddBoard2(comment);	
});


function ajaxAddBoard2(comment){
	console.log(comment)
	console.log(no);
	
	$.post(serverAddr+"/travel/cmadd.json?no="+no,comment,function(obj){
		var result = obj.jsonResult
		console.log(comment)
		if(result.state !="success"){
			alert("등록실패입니다.")
			return;
		}
		location.reload();
		console.log(comment)
		//window.location.href="reviewApp.html"
	},"json")
	
	
}


function ajaxCommentList(no) {
	/*console.log(no)
	console.log(parseInt(no))*/
	$.getJSON(serverAddr+"/travel/cmlist.json?no="+no,parseInt(no), function(obj) {
		var result=obj.jsonResult;
		if(result.state!="success"){
			
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		
		var contents="";
		var arr = result.data
		for ( var i in arr) {

			contents += "<tr>"+
				"<td>"+arr[i].memberName+"</td>"+
				"<td>"+arr[i].content+"</td>"+
				"<td>"+arr[i].createdDate2+"</td>"+
				/*"<td><a class='titleLink' href='#' data-no='"+arr[i].reviewcommentNo+"'>수정</a></td>"+*/
				"<td><button  >수정</button>" +
				"<button  >삭제</button></td>"+
			"</tr>";

		}
		console.log(contents)
		$("#commentTable tbody").html(contents);
		
		//console.log(contents)
		
		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(".titleLink").click(function(event) {
			$("#commentTable tbody tr:first td:last").html("<tr><td>sdf</td></tr>");
				//window.location.href = "reviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
			});
		});
		
	
		
	
	
	
	
}
