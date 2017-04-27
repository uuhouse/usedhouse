function showTime(){
	var myDate = new Date();
	var year=myDate.getFullYear();
	var month=myDate.getMonth()+1;
	var date=myDate.getDate();
	var day=myDate.getDay();
	var d="";
	switch(day){
		case 1:
			d+="一";
			break;
		case 2:
			d+="二";
			break;
		case 3:
			d+="三";
			break;
		case 4:
			d+="四";
			break;
		case 5:
			d+="五";
			break;
		case 6:
			d+="六";
			break;
		case 7:
			d+="日";
			break;
	}
	var show="系统时间： "+year+"年"+month+"月"+date+"日 "+"星期"+d;

	var node=document.createElement("p");
	var textnode=document.createTextNode(show);
	node.appendChild(textnode);
	context=document.getElementById("date");
	context.appendChild(node);
}