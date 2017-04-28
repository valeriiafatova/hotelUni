<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>
        Hilton
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/2.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showRoom.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="wrapper">
    <form action="${pageContext.request.contextPath}/main/reservRoom" method="post">
        <table class="table" style="height: 20%">
            <thead>
            <tr><th>Имя</th>
            <th>Телефон</th>
            <th>Дата Заезда</th>
            <th>Дата Выезда</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="name" value="Имя"/></td>
                <td><input type="text" name="phone" value="Телефон"/></td>
                <td><input type="date" name="dateIn" value="Заезд"/></td>
                <td><input type="date" name="dateOut" value="Выезд"/></td>
            </tr>
            </tbody>
        </table>
        <input value="${requestScope.idRoom}" name="idRoom" type="hidden">
        <button value="reservRoom" name="Submit" class="button" type="submit">Забронировать</button>
    </form>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
