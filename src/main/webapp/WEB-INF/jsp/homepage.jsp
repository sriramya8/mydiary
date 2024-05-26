<%--
  Created by IntelliJ IDEA.
  User: SriRamya Nemani
  Date: 18-May-24
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value='/css/styling.css' />">
</head>
<body>
<h1>My Diary</h1>
<h2>Welcome ${user.username}</h2>
<div class="button-container">
    <a href="./entries" class="button add-memory-button">Add Memory</a>
    <a href="./logout" class="button signout-button">Sign Out</a>
</div>


<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${noItems != null}">
        <tr>
            <td colspan="2">${noItems}</td>
        </tr>
    </c:if>
    <c:forEach items="${entries}" var="e">
        <tr>
            <td>
                <fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyy" /></td>
            <td>
                <a href="./view?id=${e.id}">View</a>
                <a href="./update?id=${e.id}">Update</a>
                <a href="./delete?id=${e.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
