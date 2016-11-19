
$("#bookmarkSummit").click(function(event) {

	ajaxAddBookmark()
})


function ajaxBookmarkList() {
	$.getJSON(serverAddr + "/travel/bookmarkList.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			//alert("서버에서 북마크데이터를 가져오는데 실패했습니다.")
			return
		}
		var contents = "<h4>북마크</h4>";
		var arr = result.data
		for (var i in arr) {
			contents +=
				'<pre class="prettyprint">'
				if (arr[i].memberPhoto == null) {
					contents += '<img  class="img-circle" src="img/iconmonstr-user-20-240.png"style="width:40px; height:40px;">'
				} else if (arr[i].memberPhoto.substring(0,1) == 'h') {
					contents += '<img  class="img-circle" src="'+arr[i].memberPhoto+'"style="width:40px; height:40px;">'
				} else {
					contents += '<img  class="img-circle" src="../upload/'+arr[i].memberPhoto+'"style="width:40px; height:40px;">'
				}
			contents +=
				"&nbsp&nbsp;"+
				arr[i].memberName+"님의 페이지가 추가되었습니다. &nbsp;"+
				'<button type="button" data-no="'+arr[i].travelMainNo+'" data-no2="'+arr[i].memberNo+'" class="btn btn-default btn-sm" id="bookmarkdelete" style="float:right;">삭제</button>' +
				'<button type="button" data-no="'+arr[i].travelMainNo+'"class="btn btn-default btn-sm" id="bookmarkdetail" style="float:right;">상세페이지</button>'
				+'</pre>'		
		}

		$("#fadeandscale>h6").html(contents)
		$(document).on("click","#bookmarkdetail",function(event) {
			var no=$(this).attr('data-no')
			window.location.href = "newdetail.html?no="+$(this).attr('data-no');

		});

		$(document).on("click","#bookmarkdelete",function(event) {
			var no=$(this).attr('data-no')
			ajaxDeleteBookmark(no)

		});
	})                  
}

function ajaxBookmarkCount() {
	$.getJSON(serverAddr + "/travel/bookmarkCount.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			return
		}
		var arr = result.data
		$("#bookmarkcount").text(arr[0].bookmarkCount)

	})
}

function ajaxAddBookmark() {
	$.post(serverAddr + "/travel/bookmarkAdd.json", function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			swal(
					'이미 등록되었습니다!',
					'Something went wrong!',
					'error'
			)
			return;
		} else if (result.state == "success") {
		swal(
				'등록 성공!',
				'sign in success!',
				'success'
		)
		window.location.reload(true)
		}
	
	}, "json")
	
	   $(document).ajaxError(function(info,xhr){
    if(xhr.status==500)
		
		swal({
			title: '회원이신가요?',
			text: "만약 회원이 아니라면 회원가입을 해주세요",
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes, I will!'
		}).then(function () {
			$("#myModal").modal('show');
		})
    }
   );

	
}

function ajaxDeleteBookmark(no) {
	$.post(serverAddr + "/travel/bookmarkDelete.json", {no: no},  function(obj){
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("등록 실패입니다.")
			return
		}
		alert("삭제되었습니다.")
		history.go(0)

	}, "json")
}

