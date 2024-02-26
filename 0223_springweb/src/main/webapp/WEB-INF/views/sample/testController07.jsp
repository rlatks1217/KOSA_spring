<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jstl 이용하기 위한 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>testController07.jsp 호출</h1>
	<h1>Model 안에 저장되어 있는 데이터를 들고 와서 여기서 출력해야 해요!</h1>
	
	<h3>EL(특수한 표기법)을 이용해서 데이터를 추출해야 해요</h3>
	
	<%-- 
	<%= %> 대신 EL 사용 
	<% %> 대신 jstl 사용
	JSP 2.0 spec 안에 포함되어 있음
	
	EL : ${key값} 이런 식으로 사용함
	그럼 이 key값 어디에서 찾냐? 내장 객체에서 찾음
	
	EL에서 사용할 수 있는 내장객체
	1. page Scope
	2. request scope
	3. session scope
	4. application scope
	
	각 내장 객체들은 각각 해당 scope를 가지고 있는 객체의 정보를 가지고 있음(그래서 el문법을 사용해서 key값을 검색하는 것은 이 객체들 안을 검색하는 것)
	4가지 scope를 모두 검색해서 찾음(page scope -> request scope -> session scope -> application scope 순으로 찾음)
	(여기서의 scope는 공간이나 생명주기의 의미가 강함)
	다른 scope이면서 같은 key값을 가지고 있는 경우가 있음 하위 scope에 있는 value값을 먼저 찾게 되므로 그것을 가져오게 됨(데이터를 잘못 동작할 우려가 있음)
	-> 이처럼 여러 scope에 동일한 key값이 있을 경우 명시적으로 어떤 scope인지 써줘야 그 scope에서만 key값을 찾음
	sessionScope.myName : 이런 식으로 찾을 scope를 명시해주면 해결됨
	
	page scope 소속: Page Context 객체
	request scope 소속: Request 객체 + Model 객체(같은 requestScope이지만 request보다 Model객체를 먼저 검색하게 됨)
	session scope 소속: session 객체
	application scope 소속: servlet context 객체
	
	
	
	 --%>
	<!-- EL을 사용하면 request scope 안에 있는 model객체를 모두 검색할 수 있음 -->
	<ul>
		<li>이름 : ${myName}</li>
		<li>나이 : ${myAge}</li>
		<li></li>
	</ul>
	
</body>
</html>