<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2019/2/11
  Time: 09:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
    <title>重庆文理学院教务系统成绩查询</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        input {
            margin-top: 20px;
        }
        body {
            padding-top: 40px;
            padding-bottom: 40px;
        }
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
    <script src="./js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</head>
<body style="text-align: center;margin-top:20px;">
<div class="container">
    <form action="./search" method="post" class="form-signin">
        <h4 class="form-signin-heading">本网站共累计查询<span style="color:red;">${currentCount.count}</span>次</h4>
        <label for="inputText" class="sr-only">学号或用户名</label>
        <input type="text" id="inputText" class="form-control" placeholder="学号或用户名...." required autofocus name="username">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码...." required name="password">
        <button style="margin-top:20px;" class="btn btn-lg btn-primary btn-block" type="submit">查询</button>
    </form>
</div>
<footer>
    Copyright &copy; 2019 @author lxxxxxxy @time 2019/2/11 09:58
</footer>
</body>
</html>
