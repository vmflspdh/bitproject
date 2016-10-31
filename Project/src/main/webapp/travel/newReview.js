function ajaxCommentCount(){
	console.log(no)
	$.post("rvviewupdate.json?no="+no,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		//console.log(review)
		
	},"json")
	
}

var pageNo = 1, /* window.pageNo */
pageLength = 10; /* window.pageLength */
function ajaxBoardList() {
	console.log(pageNo)
	$.getJSON("rvlist.json", {
		"pageNo": pageNo,
		"length": pageLength
		},function(result) {
			
		if(result.state!="success"){
			
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		var contents="";
		var arr = result.data
		for ( var i in arr) {
			var b = arr[i].reviewboardno
			console.log(b)
			contents += "<tr>"+
				"<td>"+arr[i].reviewboardno+"</td>"+
				"<td>"+arr[i].travelno+"</td>"+
				"<td><a class='titleLink2' href='#' data-no2='"+arr[i].memberno+"'>"+arr[i].membername+"</a></td>"+
				"<td><a class='titleLink' href='#' data-no='"+arr[i].reviewboardno+"'>"+arr[i].title +" "+(arr[i].commentCount==0?"":"("+arr[i].commentCount+")")+"</a></td>"+
				"<td>"+arr[i].content+"</td>"+
				"<td>"+arr[i].createdDate+"</td>"+
				"<td>"+arr[i].viewcount+"</td>"+
			"</tr>";

		}
		$("#boardTable tbody").html(contents);
		
		//console.log(contents)
		
		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(".titleLink").click(function(event) {
			ajaxUpdateViewCount($(this).attr("data-no"))
				 window.location.href = "travelreviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다.
			});
		$(".titleLink2").click(function(event) {
			window.location.href = "travelreviewmemberForm.html?no="+$(this).attr("data-no2");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
		});
		
		pageNo = result.pageNo;
	    totalPage = result.totalPage;
	    console.log(pageNo)
	    console.log(totalPage)
	    var cont="<li><a id='prevBtn' href='#'><span class='glyphicon glyphicon-chevron-left'></span></a></li>"
	    for(var i=1; i<=totalPage;i++){
	    	var a=console.log(i)
	    	//$('ul>li:first').after.html(a);
	    	//$('ul>li:first').append("<li><a href='#'> "+i+"</a></li>");
//	    	$('#asd').append("<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>");
	    	 cont+="<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>"
	    	
	    	
//	    	$('#asd').html("<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>");
	    	
	    }
	    cont +="<li><a id='nextBtn' href='#'><span class='glyphicon glyphicon-chevron-right'></span></a></li>"
	    $('#asd').html(cont);
	    
	    $(document).on("click","#abc",function(event) {
	    	console.log($(this).attr("data-no"))
	    	console.log($(this))
//	    	$("li").addClass("active")
	    	pageNo=$(this).attr("data-no")
	    	ajaxBoardList();
			});
	    
	    
	    
	    	
	    	
	    $("#prevBtn").click(function(event) {
	    	pageNo--;
	    	ajaxBoardList();
	    });
	    
	    $("#nextBtn").click(function(event) {
	    	pageNo++;
	    	console.log(pageNo)
	    	ajaxBoardList();
	    });
//	    $('#pageNo').text(pageNo);
	    // 페이지 번호가 1이면 [이전] 버튼을 비활성화시킨다.
	    if (pageNo <= 1) {
	    	$('#prevBtn').attr('disabled', true);
	    } else {
	    	$('#prevBtn').removeAttr('disabled');
	    } 
	    
	    // 페이지 번호가 마지막 페이지라면 [다음] 버튼을 비활성화시킨다.
	    if (pageNo >= totalPage) {
	    	$('#nextBtn').attr('disabled', true);
	    } else {
	    	$('#nextBtn').removeAttr('disabled');
	    }
		});
		
	
		
	
	
	
	
}

function ajaxUpdateViewCount(no){
	console.log(no)
	$.post("rvviewupdate.json?no="+no,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		//console.log(review)
		
	},"json")
	
}

