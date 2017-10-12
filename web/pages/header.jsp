<%--
  Created by IntelliJ IDEA.
  User: lerafatova
  Date: 28.04.17
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" type="text/css">
</head>
<body>
<div class="container">
  <ul class="my">
    <li class="my"><a href="${pageContext.request.contextPath}/main/home"><img src="${pageContext.request.contextPath}/images/logo.png" width="100" height="50" align="center"></a></li>
    <li class="my"><a href="${pageContext.request.contextPath}/main/about_us">Про нас</a></li>
    <li class="my"><a href="${pageContext.request.contextPath}/main/reservation">Бронирование</a></li>
    <li class="my"><a href="${pageContext.request.contextPath}/main/gallery">Галерея</a></li>
    <li class="my"><a href="${pageContext.request.contextPath}/main/contact">Контакты</a></li>
  </ul>
</div>
</body>
</html>
