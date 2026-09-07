package iuh.fit.vantruong.bai1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String course = request.getParameter("course");

        String[] hobbies = request.getParameterValues("hobbies");

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("dob", dob);
        request.setAttribute("email", email);
        request.setAttribute("mobile", mobile);
        request.setAttribute("gender", gender);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("pinCode", pinCode);
        request.setAttribute("state", state);
        request.setAttribute("country", country);
        request.setAttribute("course", course);
        request.setAttribute("hobbies", hobbies);

        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}