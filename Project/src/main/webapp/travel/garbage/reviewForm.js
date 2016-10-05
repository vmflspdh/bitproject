$("#addBtn").click (function(event){
	
	var review = { 
			travelno : $("#tmno").val(),
			memberno : $("#mno").val(),
			title : $("#title").val(),
			content : $("#contents").val()
	}
	
	
	
	ajaxAddBoard(review);	
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

function ajaxAddBoard(review){
	
	$.post("rvadd.json",review,function(result){
		console.log(review)
		if(result.state !="success"){
			alert("등록실패입니다.")
			return;
		}
		window.location.href="reviewApp.html"
	},"json")
	
	
}


function ajaxLoadBoard(no){
	
	$.getJSON("rvdetail.json?no="+no,function(result){
		if(result.state !="success"){
			alert("조회 실패입니다.")
			return;
		}
		$("#rbno").val(result.data.reviewboardno);
		$("#tmno").val(result.data.travelno);
		$("#mno").val(result.data.memberno);
		$("#title").val(result.data.title);
		$("#contents").val(result.data.content);
		$("#createdDate").val(result.data.createdDate);
		$("#viewCount").text(result.data.viewcount);
	})
		
		
}



function ajaxUpdateBoard(review){
	$.post("rvupdate.json",review,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		console.log(review)
		window.location.href="reviewApp.html"
	},"json")
	
}


function ajaxDeleteBoard(no,password){
	$.getJSON("rvdelete.json",{no:no,password:password},function(result){
		if(result.state !="success"){
			console.log(result.data)
			alert("삭제실패입니다.")
			return;
		}
		location.href="reviewApp.html"
		
	})
		
}