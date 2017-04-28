<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>
Hilton
</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/2.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
  <div id="menu">
   <div><a href="${pageContext.request.contextPath}/main/about_us">Про нас</a></div>
   <div class="line"></div>
   <div><a href="${pageContext.request.contextPath}/our_service">Наши услуги</a></div>
  </div>
  <div id="content">
   <p><img src="${pageContext.request.contextPath}/images/4.jpg" width="189" height="255" class="rightimg">
Вдохновленный мечтой создания лучшего отеля в Техасе, Конрад Николсон Хилтон, в 1919 году основал первый отель сети Hilton. Благодаря полной самоотдаче, умению руководить и нововведениям, сегодня Hilton - это один из самых известных и уважаемых брендов в мире. 
Компания была основана Конрадом Хилтоном (1887—1979) в 1919 году, когда был открыт первый отель сети — Mobley Hotel — в городе Сиско, штат Техас. Первый отель носящий имя Hilton открылся в 1925-м году в Далласе. Открытие отеля Caribe Hilton Hotel в городе Сан-Хуан в Пуэрто-Рико сделало Hilton первой в мире международной сетью отелей.
По состоянию на 2014 год бренд Hilton Hotels & Resorts включает более 540 отелей и курортов в 78 странах мира.Существует одна из легенд создания коктейля Маргарита. В ней говорится о том, что придуманный в 1948 году коктейль, популяризировался именно в сети отелей «Хилтон». Именно благодаря тому, что коктейль предлагался во всех отелях «Хилтон», он и получил такую популярность.</p>
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
