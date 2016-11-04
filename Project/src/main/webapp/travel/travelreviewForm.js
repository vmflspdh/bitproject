$("#addBtn").click (function(event){
	console.log('aaa')
	var review = { 
			travelno : $("#tmno").val(),
			/*memberno : $("#mno").val(),*/
			title : $("#title").val(),
			content : $("#contents").val()
	}
	
	var formData = new FormData();
	formData.append("travelno",$("#tmno").val())
	formData.append("title",$("#title").val())
	formData.append("content",$("#contents").val())
	
	console.log($("#multiFile")[0].files)
	$($("#multiFile")[0].files).each(function(index, file) {
		
		console.log(file)
	formData.append("files", file); 
	});

	console.log(formData)
	
	
	ajaxAddBoard(formData);	
});

$("#updateBtn").click(function(event){
	
	var review = {
			title : $("#title").val(),
			content : $("#contents").val(),
			reviewboardno : $("#rbno").val()
			
	}
	
	
	
	ajaxUpdateBoard(review);	
});

$("#deleteBtn").click(function(event){
	
	ajaxDeleteBoard($("#rbno").val());
});

function photoList(no){
	$.getJSON("rvphotoList.json?=no"+no,{no:no},function(result){
		console.log(no)
		if(result.state !="success"){
			console.log(result.data)
			alert("사진조회실패.")
			return;
		}
		
		var contents="";
		var arr = result.data
		console.log(result.data)
		
		
		for ( var i in arr) {

			contents += 
				"<img src='../upload/"+arr[i].reviewPhotoName+"' style='width:60px;height:60px;'>"
				
		}
		
		$("#commentTable tbody").html(contents);
	})
}

function ajaxAddBoard(formData) {

	console.log(formData)

	$.ajax({
		url : "rvadd.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(result) {
			if (result.state != "success") {
				console.log(result.data)
				console.log(result.state)
				alert("등록 실패입니다.")
				return
			}
			window.location.href = "travelreviewApp.html";
		}
	});

}
	
/*function ajaxAddBoard(formData){
	console.log(formData)
	$.post("rvadd.json",formData,function(result){
		console.log(formData)
		if(result.state !="success"){
			alert("등록실패입니다.")
			return;
		}
		
		window.location.href="travelreviewApp.html"
	},"json")
	
	
}*/


function ajaxLoadBoard(no){
	
	$.getJSON("rvdetail.json?no="+no,function(result){
		if(result.state !="success"){
			alert("조회 실패입니다.")
			return;
		}
		$("#rbno").val(result.data.reviewboardno);
		$("#tmno").val(result.data.travelno);
//		$("#userName3").val('');
		$("#userName2").val(result.data.membername);
		/*$("#userNo").val(result.data.no)*/
		$("#title").val(result.data.title);
		$("#contents").val(result.data.content);
		$("#createdDate").val(result.data.createdDate);
		$("#viewCount").text(result.data.viewcount);
	})
		
		
}



function ajaxUpdateBoard(review){
	console.log(review)
	$.post("rvupdate.json",review,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		console.log(review)
		window.location.href="travelreviewApp.html"
	},"json")
	
}




function ajaxDeleteBoard(no,password){
	$.getJSON("rvdelete.json",{no:no,password:password},function(result){
		if(result.state !="success"){
			console.log(result.data)
			alert("삭제실패입니다.")
			return;
		}
		location.href="travelreviewApp.html"
		
	})
		
}