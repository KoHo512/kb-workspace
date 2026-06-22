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

<h1 class="mb-4">게시글 등록</h1>
<!-- TODO: 파일 업로드를 위해 form에 enctype="multipart/form-data"를 추가하세요. -->
<form action="/board/register" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label class="form-label">제목</label>
        <input class="form-control" name="title" required>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea class="form-control" name="content" rows="6" required></textarea>
    </div>
    <div class="mb-3">
        <label class="form-label">작성자</label>
        <input class="form-control" name="writer" required>
    </div>
    <div class="mb-3">
        <label class="form-label">첨부파일</label>
        <!-- TODO: name="files" type="file" multiple 입력 요소를 작성하세요. -->
        <input class="form-control" name="files" type="file" multiple />
    </div>
    <button class="btn btn-primary">등록</button>
    <a class="btn btn-secondary" href="/board/list">목록</a>
</form>
</div></body></html>
