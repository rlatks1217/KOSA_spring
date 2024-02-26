<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산시 오류가 발생했어요!</h1>
	<h3>오류의 원인${msg}</h3> <!-- 검색을 pageScope부터 시작해서 requestScope에 해당하는 객체 내부에서 검색해서 가져오게 될 것 -->
	<h3>
		오류의 원인: <%=request.getAttribute("msg")%>
	</h3>
</body>
</html>