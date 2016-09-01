<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2015/8/31
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<script type="text/javascript" >
    function paging(pageNo) {
        var i=0;
//        console.log("paging..." + pageNo);
        $('#pageNo').val(pageNo);
        console.log(event.target);
        $(event.target).closest('form').submit();
//        event.srcElement
//        $('#userForm').submit();
        console.log("paging..." + pageNo);
    }
</script>
${page.totalCount}-
${page.prePage}
-
${page.pages}

<div>
    <nav>
        <ul class="pagination">
            <%--传递将页码--%>
            <input type="hidden" name="pageNo" id="pageNo" value="${page.prePage}"/>
            <li>
                <%--<a href="#" aria-label="Previous">--%>
                <a href="javascript:void(0);"onclick="paging(1);" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

                <% int count = 0 ;%>
                <c:forEach varStatus="cur " begin="1"  end="${page.pages > 3  ?  3  : page.pages}" >

                    <li>
                        <a href="javascript:void(0);" onclick="paging(<%=count+1 %>);" ><c:out value="${cur.index}"></c:out><%= ++count %> </a>
                    </li>
                </c:forEach>
            <%--<c:forTokens  >--%>
                <%--<li>--%>
                    <%--<a href="#">${cur}</a>--%>
                <%--</li>--%>
            <%--</c:forTokens>--%>

                ${page.pages > 2  ?  2  : page.pages}
            <li>
                <a href="javascript:void(0);"onclick="paging(${page.pages}); $(this).closest('form').submit();" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>