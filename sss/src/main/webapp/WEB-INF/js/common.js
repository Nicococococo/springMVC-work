var urlVal = "http://106.13.209.94:1001";
//var urlVal = "http://localhost:1001";

var token = "bearereyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdCJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1NjU1MTA0MjksImF1dGhvcml0aWVzIjpbImEiLCJiIiwidiJdLCJqdGkiOiIyMTg1ODJkOC1kOTFhLTQ4ZjgtYTg5OC1lNjdlYTU2M2Q1MjUiLCJjbGllbnRfaWQiOiJteWFwcCJ9.XtjrAxg-_80tPJclhUb5oUiTQF8HiRZMO98oS-SQZ0c";

$.ajaxSetup({
	contentType : "application/x-www-form-urlencoded;charset=utf-8",
	complete : function(XMLHttpRequest, textStatus) {
		var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
		if (sessionstatus == "timeout") {
			window.location.replace("${request.contextPath}/login.do");
		}
	}
});

/**
 * 获取一个随机不重复的数
 * @returns {String}
 */
function geTrandomCode(){
	    var myDate = new Date();
	    var year = myDate.getFullYear();
	    var month = myDate.getMonth() + 1;
	    var date = myDate.getDate();
	    var hours = myDate.getHours();
	    var minutes = formatTime(myDate.getMinutes());
	    var seconds = formatTime(myDate.getSeconds());
	    var times = myDate.getTime()
	    var date = year +""+ month +""+  date +""+  hours +""+  minutes + Math.ceil(seconds+Math.random()*100000);
	    return date;
}

//格式化时间：分秒
function formatTime (i){
  if(i < 10){
    i = "0" + i;
  }
  return i;
}

//复选框全选 反选
$(function() {
	$("#checkAll").click(function() {
	    $("#checkAll").parent().parent().parent().parent().find("tbody").find("tr").find("td").find("input[type='checkbox']").prop("checked",this.checked); 
	})
});

/**
 * 根据年月获取天数
 * @param year
 * @param month
 * @returns
 */
function getDaysInMonth(year,month){ 
	month = parseInt(month,10); //parseInt(number,type)这个函数后面如果不跟第2个参数来表示进制的话，默认是10进制。 
	var temp = new Date(year,month,0); 
	return temp.getDate(); 
}

/**
 * 必填项校验
 * @param str
 * @returns {Boolean}
 */
function validateForm(str){
	var strArr=str.split(",");
	var flag = true;
	for(i = 0; i < strArr.length; i++) {
	    if(!$(strArr[i]).val()){
			layer.tips('请填写字段', strArr[i], {tipsMore: true});
			flag = false;
		}
	};
	return flag;
}

/**
 * 计算距离今天剩余天数
 */
function getIntervalOfDay(begindate){
	
	if(!begindate){
		return "";
	}
	
	begindate = new Date(Date.parse(begindate.replace(/-/g, "/"))); //将开始时间由字符串格式转换为日期格式       
	
	var startDate= begindate.getTime();
	
	var myDate = new Date(); //此处将服务器当前日期作为结束日期，也可为其他任意时间 

	var endDate = myDate.getTime(); //将结束日期转换成毫秒  
	
	var day = parseInt((startDate-endDate)/1000/3600/24); //结束日期减去开始日期后转换成天数    
	
	return day;
}