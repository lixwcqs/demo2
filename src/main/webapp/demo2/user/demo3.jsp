<!DOCTYPE  html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>

<html lang="en">
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/i18n/grid.locale-cn.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/minified/jquery.jqGrid.min.js"></script>
    <!-- A link to a Boostrap  and jqGrid Bootstrap CSS siles-->
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/jqgrid/5.0/ui.jqgrid-bootstrap.css" />

    <script>
        $.jgrid.defaults.width = 780;
//        $.jgrid.defaults.responsive = true;
        $.jgrid.defaults.styleUI = 'Bootstrap';
    </script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>
    <meta charset="utf-8" />
    <title>jqGrid Loading Data - Dialogs - Edit, Add, Delete</title>
</head>
<body>
<div style="margin-top:20px;margin-left: 20px;">
    <table id="users"></table>
    <div id="jqGridPager"></div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#users").jqGrid({
            url: "${ctx}/user/list2.action",
            // we set the changes to be made at client side using predefined word clientArray
            editurl: 'clientArray',
            datatype: "json",
            mtype: 'POST',
            colModel: [
                {
                    label: '主键',
                    name: 'id',
                    width: 75,
                    key: true,
                    editable: true,
                    editrules : {
                        edithidden:false,
                    }
                },
                {
                    label: '名称',
                    name: 'name',
                    width: 140,
                    editable: true // must set editable to true if you want to make the field editable
                },
                {
                    label : '密码',
                    name: 'password',
                    width: 100,
                    editable: true,
                    editrules : {
                        required: true,
                        size:10,
                        maxlength: 16,
                    },
                    editoptions:{

                    }
                },
                {
                    label: '邮箱',
                    name: 'email',
                    width: 80,
                    editable: true,
                    editrules:{
                        required: false,
                        email: true,
                    }
                }
            ],
            jsonReader:{
                root:"users",       // 对应于colModel
                total:'jqpage.pages',
                records: 'jqpage.totalCount',
                repeatitems: false
            },
            sortname: 'id',
            sortorder : 'asc',
            loadonce: true,
            viewrecords: true,
            height: 200,
            rowNum: 10,
            loadonce:true,
            rowList: [6,25,35],
            pager: "#jqGridPager",
            caption:"Users 列表"
        });

//        $('#users').navGrid('#jqGridPager',
//                // the buttons to appear on the toolbar of the grid
//                { edit: true, add: true, del: true, search: true, refresh: false, view: false, position: "left", cloneToTop: false },
//                // options for the Edit Dialog
//                {
//                    editCaption: "The Edit Dialog",
//                    recreateForm: true,
//                    checkOnUpdate : true,
//                    checkOnSubmit : true,
//                    closeAfterEdit: true,
//                    errorTextFormat: function (data) {
//                        return 'Error: ' + data.responseText
//                    }
//                },
//                // options for the Add Dialog
//                {
//                    closeAfterAdd: true,
//                    recreateForm: true,
//                    errorTextFormat: function (data) {
//                        return 'Error: ' + data.responseText
//                    }
//                },
//                // options for the Delete Dailog
//                {
//                    errorTextFormat: function (data) {
//                        return 'Error: ' + data.responseText
//                    }
//                });
    });

</script>

<sec:authorize access="hasRole('ADMIN')">
    <%--<sec:authorize access="hasRole('IS_AUTHENTICATED_FULLY')">--%>
    This content will only be visible to users who have
    the "ADMIN" authority in their list of <tt>ADMIN</tt>s.
</sec:authorize>
</body>
</html>