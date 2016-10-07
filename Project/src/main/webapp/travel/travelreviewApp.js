/*$("#loginBtn").click(function(event){
	location.href="../auth/authApp.html"
});1
$("#logoutBtn").click( function(event){
	location.href="../auth/authApp.html"
	//ajaxLogout()
});
*/
function ajaxUpdateBoard2(review){
	console.log(review)
	$.post("rvupdate.json",review,function(result){
		if(result.state !="success"){
			alert("변경실패입니다.")
			return;
		}
		console.log(review)
		window.location.href="travelreviewForm.html"
	},"json")
	
}

function ajaxBoardList() {
	
	$.getJSON("rvlist.json", function(result) {
		if(result.state!="success"){
			 
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		
		var contents="";
		var arr = result.data
		for ( var i in arr) {

			contents += "<tr>"+
				"<td>"+arr[i].reviewboardno+"</td>"+
				"<td>"+arr[i].travelno+"</td>"+
				"<td><a class='titleLink2' href='#' data-no2='"+arr[i].memberno+"'>"+arr[i].memberno+"</a></td>"+
				"<td><a class='titleLink' href='#' data-no='"+arr[i].reviewboardno+"' data-no3='"+i+"'>"+arr[i].title+"</a></td>"+
				"<td>"+arr[i].content+"</td>"+
				"<td>"+arr[i].createdDate+"</td>"+
				"<td>"+arr[i].viewcount +"</td>"+
			"</tr>";
		}
		
		$("#boardTable tbody").html(contents);
		
		//console.log(contents)
		
		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(".titleLink").click(function(event) {
				window.location.href = "travelreviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다.
				alert(result.data[$(this).attr("data-no3")].viewcount)
				var review = {
					viewcount : result.data[$(this).attr("data-no3")].viewcount+1
				}
				ajaxUpdateBoard2(review);	
				console.log(review)
				/*alert(result.data[$(this).attr("data-no3")].viewcount+1)*/
				/*arr[i].viewcount = */
				/*	alert(result.data[$(this).attr("data-no3")].viewcount+1)
				alert(a++)*/
				/*var arr = result.data
				for ( var i in arr) {
				alert(arr[30].viewcount)
				}
				var a = arr[$(this).attr("data-no")].viewcount 
				console.log('a');*/
				
			});
		
		$(".titleLink2").click(function(event) {
			window.location.href = "travelreviewmemberForm.html?no="+$(this).attr("data-no2");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다. 
		});
		});
		
	
		
	
	
	
	
}

/*function ajaxLoginUser(){
	
	$.getJSON("../auth/loginUser.json", function(result) {
		
		
		if(result.state !="success"){
			$('.my-login').css("display","none")
			return;
		}
		
		$('.my-logout').css("display","none")
		
			
			
			//document.querySelector("#userName").textContent = result.data.name;
			$("#userName").text(result.data.name);
		
	})
	
	
	
	
}*/