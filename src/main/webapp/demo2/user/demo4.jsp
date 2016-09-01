<!DOCTYPE  html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>

<html lang="en">
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <%--<script type="text/ecmascript" src="${ctx}/webjars/jquery-ui/1.10.4/ui/jquery-ui.js"></script>--%>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/i18n/grid.locale-cn.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/minified/jquery.jqGrid.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/models/user.js"></script>
    <!-- A link to a Boostrap  and jqGrid Bootstrap CSS siles-->
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/jqgrid/5.0/ui.jqgrid-bootstrap.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap-datetimepicker.css" />

    <script>
    </script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap-datetimepicker.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap-datetimepicker.zh-CN.js"></script>
    <meta charset="utf-8" />
    <title>jqGrid Loading Data - Dialogs - Edit, Add, Delete</title>
    <script >
        function searchUser(){
            var name = jQuery("#name").val()||"";
            jQuery("#users").jqGrid('setGridParam', {
                url: "${ctx}/user/list2.action?name="+name,
                mtype: 'POST',
                page : 1
            }).trigger("reloadGrid");
        }

        <%--function delUser(){--%>
            <%--var gr = jQuery("#users").jqGrid('getGridParam', 'selrow');--%>
            <%--if (gr != null)--%>
                <%--jQuery("#users").jqGrid('delGridRow', gr, {--%>
                    <%--url: "${ctx}/user/delete.action",--%>
                    <%--reloadAfterSubmit : true--%>
                <%--});--%>
            <%--else--%>
                <%--alert("Please Select Row to delete!");--%>
        <%--}--%>
    </script>
</head>
<body>
<div class="search">

</div>
<div style="margin-top:20px;margin-left: 20px;" id="userTable">
    <div class="searchArea">
        <form class="formGrid">
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <table class="EditTable ui-common-table" width="72%" border="0">
                <tr rowpos="1" class="FormData" id="tr_name">
                    <td class="CaptionTD" style="margin-right: 5px;width: 7%;" align="middle">姓名</td>
                    <td class="DataTD" width="20%">
                      <input name="name" id="name" value="${user.name}" class="FormElement form-control" size="10"/>
                    </td>
                    <%--<td width="10%;" align="right">--%>
                        <%--<div class="input-append date form_datetime">--%>
                            <%--<input size="16" type="text" value="" readonly>--%>
                            <%--<span class="add-on"><i class="icon-remove"></i></span>--%>
                            <%--<span class="add-on"><i class="icon-th"></i></span>--%>
                        <%--</div>--%>
                    <%--</td>--%>
                    <td width="5%;" align="right">
                       <input value="search" type="button" onclick="searchUser();" class="fm-button btn btn-default ">
                    </td>
                    <%--<td width="5%;" align="right">--%>
                        <%--<input value="delete" type="button" onclick="delUser();" class="fm-button btn btn-default ">--%>
                    <%--</td>--%>
                    <td></td>

                </tr>
            </table>

        </form>
    </div>
    <div style="margin: 5px;"></div>
    <table id="users" class="table-striped"></table>
    <div id="gridPager" ></div>
</div>
<script>
    $(".form_datetime").datetimepicker({
        autoclose:true,
        format: 'yyyy-mm-dd',
        orientation: 'bottom',
        todayBtn:'true',
        //国际化
        language:"zh-CN",
    });
</script>
<script type="text/javascript">
    $(document).ready(function(){
        console.log('${ctx}')
        console.log(getContextPath())
        initUser();
    });

</script>
</body>
</html>