<%--
  Created by IntelliJ IDEA.
  User: lerafatova
  Date: 28.04.17
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Varela" rel="stylesheet"/>
</head>
<body>
<div class="footer">
    <table>
        <tr>
            <td align="center"><img class="ukraine"></td>
            <td align="center"><a href="https://www.facebook.com/Hiltonhotelsuk/?brand_redir=125762892900">
                <img src="${pageContext.request.contextPath}/images/facebook.png" class="social"></a>
                <a href="https://www.instagram.com/hiltonhotels/">
                    <img src="${pageContext.request.contextPath}/images/insta.png" class="social"></a></td>
            <td align="center"><p>Подпишитесь на рассылку самых выгодных</p>
                <p>предложений и акций от Hilton Hotels & Resorts</p>
                   <form action="${pageContext.request.contextPath}/main/subscribe">
                       <input type ="hidden" name="subscribe" value="subscribe">
                       <button class="new" type="submit" name="Submit">Подписаться</button>
                   </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
