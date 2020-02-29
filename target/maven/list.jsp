<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/28
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<table width="30%" align="center">
    <tr bgcolor="gray">
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
    </tr>
    <c:forEach items="${list}" var="p" varStatus="st">

        <tr bgcolor="${st.index%2!=0?'#aaaaa':'' }">
            <td>${p.sname }</td>
            <td>${p.age }</td>
            <td>${p.sex }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
