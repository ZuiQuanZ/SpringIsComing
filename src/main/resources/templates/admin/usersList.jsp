<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>AdminPage</title>
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
<!--<div class="navbar navbar-inverse navbar-static-top header navbar-default">
    <a class="navbar-brand" href="#addUser"><i class="glyphicon glyphicon-leaf"></i>Admin Manager</a>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/logout"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
    </ul>

</div> -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <jsp:include page="/WEB-INF/admin/uList.jsp"/>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Roles</th>
                    <td>
                        <a class="btn btn-default" href="${pageContext.servletContext.contextPath}/admin/addUser"><i
                                class="glyphicon glyphicon-plus-sign"></i>Add
                            User</a>
                    </td>
                </tr>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.login}</td>
                        <td>${user.password}</td>
                        <td>
                            <c:forEach var="role" items="${user.roles}">
                                ${role}
                            </c:forEach>
                        </td>
                        <td>
                            <div class="btn-group-vertical btn-group-xs">
                                <a class="btn btn-default"
                                   href="${pageContext.servletContext.contextPath}/admin/editUser?id=${user.id}"><i
                                        class="glyphicon glyphicon-pencil"></i>Edit</a>
                                <a class="btn btn-default"
                                   href="${pageContext.servletContext.contextPath}/admin/deleteUser?id=${user.id}"><i
                                        class="glyphicon glyphicon-trash"></i>Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>