

function ajaxMemberList() {

	$.getJSON("list.json", function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는 데 실패했습니다.")
			return
		}

		var contents = "";
		var arr = result.data

		for ( var i in arr) {
			contents += "<tr>" +
			"<td>" + arr[i].no + "</td>" +
			"<td><a class='titleLink' href='#' data-no='" + arr[i].no +"'>" + arr[i].name + "</a></td>" +
			"<td>" + arr[i].email + "</td>" +
			"<td>" + arr[i].birthday + "</td>" +
			"<td>" + (arr[i].gender == "1" ? "여" : "남") + "</td>" +
			"<td>" + arr[i].registedDate + "</td>" +
			"<td>" + arr[i].memberPhoto + "</td>" +
			"</tr>";
		}

		$("#boardTable tbody").html(contents);
		// tr 태그를 추가한 후에 제목에 대해 click 리스너를 추가하지 않는다.
		$(".titleLink").click(function(event) {
			window.location.href = "memb_regForm.html?no=" + $(this).attr("data-no");
		})
	})
}


