
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
	            	 '<tr style="border:0px solid black; border-bottom:1px solid #DDDDDD; font-size: 15px;">' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].qno + '</center></td>' +
	            	 '<td style="width:55%; padding:10px;  padding:20px; text-align: left;"><a href="#" class="titleLink" data-qno="' + arr[i].qno + '" style="color:black;">' + arr[i].title + '</a><span>  </span><span style="color:#FF7C4E">'+ (arr[i].commentCount==0?"":"["+arr[i].commentCount+"]") +'</span></td>' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].memberName + '</center></td>' +
	            	 '<td style="width:15%; padding:10px;"><center>' + arr[i].createDate + '</center></td>' +
	            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].viewCount + '</center></td>' +
	            	 '</tr>'
	     }
		
	 	   $(".qnalisttable tbody").html(contents)
	 	   $(".titleLink").click(function(event) {
	 		   console.log($(this).attr("data-qno"))
	 		   ajaxUpdateViewCount2($(this).attr("data-qno"))
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

/*$("#searchBtn").click(function(event) {
	console.log($("#search").val())
	ajaxQnaSearchBoardList($("#search").val())
});*/

$("#search").keydown(function(key) {
	console.log(key.keyCode)
	if(key.keyCode==13){
		
		console.log($("#search").val())
		ajaxQnaSearchBoardList($("#search").val())
	}
});



function ajaxQnaSearchBoardList(searchContent) {
	console.log(searchContent)
	$.post("searchList2.json",
		{"title": searchContent},function(result) {
			console.log(result)
			var contents = ""
		    var arr = result.data
		    for (var i in arr) {
		             contents += 
		            	 '<tr style="border:0px solid black; border-bottom:1px solid #DDDDDD; font-size: 15px;">' +
		            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].qno + '</center></td>' +
		            	 '<td style="width:55%; padding:10px;  padding:20px; text-align: left;"><a href="#" class="titleLink" data-qno="' + arr[i].qno + '" style="color:black;">' + arr[i].title + '</a><span>  </span><span style="color:#FF7C4E">'+ (arr[i].commentCount==0?"":"["+arr[i].commentCount+"]") +'</span></td>' +
		            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].memberName + '</center></td>' +
		            	 '<td style="width:15%; padding:10px;"><center>' + arr[i].createDate + '</center></td>' +
		            	 '<td style="width:10%; padding:10px;"><center>' + arr[i].viewCount + '</center></td>' +
		            	 '</tr>'
		     }
			
		 	   $(".qnalisttable tbody").html(contents)
		 	   $(".titleLink").click(function(event) {
		 		   console.log($(this).attr("data-qno"))
		 		   ajaxUpdateViewCount2($(this).attr("data-qno"))
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
	 
	 
function ajaxUpdateViewCount2(no){
	$.post("qnaviewupdate.json?no="+no,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		//console.log(review)
		
	},"json")
	
}

function ajaxInviteList() {
	$.getJSON(serverAddr + "/travel/invlist.json", function(result) {
		if (result.state != "success") {
//		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		console.log(result)
		var contents = "<h4>동행요청</h4>";
	    var arr = result.data
	    for (var i in arr) {
	    	contents +=
	    		'<pre class="prettyprint">'+'<img  class="img-circle" src="../upload/'+arr[i].invitePhoto+'"style="width:50px; height:40">'+"&nbsp&nbsp;"+
	    		arr[i].inviteName+" 님이 동행요청을 하셨습니다. &nbsp;"+
	    		'<button type="button" data-no="'+arr[i].inviteBoardNo+'" data-no2="'+arr[i].memberNo2+'"class="btn btn-default btn-sm" id="invitedetail">상세페이지</button>'+
//	    		'<a  onclick="detailPage("'+arr[i].inviteNo+'")" class="btn btn-default btn-sm fadeandscale_open"  >상세 페이지3</a>'+
				'<button type="button" data-no="'+arr[i].inviteNo+'" data-no2="'+arr[i].memberNo2+'" data-no3="'+arr[i].memberNo+'" class="btn btn-default btn-sm" id="inviteadd">수락</button><button data-no="'+arr[i].inviteNo+'" class="btn btn-default btn-sm" id="inviterefuse" value="sdfds">거절</button>'
				+'</pre>'
	    		
	    		/*'<ul>' +
	    		'<li><a class="titleLink" href="#" data-memno="' + arr[i].memberNo + '" data-no="' + arr[i].no + '">' +
	    		'<img src="' + arr[i].myPhoto + '"></a>' +
	    		'<div class="cycle-overlay">' +
	    		arr[i].writer + '<br>' +
	    		arr[i].continent + ',' + arr[i].nation + ',' + arr[i].city + '<br>' +
	    		arr[i].startDate + '~' + arr[i].endDate + '</div></li>' +
	    		'</ul>'*/
	      }
	    
	    $("#fadeandscale>h4").html(contents)
	    
	    
	     $(document).on("click","#invitedetail",function(event) {
			var no=$(this).attr('data-no')
			console.log(no)
			window.location.href = "newdetail.html?no="+$(this).attr('data-no');
		    
			});
	    
	    
	    
	    $(document).on("click","#inviteadd",function(event) {
			var no=$(this).attr('data-no')
			var no2=$(this).attr('data-no2')
			var no3=$(this).attr('data-no3')
			console.log(no)
			console.log(no2)
			$.post(serverAddr + "/travel/invagree.json?no="+no, {no:no,no2:no2,no3:no3}, function(obj) {
				var result = obj.jsonResult
				console.log(no)
				//location.reload(true)
				history.go(0)
		    })  
			});
	    
	    $(document).on("click","#inviterefuse",function(event) {
	    	
			var no=$(this).attr('data-no')
			console.log(no)
			$.post(serverAddr + "/travel/invrefuse.json?no="+no, {no:no}, function(obj) {
				var result = obj.jsonResult
				console.log(no)
				//location.reload(true)
				history.go(0)
		    })  
		    
			});
    })
}

function ajaxAgreeInviteList() {
	$.getJSON(serverAddr + "/travel/invagreelist.json", function(result) {
		if (result.state != "success") {
//		       alert("서버에서 데이터를 가져오는데 실패했습니다.")
		       return
		}
		console.log(result)
		var contents = "<h4>수락한동행</h4>";
	    var arr = result.data
	    for (var i in arr) {
	    	contents +=
	    		'<pre class="prettyprint">'+'<img  class="img-circle" src="../upload/'+arr[i].invitePhoto+'"style="width:50px; height:40">'+"&nbsp&nbsp;"+
	    		arr[i].inviteName+" 님과 동행입니다. &nbsp;"+
				'<button style="float:right" data-no="'+arr[i].inviteNo+'" class="btn btn-default btn-sm" id="inviterefuse" value="sdfds">거절</button>'
				+'</pre>'	    		
	    		
	    		/*'<ul>' +
	    		'<li><a class="titleLink" href="#" data-memno="' + arr[i].memberNo + '" data-no="' + arr[i].no + '">' +
	    		'<img src="' + arr[i].myPhoto + '"></a>' +
	    		'<div class="cycle-overlay">' +
	    		arr[i].writer + '<br>' +
	    		arr[i].continent + ',' + arr[i].nation + ',' + arr[i].city + '<br>' +
	    		arr[i].startDate + '~' + arr[i].endDate + '</div></li>' +
	    		'</ul>'*/
	      }
	    
	    $("#fadeandscale>h5").html(contents)
	    
	    $(document).on("click","#inviteadd",function(event) {
			var no=$(this).attr('data-no')
			console.log(no)
			$.post(serverAddr + "/travel/invagree.json?no="+no, {no:no}, function(obj) {
				var result = obj.jsonResult
				console.log(no)
				//location.reload(true)
				history.go(0)
		    })  
		    
			});
	    
	    $(document).on("click","#inviterefuse",function(event) {
			var no=$(this).attr('data-no')
			console.log(no)
			$.post(serverAddr + "/travel/invrefuse.json?no="+no, {no:no}, function(obj) {
				var result = obj.jsonResult
				console.log(no)
				//location.reload(true)
				history.go(0)
		    })  
		    
			});
    })
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







