
$("#signInBtn").click(function(event) {
	
var member = {
		name: $("#name").val(),
		email: $(".col-sm-10 > #email").val(),
		password: $(".col-sm-10 > #password").val(),
		birthday: $("#birthday").val(),
		gender: $("#gender").val()
		
}
console.log(member)
ajaxAddMember(member)
});

$("#updateBtn").click(function(event) {

	var member = {
	    name: $("#name").val(),
	    email: $("#email").val(),
	    password: $("#password").val(),
	    birthday: $("#birthday").val(),
	    gender: $("#gender").val(),
	    registedDate: $("#registedDate").val(),
	    no: $("#no").val()
	}
	console.log(member)
	ajaxUpdateMember(member)
	});

$("#deleteBtn").click(function(event) {

	  ajaxDeleteMember($("#no").val(),
		$("#password").val())
	  });

function ajaxAddMember(member) {
	
	$.post("add.json", member, function(result) {
		if (result.state != "success") {
	    	  console.log(result.data)
	    	  alert("등록 실패입니다.")
	    	  return
	      }
		window.location.reload(true)
	}, "json")
  }
  
function ajaxLoadMember(no) {

	$.getJSON("detail.json?no="+ no, function(result) {
		 if (result.state != "success") {
		        console.log(result.data)
		        alert("조회 실패입니다.")
		        return;
		      }
		 
		      $("#no").val(result.data.no);
		      $("#name").val(result.data.name);
		      $("#email").val(result.data.email);
		      $("#birthday").val(result.data.birthday);
		      $("#gender").val(result.data.gender);
		      $("#registedDate").val(result.data.registedDate);
		      $("#memberPhoto").text(result.data.memberPhoto);
	})
	  }
  
function ajaxUpdateMember(member) {
	
	$.post("update.json", member, function(result) {
		if (result.state != "success") {
	    	  console.log(result.data)
	    	  alert("변경 실패입니다.")
	    	  return
	      }
	      window.location.href = "memberApp.html"
	}, "json")
  }
  
  
function ajaxDeleteMember(no, password) {

	$.getJSON("delete.json", {
		no: no, 
		password: password
	}, function(result) {
		  if (result.state != "success") {
		        console.log(result.data)
		        alert("삭제 실패입니다.")
		        return
		      }
		      window.location.href = "memberApp.html"
	})

  }