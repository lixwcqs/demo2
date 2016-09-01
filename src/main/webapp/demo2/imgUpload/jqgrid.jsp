<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/9/15
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<html>
<head>
    <link href="${ctx}/webjars/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   <link href="${ctx}/style/plugins/ui.jqgrid.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/style/plugins/slide/lrtk.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/plugins/slide/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/plugins/slide/16sucai.js"></script>
    <!--[if lte IE 6]>
    <script type="text/javascript" src="${ctx}/js/plugins/slide/belatedPNG.js"></script>
    <script type="text/javascript">
        var __IE6=true;
        DD_belatedPNG.fix('.logo img,.prev img,.next img,img');
    </script>
    <![endif]-->

    <%--<script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" ></script>--%>
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.0.min.js" ></script>
    <%--<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>--%>
    <script type="text/javascript" src="${ctx}/webjars/jqgrid/4.7.0/js/i18n/grid.locale-cn.js" ></script>
    <script type="text/javascript" src="${ctx}/webjars/jqgrid/4.7.0/js/jquery.jqGrid.js" ></script>
    <script type="text/javascript" src="${ctx}/webjars/jqgrid/4.7.0/js/grid.jqueryui.js" ></script>

    <script type="text/javascript" >

        $(function(){
            // 配置jqGrid组件
            $("#gridTable").jqGrid({
                url: '${ctx}/imgUpload/imgList',
                <%--url: '${ctx}/user/create',--%>
                datatype: "json",
                mtype: "POST",
//                height: 350,
                height : 'auto',
                autowidth: true,
                colModel: [
                    {name:"id",index:"id",label:"img Id",width:100 },
                    {name:"applyId",index:"applyId",label:"apply applyId",width:80,sortable:false},
                    {name:"name",index:"name",label:"img name",width:80,sortable:false},
                    {name:"url",index:"url",label:"img url",width:160,sortable:false},
                ],
                viewrecords: true,
                rowNum: 2,
                rowList: [2,50,100],
                prmNames: {search: "search"},	//(1)
                jsonReader: {
                    root:"jsonResult",		// (2)
                    records: "record",		// (3)
                    repeatitems : false		// (4)
                },
                pager: "#gridPager",
                caption: "image list",
                hidegrid: false
            });
        });
    </script>
    <title></title>
</head>

<body>

        ${imgs}
        <a href="${ctx}/imgUpload/imgList" >img</a>
        <div class="container">
            <table id="gridTable" class="table-striped table-bordered" ></table>
            <%--<div id="gridPager" ></div>--%>

            <div class="slide-main" id="touchMain">
                <a class="prev" href="javascript:;" stat="prev1001"><img src="${ctx}/images/slide/l-btn.png" /></a>

                <%--幻灯片--%>
                <div class="slide-box" id="slideContent">
                    <c:forEach var="img" items="${imgs}">
                        ${img}
                        <div class="slide" id="bgstylec">
                            <a stat="sslink-3" href="#" target="_blank">
                                <div class="obj-e"><img src="${img.url}" /></div>
                                    <%--<div class="obj-f"><img src="${ctx}/images/slide/baomi-kl.jpg" /></div>--%>
                            </a>
                        </div>
                    </c:forEach>
                </div>
                <a class="next" href="javascript:;" stat="next1002"><img src="${ctx}/images/slide/r-btn.png" /></a>
                <div class="item">
                    <a class="cur" stat="item1001" href="javascript:;"></a><a href="javascript:;" stat="item1002"></a>
                    <a href="javascript:;" stat="item1003"></a>
                </div>
            </div>
            <!-- 代码 结束 -->

            <div style="text-align:center;margin:50px 0">
                <p style="margin:20px 0"></p>
            </div>
        </div>


</body>
</html>
