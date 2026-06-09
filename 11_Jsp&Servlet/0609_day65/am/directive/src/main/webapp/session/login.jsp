<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2026-06-09
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="ko">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>로그인 실습</title>
</head>
<body>
<h1>로그인 정보를 세션에 저장</h1>
<%
  String id = request.getParameter("userid");
  if (id == null) response.sendRedirect("loginForm.html");
  else {
    String pw = request.getParameter("password");
    session.setAttribute("userid", id);
    session.setAttribute("password", pw);
    out.print("안녕하세요 " + id + "<br>");
    out.print("<a href='loginInfo.jsp'>정보 보기</a>");
  }
%>
</body>
