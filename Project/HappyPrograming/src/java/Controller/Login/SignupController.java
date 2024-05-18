package Controller.Login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Perform user registration (placeholder for actual registration logic)
        // registerUser(username, password, email);

        // Send verification email
        try {
            sendVerificationEmail(email);
            // Redirect user to a confirmation page
            response.sendRedirect("confirmation.html");
        } catch (MessagingException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to send verification email");
        }
    }

    private void sendVerificationEmail(String to) throws MessagingException {
        // SMTP server configuration
        String host = "smtp.gmail.com";
        int port = 587;
       String username = "faded886@gmail.com";
        String password = "mailinh56";

        // Check if credentials are available
        if (username == null || password == null) {
            throw new MessagingException("Email credentials are not set in environment variables");
        }

        // Email content
        String subject = "Account Verification";
        String body = "Dear user,\n\n" +
                      "Thank you for registering. Please click the following link to verify your email address:\n\n" +
                      "http://your_website.com/verify?email=" + to + "\n\n" +
                      "Best regards,\n" +
                      "Your Website Team";

        // Set mail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Create message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        // Send message
        Transport.send(message);

        System.out.println("Verification email sent to: " + to);
    }
}
