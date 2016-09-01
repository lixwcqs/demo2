<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/11/22
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>new lists</title>
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <script>
        function searchNews(){
            var url = "${ctx}/news/list.action";
            var title = $('#author').val()
            console.log("title="+title)
            $.ajax({
                type : "get",
//                async : false,  //同步请求
                url : url,
                data : "author="+title,
                timeout:1000,
                success:function(dates){
                    console.log(dates);
                    $("#mainContent").html(dates);//要刷新的div
                },
                error: function() {
                    // alert("失败，请稍后再试！");
                    console.log("failed")
                }
            });
        }
    </script>
</head>
<body>
    <div id="mainContent">
        <form action="#" id="newsList" method="get">
            <input name="author" id="author" />
            <input type="button" onclick="searchNews();" value="submit">
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
        </form>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
    <%--<sec:authorize access="hasRole('IS_AUTHENTICATED_FULLY')">--%>
        This content will only be visible to users who have
        the "supervisor" authority in their list of <tt>ADMIN</tt>s.
    </sec:authorize>
</body>
</html>
