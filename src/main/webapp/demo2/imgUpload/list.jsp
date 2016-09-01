<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/9/14
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/taglib.jsp"%>
<html>
<head>
  <link href="${ctx}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
  <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" ></script>
  <script type='text/javascript' src="${ctx}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"  ></script>
    <script type="text/javascript" >
            <%--function ajaxSub(){--%>
                <%--$.post(--%>
                        <%--'${ctx}/imgUpload/imgList.action',--%>
                        <%--{--%>
                            <%--applyId:$('#applyId').val()--%>
                        <%--},--%>
                        <%--function (jsonResult,status){--%>
<%--//                            alert(data)--%>
                            <%--console.log('data: '+jsonResult[0].applyId)--%>
                            <%--console.log('data: '+jsonResult[0].name)--%>
                        <%--},'json'--%>
                <%--)--%>
            <%--}--%>
   </script>
  <title>images</title>
</head>
<body>
    <div class="container">
        <form class="form-horizontal"  >
                <table>
                    <tr>
                        <td>applyId</td>
                        <td><input name="applyId" id="applyId" ></td>
                        <td><input name="search"  type="button" onclick="ajaxSub();" class="btn-info" value="查询"></td>
                    </tr>
                </table>
                <table class="table-striped table-striped" >
                    <tr>
                        <td>name</td>
                        <td>applyId</td>
                        <td>URL</td>
                        <td>operate</td>
                    </tr>
                    <tr>

                    </tr>
                </table>
        </form>
    </div>
</body>
</html>
