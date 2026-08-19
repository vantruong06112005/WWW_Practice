    /*
     * @ (#) LoginServlet.java     1.0    8/18/2026
     *
     * Copyright (c) 2026 IUH. All rights reserved.
     */
    package iuh.vantruong.bai5;


    /*
     * @description
     * @author:NguyenTruong
     * @date:  8/18/2026
     * @version:    1.0
     */

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpSession;

    import java.io.IOException;
    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    super.doPost(req, resp);
                String username=req.getParameter("username");
                String password = req.getParameter("password");
                if("admin".equals(username)&&password.equals("password")){
                    // tạo phiên làm việc
                    HttpSession session = req.getSession();
                    session.setAttribute("username",username);
                    resp.sendRedirect("home.jsp");

                }else{
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                }
        }
    }
