<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/8/30
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp"%>
<html>
<head>
    <title>账号列表</title>
    <link rel="stylesheet" href="${ctx}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" />
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" ></script>
    <script type="text/javascript">
        $().ready(function(){
            console.log("Hello User");
        });
    </script>
    <script type='text/javascript' src="${ctx}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"  ></script>
</head>
<body>
        <br>
        <div class="container">
            <form  style="width: 30%"   action="${ctx}/user/list.action" method="get" id="userForm">
                <div class="form-group">
                    <label for="name" >
                        用户名:
                    </label>
                    <input name="name" id="name"  placeholder="userName" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email" >
                        Email:
                    </label>
                    <input name="email"  id="email"  placeholder="email" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="submit" value="查询"   class="form-control btn-default"/>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <table class="table table-striped table-bordered">
                        <c:forEach items="${page.result}" var="user" varStatus="count"  >
                            <tr>
                                <td>
                                    <c:out value="${1 + count.index + (page.pageNo-1) * page.pageSize } " />
                                </td>
                                <td>
                                    <c:out value="${user.name}" />
                                </td>
                                <td>
                                    <c:out value=" ${user.email}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <%@include  file="../commons/pagination.jsp" %>
            </form>
        </div>
</body>
</html>
