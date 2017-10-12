<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lerafatova
  Date: 28.04.17
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showRoom.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"/>

<c:forEach var="room" items="${requestScope.rooms}" varStatus="courseLoop">
    <c:set var="type" value="${room.roomType}"/>
    <form action="${pageContext.request.contextPath}/main/reservInfo" method="get">
    <div class="wrapper">
        <table class="room">
            <td class="my">
                <div>
                    <c:choose>
                        <c:when test="${type == 'ECONOMY'}"><img class="my" src="/images/economy.jpg"></c:when>
                        <c:when test="${type == 'STANDARD'}"><img class="my"  src="/images/standart.jpg"></c:when>
                        <c:otherwise><img class="my" src="/images/lux.jpg"></c:otherwise>
                    </c:choose>

                </div>
            </td>
            <td class="my">
                <h3><c:out value="${room.roomType}"/> class</h3>

                <p>
                    Выбрав номера <c:out value="${room.roomType}"/> класса, гостям представится возможность индивидуальной
                    регистрации
                    заезда и выезда, бесплатный завтрак, доступ к закускам и напиткам на протяжении дня. Мы
                    гарантируем Вам
                    лучшие условия для отдыха и работы!
                </p>

                <button class="button" name="idRoom" value="${room.id}" type="submit">Бронировать</button>
            </td>
        </table>
    </div>
    </form>
</c:forEach>
<jsp:include page="footer.jsp"/>
</body>
</html>
