
/**
 *  tr을 눌럿을 때 글번호의 값을 쿼리스트링으로 붙여서 이동시켜주는 함수
 */
$("tbody tr").click(function(){
	var index = $(this).find("td").eq(0).html();
	window.location = "bbsView.do?id="+index;
});