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

<h1 class="mb-4">게시글 수정</h1>
<form action="/board/modify" method="post" enctype="multipart/form-data" >
    <input type="hidden" name="no" value="${board.no}">
    <div class="mb-3">
        <label class="form-label">제목</label>
        <input class="form-control" name="title" value="${board.title}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea class="form-control" name="content" rows="6" required>${board.content}</textarea>
    </div>
    <div class="mb-3">
        <label class="form-label">작성자</label>
        <input class="form-control" name="writer" value="${board.writer}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">새 첨부파일 추가</label>
        <!-- TODO: 새 첨부파일 input을 작성하세요. -->
        <input class="form-control" name="files" type="file" multiple />
    </div>
    <button class="btn btn-primary">수정 저장</button>
    <a class="btn btn-secondary" href="/board/get?no=${board.no}">취소</a>
</form>

<hr>
<h5>기존 첨부파일</h5>
<c:forEach var="file" items="${board.attaches}">
    <c:if test="${not empty file.no}">
        <form action="/board/attachment/delete" method="post" class="d-inline-block mb-2">
            <input type="hidden" name="no" value="${file.no}">
            <input type="hidden" name="bno" value="${board.no}">
            ${file.filename} (${file.fileSize})
            <button class="btn btn-sm btn-danger">삭제</button>
        </form><br>
    </c:if>
</c:forEach>

<form action="/board/remove" method="post" class="mt-3">
    <input type="hidden" name="no" value="${board.no}">
    <button class="btn btn-danger">게시글 삭제</button>
</form>
</div></body></html>
