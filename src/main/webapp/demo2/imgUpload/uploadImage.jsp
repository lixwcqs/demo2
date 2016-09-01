<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/9/13
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/taglib.jsp" %>
<html>
<head>
    <link href="${ctx}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.1/jquery.min.js" ></script>
    <script type='text/javascript' src="${ctx}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"  ></script>
    <title>uploadImage</title>
</head>
<body>
  <div class="container" >
    <form class="form-horizontal" action="${ctx}/imgUpload/uploadImage.action" method="post" style="width: 30%;" enctype="multipart/form-data">
        <div>
          <label for="imageFile">图片预览</label>
          <input id="imageFile" name="imageFile" class="form-control" placeholder="图片预览" type="file">
        </div>
      <div>
        <input  class="form-control"  name="提交" value="提交" type="submit">
      </div>
    </form>
      ${imgPath}===!
      <img src="${imgPath}">
  </div>
</body>
</html>
