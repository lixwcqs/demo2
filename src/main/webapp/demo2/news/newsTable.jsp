<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/11/23
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>title</td>
        <td>author</td>
        <%--<td>content</td>--%>
        <td>category</td>
        <td>createDate</td>
    </tr>
    <c:forEach var="news" items="${page.result}" varStatus="count">
        <tr>
            <td>${news.title}</td>
            <td>${news.author}</td>
                <%--<td>${news.content}</td>--%>
            <td>${news.category}</td>
            <td>${news.createDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
