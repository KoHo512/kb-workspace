<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2026-06-09
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("loginForm.html");
%>>
