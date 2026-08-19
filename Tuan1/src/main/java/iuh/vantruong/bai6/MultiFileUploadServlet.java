/*
 * @ (#) MultiFileUploadServlet.java     1.0    8/19/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.vantruong.bai6;


/*
 * @description
 * @author:NguyenTruong
 * @date:  8/19/2026
 * @version:    1.0
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/uploadmulti")
@MultipartConfig(
        // Nếu file lớn hơn 1MB thì Servlet có thể lưu tạm ra disk
        fileSizeThreshold = 1024 * 1024,

        // Kích thước tối đa của MỖI file = 10MB
        maxFileSize = 1024 * 1024 * 10,

        // Tổng dung lượng tối đa của TOÀN BỘ request = 50MB
        // Ví dụ upload 5 file, tổng 5 file không được vượt quá 50MB
        maxRequestSize = 1024 * 1024 * 50
)
public class MultiFileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Khi truy cập /uploadmulti bằng GET
        // Servlet chuyển người dùng đến trang uploadmulti.jsp
        req.getRequestDispatcher("uploadmulti.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /*
         * BƯỚC 1: Xác định thư mục lưu file
         *
         * System.getProperty("user.home")
         * → lấy thư mục Home của máy tính hiện tại.
         *
         * Ví dụ Windows:
         * C:\Users\Truong
         *
         * File.separator
         * → dấu phân cách thư mục của hệ điều hành.
         *
         * "uploads"
         * → tên thư mục muốn lưu file.
         *
         * Kết quả:
         * C:\Users\Truong \\uploads
         */
        String uploadPath =
                System.getProperty("user.home")
                        + File.separator
                        + "uploads";


        /*
         * BƯỚC 2: Chuyển String thành Path
         *
         * uploadPath đang là String.
         *
         * Paths.get()
         * → chuyển String thành đối tượng Path
         * để Java dễ dàng thao tác với file/thư mục.
         */
        Path uploadDir = Paths.get(uploadPath);


        /*
         * BƯỚC 3: Kiểm tra thư mục uploads có tồn tại không
         *
         * Nếu chưa tồn tại:
         * → tạo thư mục.
         */
        if (!Files.exists(uploadDir)) {

            /*
             * createDirectories()
             * → tạo thư mục uploads.
             *
             * Nếu thư mục cha chưa tồn tại,
             * Java cũng có thể tạo luôn.
             */
            Files.createDirectories(uploadDir);
        }


        /*
         * BƯỚC 4: Lấy tất cả file được gửi từ form
         *
         * req.getParts()
         * → lấy toàn bộ Part trong multipart/form-data.
         *
         * Mỗi file upload sẽ tương ứng với một Part.
         *
         * Ví dụ người dùng chọn:
         * - image1.jpg
         * - image2.png
         * - document.pdf
         *
         * thì req.getParts() sẽ chứa các Part tương ứng.
         */
        for (Part part : req.getParts()) {


            /*
             * BƯỚC 5: Lấy tên file
             *
             * getSubmittedFileName()
             * → lấy tên file mà người dùng chọn.
             *
             * Ví dụ:
             * "image1.jpg"
             */
            String fileName = part.getSubmittedFileName();


            /*
             * Kiểm tra Part này có phải file hay không.
             *
             * Nếu fileName != null
             * → Part có chứa file.
             *
             * Nếu !fileName.isEmpty()
             * → tên file không được rỗng.
             */
            if (fileName != null && !fileName.isEmpty()) {


                /*
                 * BƯỚC 6: Làm sạch tên file
                 *
                 * Người dùng có thể gửi đường dẫn kiểu:
                 *
                 * C:\Users\Truong\Desktop\image.jpg
                 *
                 * hoặc:
                 *
                 * /home/user/image.jpg
                 *
                 * Paths.get(fileName).getFileName()
                 * → chỉ lấy phần tên file.
                 *
                 * Kết quả:
                 * image.jpg
                 *
                 * Mục đích:
                 * tránh sử dụng nguyên đường dẫn do client gửi lên.
                 */
                fileName =
                        Paths.get(fileName)
                                .getFileName()
                                .toString();


                /*
                 * BƯỚC 7: Tạo đường dẫn đầy đủ đến file
                 *
                 * uploadDir:
                 * C:\Users\Truonguploads
                 *
                 * fileName:
                 * image.jpg
                 *
                 * resolve()
                 * → ghép 2 phần lại.
                 *
                 * Kết quả:
                 * C:\Users\Truong\\uploads\image.jpg
                 */
                Path filePath =
                        uploadDir.resolve(fileName);


                /*
                 * BƯỚC 8: GHI FILE XUỐNG MÁY
                 *
                 * part.write()
                 * → lấy dữ liệu file từ request
                 * và ghi xuống đường dẫn filePath.
                 *
                 * Đây chính là bước FILE ĐƯỢC LƯU THẬT SỰ.
                 */
                part.write(filePath.toString());
            }
        }


        /*
         * BƯỚC 9: Thiết lập kiểu dữ liệu trả về
         *
         * Servlet sẽ trả về HTML.
         *
         * UTF-8 giúp hiển thị tiếng Việt đúng.
         */
        resp.setContentType("text/html;charset=UTF-8");


        /*
         * BƯỚC 10:
         * Trả HTML về cho trình duyệt.
         */
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<meta charset='UTF-8'>");
        resp.getWriter().println("<title>Upload Result</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");


        // Thông báo upload thành công
        resp.getWriter().println("<h2>Upload successful!</h2>");


        // Thông báo vị trí lưu file
        resp.getWriter().println(
                "<p>Files are saved in:</p>"
        );


        // Hiển thị đường dẫn thư mục uploads
        resp.getWriter().println(
                "<p><b>" + uploadPath + "</b></p>"
        );


        resp.getWriter().println("<br>");


        /*
         * Tạo link quay lại trang upload.
         *
         * req.getContextPath()
         * → lấy context path của project.
         *
         * Ví dụ:
         * /BaiTapWeb
         *
         * Sau đó nối với:
         * /upload-multi.jsp
         */
        resp.getWriter().println(
                "<a href='" +
                        req.getContextPath() +
                        "/upload-multi.jsp'>" +
                        "Back to Upload" +
                        "</a>"
        );


        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}








