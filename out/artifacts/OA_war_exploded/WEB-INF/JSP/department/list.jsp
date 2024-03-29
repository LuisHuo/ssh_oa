<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/24
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>部门列表</title>
  <%@ include file="/WEB-INF/JSP/public/basejsp.jspf"%>
</head>
<body>

<div id="Title_bar">
  <div id="Title_bar_Head">
    <div id="Title_Head"></div>
    <div id="Title"><!--页面标题-->
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门管理
    </div>
    <div id="Title_End"></div>
  </div>
</div>

<div id="MainArea">
  <table cellspacing="0" cellpadding="0" class="TableStyle">

    <!-- 表头-->
    <thead>
    <tr align="CENTER" valign="MIDDLE" id="TableTitle">
      <td width="150px">部门名称</td>
      <td width="150px">上级部门名称</td>
      <td width="200px">职能说明</td>
      <td>相关操作</td>
    </tr>
    </thead>
<tbody/>
    <!--显示数据列表-->
      <tbody id="TableData" class="dataContainer" datakey="roleList">
        <s:iterator value="#deptList">
            <tr class="TableDetail1 template">
                <td><s:a action="department_list?parentId=%{id}">${name} &nbsp;</s:a></td>
              <td>${parent.name} &nbsp;</td>
              <td>${description} &nbsp;</td>
              <td>
                  <s:a action="department_delete?id=%{id}&parentId=%{parentId}" onclick="return confirm('若删除该部门会同时删除该部门的下属部门，确定要删除吗?')">删除</s:a>
                  <s:a action="department_editUI?id=%{id}">修改</s:a>
              </td>
            </tr>
        </s:iterator>
        </tbody>
  </table>

  <!-- 其他功能超链接 -->
  <div id="TableTail">
    <div id="TableTail_inside">
        <s:a action="department_addUI?parentId=%{parentId}"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        <s:a action="department_list?parentId=%{#parent.parent.id}"><img src="${pageContext.request.contextPath}/style/blue/images/button/ReturnToPrevLevel.png" /></s:a>
    </div>
  </div>
</div>
<div id="Description">
  说明：<br />
  1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
  2，点击部门名称，可以查看此部门相应的下级部门列表。<br/>
  3，删除部门时，同时删除此部门的所有下级部门。
</div>
</body>
</html>