<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보입니다</h1>
	<c:choose>
		<c:when test="${ !empty requestScope.member2 }">
			<ul>
				<li>${member2.name}</li>
				<li>${member2.phone}</li>
				<li>${member2.id}</li>
				<li>${member2.pw }</li>
				<li>${address}</li>
			</ul>
		</c:when>
		<c:when test="${ !empty requestScope.mem }">
			<ul>
				<li>${mem.name}</li>
				<li>${mem.phone}</li>
				<li>${mem.id}</li>
				<li>${mem.pw }</li>
			</ul>
		</c:when>
		<c:when test="${ !empty requestScope.memberVO }"><!-- request에 데이터가 있으면 -->
			<ul>
				<li>${memberVO.name}</li>
				<li>${memberVO.phone}</li>
				<li>${memberVO.id}</li>
				<li>${memberVO.pw }</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li>${name}</li>
				<li>${phone}</li>
				<li>${id}</li>
				<li>${password}</li>
			</ul>
		</c:otherwise>
	</c:choose>
	<br>
	<br>

	<!-- 알고 있듯이 내장 객체 이용해서 전 페이지 주소 알아낼 수 있으니까 뒤로가기 기능 만들 수 있음 -->
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>