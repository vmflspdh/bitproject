$("#loginBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});

$("#logoutBtn").click(function(event) {
	location.href = "../auth/authApp.html"
});


function ajaxQnaList() {
	$.getJSON("qnalist.json", function(result) {
		if (result.state != "success") {
	    	 alert("서버에서 데이터를 가져오는데 실패했습니다.")
	    	 return
	    }
		
		var contents = ""
	    var arr = result.data
	    for (var i in arr) {
	        /* 	if (i == 0) {
	         		contents +=
	         			'<div class="notice_top_wrap">' +
	         			'<p class="listNum fr">Total&nbsp;<span class="purple">89</span></p>' +
	         			'</div>'
	         	}*/
	             contents += 
	             	'<dl class="clearfix goView"  style=" padding-right : 708px; border-bottom :1px #7f7f7f solid; width: 1170px;">' +
	             	'<dd class="fr" style="border : 1px solid ##ffffff; >' +
	             	'</br>'+
	             	'<p class="info_notice clearfix">' +
	             	'<span class="date_notice">' + arr[i].createDate + '</span>'+
	             	'</br>'+
	             	'</br>'+
	             	'<span class="hit_notice">' + arr[i].viewCount +  '</span>'+
	             	'</p>'+
	             	'</br>'+
	             	'<p class="tit_notice clearfix">' +
	             	'<span class="titleLink" href="#" data-qno="' + arr[i].qno + '">' + arr[i].title + '</span>'+
	             	'</p>' +
	             	/*<td><a class='titleLink' href='#' data-qno='" + arr[i].qno + "'>" + arr[i].title + "</a></td>"
	 */            	'<p class="txt_notice">' + arr[i].contents + '</p>' +
	             	'</dd>' +
	             	'</dl>'
	     }
	 		
	
	 		/*
	 		<span><a class='titleLink' href='#' data-qno='" + arr[i].qno + "'>" + arr[i].title + "</a><span>
	 		*/
	 /*	page.renderpager(1001);*/
	     
	 	    $(".notice_wrap").html(contents)
	 	   $(".titleLink").click(function(event) {
	 		    window.location.href = "qnaForm.html?qno=" + $(this).attr("data-qno")
	 	    })
	     })
	 }
	 ajaxQnaList();
