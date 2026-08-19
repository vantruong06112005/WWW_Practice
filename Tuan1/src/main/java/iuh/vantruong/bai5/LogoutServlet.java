/*
 * @ (#) LogoutServlet.java     1.0    8/18/2026
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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}
