<!DOCTYPE  html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<html lang="cn">
<head>
    <%--Bootstrap3.4--%>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/boostrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/styles/plugins/jqgrid/${jg_version}/ui.jqgrid-bootstrap.css" />

    <script type="text/ecmascript" src="${ctx}/scripts/jquery-1.11.0.min.js"></script>

    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/i18n/grid.locale-cn.js"></script>
    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/${jg_version}/minified/jquery.jqGrid.min.js"></script>

    <script type="text/ecmascript" src="${ctx}/scripts/plugins/jqgrid/5.0/i18n/grid.locale-en.js"></script>

    <script type="text/ecmascript" src="${ctx}/scripts/plugins/boostrap/bootstrap.min.js"></script>


    <script>

        $.jgrid.defaults.styleUI = 'Bootstrap';

      $(document).ready(function(){
          $("#users").jqGrid({
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
                {name:'name', label:'用户名',width:'20%',align:'center',editable:true,sortable:true },
                {name:'password', width:'15%',align:'center',sortable:true },
                {name:'email',width:'20%', align:"center", sortable:true },
                {name:'id', width:'35%', align:"left", sortable:false,key: true}
               ],
            jsonReader: {
                root:"users",       // 对应于colModel
                total:'jqpage.pages',
                records: 'jqpage.totalCount',
                repeatitems: false,
                addtext: 'Add',
                edittext: 'Edit',
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
              userDataOnFooter: true,
              sortname:'email',

          });
      }).navGrid("#gridPager",{edit:false,del:false, search:false});

//      $('#users').navGrid('#gridPager',
//              {edit:true,add:true,del:true,refresh:true,
//                  searchtext:'查找',edittext:'编辑',addtext:'添加',refreshtext:'刷新', deltext:'删除',
//                  position:'right'}
//      );

      //      $('#jqGrid').navGrid('#gridPager',
//              // the buttons to appear on the toolbar of the grid
//              { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
//              // options for the Edit Dialog
//              {
//                  editCaption: "The Edit Dialog",
//                  recreateForm: true,
//                  checkOnUpdate : true,
//                  checkOnSubmit : true,
//                  closeAfterEdit: true,
//                  errorTextFormat: function (data) {
//                      return 'Error: ' + data.responseText
//                  }
//              },
//              // options for the Add Dialog
//              {
//                  closeAfterAdd: true,
//                  recreateForm: true,
//                  errorTextFormat: function (data) {
//                      return 'Error: ' + data.responseText
//                  }
//              },
//              // options for the Delete Dailog
//              {
//                  errorTextFormat: function (data) {
//                      return 'Error: ' + data.responseText
//                  }
//              });


    </script>
    <title>
       <p>Hello</p>
    </title>
</head>
<body>
    <div style="margin-left:20px;margin-top: 20px;">
        <table id="users"  class="table-striped"></table>
      <div id="gridPager"></div>
  </div>
</body>
</html>
