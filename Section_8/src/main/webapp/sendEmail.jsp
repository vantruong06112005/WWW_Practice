<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sendEmail" method="post"
      enctype="multipart/form-data">
    <label for="to">Người nhận:</label>
    <input type="email" name="to" id="to" required/>
    <br/>
    <label for="subject">Tiêu Đề:</label>
    <input style="margin-left: 25px" type="text" name="subject" id="subject" required/>
    <br/>
    <label for="body">Nội Dung:</label>
    <br/>
    <textarea name="body" rows="10" cols="30" id="body" required></textarea>
    <br/>
    <label for="attachment">File đính kèm:</label>
    <input type="file" name="attachment" id="attachment"/>
    <br/>
    <button type="submit">Gửi Email</button>
</form>
</body>
</html>
