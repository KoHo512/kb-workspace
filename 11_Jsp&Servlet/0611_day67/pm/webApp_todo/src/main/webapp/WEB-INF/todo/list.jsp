<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>TodoController에서 보여주는 list.jsp 화면</h1>--%>
<h1>Todo List</h1>
<%--${todos}<br/><br/>--%>
<%--${todos[0].tno} -- ${todos[0].title} -- ${todos[0].dueDate}--%>
<ul>
    <c:forEach var="dto" items="${todos}">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
