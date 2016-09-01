<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



	<script type="text/javascript">
		function checkForward(){

			var minNo = 1;
			var maxNO = ${page.totalPages};
			var curNo = $("#toPageNo").val();
			if(curNo<minNo || curNo > maxNO){
				var message = "警告！输入页码不在" + minNo +"~"+maxNO+"范围内";
				alert(message);
				return false;
			}
			$(this).closest("form").submit()
			console.log(curNo +"\t==" + minNo +"\t"+ maxNO)
		}
	</script>

<div class="fanye">
	<input type="hidden" name="pageNo" id="pageNo" value="${page.prePage}"/>
	<div class="fanye_1">
	  共${page.totalCount}条记录 共${page.totalPages}页
			当前第${page.pageNo}页
	 </div>
     <div class="fanye_2">
   		<a href="javascript:void(0);"onclick="$('#pageNo').val(1); $(this).closest('form').submit();" style="text-decoration: none">
   			<img src="${ctx }/images/firstPage_02.jpg" title="首页"/>
   		</a>

   		<s:if test="page.isHasPre()">
			<a href="javascript:void(0);" onclick='$("#pageNo").val(${page.prePage});$(this).closest("form").submit();' style="text-decoration: none">
				<img src="${ctx }/images/prePage_01.jpg" title="上一页"/>
			</a>
		</s:if>
		<s:else>
			<img src="${ctx }/images/prePage_01.jpg" title="上一页"/>
		</s:else>


		<s:if test="page.isHasNext()">
			<a href="javascript:void(0);" onclick='$("#pageNo").val(${page.nextPage});$(this).closest("form").submit();' style="text-decoration: none">
				<img src="${ctx }/images/nextPage_01.jpg" title="下一页"/>
			</a>
		</s:if>
		<s:else>
			<img src="${ctx }/images/nextPage_01.jpg" title="下一页"/>
		</s:else>

		<a href="javascript:void(0);" onclick='$("#pageNo").val(${page.totalPages});$(this).closest("form").submit();' style="text-decoration: none">
			<img src="${ctx }/images/lastPage_01.jpg" title="尾页"/>
		</a>
     </div>
   <div class="fanye_3">
		 <div class="fanye_4">
			 转到第<input id="toPageNo" name="toPageNo" type="text" value="${page.pageNo}" class="fy_input" style="text-decoration: none" />页
			 <%--<a href="javascript:void(0);" onclick='$("#pageNo").val($("#toPageNo").val());checkForward($("#toPageNo").val());' style="text-decoration: none">--%>
			 <a href="javascript:void(0);" onclick='$("#pageNo").val($("#toPageNo").val());$(this).closest("form").submit();' style="text-decoration: none">
				 <img src="${ctx }/images/tiaozhan.jpg" title="跳转" />
			 </a>
		 </div>

   </div>

</div>
