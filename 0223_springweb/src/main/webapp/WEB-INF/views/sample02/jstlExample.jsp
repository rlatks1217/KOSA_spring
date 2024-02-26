<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page directive라고 부름 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- taglib directive라고 부름 -->
<!-- core는 jstl의 기본적인 기능을 제공 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- taglib directive라고 부름 -->
<!-- formator는 jstl을 쓰는 데에 있어서 필요한 기본적인 형식을 정해줄 수 있는 기능을 제공해줌 -->

<!--
이런 애들을 directive라고 부름(특정 기능을 추가해주는 역할)

-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int k = 100; %>
<!-- 기존에 이렇게 jsp expression으로 했던 것처럼 변수를 만들고 값을 할당할 수 있어요 -->
<!-- core의 prefix를 이용하는 것이기 때문에 c라는 글자가 붙음 -->
<!-- var속성 : 변수명 value: 해당변수에 할당할 값 -->
<c:set var="num1" value="1"></c:set>
<!-- 당연히 선언한 변수 EL로 접근할 수 있음 + model의 key값과 같은 이름의 변수를 잡을 경우 여기서 먼저 찾고 검색을 멈추기 때문에 model의 데이터는 가져올 수 없게 됨 (주의)-->

<!-- 제어문 중 대표적인 제어문 .. if -->
<%-- <c:if test="이 안에 보통 EL이 들어와요"></c:if> 즉, test 속성은 if의 ()와 같은 부분이라고 생각하면 됨--%>
<c:if test="${ num1 + myNum > 100}"> <!-- 0보다 큰 값이 나오면 true로 인식함 -->
<!-- myNum은 model에서 가져오는 것 -->
<!-- true면 여기에 있는 내용 출력 -->
100보다 커요!
</c:if>
<br><br>


<!-- else가 따로 없음 그러면 어떻게 하지? -->
<!-- 일반적으로 조건이 여러 개인 경우에는 c:if 대신 다른 것을 사용함 -->
<c:choose>
<c:when test="${ num1 + myNum > 50}"><!-- 이게 여러 개 나올 수 있음 -->
50보다 커요!
</c:when>
<c:when test="${ num1 + myNum > 100}">
100보다 커요!
</c:when>
<c:when test="${ num1 + myNum > 300}">
300보다 커요!
</c:when>
<c:otherwise><!-- 이게 else의 역할을 함 -->
이도저도 아니에요!
</c:otherwise>
</c:choose>
<!-- 조건을 만족하는 것이 나오면 그 뒤에는 조건에 만족하더라도 출력되지 않음 -->
<br><br>



<!-- 그렇다면 반복문은?! -->
<!-- 기본 for문    begin : 몇번부터 반복? / end : 몇번까지?/ step : 몇개씩 증가?-->
<c:forEach var="tmp" begin="1" end="5" step="1">
	<li>${tmp}</li>
</c:forEach>

<!-- 우리가 아는 for each의 사용 -->
<!-- items : 반복가능한 자료구조(list같은 것들) var : 리스트에 있는 하나의 값 -->
<c:forEach var="name" items="${myList}">
<li>${name}</li>
</c:forEach>



<!-- 
그럼 formator는 왜 가지고 왔니? 
출력을 편하게 할 수가 있어요!
-->
<!-- fmt를 사용하기 위해 변수를 하나 선언해보자 -->
<c:set var="number" value="123456" />
<br><br>
<!-- 숫자 표현할 때 3자리마다 콤마 표시하는 거 해보자 => fmt 사용하면 자동으로 해줌 -->
<!-- 위에서 선언한 변수 number를 접근하기 위해서는 당연히 EL 사용 -->
<fmt:formatNumber value="${number}"></fmt:formatNumber>
<br><br>

<!-- 화폐 단위 : type을 currency로만 잡아주면 됨 -->
<fmt:formatNumber value="${number}" type="currency"></fmt:formatNumber>
<br><br>
<!-- 퍼센트 단위 : type을 percent로만 잡아주면 됨 -->
<c:set var="number" value="0.783" />
<fmt:formatNumber value="${number}" type="percent"></fmt:formatNumber>
<br><br>

<!-- 이렇게 출력의 형식을 어떻게 할 지 정해줄 수 있음 -->
</body>
</html>