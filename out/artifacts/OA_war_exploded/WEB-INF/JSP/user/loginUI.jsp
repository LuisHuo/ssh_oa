<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/24
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<HTML>
<HEAD>
  <META http-equiv=Content-Type CONTENT="text/html; charset=gbk" />
  <TITLE>Itcast OA</TITLE>
  <LINK HREF="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet />
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<FORM METHOD="post" NAME="actForm" ACTION="user_login.action">
  <DIV ID="CenterAreaBg">
    <DIV ID="CenterArea">
      <DIV ID="LogoImg"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/logo.png" /></DIV>
      <DIV ID="LoginInfo">
        <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
          <tr>
            <%--<td clospan="2">--%>
              <font color="red"> <s:fielderror/></font>
            <%--</td>--%>
          </tr>
          <TR>
            <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/login/userId.gif" /></TD>
            <TD><s:textfield name="loginName" SIZE="20" CLASS="TextField" TYPE="text" NAME="loginName" /></TD>
            <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif"/></TD>
          </TR>
          <TR>
            <TD CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/login/password.gif" /></TD>
            <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="password" /></TD>
          </TR>
        </TABLE>
      </DIV>
      <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2010 版权所有 itcast</A></DIV>
    </DIV>
  </DIV>
</FORM>
</BODY>