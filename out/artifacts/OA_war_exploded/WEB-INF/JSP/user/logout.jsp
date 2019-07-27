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
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>您已退出Itcast OA系统</title>
  <link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
  <tr>
    <td align=center>
      <div id=Logout>
        <div id=AwokeMsg><img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border=0 /></div>
        <div id=LogoutOperate>
          <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 />
          <a href="${pageContext.request.contextPath}/user_loginUI.action">重新进入系统</a>
          <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: window.close();">关闭当前窗口</a>
        </div>
      </div>
    </td>
  </tr>
</table>
</body>
</html>