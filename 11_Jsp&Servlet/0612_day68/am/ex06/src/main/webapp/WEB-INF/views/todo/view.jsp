<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo 상세</h1>

    <div>
        <a href="list">목록 보기</a>
        <a href="update">수정하기</a>
    </div>

    <form action="delete" method="POST">
        <input type="submit" value="삭제">
    </form>
</body>
</html>
