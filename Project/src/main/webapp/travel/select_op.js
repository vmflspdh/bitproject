        $(document).ready(function(){
            // 옵션추가 버튼 클릭시
     /*       $("#addrootBtn").click(function(){
                // root 의 최대번호 구하기
                var lastrootNo = $("#root-select tr:last").attr("class").replace("root", "");
                var newroot = $("#root-select tr:eq(1)").clone();
                newroot.removeClass();
                newroot.find("td:eq(0)").attr("rowspan", "1");
                newroot.addClass("root"+(parseInt(lastrootNo)+1));
 
                $("#root-select").append(newroot);
            });
 
 */
            // 항목추가 버튼 클릭시
            $(".selectAddBtn").live("click", function(){
                var clickedRow = $(this).parent().parent();
                var cls = clickedRow.attr("class");
 
                // tr 복사해서 마지막에 추가
                var newrow = clickedRow.clone();
                newrow.find("td:eq(0)").remove();
                newrow.insertAfter($("#root-select ."+cls+":last"));
 
                // rowspan 조정
                resizeRowspan(cls);
            });
             
             
            // 삭제버튼 클릭시
            $(".selectDelBtn").live("click", function(){
                var clickedRow = $(this).parent().parent();
                var cls = clickedRow.attr("class");
                 
                // 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
                if( clickedRow.find("td:eq(0)").attr("rowspan") ){
                    if( clickedRow.next().hasClass(cls) ){
                        clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
                    }
                }
 
                clickedRow.remove();
 
                // rowspan 조정
                resizeRowspan(cls);
            });
 
            // cls : rowspan 을 조정할 class ex) root1, root2, ...
            function resizeRowspan(cls){
                var rowspan = $("."+cls).length;
                $("."+cls+":first td:eq(0)").attr("rowspan", rowspan);
            }
        });
