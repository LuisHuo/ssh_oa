<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/24
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>版块列表</title>
    <%@ include file="/WEB-INF/JSP/public/basejsp.jspf" %>
    <STYLE type="text/css">
        .disabled{
            color: gray;
            cursor: pointer;
        }
    </STYLE>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        <!-- 表头-->
        <thead>
        <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            <td width="250px">版块名称</td>
            <td width="300px">版块说明</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        <s:iterator value="#forumList" status="status">
            <tr class="TableDetail1 template">
                <td>${name}&nbsp;</td>
                <td>${description}&nbsp;</td>
                <td>
                    <s:a action="forumManage_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a>
                    <s:a action="forumManage_editUI?id=%{id}">修改</s:a>
                    <s:if test="#status.first">
                        <span class="disabled">上移</span>
                    </s:if>
                    <s:else>
                        <s:a action="forumManage_moveUp?id=%{id}">上移</s:a>
                    </s:else>
                    <s:if test="#status.last">
                        <span class="disabled">下移</span>
                    </s:if>
                    <s:else>
                        <s:a action="forumManage_moveDown?id=%{id}" >下移</s:a>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="forumManage_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png"/></s:a>
        </div>
    </div>
</div>

<div class="Description">
    说明：<br/>
    1，显示的列表按其sortOrder值升序排列。<br/>
    2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br/>
</div>

</body>
</html>