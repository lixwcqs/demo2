
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@include file="/demo2/commons/taglib.jsp"%>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="${ctx}/webjars/bootstrap/3.3.0/css/bootstrap.min.css" />
    <%--<script type="text/javascript"  src="plugins/jquery-1.11.2.min.js" ></script>--%>
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" >
    $().ready(function(){
            console.log("Hello index");
        });
    </script>
    <script type='text/javascript' src="${ctx}/webjars/bootstrap/3.3.0/js/bootstrap.min.js"  ></script>
</head>

<body>
<h2>Hello World!</h2>
<h2>${ctx}</h2>
    <script>
        $().ready(function(){
            console.log("Hello World!")
        });
    </script>
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

    <table border="5" width="30%">
        <tr><td>Hello</td></tr>
        <tr><td>Hello</td></tr>
        <tr><td>Hello</td></tr>
        <tr><td>Hello</td></tr>
    </table>
</body>
</html>
