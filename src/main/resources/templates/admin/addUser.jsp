<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Add User</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
        body {
            background: #9ebfee;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <jsp:include page="/WEB-INF/admin/uList.jsp"/>
    </div>
</nav>
<form action="/admin/addUser" method="POST">
    <h1>Add User</h1>
    <div>
        <label for="uLogin">Username</label>
        <input type="text" id="uLogin" name="login" required/>
    </div>
    <div>
        <label for="uPass">Password</label>
        <input type="text" id="uPass" name="password" required/>
    </div>
    <label for="rol">Roles</label>
    <select name="rol" id="rol" multiple>
        <c:forEach var="role" items="${roles}">
            <option value=${role.id}>${role.role}</option>
        </c:forEach>
    </select>
    <div>
        <input type="submit" value="Add">
    </div>
</form>
</body>
</html>
