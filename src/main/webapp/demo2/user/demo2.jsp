<!DOCTYPE  html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<c:set var="jg_version" value="4.8" />
<html lang="cn">
<head>

    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/jquery-migrate-1.2.1.min.js"></script>

    <script type="text/ecmascript" src="${ctx}/webjars/jqgrid/4.7.0/js/i18n/grid.locale-cn.js"></script>
    <script type="text/ecmascript" src="${ctx}/webjars/jqgrid/4.7.0/js/minified/jquery.jqGrid.min.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>

    <%--Bootstrap3.4--%>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />

    <%--jqgrid 4.8.2 --%>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/jqgrid/5.0/ui.jqgrid-bootstrap.css" />

    <script>
      $(document).ready(function(){
          $("#showUsers").jqGrid({
              //提交表单的ＵＲＬ
            url: "${ctx}/user/list2.action",
              //服务器返回的数据格式
            datatype: "json",
              //提交方式
            mtype: "POST",
              //table的首行列名
            colNames:['用户名', '密码', '邮箱','Primary Key'],
              //各列数据
            colModel:[
                {name:'name', label:'用户名',width:'20%',align:'center',editable:true, },
                {name:'password', width:'15%',align:'center'},
                {name:'email',width:'20%', align:"center"},
                {name:'id', width:'35%', align:"left", sortable:false,key: true}
               ],
            jsonReader: {
                root:"users",       // 对应于colModel
                total:'jqpage.pages',
                records: 'jqpage.totalCount',
                repeatitems: false,
            },

                //数据
              edit:true,

                //  样式/////

              //显示翻页按钮，及当前页记录和总记录数
              viewrecords: true,
              styleUI : 'Bootstrap',
              rownumbers:true,//记录序号
              rowNum: 6,//grid显示记录条数
              rowList: [6,25,35],
              //表单高度
              height: 220,
              //宽
              width:1000,
            // 表下面的导航栏
            pager: "#gridPager",
            // 表信息
            caption: "联系人列表",

//
              gridview: true,
              autoencode: true,
              onSelectRow: 'editRow',
          });
      });

      $('#showUsers').jqGrid('navGrid','#gridPager',
              // the buttons to appear on the toolbar of the grid
              {edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
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


    </script>
    <title>
       <p>Hello</p>
    </title>
</head>
<body>
    <div style="margin-left:20px;margin-top: 20px;">
        <table id="showUsers"  class="table-striped"></table>
      <div id="gridPager"></div>
  </div>
</body>
</html>
