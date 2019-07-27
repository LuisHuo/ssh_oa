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
    <title>岗位管理</title>
  </head>
  <body>

    <s:iterator value="#roleList">
      <s:property value="id"/>
      <s:property value="name"/>
      <s:property value="description"/>
      <s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a>
      <s:a action="role_editUI?id=%{id}">修改</s:a>
      <br/>
    </s:iterator>

    <br/>

    <s:a action="role_addUI">添加</s:a>

  </body>
</html>
