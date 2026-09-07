<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Result</title>

  <style>
    .container {
      width: 80%;
      margin: auto;
      border: 1px solid;
      padding: 20px;
    }

    h1 {
      text-align: center;
    }

    p {
      margin: 10px 0;
    }

    .title {
      font-weight: bold;
    }
  </style>
</head>

<body>

<div class="container">

  <h1>Student Registration Result</h1>

  <p>
    <span class="title">First Name:</span>
    ${firstName}
  </p>

  <p>
    <span class="title">Last Name:</span>
    ${lastName}
  </p>

  <p>
    <span class="title">Date of Birth:</span>
    ${dob}
  </p>

  <p>
    <span class="title">Email:</span>
    ${email}
  </p>

  <p>
    <span class="title">Mobile:</span>
    ${mobile}
  </p>

  <p>
    <span class="title">Gender:</span>
    ${gender}
  </p>

  <p>
    <span class="title">Address:</span>
    ${address}
  </p>

  <p>
    <span class="title">City:</span>
    ${city}
  </p>

  <p>
    <span class="title">Pin Code:</span>
    ${pinCode}
  </p>

  <p>
    <span class="title">State:</span>
    ${state}
  </p>

  <p>
    <span class="title">Country:</span>
    ${country}
  </p>

  <p>
    <span class="title">Course:</span>
    ${course}
  </p>

  <p>
    <span class="title">Hobbies:</span>

    <%
      String[] hobbies = (String[]) request.getAttribute("hobbies");

      if (hobbies != null) {
        for (String hobby : hobbies) {
          out.print(hobby + " ");
        }
      }
    %>
  </p>

</div>

</body>
</html>