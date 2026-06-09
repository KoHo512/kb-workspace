<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2026-06-09
  Time: 오전 11:19
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
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userid");
    if (id == null) response.sendRedirect("loginForm.html");
    else {
        String pw = (String) session.getAttribute("password");
        out.print("사용자 아이디 : " + id + "<br>");
        out.print("사용자 비밀번호 : " + pw + "<br>");
        out.print("<a href='logout.jsp'>로그아웃</a>");
    }
%>
</body>
