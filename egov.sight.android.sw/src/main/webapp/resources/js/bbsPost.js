/**
 * 
 */
$("#submit").click(function(){
	console.log("아오");
	console.log($('#content').val());
	$('#content').val().replace(/' '/g, '<br>');
})
