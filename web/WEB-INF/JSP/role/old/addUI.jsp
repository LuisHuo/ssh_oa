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
    <title>添加岗位</title>
  </head>
  <body>
    <s:form action="role_add">
        <s:textfield name="name">name</s:textfield><br/>
        <s:textarea name="description">description</s:textarea><br/>
        <s:submit value="提交"/>
    </s:form>
  </body>
</html>
