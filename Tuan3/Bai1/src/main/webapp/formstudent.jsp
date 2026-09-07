<%--
  Created by IntelliJ IDEA.
  User: ASUS1
  Date: 8/26/2026
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>FormDangKi</title>

    <style>

        .container {
            width: 90%;
            border: 1px solid;
            margin: auto;
            padding: 20px;
        }

        .tieude {
            text-align: center;
        }

        .row {
            display: flex;
            gap: 20px;
            margin-bottom: 20px;
        }

        .col {
            flex: 1;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="number"],
        textarea {
            width: 100%;
            box-sizing: border-box;
            padding: 5px;
        }

        textarea {
            height: 70px;
        }

        .inline {
            display: flex;
            gap: 15px;
        }

        .inline label {
            display: inline;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th,
        td {
            border: 1px solid;
            padding: 5px;
        }

        table input {
            width: 95%;
        }

        .button {
            text-align: center;
            margin-top: 20px;
        }

    </style>

</head>

<body>

<div class="container">

    <h1 class="tieude">
        Student Registration Form
    </h1>


    <form action="register" method="get">


        <!-- First Name + Last Name -->

        <div class="row">

            <div class="col">

                <label>First Name</label>

                <input type="text"
                       name="firstName"
                       maxlength="50"
                       required>

            </div>


            <div class="col">

                <label>Last Name</label>

                <input type="text"
                       name="lastName"
                       maxlength="50"
                       required>

            </div>

        </div>



        <!-- Date of Birth -->

        <div class="row">

            <div class="col">

                <label>Date of Birth</label>

                <input type="date"
                       name="dob">

            </div>

        </div>



        <!-- Email + Mobile -->

        <div class="row">

            <div class="col">

                <label>Email</label>

                <input type="email"
                       name="email">

            </div>


            <div class="col">

                <label>Mobile</label>

                <input type="text"
                       name="mobile">

            </div>

        </div>



        <!-- Gender -->

        <div class="row">

            <div class="col">

                <label>Gender</label>

                <div class="inline">

                    <label>
                        <input type="radio"
                               name="gender"
                               value="Male">
                        Male
                    </label>


                    <label>
                        <input type="radio"
                               name="gender"
                               value="Female">
                        Female
                    </label>

                </div>

            </div>

        </div>



        <!-- Address -->

        <div class="row">

            <div class="col">

                <label>Address</label>

                <textarea name="address"></textarea>

            </div>

        </div>



        <!-- City + Pin Code -->

        <div class="row">

            <div class="col">

                <label>City</label>

                <input type="text"
                       name="city">

            </div>


            <div class="col">

                <label>Pin Code</label>

                <input type="text"
                       name="pinCode">

            </div>

        </div>



        <!-- State + Country -->

        <div class="row">

            <div class="col">

                <label>State</label>

                <input type="text"
                       name="state">

            </div>


            <div class="col">

                <label>Country</label>

                <input type="text"
                       name="country"
                       value="Vietnam">

            </div>

        </div>



        <!-- Hobbies -->

        <div class="row">

            <div class="col">

                <label>Hobbies</label>

                <div class="inline">

                    <label>
                        <input type="checkbox"
                               name="hobbies"
                               value="Drawing">
                        Drawing
                    </label>


                    <label>
                        <input type="checkbox"
                               name="hobbies"
                               value="Singing">
                        Singing
                    </label>


                    <label>
                        <input type="checkbox"
                               name="hobbies"
                               value="Dancing">
                        Dancing
                    </label>


                    <label>
                        <input type="checkbox"
                               name="hobbies"
                               value="Sketching">
                        Sketching
                    </label>


                    <label>
                        <input type="checkbox"
                               name="hobbies"
                               value="Others">
                        Others
                    </label>

                </div>

            </div>

        </div>



        <!-- Qualification -->

        <label>Qualification</label>

        <table>

            <thead>

            <tr>

                <th>SL.No</th>

                <th>Examination</th>

                <th>Board</th>

                <th>Percentage</th>

                <th>Year of Passing</th>

            </tr>

            </thead>


            <tbody>


            <!-- Class X -->

            <tr>

                <td>1</td>

                <td>
                    Class X
                </td>

                <td>
                    <input type="text"
                           name="board10">
                </td>

                <td>
                    <input type="text"
                           name="percentage10">
                </td>

                <td>
                    <input type="text"
                           name="year10">
                </td>

            </tr>



            <!-- Class XII -->

            <tr>

                <td>2</td>

                <td>
                    Class XII
                </td>

                <td>
                    <input type="text"
                           name="board12">
                </td>

                <td>
                    <input type="text"
                           name="percentage12">
                </td>

                <td>
                    <input type="text"
                           name="year12">
                </td>

            </tr>

            </tbody>

        </table>



        <!-- Course -->

        <div style="margin-top: 15px;">

            <label>Course applies for</label>

            <div class="inline">


                <label>
                    <input type="radio"
                           name="course"
                           value="BCA">
                    BCA
                </label>


                <label>
                    <input type="radio"
                           name="course"
                           value="B.Com">
                    B.Com
                </label>


                <label>
                    <input type="radio"
                           name="course"
                           value="B.Sc">
                    B.Sc
                </label>


                <label>
                    <input type="radio"
                           name="course"
                           value="B.A">
                    B.A
                </label>

            </div>

        </div>



        <!-- Button -->

        <div class="button">

            <button type="submit">
                Submit
            </button>


            <button type="reset">
                Reset
            </button>

        </div>


    </form>

</div>

</body>

</html>