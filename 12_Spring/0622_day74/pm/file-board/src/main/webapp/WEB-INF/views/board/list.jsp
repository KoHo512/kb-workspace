<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>File Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">

<h1 class="mb-4">게시글 목록</h1>
<a class="btn btn-primary mb-3" href="/board/register">새 게시글</a>
<table class="table table-bordered">
    <thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr></thead>
    <tbody>
    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.no}</td>
            <td><a href="/board/get?no=${board.no}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div></body></html>
