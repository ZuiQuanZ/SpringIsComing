<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="/admin/editUser" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <h1>Edit User</h1>
    <div>
        <label for="uName">Username</label>
        <input type="text" id="uName" name="login" value="${user.login}" required/>
    </div>
    <div>
        <label for="uPass">Password</label>
        <input type="text" id="uPass" name="password" value="${user.password}" required/>
    </div>
    <div>
        <label for="rol">Roles</label>
        <select name="rol" id="rol" multiple>
            <c:forEach var="role" items="${roles}">
                <option value=${role.id}>${role.role}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <input type="submit" value="Edit">
    </div>
</form>
</body>
</html>
