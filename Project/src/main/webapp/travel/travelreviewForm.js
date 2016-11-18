$("#addBtn").click (function(event){
	console.log('aaa')
	var review = { 
			travelno : $("#tmno").val(),
			/*memberno : $("#mno").val(),*/
			title : $("#title").val(),
			content : $("#contents").val()
	}
	//console.log($("#reviewContentInput").val())
	
	
	var reviewArray = [];
	var formData = new FormData();
	$('.root-schedule').each(function(index, element) {
		
		var tag = $(element)
		$(tag.find("#file")[0].files).each(function(index, file) {
		
		console.log(file)
	formData.append("files", file); 
	});
		
		reviewArray[index] = {
			scheduleNo : tag.find('#scheduleNo').val(),
			content : tag.find('#scheduleReview').val(),
		};
	})
	console.log(reviewArray)
	var reviewContent = JSON.stringify(reviewArray)
	
	
	formData.append("travelno",$("#tmno").val())
	formData.append("title",$("#title").val())
	formData.append("content",$("#contents").val())
	formData.append("reviewContentList",reviewContent)
	/*console.log($("#file")[0].files)
	$($("#file")[0].files).each(function(index, file) {
		
		console.log(file)
	formData.append("files", file); 
	});*/

	console.log(formData)
	
	
	ajaxAddBoard(formData);	
});

$("#updateBtn").click(function(event){
	
	var review = {
			title : $("#title").val(),
			content : $("#contents").val(),
			reviewboardno : $("#rbno").val()
			
	}
	
	var formData = new FormData();
	formData.append("title",$("#title").val())
	formData.append("content",$("#contents").val())
	formData.append("reviewboardno",$("#rbno").val())
	formData.append("no",no);
	
	console.log($("#multiFile")[0].files)
	console.log($("#multiFile")[0].files.length)
	if($("#multiFile")[0].files.length!=0){
	$($("#multiFile")[0].files).each(function(index, file) {
		
		console.log(file)
	formData.append("files", file); 
	});
	} 
	
	ajaxUpdateBoard(formData);	
});

$("#deleteBtn").click(function(event){
	
	ajaxDeleteBoard($("#rbno").val());
});

function reviewContentList(reviewContent){
	console.log(reviewContent.scheduleNo)
	
}


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
			if(i==0){
				contents += 
					'<div class="item active">'+
					'<p><img width=100%  height=700 src="../upload/'+arr[i].reviewPhotoName+'" alt="..."></p>'+
					'</div>'
			} else {
			contents += 
				
				'<div class="item">'+
				'<p><img width=100% height=700 src="../upload/'+arr[i].reviewPhotoName+'" alt="..."></p>'+
			    '</div>'
			}
		}
		
		
		
		/*for ( var j in arr) {
			if(j==0){
				contents2 += 
					'<li data-target="#carousel-example-generic" data-slide-to="'+j+'" class="active"></li>'
			} else {
			contents2 += 
				
				'<li data-target="#carousel-example-generic" data-slide-to="'+j+'"></li>'
			}
		}*/
		console.log(contents)
		$(".carousel-inner").html(contents);
		//$(".carousel-indicators").html(contents2);
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
			if (result.state == "success") {
				swal(
						'입력 성공!',
						'add in success!',
						'success'
				)
				window.location.href = "reviewApp.html";
			}
		},
		error: function(result) {
			if (result.state != "success") {
				console.log(result.data)
				swal(
						'입력 실패.',
						'Something went wrong!',
						'error'
				)
				return;
			}
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



function ajaxUpdateBoard(formData){
	console.log(formData)
	/*$.post("rvupdate.json",formData,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		console.log(formData)
		window.location.href="travelreviewApp.html"
	},"json")*/
	$.ajax({
		url : "rvupdate.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(result) {
			if (result.state != "success") {
				console.log(result.data)
				console.log(result.state)
				alert("변경 실패입니다.")
				return
			}
			window.location.href = "travelreviewApp.html";
		}
	});
	
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