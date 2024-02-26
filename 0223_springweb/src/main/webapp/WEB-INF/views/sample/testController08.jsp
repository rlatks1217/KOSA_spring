<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>testController08.jsp 호출</h1>
   
   <h3>EL을 이용해서 데이터를 추출하는 다양한 방법</h3>
   <ul>
      <li>문자열 출력 -1 : ${ "test" }</li>
      <li>문자열 출력 -2 : ${ 'test' }</li>
      <br>
      <li>숫자 출력 : ${ 123123 }</li>
      <li>논리값 출력 : ${ true }</li>
      <li>null 출력 : ${ null }</li> <!-- null은 아예 출력 안 됨 -->
      <li>list 출력(myList[1]) : ${ myList[1] }</li>
      <br>
      <li>JavaBean(VO) : ${ myUser.name }</li>
      <li>Map : ${ myName }</li>
      <br>
      <li>param객체를 써보자 : ${ param.name }</li>
      <li>header객체를 써보자 : ${ header.referer }</li> 
      <!-- referer은 이전 페이지의 url을 의미하는 속성이기 때문에 뒤로가기 버튼에 쓰면 좋음 -->
      <br>
      <li>산술연산(+,-,*,/,%) : ${ param.age + 20 }</li>
      <li>논리연산(&&, ||, !) : ${ !false }</li>
      <li>비교연산(==, !=, 비교연산자사용가능) : ${ param.age < 20 }</li>
      <li>삼항연산( 논리값 ? a : b ) : ${ param.age < 20 ? "미성년자" : "성인"}</li>
      <br>
      <li>empty 연산 : ${empty ""} - ("")true</li>
      <li>empty 연산 : ${empty "abc"} - ("abc")false</li>
      <li>empty 연산 : ${empty null} - (null)true</li>
      <li>empty 연산 : ${empty null} - (null)true</li>
      <li>empty 연산 : ${empty myList} - (안에 2개 있음)false</li>
      <!-- empty 뒤에 오는 놈이 null이나 ""이면 true 반환 / 아니면 false -->
      
   </ul>
   <br><br>
   <a href="${ header.referer}">뒤로가기</a>
</body>
</html>
