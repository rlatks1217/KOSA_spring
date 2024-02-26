<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jstl을 쓰기 위한 태그 라이브러리가 기본적으로 들어와 있는 것 -->
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}</P>
<!-- <%--${}--%>을 사용해야 Model객체 안의 데이터를 사용할 수 있음 -->
<!-- <%----%>가 jsp 주석임 / el도 jsp의 한 표기방식이므로 이걸 써야 함 -->
</body>
</html>
<!-- 
기존에는 servlet이 컨트롤러의 역할을 했었음
하지만 spring에서는 기본적으로 제공되는 Front Controller가 있음(Dispatcher Servlet)
 -->
