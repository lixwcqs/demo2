<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<html>
<meta name="keywords" content="JS代码,焦点图,JS广告代码,JS特效代码" />
<meta name="description" content="此代码内容为猎豹jQuery全屏焦点图代码，属于站长常用代码，更多焦点图代码请访问16素材网JS代码频道。" />
<title>猎豹jQuery全屏焦点图代码_16素材网</title>
<link href="${ctx}/style/plugins/slide/lrtk.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" ></script>
<script type="text/javascript" src="${ctx}/js/plugins/slide/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/plugins/slide/16sucai.js"></script>
<!--[if lte IE 6]>
<script type="text/javascript" src="${ctx}/js/plugins/slide/belatedPNG.js"></script>
<script type='text/javascript' src="${ctx}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"  ></script>
<script type="text/javascript">
    var __IE6=true;
    DD_belatedPNG.fix('.logo img,.prev img,.next img,img');
</script>
<![endif]-->

<script type="text/javascript" >
    function viewImg(url) {
        console.log("查看图片：" + url)
    }
</script>
</head>
<body>
    <div class="container" >
    <%--表单 展示个图片的审批信息--%>
    <div>
        <form class="form-horizontal">
            <table border="1" class="table-bordered table-striped" width="60%">
                <tr>
                    <td>序号</td>
                    <td>图片名称</td>
                    <td>审批详情</td>
                    <td>预览</td>
                </tr>
                <c:forEach var="img" items="${imgs}" varStatus="count">
                    <tr style="height: 30px;">
                        <td width="5%"><c:out value="${count.index}"/></td>
                        <td width="20%"><c:out value="${img.name}"/></td>
                        <td width="20%"><input name="money" id="money"/></td>
                        <td width="20%"><button onclick="viewImg('${img.name}');" class="btn-default">查案</button></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>

  <%----%>
        <div>
            <label class="label-info" >图片展示：</label>
        </div>

    <!-- 图片幻灯片 -->
    <div class="slide-main" id="touchMain">
        <%--<a class="prev" href="javascript:;" stat="prev1001"><img src="${ctx}/images/slide/l-btn.png" /></a>--%>
        <a class="prev" href="javascript:;" ><img src="${ctx}/images/slide/l-btn.png" /></a>
        ${img.name}
        <%--幻灯片--%>
        <div class="slide-box" id="slideContent">
           <c:forEach var="img" items="${imgs}">

               <div class="slide" id="bgstylea">
                   <a stat="sslink-3"  target="_blank">
                       <div class="obj-e"><img src="${img.url}" title="${img.name}"/></div>
                   </a>
               </div>
               <%--<s:label value="${img.name}" />--%>
           </c:forEach>
        </div>
        <a class="next" href="javascript:;" stat="next1002"><img src="${ctx}/images/slide/r-btn.png" /></a>
        <%--<div class="item">--%>
            <%--<a class="cur" stat="item1001" href="javascript:;"></a><a href="javascript:;" stat="item1002"></a>--%>
            <%--<a href="javascript:;" stat="item1003"></a>--%>
        <%--</div>--%>
    </div>
    <!-- 代码 结束 -->

    <div style="text-align:center;margin:50px 0">
        <p style="margin:20px 0"></p>
    </div>
    </div><%-- container--%>
</body>
</html>