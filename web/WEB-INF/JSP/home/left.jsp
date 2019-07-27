<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航菜单</title>
    <%@ include file="/WEB-INF/JSP/public/basejsp.jspf" %>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css"/>
    <script type="text/javascript">
        function menuClick(menu) {
            $(menu).next().toggle();
        }
    </script>

</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <s:iterator value="#application.topPrivilege">
            <s:if test="#session.user.hasPrivilegeByName(name)">
        <li class="level1">
            <div onClick="menuClick(this)" class="level1Style"><img
                    src="${pageContext.request.contextPath}/style/images/MenuIcon/${id}.gif" class="Icon"/>
                    ${name}
            </div>
            <ul style="" class="MenuLevel2">
                <s:iterator value="children">
                    <s:if test="#session.user.hasPrivilegeByName(name)">
                <li class="level2">
                    <div class="level2Style"><img
                            src="${pageContext.request.contextPath}/style/images/MenuIcon/menu_arrow_single.gif"/>
                            <a target="right" href="${pageContext.request.contextPath}${url}.action">
                        ${name}
                            </a>
                    </div>
                </li>
                    </s:if>
                </s:iterator>
            </ul>
        </li>
            </s:if>
        </s:iterator>
    </ul>
</div>
</body>
</html>
