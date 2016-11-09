$("#loginBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});

$("#logoutBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});



var pageNo = 1, /* window.pageNo */
pageLength = 8; /* window.pageLength */

function ajaxQnaBoardList() {
	$.getJSON("qnalist.json", {
		"pageNo": pageNo,
		"length": pageLength
	},function(result) {
		if (result.state != "success") {
	    	 alert("서버에서 데이터를 가져오는데 실패했습니다.")
	    	 return
	    }
		console.log(result)
		var contents = ""
	    var arr = result.data
	    for (var i in arr) {
	             contents += 
	            	 '<tr style="border:0px solid black; border-bottom:1px solid #DDDDDD; font-size: small;">' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].qno + '</center></td>' +
	            	 '<td style="width:55%; padding:10px;"><a href="#" class="titleLink" data-qno="' + arr[i].qno + '" style="color:black;">' + arr[i].title + '</a><span>  </span><span style="color:#FF7C4E">'+ (arr[i].commentCount==0?"":"["+arr[i].commentCount+"]") +'</span></td>' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].memberName + '</center></td>' +
	            	 '<td style="width:15%; padding:10px;"><center>' + arr[i].createDate + '</center></td>' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].viewCount + '</center></td>' +
	            	 '</tr>'
	     }
		
	 	   $(".qnalisttable tbody").html(contents)
	 	   $(".titleLink").click(function(event) {
	 		    ajaxUpdateViewCount($(this).attr("data-qno"))
	 		   checkToNo($(this).attr("data-qno"))
	 	    })
	 	    pageNo = result.pageNo;
		    totalPage = result.totalPage;
		    console.log(pageNo)
		    console.log(totalPage)
		    var cont="<li><a id='prevBtn' href='#'><span class='glyphicon glyphicon-chevron-left'></span></a></li>"
		    for(var i=1; i<=totalPage;i++){
		    	var a=console.log(i)
		    	 cont+="<li><a id='abc' data-no='"+i+"' href='#'>"+i+"</a></li>"
		    	
		    }
		    cont +="<li><a id='nextBtn' href='#'><span class='glyphicon glyphicon-chevron-right'></span></a></li>"
		    $('#asd').html(cont);
		    
		    $(document).on("click","#abc",function(event) {
		    	console.log($(this).attr("data-no"))
		    	console.log($(this))
		    	pageNo=$(this).attr("data-no")
		    	ajaxQnaBoardList();
				});
		    
		    
		    
		    	
		    	
		    $("#prevBtn").click(function(event) {
		    	pageNo--;
		    	ajaxQnaBoardList();
		    });
		    
		    $("#nextBtn").click(function(event) {
		    	pageNo++;
		    	console.log(pageNo)
		    	ajaxQnaBoardList();
		    });
		    if (pageNo <= 1) {
		    	$('#prevBtn').attr('disabled', true);
		    } else {
		    	$('#prevBtn').removeAttr('disabled');
		    } 
		    
		    if (pageNo >= totalPage) {
		    	$('#nextBtn').attr('disabled', true);
		    } else {
		    	$('#nextBtn').removeAttr('disabled');
		    }
	  })
}
	 
	 
function ajaxUpdateViewCount(no){
	$.post("qnaviewupdate.json?no="+no,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		//console.log(review)
		
	},"json")
	
}


function checkToNo(no) {
	$.getJSON(serverAddr + "/travel/compareUser.json", {no: no}, function(result) {
		
		if (result.state == "success") {
			window.location.href = "qnaForm.html?no=" + no
		} else {
			window.location.href = "qnaDetail.html?no=" + no
		}
    })                  
}







