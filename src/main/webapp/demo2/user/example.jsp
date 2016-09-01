<!DOCTYPE  html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>

<html lang="en">
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="${ctx}/js/jquery-1.11.0.min.js"></script>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${ctx}/js/plugins/jqgrid/5.0/i18n/grid.locale-cn.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="${ctx}/js/plugins/jqgrid/5.0/minified/jquery.jqGrid.min.js"></script>
    <!-- A link to a Boostrap  and jqGrid Bootstrap CSS siles-->
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/style/plugins/boostrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/style/plugins/jqgrid/5.0/ui.jqgrid-bootstrap.css" />

    <script>
        $.jgrid.defaults.width = 780;
//        $.jgrid.defaults.responsive = true;
        $.jgrid.defaults.styleUI = 'Bootstrap';
    </script>
    <script type="text/ecmascript" src="${ctx}/js/plugins/boostrap/bootstrap.min.js"></script>
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
            colModel: [
                {
                    label: 'id',
                    name: 'id',
                    width: 75,
                    key: true,
                    editable: true,
                    editrules : { required: true}
                },
                {
                    label: 'name',
                    name: 'name',
                    width: 140,
                    editable: true // must set editable to true if you want to make the field editable
                },
                {
                    label : 'password',
                    name: 'password',
                    width: 100,
                    editable: true,
                    editrules : { required: true}
                },
                {
                    label: 'email',
                    name: 'email',
                    width: 80,
                    editable: true
                }
            ],
            jsonReader:{
              root:'users'
            },
            sortname: 'id',
            sortorder : 'asc',
            loadonce: true,
            viewrecords: true,
            height: 200,
            rowNum: 10,
            pager: "#jqGridPager"
        });

        $('#users').navGrid('#jqGridPager',
                // the buttons to appear on the toolbar of the grid
                { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
                // options for the Edit Dialog
                {
                    editCaption: "The Edit Dialog",
                    recreateForm: true,
                    checkOnUpdate : true,
                    checkOnSubmit : true,
                    closeAfterEdit: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Add Dialog
                {
                    closeAfterAdd: true,
                    recreateForm: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Delete Dailog
                {
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                });
    });

</script>


</body>
</html>