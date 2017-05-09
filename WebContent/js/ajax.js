clickNum=0;  //标记点击个数
stringToServlet=""; //传给服务器后台的数据
function ajax(){
//将每次点击的内容保存下来以字符串的形式
    var x=String(event.clientX);
	var y=String(event.clientY);
//	alert(event.clientX+"String:"+event.clientY);//验证值成功
	//字符串的形式是x1=1&y1=2&x1=1&y2=2	
	if(clickNum==0)
		stringToServlet+="x"+(clickNum+1)+"="+x+"&y"+(clickNum+1)+"="+y;
	else
		stringToServlet+="&x"+(clickNum+1)+"="+x+"&y"+(clickNum+1)+"="+y;
//	console.log(stringToServlet);
	clickNum++;
}

function ajaxsend1() {
	// 1.创建对象
	var oAjax = null;
	if (window.XMLHttpRequest) {
		oAjax = new XMLHttpRequest();
	} else {
		oAjax = new ActiveXObject("Microsoft.XMLHTTP");
	}

	stringToServlet+="&fun=1&clickNum="+clickNum;
	if (oAjax != null) {
		oAjax.onreadystatechange = state_Change;
		oAjax.open("POST", "Routing", true); // 2.连接服务器 url直接填的"Routing"
		oAjax.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		//在Get请求不使用send传递数据，填入null
		oAjax.send(stringToServlet);
	} else {
		alert("Your browser does not support XMLHTTP.");
	}
	
	clickNum=0;
	stringToServlet="";
	// 4.接收返回
	function state_Change() {
		if (oAjax.readyState == 4) {// 4 = "loaded"
			if (oAjax.status == 200) {// 200 = OK
//				alert(oAjax.responseText);
//				console.log(oAjax.responseText)
				a = eval(oAjax.responseText);
				//获取的话是这样的
				len=0; //全局变量表示个数
				for(key in a){
					len++;
				}
				print();
			} else {
				// alert("Problem retrieving XML data");
			}
		}
	}
}
function ajaxsend2() {
	// 1.创建对象
	var oAjax = null;
	if (window.XMLHttpRequest) {
		oAjax = new XMLHttpRequest();
	} else {
		oAjax = new ActiveXObject("Microsoft.XMLHTTP");
	}

	stringToServlet+="&fun=2&clickNum="+clickNum;
	if (oAjax != null) {
		oAjax.onreadystatechange = state_Change;
		oAjax.open("POST", "Routing", true); // 2.连接服务器 url直接填的"Routing"
		oAjax.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		oAjax.send(stringToServlet);
	} else {
		alert("Your browser does not support XMLHTTP.");
	}
	clickNum=0;
	stringToServlet="";
	// 4.接收返回
	function state_Change() {
		if (oAjax.readyState == 4) {// 4 = "loaded"
			if (oAjax.status == 200) {// 200 = OK
				// ...our code here...
				a = eval(oAjax.responseText);
				//获取的话是这样的
				len=0; //全局变量表示个数
				for(key in a){
					len++;
				}
				print();
			} else {
				// alert("Problem retrieving XML data");
			}
		}
	}
}
function print(){
	//追加画线的功能
	var x1="",y1="",x2="",y2="",pos1="",pos2="";
	for(var i=1;i<=len-4;i++){
		pos1='a'+i;
		pos2='a'+(i+1);
	    svg.append("line")
	       .attr("x1",a[pos1].x)
	       .attr("y1",a[pos1].y)
	       .attr("x2",a[pos2].x)
	       .attr("y2",a[pos2].y)
	       .attr("stroke","black")
	       .attr("stroke-width","5");
	}
	//追加输出的信息文本
	d3.select("body").append("p");//相对按钮标签换行
	var text= d3.select("body")
		.append("text")
		.text(function(d){
			return "计算使用时间："+a.time+
				"ms  路径距离："+a.distance;
		});
}