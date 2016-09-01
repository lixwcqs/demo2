<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../commons/taglib.jsp" %>
<html>
<meta name="keywords" content="JS代码,焦点图,JS广告代码,JS特效代码" />
<meta name="description" content="此代码内容为猎豹jQuery全屏焦点图代码，属于站长常用代码，更多焦点图代码请访问16素材网JS代码频道。" />
<title>猎豹jQuery全屏焦点图代码_16素材网</title>
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
</head>
<body>
<!-- 代码 开始 -->
<div class="slide-main" id="touchMain">
	<a class="prev" href="javascript:;" stat="prev1001"><img src="${ctx}/images/slide/l-btn.png" /></a>

    <%--幻灯片--%>
	<div class="slide-box" id="slideContent">
		<div class="slide" id="bgstylec">
			<a stat="sslink-3" href="#" target="_blank">
				<div class="obj-e"><img src="${ctx}/images/slide/baomi-t-1.png" /></div>
				<div class="obj-f"><img src="${ctx}/images/slide/baomi-kl.jpg" /></div>
			</a>
		    </div>
		<div class="slide" id="bgstylea">
			<a stat="sslink-1" href="#" target="_blank">
				<div class="obj-a"><img src="${ctx}/images/slide/bao.png" /></div>
				<div class="obj-b"><img src="${ctx}/images/slide/nt-1.png" /></div>
			</a>
		</div>
		<div class="slide" id="bgstyleb">
			<a stat="sslink-2" href="#" target="_blank">
				<div class="obj-c"><img src="${ctx}/images/slide/bao-2.png" /></div>
				<div class="obj-d"><img src="${ctx}/images/slide/st-2.png" /><p>全新chrome内核，内存占用最低，轻巧炫酷皮肤</p></div>
			</a>
		</div>
	</div>
	<a class="next" href="javascript:;" stat="next1002"><img src="${ctx}/images/slide/r-btn.png" /></a>
	<div class="item">
		<a class="cur" stat="item1001" href="javascript:;"></a><a href="javascript:;" stat="item1002"></a>
        <a href="javascript:;" stat="item1003"></a>
	</div>
</div>
<!-- 代码 结束 -->

<div style="text-align:center;margin:50px 0">
<p>来源：<a href="http://www.liebao.cn/" target="_blank">猎豹安全浏览器</a>　代码整理：<a href="http://www.16sucai.com/" target="_blank">16素材网</a></p>
<p>＊尊重他人劳动成果，转载请自觉注明出处！注：此代码仅供学习交流，请勿用于商业用途。</p>
<p></p>
<p><p>猎豹jQuery全屏焦点图代码，兼容主流浏览器，16素材网推荐下载！</p><p><br /></p><p>使用方法：</p><p>1、在head区域引入样式表文件lrtk.css</p><p>2、在head区域引入jquery.js和lrtk.js</p><p>3、对IE6的兼容也做了相应考虑，代码见head头部</p><p>4、在你的网页中加入&lt;!-- 代码 开始 --&gt;&lt;!-- 代码 结束 --&gt;注释区域代码即可。</p></p>
<p style="margin:20px 0"></p>
</div>
</body>
</html>