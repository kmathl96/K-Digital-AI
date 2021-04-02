<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
    $(function() {
        $(document).on("click", ".select", function() {
        var innum = $(this).attr("id");

        var btnnum = Number(innum.charAt(3));
        var orderstr = $(".querystring"+Number(btnnum)).val();  
    	$.ajax({
            type:"post",
            async:false, 
            url:"${contextPath}/chatbot",
            data : {order: orderstr},
            success:function (data,textStatus){           
            	var jsondata = JSON.parse(data);	
        		var div = $("<div></div>").attr("id","div"+String(btnnum+1));
            	var label = $("<label>"+jsondata.description+"</label>").attr("id", "label"+String(btnnum+1));
            	var query = $("<input></input>").attr("type","text").attr("class", "querystring"+String(btnnum+1));
            	var btn = $("<input></input>").attr("type","button").attr("id", "btn"+String(btnnum+1)).attr("value","선택").attr("class","select");
            	div.append(label);
            	if(!jsondata.end) div.append(query);
            	if(!jsondata.end) div.append(btn);
            	$("#outter").append(div);
	        },
    	    error:function(data,textStatus){
	          alert("에러가 발생했습니다.");ㅣ
	        },
	        complete:function(data,textStatus){
	        }
	    }); 
        });
    });
 </script>
</head>
<body>
   <input type="button" id="btn0" class="select querystring0" style="cursor:pointer" value="피자주문할께요"/><br><br>
   <div id="outter"></div>
  <!--  <div><label id="label1"></label><input type="text" id="qurstring1"/><input type="button" id="btn1" value="선택"/></div> -->
