<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2019/2/11
  Time: 10:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
    <meta charset="UTF-8">
    <title>查询结果</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="./js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var stu = ${score};
        $(document).ready(function () {
            var s = "";
            for (var i = 0; i < stu.length; i++) {
                s = "<tr><td>" + stu[i].courseName + "</td><td style=\"color:red;\">" + stu[i].validscore + "</td><td>" +
                    stu[i].studyNature + "</td></tr>";
                $("#tab").append(s);
            }
        });
    </script>
</head>

<body>
<table style="margin:0 auto;" border="1px" cellspacing="0" cellpadding="0" class="table table-hover">
    <tr>
        <th>课程名称</th>
        <th>成绩</th>
        <th>性质</th>
    </tr>
    <tbody id="tab">

    </tbody>
</table>
<footer>
    Copyright &copy; 2019 @author lxxxxxxy @time 2019/2/11 09:58
</footer>
</body>
</html>