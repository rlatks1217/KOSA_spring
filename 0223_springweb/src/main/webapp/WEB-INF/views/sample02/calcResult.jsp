<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL 검색 순서
	page scope => request scope => session scope => application scope
 -->
 <% pageContext.setAttribute("myData", "소리없는 아우성!"); %>
 <!-- 
 EL표기법을 사용할 경우 하위 scope부터 해당 key의 값을 찾기 때문에 page scope에 찾고자 하는 key가 있으면 여기서 먼저 찾을 데이터를 검색하고 멈추게 됨 
 그래서 사용할 데이터는 model에 저장했는데 해당 데이터에 대한 key가 page에도 있으면 그 값을 가져오게 됨 
 -->
 <br>
 <h6>request.getAttribut("msg") - 결과는 : <%= request.getAttribute("msg") %></h6>
 <h3>$ { msg } - 결과는 : ${ msg }</h3>
 <h3>$ { param.msg } - 결과는 : ${ param.msg  }</h3> <!-- 클라이언트가 보내준 데이터의 key중 msg는 없으므로 아무것도 안 나옴  -->
 <!-- param은 request가 가지고 있는 객체임 얘를 씀으로써 조금 더 간단한 표기방식으로 attribute 즉, key값에 접근할 수 있음 -->
 <h3>${ param.firstNum }, ${ param.secondNum }</h3>
 <!-- 그냥 찍어주기 위해서 $ 다음 띄워쓰기 -->
 
 <br><br>
 <a href="${header.referer}">뒤로가기</a>
</body>
</html>