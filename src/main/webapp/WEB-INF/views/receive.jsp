<html>
<head>
<title>Receive</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Receive Message</h1>
    <p>
        <c:choose>
            <c:when test="${message != null}">
                <c:out value="${message.text}" />
            </c:when>
            <c:otherwise>
                queue is empty!
            </c:otherwise>
        </c:choose>
    </p>

    <ul>
        <li><a href='<c:url value="/" />'>home</a></li>
        <li><a href='<c:url value="/send" />'>send</a></li>
        <li><a href='<c:url value="/receive" />'>receive (again)</a></li>
    </ul>
</body>
</html>
