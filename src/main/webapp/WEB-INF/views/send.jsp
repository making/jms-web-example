<html>
<head>
<title>Send</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Send Message</h1>
    <form:form modelAttribute="messageForm" method="post">
        message <form:input path="message" />
        <br />
        <input type="submit" value="send" />
    </form:form>

    <ul>
        <li><a href='<c:url value="/" />'>home</a></li>
        <li><a href='<c:url value="/receive" />'>receive</a></li>
    </ul>
</body>
</html>
