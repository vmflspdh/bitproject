$("#signInBtn").click(function(event) {

	var member = {
			name: $("#name").val(),
			email: $(".col-sm-10 > #email").val(),
			password: $(".col-sm-10 > #password").val(),
			birthday: $("#birthday").val(),
			gender: $("#gender").val()

	}
	console.log(member)
	var count = 0;
	for (var key in member) {
		if (member[key] != "") {
			console.log(member[key])
			count++
		}
	}
	console.log(count)
	if (count == 5) {
		ajaxAddMember(member)
		alert("등록 성공입니다.")
	} else {
	alert("등록 실패입니다.")
	}
});



$("#updateBtn").click(function(event) {

	var formData = new FormData();
	formData.append("no", $("#bit-no").val());
	formData.append("name", $("#bit-name").val());
	formData.append("email", $("#bit-email").val());
	formData.append("password", $("#bit-password").val());
	formData.append("birthday", $("#bit-birthday").val());
	formData.append("gender", $("#bit-gender").val());
	formData.append("file", $("input[name=file]")[0].files[0]);
	
	
/*	var member = {
			name: $("#name").val(),
			email: $("#email").val(),
			password: $("#password").val(),
			birthday: $("#birthday").val(),
			gender: $("#gender").val(),
			registedDate: $("#registedDate").val(),
			no: $("#no").val()
	}*/
	ajaxUpdateMember(formData)
});

$("#deleteBtn").click(function(event) {

	ajaxDeleteMember($("#no").val(),
			$("#password").val())
});

function ajaxAddMember(member) {

	$.post("add.json", member, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("등록 실패입니다.")
			return
		}

	}, "json")
}

function ajaxLoadMember(no) {

	$.getJSON("detail.json?no="+ no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("조회 실패입니다.")
			return;
		}

		$("#no").val(result.data.no);
		$("#bit-name").val(result.data.name);
		$("#bit-email").val(result.data.email);
		$("#bit-birthday").val(result.data.birthday);
		$("#bit-gender").val(result.data.gender);
		$("#bit-registedDate").val(result.data.registedDate);
		$("#memberPhoto").text(result.data.memberPhoto);
	})
}

function ajaxUpdateMember(formData) {
	console.log(formData)
	
	$.ajax({
		url : "update.json",
		processData : false,
		contentType : false,
		data : formData,
		type : "POST",
		success : function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				console.log(result.data)
				alert("변경 실패입니다.")
				return
			}
			window.location.reload(true)
		}
	});

/*	$.post("update.json", member, function(obj) {
		var result = obj.jsonResult
		console.log(member)
		if (result.state != "success") {
			console.log(result.data)
			alert("변경 실패입니다.")
			return
		}
		window.location.reload(true)
	}, "json")*/
}


function ajaxDeleteMember(no, password) {

	$.getJSON("delete.json", {
		no: no, 
		password: password
	}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			console.log(result.data)
			alert("삭제 실패입니다.")
			return
		}
		window.location.href = "memberApp.html"
	})

}