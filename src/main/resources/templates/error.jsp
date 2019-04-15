<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
        body {
            background: #9ebfee;
        }

        .empty-block {
            height: 88px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-5 col-lg-offset-3">
            <h1 class="page-header">Error</h1>

            <div class="empty-block"></div>


            <div class="alert alert-danger">
                <h2>Status ${pageContext.response.getStatus()}</h2>
            </div>
                <a class="btn btn-default btn-block" href="/logout"><i
                        class="glyphicon glyphicon-off"></i> Logout</a>

        </div>
    </div>
</div>
</body>
</html>

