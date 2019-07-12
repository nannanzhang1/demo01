<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2019/7/6
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="jquery-3.3.1.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/quickk22">
    <input type="text" name="username">
    <input type="file" name="uploadFile">
    <input type="submit" value="提交">

</form>
</body>
</html>
