package me.huynhducphu.section_8;

import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/sendEmail")
@MultipartConfig
public class SendEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String USERNAME = "";
    private final String PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");
        Part file = req.getPart("attachment");
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject, "UTF-8");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(body, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            if (file != null && file.getSize() > 0) {
                MimeBodyPart attachPart = new MimeBodyPart();
                String fileName = file.getSubmittedFileName();
                InputStream fileContent = file.getInputStream();
                attachPart.setFileName(fileName);
                attachPart.setDataHandler(
                        new DataHandler(
                                new ByteArrayDataSource(
                                        fileContent,
                                        getServletContext().getMimeType(fileName)
                                )
                        )
                );
                multipart.addBodyPart(attachPart);

                message.setContent(multipart);

                Transport.send(message);
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().println("<h3>Da gui mail thanh cong<h3>");
            }
        } catch (Exception e) {
            throw new ServletException("Loi gui mail: " + e.getMessage(), e);
        }
    }
}
