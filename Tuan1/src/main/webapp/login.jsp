<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>

<h2>Đăng nhập</h2>

<form action="${pageContext.request.contextPath}/login" method="post">

  <label>Tên đăng nhập:</label>
  <input type="text" name="username">
  <br><br>

  <label>Mật khẩu:</label>
  <input type="password" name="password">
  <br><br>

  <button type="submit">Đăng nhập</button>

</form>

<%
  if (request.getAttribute("error") != null) {
%>
<p style="color:red">
  <%= request.getAttribute("error") %>
</p>
<%
  }
%>
</body>
</html>