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
    <script type="text/ecmascript" src="${ctx}/scripts/models/book.js"></script>
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

    </script>

</head>
<body>
<div class="search">

</div>
<div style="margin-top:20px;margin-left: 20px;" id="userTable">
    <div class="searchArea">
        <form class="formGrid">
            <table class="EditTable ui-common-table" width="72%" border="0">
                <tr rowpos="1" class="FormData" id="tr_name">
                    <td class="CaptionTD" style="margin-right: 5px;width: 7%;" align="middle">书名</td>
                    <td class="DataTD" width="20%">
                      <input name="name" id="name" value="${book.name}" class="FormElement form-control" size="10"/>
                    </td>
                    <td class="CaptionTD" style="margin-right: 5px;width: 7%;" align="middle">出版日期</td>
                    <td class="DataTD" width="20%">
                        <input name="publishDate" id="publishDate" value="${book.publishDate}" class="FormElement form-control" readonly/>
                        <span class="add-on"><i class="icon-remove"></i></span>
                        <span class="add-on"><i class="icon-calendar"></i></span>
                    </td>
                    <td width="5%;" align="right">
                       <input value="search" type="button" onclick="searchBook();"  class="fm-button btn btn-default ">
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
    <div style="margin: 5px;"></div>
    <table id="books" class="table-striped"></table>
    <div id="gridPager" ></div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        initBook();
        $("#publishDate").datetimepicker({
            format: "yyyy/mm/dd",
            autoclose: true,
            todayBtn: true,//是否显示今日按钮
            startDate: "2013-02-14 10:00",//日历最高的时间
            //此数值被当做步进值用于构建小时视图。对于每个 minuteStep 都会生成一组预设时间（分钟）用于选择。
            //minuteStep: 10,
            hidden:true,//是否直接弹出时间控件
            //参考http://www.bootcss.com/p/bootstrap-datetimepicker/的【选项】说明
            startView:2,//2 or 'month' for month view (the default)
            minView:2,
            maxView:2,
            language:"zh-CN"
        })
    });
</script>
</body>
</html>