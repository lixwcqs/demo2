
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%--<%@ taglib uri="http://www.cqs.com/functions" prefix="mfn" %>--%>
<%@include file="../commons/taglib.jsp"%>


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
        ${ctx}
    </h1>


    <form  class="form-horizontal" action="${ctx}/user/create.action" method = "post" style="width: 35%;" >
        <div class="form-group">
            <label for="name" >
                用户名:
            </label>
            <input name="name" id="name"  placeholder="userName" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password" >
                密码:
            </label>
            <input name="password"  id="password"  placeholder="password" class="form-control" />
        </div>
        <div class="form-group">
            <label for="email" >
                Email:
            </label>
            <input name="email"  id="email"  placeholder="email" class="form-control" />
            <input name="percent"  id="percent"  placeholder="percent" value="" />
        </div>
        <div class="form-group">
            <input type="submit" value="提交"   class="form-control btn-default"/>
        </div>
    </form>

    <form class="form-inline">
        <div class="form-group">
            <label for="exampleInputName2">Name</label>
            <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">Email</label>
            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
        </div>
        <button type="submit" class="btn btn-default">Send invitation</button>
    </form>
    <br/>
    <br/>
    <br/>
</div>
</body>
</html>
