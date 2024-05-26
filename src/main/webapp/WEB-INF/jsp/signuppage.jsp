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
    <title>Sign Up</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>


<div class="container">
    <div class="header">
        <h1> My Diary</h1>
    </div>
    <div class="around">
        <div class="image">
            <img src="<c:url value='/images/diary.png'/>" alt="Diary image" >
        </div>
        <div class="details">
            <h2>Sign Up </h2>
            <form method="post" action="./saveuser">
                <label>Email Id</label>
                <input type="email" name="emailid">
                <label>Username</label>
                <input type="text" name="username">
                <label>Password</label>
                <input type="password" name="password">
                <button class="btn" type="submit">Register</button>
            </form>
            <p>Already have an account? <a href="./login">Login</a></p>
        </div>

    </div>
</div>

</body>
</html>
