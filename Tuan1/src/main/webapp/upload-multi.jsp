<%--
  Created by IntelliJ IDEA.
  User: ASUS1
  Date: 8/19/2026
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài tập  6</title>
</head>
<body>
<h1>Bài tập số 6</h1>
<form action="${pageContext.request.contextPath}/uploadmulti" method="post" enctype="multipart/form-data">
    <input type="file" name="file"> <br><br>
    <input type="file" name="file"> <br><br>
    <input type="file" name="file"> <br><br>
    <input type="file" name="file"> <br><br>
    <button type="submit">Submit</button>
    <button type="submit" >Reset</button>


</form>
</body>
</html>
