$("#comtaddBtn").click(function(event){
	
	var comment = { 
			// reviewboardNo :$("#crbno").val(),
			reviewboardNo : no,
			/* memberNo :$("#cmno").val(), */
			content : $("#cmcontent").val()
// cc.val(result.data.name)
			
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
			swal(
					  '로그인 후 작성해주세요!',
					  'Something went wrong!',
					  'error'
					)
			return;
		}
		location.reload();
		console.log(comment)
		// window.location.href="reviewApp.html"
	},"json")
	
	
}


function ajaxCommentList(no) {
	/*
	 * console.log(no) console.log(parseInt(no))
	 */
	$.getJSON(serverAddr+"/travel/cmlist.json?no="+no,parseInt(no), function(obj) {
		var result=obj.jsonResult;
		if(result.state!="success"){
			
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		
		var contents="";
		var arr = result.data
		a=0;
		console.log($(".form-horizontal > #bbb").val())
		for ( var i in arr) {
			
			

			contents += 
				"<tr>"+
				"<td id='firstcolum'>"+arr[i].reviewcommentNo+"<input id='aaa'></input></td>"
				if (arr[i].cmMemberPhoto == null) {
					contents += "<td style='font-weight: bold;'><img src='img/iconmonstr-user-20-240.png'style='width: 30px; height: 30px; border-radius: 50%;'>&nbsp;"+ arr[i].memberName+"</td>"
				} else if (arr[i].cmMemberPhoto.substring(0,1) == 'h') {
					contents += "<td style='font-weight: bold;'><img src='" + arr[i].cmMemberPhoto+"'style='width: 30px; height: 30px; border-radius: 50%;'>&nbsp;"+ arr[i].memberName+"</td>"
				} else {
					contents += "<td style='font-weight: bold;'><img src='../upload/" + arr[i].cmMemberPhoto+"'style='width: 30px; height: 30px; border-radius: 50%;'>&nbsp;"+ arr[i].memberName+"</td>"
				}
			contents +=
				"<td>"+arr[i].content+"</td>"+
				"<td>"+arr[i].createdDate2+"</td>"+
				
				"<td><a class='updateLink' href='#' oneclick='true' data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].reviewcommentNo+"'>"+(($("#bbb").val()==arr[i].memberNo)?"수정":"")+"</a></td>"+
				"<td><a class='deleteLink' href='#'  data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].reviewcommentNo+"'>"+(($("#bbb").val()==arr[i].memberNo)?"삭제":"")+"</a></td>"+
				"</tr>";
				
		}
		
		console.log($("#bbb").val())
		/* console.log($("#ccc1").val()) */
		
		
		console.log(contents)
		
		$("#commentTable tbody").html(contents);
		
		// console.log(contents)
		
		// tr 태그를 추가한 후에 제목에 대해 click 리스너를 추가한다.
		$(document).on("click",".updateLink",function(event) {
			
			console.log($(this).attr("oneclick"))
			if($(this).attr("oneclick") =="true"){
				
			var a=$(this).attr("data-no2")
			console.log(a)
			$("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" +
					"<td><button type='button' id='commentUpdateBtn'>변경 </button></td>");
			
				// window.location.href =
				// "reviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다
				// this자리에 selector 말고도 태그를 넣을수 있다.
			console.log($(this).attr("data-no"))
			$("#aaa").val($(this).attr("data-no"))
			$(this).attr("oneclick","false")
			}
			});
		
		
		
			
		
			$(document).on("click",".deleteLink",function(event) {
			
			console.log($(this).attr("data-no"))
/*
 * var a=$(this).attr +("data-no2") console.log(a)
 */
			
		/*
		 * $("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input
		 * class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" + "<td><button
		 * type='button' id='commentUpdateBtn'>변경 </button></td>");
		 */
			
			console.log($(this).attr("data-no"))
			$("#aaa").val($(this).attr("data-no"))
			
			ajaxCommentDelete($(this).attr("data-no"))
			
			
			});
		/*
		 * $(".zz").click(function(event) { alert('aaaa');
		 * 
		 * });
		 */
		
		
		});
	
		
	
}

function abc(){
	aaaa={
	b:$("#bbb").val(),
	c:$("#ccc").val()
	}
	console.log(aaaa)
}



function ajaxCommentDelete(no){
	$.getJSON("cmdelete.json?=no"+no,{no:no},function(obj){
		var result = obj.jsonResult
		console.log(no)
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
	
	comment= {
			reviewcommentNo : $("#aaa").val(),
			content: $(".updateContentInput").val()
	}
	console.log(comment)
	ajaxCommentUpdate(comment)
});


function ajaxCommentUpdate(comment){
	console.log(comment)
	console.log($(this).attr("data-no"));
	
	$.post(serverAddr+"/travel/cmupdate.json",comment,function(obj){
		var result = obj.jsonResult
		console.log(comment)
		if(result.state !="success"){
			swal(
					  '로그인 후 작성해주세요!',
					  'Something went wrong!',
					  'error'
					)
			return;
		}
		location.reload();
		console.log(comment)
		// window.location.href="reviewApp.html"
	},"json")
	
	
}