$("#addBtn").click(function(event) {
	var qna = {
	no: $("#no").val(),
	title: $("#title").val(),
	  contents: $("#contents").val()
	}
	ajaxAddQna(qna)
});

$("#updateBtn").click(function(event) {
  var qna = {
	title: $("#title").val(),
	 contents: $("#contents").val(),
    qno: $("#qno").val()
  }
  ajaxUpdateQna(qna)
});



$("#deleteBtn").click(function(event) {
  ajaxDeleteQna(
		 $("#qno").val())
});



function ajaxAddQna(qna) {
	console.log(qna)
	$.post("qnaadd.json", qna, function(result) {
		if (result.state != "success") {
			console.log(result.data)
	    	 alert("등록 실패입니다.")
	    	 return
	    }
	    window.location.href = "qnaApp.html"
	}, "json")
}

function ajaxLoadQna(qno) {
	$.getJSON("qnadetail.json?qno=" + qno, function(result) {
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
	$("#qno").val(result.data.qno);
      $("#no").val(result.data.no);
      $("#title").val(result.data.title);
      $("#contents").val(result.data.contents);
      $("#createDate").val(result.data.createDate);
      $("#viewCount").val( result.data.viewCount);
      ajaxCmtList()
    })
}
   
function ajaxUpdateQna(qna) {
	$.post("qnaupdate.json", qna, function(result) {
		if (result.state != "success") {
			alert("변경 실패입니다.")
			return
		}
		window.location.href = "qnaApp.html"
	}, "json")
}

function ajaxDeleteQna(qno) {
	$.getJSON("qnadelete.json", {
		qno: qno
	}, function(result) {
		if (result.state != "success") {
			alert("삭제 실패입니다.")
			return
		}
		location.href = "qnaApp.html"
	})
}

//_______________________________________________[댓글]기능_____________________________________________________//




function ajaxCmtList() {
	$.getJSON("cmtlist.json", function(result) {
		if (result.state != "success") {
	    	 alert("서버에서 데이터를 가져오는데 실패했습니다.")
	    	 return
	    }
		
		var contents = ""
	    var arr = result.data
        for (var i in arr) {
          contents += "<tr>" +
          	"<td>" + arr[i].qcno + "</td>" + 
          	"<td>" + arr[i].comMemberNo + "</td>" + 
            "<td>" + arr[i].commentContents + "</td>" +
            "<td>" + arr[i].cmtCreateDate + "</td>" + 
            "</tr>"
    }
    
	    $("#cmtTable tbody").html(contents)
	   
    })
}
/*
function ajaxLoadCmt(cmt) {
	$.getJSON("cmtdetail.json?qcno=" + qcno, function(result) {
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
	$("#qcno").val(result.data.qcno);
      $("#no").val(result.data.no);
      $("#contents").val(result.data.contents);
      $("#createDate").val(result.data.createDate);
    })
}*/
   





//---------------------------댓글 js ------------------------------------------//

$(function(){
       
    //제일 하단에 있는 depth1의 댓글을 다는 이벤트
    $("#commentParentSubmit").click(function( event ) {
           
        //ajax로 저장하고 성공하면 저장한 데이터를 가져와 넣어야 하는데 여기서는 테스트라 그냥 입력값을 가져옴
        var pNumber = $("#commentNumber");
        var pMember = $("#commentMember");//회원번호를 노출 시켰는데 저장하고 나서 저장한 날짜를 보여줄 예정
        var pText = $("#commentParentText");
           
   
        var commentParentText = '<tr id="r1" name="commentParentCode">'+
                                    '<td colspan=2>'+
                                        '<strong>'+pNumber.val()+'</strong> '+pMember.val()+' <a style="cursor:pointer;" name="pAdd">답글</a> | <a style="cursor:pointer;" name="pModi">수정</a> | <a style="cursor:pointer;" name="pDel">삭제</a><p>'+pText.val().replace(/\n/g, "<br>")+'</p>'+
                                    '</td>'+
                                '</tr>';
           
        //테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
        if($('#commentTable').contents().size()==0){
            $('#commentTable').append(commentParentText);
        }else{
            $('#commentTable tr:last').after(commentParentText);
        }
           
        $("#commentNumber").val("");
        $("#commentMember").val("");
        $("#commentParentText").val("");
           
    });
       
    //댓글의 댓글을 다는 이벤트
    $(document).on("click","#commentChildSubmit", function(){
           
        var cNumber = $("#commentChildNumber");
        var cMember = $("#commentChildMember");
        var cText = $("#commentChildText");
           
        if($.trim(cNumber.val())==""){
            alert("이름을 입력하세요.");
            cNumber.focus();
            return;
        }else if($.trim(cMember.val())==""){
            alert("패스워드를 입력하세요.");
            cMember.focus();
            return;
        }else if($.trim(cText.val())==""){
            alert("내용을 입력하세요.");
            cText.focus();
            return;
        }
           
        var commentChildText = '<tr name="commentChildCode">'+
                                    '<td style="width:1%"><span class="glyphicon glyphicon-arrow-right"></span></td>'+
                                    '<td style="width:99%">'+
                                        '<strong>'+cNumber.val()+'</strong> '+cMember.val()+' <a style="cursor:pointer;" name="cAdd">답글</a> | <a style="cursor:pointer;" name="cDel">삭제</a>'+
                                        '<p>'+cText.val().replace(/\n/g, "<br>")+'</p>'+
                                    '</td>'+
                                '</tr>';
                                   
        //앞의 tr노드 찾기
        var prevTr = $(this).parent().parent().parent().parent().prev();
        //댓글 적는 에디터 삭제
        $("#commentEditor").remove();//여기에서 삭제를 해줘야 에디터tr을 안 찾는다.
           
        //댓글을 타고 올라가며 부모 tr을 찾음
        while(prevTr.attr("name")!="commentParentCode"){
            prevTr = prevTr.prev();
        }
        //while를 타는지 체크
        var check = false;
        //다음 노드가 댓글(depth1)의 댓글인지 찾기위해 next
        var nextTr = prevTr.next();
        //뒤에 댓글(depth1)의 댓글(depth2_1)이 없다면 바로 붙인다.
        if(nextTr.attr("name")!="commentChildCode"){
            prevTr.after(commentChildText);
        }else{
            //댓글(depth1)의 댓글(depth2_n)이 있는경우 마지막까지 찾는다.
            while(nextTr.attr("name")=="commentChildCode"){
                nextTr = nextTr.next();
                check = true;
            }
        }
           
        if(check){//댓글(depth1)의 댓글(depth2_n)이 있다면 그 댓글(depth2_n) 뒤에 댓글(depth2_n+1) 추가
            nextTr = nextTr.prev();//while문에서 검색하느라 next로 넘거갔던거 다시 앞으로 돌려줌
            nextTr.after(commentChildText);
        }
           
    });
       
    //답글링크를 눌렀을때 에디터 창을 뿌려주는 이벤트, 삭제링크를 눌렀을때 해당 댓글을 삭제하는 이벤트
    $(document).on("click","table#commentTable a", function(){//동적으로 버튼이 생긴 경우 처리 방식
           
        if($(this).attr("name")=="pDel"){
            if (confirm("답글을 삭제 하시면 밑에 답글도 모두 삭제 됩니다. 정말 삭제하시겠습니까?") == true){    //확인
                   
                var delComment = $(this).parent().parent();
                var nextTr = delComment.next();
                var delTr;
                //댓글(depth1)의 댓글(depth2_1)이 있는지 검사하여 삭제
                while(nextTr.attr("name")=="commentCode"){
                    nextTr = nextTr.next();
                    delTr = nextTr.prev();//삭제하고 넘기면 삭제되서 없기 때문에 다음값을 가져오기 어려워 다시 앞으로 돌려서 찾은 다음 삭제
                    delTr.remove();
                }
                   
                delComment.remove();
                   
            }else{   //취소
                return;
            }
        }else if($(this).attr("name")=="cDel"){
            if (confirm("정말 삭제하시겠습니까??") == true){    //확인
                $(this).parent().parent().remove();
            }else{   //취소
                return;
            }
        }else{
            //자기 부모의 tr을 알아낸다.
            var parentElement = $(this).parent().parent();
            //댓글달기 창을 없앤다.
            $("#commentEditor").remove();
            //부모의 하단에 댓글달기 창을 삽입
            var commentEditor = '<tr id="commentEditor">'+
                                    '<td style="width:1%"> </td>'+
                                    '<td>'+
                                        '<span class="form-inline" role="form">'+
                                            '<p>'+
                                                '<div class="form-group">'+
                                                    '<input type="text" id="commentChildNumber" name="commentChildNumber" class="form-control col-lg-2" data-rule-required="true" placeholder="댓글번호" maxlength="10">'+
                                                '</div>'+
                                                '<div class="form-group">'+
                                                    ' <input type="text" id="commentChildMember" name="commentChildMember" class="form-control col-lg-2" data-rule-required="true" placeholder="회원번호" maxlength="10">'+
                                                '</div>'+
                                                '<div class="form-group">'+
                                                    '<button type="button" id="commentChildSubmit" class="btn btn-default">확인</button>'+
                                                '</div>'+
                                            '</p>'+
                                                '<textarea id="commentChildText" name="commentChildText" class="form-control" style="width:98%" rows="4"></textarea>'+
                                        '</span>'+
                                    '</td>'+
                                '</tr>';
                                   
            parentElement.after(commentEditor); 
        }
           
    });
       
 
});

