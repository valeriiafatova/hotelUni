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
   <div><a href="Галерея.html">Фото 1</a></div>
   <div class="line"></div>
   <div><a href="Гал2.html">Фото 2</a></div>
<div class="line"></div>
   <div><a href="Гал3.html">Фото 3</a></div>
<div class="line"></div>
   <div><a href="Гал4.html">Фото 4</a></div>
<div class="line"></div>
   <div><a href="Гал5.html">Фото 5</a></div>
  </div>
  <div id="content">
   <p><img src="${pageContext.request.contextPath}/images/9.jpg" width="100%" height="100%" class="rightimg"></p>
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
