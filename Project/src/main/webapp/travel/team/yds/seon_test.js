function ajaxCmtList() {
   $.getJSON("cmtlist.json", function(result) {
      if (result.state != "success") {
           alert("서버에서 데이터를 가져오는데 실패했습니다.")
           return
       }
      
      var contents = ""
       var arr = result.data
       	a = 0;
        for (var i in arr) {
          contents += "<tr>" +
             "<td>" + arr[i].qcno + "</td>" + 
             "<td>" + arr[i].comMemberNo + "</td>" + 
            "<td>" + arr[i].commentContents + "</td>" +
            "<td>" + arr[i].cmtCreateDate + "</td>" + 

			"<td><a class='updateLink' href='#'  data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].qcno+"'>"+(($("#bbb").val()==arr[i].comMemberNo)?"수정":"")+"</a></td>"+
			"<td><a class='deleteLink' href='#'  data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].qcno+"'>"+(($("#bbb").val()==arr[i].comMemberNo)?"삭제":"")+"</a></td>"+ 
            "</tr>"
    }
        console.log($("#bbb").val())
		/*console.log($("#ccc1").val())*/
		abc()
		
		console.log(contents)
		
    
       $("#cmtTable tbody").html(contents)
   	$(document).on("click",".updateLink",function(event) {
		
		console.log($(this).attr("data-no"))
		var a=$(this).attr("data-no2")
		console.log(a)
		/*comment = {
			reviewcommentNo : console.log($(this).attr("data-no")),
			content : $('#commentTable tbody tr td:eq(1)').val()
		}*/
		
		
		
		//console.log(arr.content)
		/*$("#commentTable tbody tr:eq("+$(this).attr("data-no2")+") td:eq(1)").html("<input value="+$(this).attr("data-no3")+"></input>");*/
		
		$("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" +
				"<td><button type='button' id='commentUpdateBtn'>변경 </button></td>");
		
			//window.location.href = "reviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다.
		console.log($(this).attr("data-no"))
		$("#aaa").val($(this).attr("data-no"))
		});
	
	
	
		
	
		$(document).on("click",".deleteLink",function(event) {
		
		console.log($(this).attr("data-no"))
/*			var a=$(this).attr                                                                                                                                       +("data-no2")
		console.log(a)*/
		
	/*	$("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" +
				"<td><button type='button' id='commentUpdateBtn'>변경 </button></td>");*/
		
		console.log($(this).attr("data-no"))
		$("#aaa").val($(this).attr("data-no"))
		
		ajaxCmtDelete($(this).attr("data-no"))
		
		
		});
	/*$(".zz").click(function(event) {
		alert('aaaa');
		
	});*/
       
      
    })
}

//---------------------------------------------------------------------------------------------------------------------------------------------------

function abc(){
	aaaa={
	b:$("#bbb").val(),
	c:$("#ccc").val()
	}
	console.log(aaaa)
}

function ajaxCmtDelete(qcno){
	$.getJSON("cmtdelete.json",{
		qcno : qcno
	},function(obj){
		var result = obj.jsonResult
		console.log(qcno)
		if(result.state !="success"){
			console.log(result.data)
			alert("삭제실패입니다.")
			return;
		}
		location.reload();
		
	})
		
}

$(document).on("click","#commentUpdateBtn",function(event){
	console.log($(this).attr("data-no"));
	
	comment={
			qcno : $("#aaa").val(),
			content: $(".updateContentInput").val()
	}
	console.log(comment)
	ajaxCmtUpdate(comment)
});

function ajaxCmtUpdate(comment){
	console.log(comment)
	console.log($(this).attr("data-no"));
	
	$.post("cmtupdate.json",comment,function(obj){
		var result = obj.jsonResult
		console.log(comment)
		if(result.state !="success"){
			alert("로그인하고 댓글써.")
			return;
		}
		location.reload();
		console.log(comment)
		//window.location.href="reviewApp.html"
	},"json")
	
	
}






