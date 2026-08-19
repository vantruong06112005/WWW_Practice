package iuh.vantruong.bai5;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/secure/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        System.out.println(">>> AUTH FILTER ĐANG CHẠY: " + req.getRequestURI());
        boolean loggedIn = session != null
                && session.getAttribute("username") != null;

        if (loggedIn) {
            // Đã đăng nhập → cho phép truy cập
            chain.doFilter(request, response);
        } else {
            // Chưa đăng nhập → quay về login
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}