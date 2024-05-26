<%--
  Created by IntelliJ IDEA.
  User: SriRamya Nemani
  Date: 18-May-24
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            <form method="post" action="save">

                <label>Date</label>
                <input type="date" name="entrydate">
                <label>Memory</label>
                <textarea type="text" name="description" rows ="20" cols="10" ></textarea>
                <input type="hidden" name="userid" value="${user.id}">
                <button class="btn" type="submit">Save</button>
            </form>

        </div>

    </div>
</div>

</body>
</html>
