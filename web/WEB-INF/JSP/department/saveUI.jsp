<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/24
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>部门设置</title>
    <%@ include file="/WEB-INF/JSP/public/basejsp.jspf" %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="department_%{ null == id ? 'add' : 'edit'}">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <s:hidden name="id"/>
                    <tr>
                        <td width="100">上级部门</td>
                        <td><s:select name="parentId" cssClass="SelectStyle"
                                      list="#deptList" listKey="id" listValue="name"
                                      headerKey="" headerValue="==请选择部门=="/>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">部门名称</td>
                        <td><s:textfield name="name" cssClass="InputStyle"/> *</td>
                    </tr>
                    <tr>
                        <td>职能说明</td>
                        <td><s:textarea name="description" cssClass="TextareaStyle"/></td>
                    </tr>
                </table>
            </div>
        </div>

        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
</html>
