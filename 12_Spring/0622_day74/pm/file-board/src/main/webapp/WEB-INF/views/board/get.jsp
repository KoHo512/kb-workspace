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

<h1 class="mb-3">${board.title}</h1>
<div class="mb-2">작성자: ${board.writer}</div>
<div class="mb-2">등록일: <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm"/></div>
<hr>
<div class="mb-4">${board.content}</div>

<h5>첨부파일</h5>
<c:choose>
    <c:when test="${empty board.attaches}">
        <div class="text-muted">첨부파일이 없습니다.</div>
    </c:when>
    <c:otherwise>
        <ul class="list-group mb-3">
            <c:forEach var="file" items="${board.attaches}">
                <c:if test="${not empty file.no}">
                    <li class="list-group-item">
                        <a href="/board/download/${file.no}">${file.filename}</a>
                        <span class="text-muted">(${file.fileSize})</span>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<a class="btn btn-warning" href="/board/modify?no=${board.no}">수정</a>
<a class="btn btn-secondary" href="/board/list">목록</a>
</div></body></html>
