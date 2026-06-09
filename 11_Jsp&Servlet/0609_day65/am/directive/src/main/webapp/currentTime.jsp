<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2026-06-09
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="ko">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>스크립트릿 실습</title>
</head>
<body>
  <h1>현재 날짜 출력</h1>
  <%
    Date d = new Date();
  %> <%-- 비권장 - Servlet에서 처리 --%>
  현재 날짜 : <%= d %> <%-- d가 없으면 500 에러 발생(=문법 에러) --%>
</body>
</html>
