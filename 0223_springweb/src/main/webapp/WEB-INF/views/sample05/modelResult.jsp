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
	<h1>model안의 데이터 : ${ v1 }</h1>
	<h1>VO안의 데이터 : ${ v2.userName }</h1>
	<h1>첫번째 수 : ${ data1 }</h1>
	<h1>두번째 수 : ${ data2 }</h1>	
	<h1>두 수의 합 : ${ sum }</h1>
</body>
</html>