<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope 데이터 보기</h1>

    pageScope 속성값 : ${pageScope.scopeName}<br/>
    requestScope 속성값 : ${requestScope.scopeName}<br/>
    sessionScope 속성값 : ${sessionScope.scopeName}<br/>
    applicationScope 속성값 : ${applicationScope.scopeName}<br/>

    scopeName 자동 찾기 : ${scopeName}<br/>
    member : ${member.name} (${member.userid})<br/>
    ${member.age} <%-- age 필드는 없지만 getter가 있어서 정상적으로 출력됨 --%>
</body>
</html>
