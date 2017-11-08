$(document).ready(function() {
	userMenu();
	loadInfor();
	loadInforT();
});
function userMenu() {
	$.getJSON("personaldata.jsp",{"name":"name"},function(data) {
// alert(data.content);
		$(".user-information-menu").html(data.content);
		
	});
	
}

function loadInfor(element){
//	alert(element.innerHTML);
	//$(".user-information-content").html("信息");
	$.getJSON("personalinfor.jsp",{"name":element.innerHTML},function(data){
		
		$(".user-information-content").html(data.content);
	});
	/*$("#menu > li").each(function(index,element){
		$(element).click(function(){
			$()
			$.getJSON("personalinfor.jsp",{"name":element.innerHTML},function(data){
				$(".user-information-content").html(data.content);
			});
		});
	});*/
}
