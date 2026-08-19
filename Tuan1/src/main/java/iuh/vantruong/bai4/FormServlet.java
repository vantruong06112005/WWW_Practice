/*
 * @ (#) FormServlet.java     1.0    8/18/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.vantruong.bai4;


/*
 * @description
 * @author:NguyenTruong
 * @date:  8/18/2026
 * @version:    1.0
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//fileSizeThreshold → Ngưỡng lưu tạm
//maxFileSize       → Tối đa 1 file
//maxRequestSize    → Tối đa toàn bộ request
@WebServlet("/processFormUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,        // 1MB
        maxFileSize = 1024 * 1024 * 10,         // 10MB
        maxRequestSize = 1024 * 1024 * 15       // 15MB
)
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form-upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // lấy dư liệu từ form về
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");

        String country = req.getParameter("country");

        String birthDate = req.getParameter("birthDate");
        // Lấy file từ form
        Part filePart = req.getPart("file");

        String fileName = null;

        if (filePart != null) {

            // Lấy tên file
            fileName = filePart.getSubmittedFileName();

            // Đường dẫn thư mục uploads
            String uploadPath =
                    "E:\\BaiTapThucHanhWWW\\Tuan1\\uploads";

            // lưu cho mọi máy
//            String uploadPath =
//                    System.getProperty("user.home")
//                            + java.io.File.separator
//                            + "uploads";
            // Chuyển String thành Path
            Path uploadDir = Paths.get(uploadPath);

            // Tạo thư mục nếu chưa tồn tại
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Tạo đường dẫn đầy đủ:
            // uploads + tên file
            Path filePath = uploadDir.resolve(fileName);

            // Lưu file
            filePart.write(filePath.toString());
        }
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Form Result</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Form Data Received</h2>");

        out.println("<p><b>Name:</b> "
                + name + "</p>");

        out.println("<p><b>Password:</b> "
                + password + "</p>");

        out.println("<p><b>Gender:</b> "
                + gender + "</p>");


        // Hobbies
        out.println("<p><b>Hobbies:</b> ");

        if (hobbies != null) {

            out.println(String.join(", ", hobbies));

        } else {

            out.println("None");

        }

        out.println("</p>");


        out.println("<p><b>Country:</b> "
                + country + "</p>");

        out.println("<p><b>Birth Date:</b> "
                + birthDate + "</p>");


        // File
        out.println("<p><b>Uploaded File:</b> ");

        if (fileName != null && !fileName.isEmpty()) {

            out.println(fileName);

        } else {

            out.println("No file");

        }
        out.println("</p>");
        out.println("<br>");

        out.println("<a href='"
                + req.getContextPath()
                + "/form-upload.jsp'>");
        out.println("Back to Form");
        out.println("</a>");

        out.println("</body>");
        out.println("</html>");
        }

    }

