<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Todo Register</title>
</head>
<body>
<h1>Todo Register</h1>
<form action="/todo/register" method="post">
    <div>Title : <input type="text" name="title"/></div>
    <div>DueDate : <input type="date" name="dueDate" value="2026-06-17"/></div>
    <div>Writer : <input type="text" name="writer"/></div>
    <div>Finished : <input type="checkbox" name="finished"/></div>
    <div><button type="submit">Register</button></div>
</form>
</body>
</html>
