<%--
  Created by IntelliJ IDEA.
  User: ASUS1
  Date: 8/18/2026
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <h1>HTML FORM EXAMPLE with File Upload</h1>
<form action="${pageContext.request.contextPath}/processFormUpload" method="post"
  enctype="multipart/form-data"
>
<%--    name--%>
    <label>Name</label>
    <input type="text" name="name"> <br> <br>
    <%-- password--%>
    <label>Password</label>
    <input type="password" name="password">
    <br> <br>
    <label>Gender</label>
    <input type="radio" name="gender" value="Male" checked>
    <input type="radio" name="gender" value="Female">
    <br><br>
    <%--Hobbies--%>
    <label >Hobibies</label>
    <input type="checkbox" name ="hobbies" value="Reading" >Reading
    <input type="checkbox" name ="hobbies" value="Sports" >Sports
    <input type="checkbox" name ="hobbies" value="Music" >Music
    <br><br>
    <!-- Country -->
    <label>Country:</label>

    <select name="country">
        <option value="VietNam">VietNam</option>
        <option value="USA">USA</option>
        <option value="Japan">Japan</option>
        <option value="Korea">Korea</option>
    </select>
        <label>Birth Date:</label>
        <input type="date" name="date">
        <br><br>

        <!-- File Upload -->
        <label>Profile Picture:</label>

        <input type="file"
               name="file">
        <button type="submit">Submit</button>
        <br><br>

</form>

</body>
</html>
