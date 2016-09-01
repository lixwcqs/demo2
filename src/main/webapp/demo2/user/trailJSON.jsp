<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.cqs.demo2.models.user.model.User1" %>
<%@ include file="../commons/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>

    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <%--<script type="text/ecmascript" src="${ctx}/webjars/jquery-ui/1.10.4/ui/jquery-ui.js"></script>--%>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/i18n/grid.locale-cn.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/minified/jquery.jqGrid.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/demo2/user.js"></script>
    <!-- A link to a Boostrap  and jqGrid Bootstrap CSS siles-->
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/jqgrid/5.0/ui.jqgrid-bootstrap.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap-datetimepicker.css" />
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap-datetimepicker.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jput/jput.min.js"></script>
    <meta charset="utf-8" />
    <script>
        var datas = [
            {"createDate":null,"email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec672a0008","imgs":[],"name":"测试啊","password":"979","updateDate":"2015-11-23T23:41:34"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec674f0009","imgs":[],"name":"测试啊","password":"762","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec678c000a","imgs":[],"name":"测试啊","password":"194","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec67bf000b","imgs":[],"name":"测试啊","password":"675","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec67f6000c","imgs":[],"name":"测试啊","password":"491","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec682d000d","imgs":[],"name":"测试啊","password":"410","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec6865000e","imgs":[],"name":"测试啊","password":"976","updateDate":"2015-11-23T23:18:07"},
            {"createDate":"2015-11-23T23:18:07","email":"fhdjkasj@163.com","id":"40283a815134ec5c015134ec68b3000f","imgs":[],"name":"测试啊","password":"531","updateDate":"2015-11-23T23:18:07"}
        ]
        function printJSon(){
            console.log(typeof datas)
            var data
            $('#result').append("<table class='table table-striped'><tr><td>User Name</td><td>Passsword</td><td>Email</td></tr>")

            for (var i = 0; i < datas.length; ++i){
                    data = datas[i]
                    console.log(data)
                    console.log(data.email)
                $('#result').append(

                        '<tr class="success">' +
                        '<td><input name="name"  id="name"  placeholder="name"  value="'+data.name+'"/></td>'+
                        '<td><input name="password"  id="password"  placeholder="password"  value="'+data.password+'"/></td>'+
                        '<td><input name="email"  id="email"  placeholder="email"  value="'+data.email+'"/></td>' +
                        '</tr>'
                )
            }
            $('#result').append("</table>")
        }



        $(document).ready(function(){
            printJSon();

            $("#tbody").jPut({
                jsonData:datas,
                //ajax_url:"youfile.json",  if you want to call from a json file
                name:"tbody_template",
            });
        });
    </script>
</head>
<body>



<form  class="form-horizontal" action="#" method = "post" style="width: 35%;" >
            <table class="table table-striped">
                <tr>
                    <td>User Name</td>
                    <td>Passsword</td>
                    <td>Email</td>
                </tr>

                <div id="result">

                </div>
            </table>
        </form>
</body>

    <table jput="t_template" border="1"  class="table table-striped">
        <tbody jput="tbody_template">
        <tr>
            <td>{{name}}</td>
            <td>{{password}}</td>
            <td>{{email}}</td>
        </tr>
        </tbody>
    </table>

===========================
    <table border="1">
        <tbody id="tbody" ></tbody>
    </table>
</html>
