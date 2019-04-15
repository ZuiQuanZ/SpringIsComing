<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background: #9ebfee;
        }

        .left-menu {
            background: lightgoldenrodyellow;
            padding: 20px 0 0 0;
            min-height: 94vh;
        }
        .left-menu ul li {
            margin: 0px;
        }
        .left-menu ul li a {
            border-radius: 0px;
        }
        .nav-content {
            margin-bottom: -1px;
        }
        .edit-form label {
            font-weight: 100;
            font-size: 20px;
            margin: 10px 0 10px 0;
        }
    </style>

</head>

<body>
<div class="container-fluid">
    <header role="banner" id="top" class="navbar navbar-static-top">
        <nav role="navigation" class="navbar navbar-default">
            <div class="container">

                <div class="navbar-header">

                    <div class="animbrand"><a href="#" class="navbar-brand"><span
                            class="glyphicon glyphicon-leaf"></span>SpringIsComing</a></div>
                </div>

                <div class="collapse navbar-collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle">
                                <span></span>
                                Hello, ${user.login} <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/logout"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="row">
        <div class="col-lg-3 left-bar left-menu">
            <ul class="nav nav-pills nav-stacked nav-content">
                <li>
                    <a href="/admin">Admin</a>
                </li>
                <li class="active">
                    <a>User</a>
                </li>
            </ul>
        </div>
        <div class="col-lg-9 col-lg-offset-4">
            <h1>User panel</h1>
            <p>Hello ${user.login}!</p>
        </div>
    </div>
</div>
</body>
</html>
