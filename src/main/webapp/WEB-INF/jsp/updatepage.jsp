<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Update Entry</title>
    <link rel="stylesheet" href="<c:url value='/css/update.css'/>">
</head>
<body>

<div class="container">
    <div class="header">
        <h1>My Diary</h1>
    </div>
    <div class="around">
        <div class="details">
            <img src="<c:url value='/images/homediary.png'/>" alt="Diary Image" class="diary-image"/>
            <div class="content">
                <h2>Update</h2>
                <p><fmt:formatDate value="${entry.entrydate}" pattern="dd/MM/yyyy" /></p>
                <form method="post" action="saveupdate">
                    <input type="hidden" name="id" value="${entry.id}"/>
                    <label>Memory</label>
                    <input type="hidden" name="entrydate" value="${entry.entrydate}" />
                    <textarea name="description" rows="10" cols="50">${entry.description}</textarea>
                    <input type="hidden" name="userid" value="${entry.userid}"/>
                    <button class="btn" type="submit">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
