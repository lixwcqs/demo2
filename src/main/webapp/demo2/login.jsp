
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@include file="./commons/taglib.jsp"%>


<!DOCTYPE  html>
<html lang="zh-CN">
<head>
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/commoms/math.js" ></script>
    <script type="text/javascript">
        $().ready(function(){
            console.log("Hello User123");
//            console.log(percentage(54,65));
//            $('#percent').attr("value",percentage(54,65))
        });
    </script>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />
</head>

<body>
<div class="container">
    <h1>
        欢迎来到登陆界面
    </h1>


    <form  class="form-horizontal" action="${ctx}/user/login.action" method = "post" style="width: 35%;" >
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <div class="form-group">
            <label for="name" >
                用户名:
            </label>
            <%--<input name="j_username" id="name" value="admin" placeholder="userName" class="form-control"/>--%>
            <s:textfield name="j_username" id="name" value="admin" placeholder="userName" class="form-control" autofocus="autofocus" />
        </div>
        <div class="form-group">
            <label for="password" >
                密码:
            </label>
            <s:password name="j_password" id="password" value="admin" class="form-control"  />
            <%--<input name="j_password"  id="password" value="admin"  placeholder="password" class="form-control" />--%>
        </div>

        <div class="form-group">
            <%--<input type="submit" value="登录" class="form-control btn-default"/>--%>
                <s:submit value="登录" class="form-control btn-default"/>
        </div>
    </form>
</div>
</body>
</html>
