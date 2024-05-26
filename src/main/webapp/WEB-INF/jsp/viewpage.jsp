<%--
  Created by IntelliJ IDEA.
  User: SriRamya Nemani
  Date: 18-May-24
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/entries.css'/>">
</head>
<body>


<div class="container">
    <div class="header">
        <h1> My Diary</h1>
    </div>
    <div class="around">
        <div class="image">
            <img src="<c:url value='/images/homediary.png'/>" alt="Diary image" >
        </div>
        <div class="details">
            <h2>Capturing My Day</h2>
            <div>

                <label>Date</label>
                <p>  <fmt:formatDate value="${entry.entrydate}" pattern="dd/MM/yyy" /></p><br>
                <label>Memory</label>
                <p> ${entry.description}</p><br>
                <button><a href="./myhome">Back</a></button>



            </div>

        </div>
    </div>

</body>
</html>
