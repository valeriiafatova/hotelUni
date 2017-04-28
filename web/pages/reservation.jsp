<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>
        Hilton
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/3.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showRoom.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <form action="${pageContext.request.contextPath}/main/showRooms" method="get">
        <ul>
            <li>
                <button name="roomType" value="economy" class="button" type="submit">Эконом номера</button>
            </li>
            <li>
                <button name="roomType" value="standard" class="button" type="submit">Стандартные номера</button>
            </li>
            <li>
                <button name="roomType" value="lux" class="button" type="submit">Номера люкс</button>
            </li>
            <c:if test="${ not empty requestScope.message}">
                <li>
                    <button name="roomType" value="lux" class="button" onclick=""><c:out
                            value="${requestScope.message}"/></button>
                </li>
            </c:if>
        </ul>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
