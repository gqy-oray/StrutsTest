$(document).ready(function(){
	is_login();
});

function is_login(){
	//通过json形式传递数据，第一个参数是数据交互页面
//	第二个参数是传递给交互页面的数据
//	data表示交互过后返回的json数据
	$.getJSON("home/islogin.jsp",{"name":"name"},function(data){
//		alert(data.context);
		$(".is_login").html(data.content);
 	});
}