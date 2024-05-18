package Controller.Login;

import Dal.LoginDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EmailService;

public class SignupController extends HttpServlet {

    private final EmailService emailService = new EmailService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        // Perform user registration (placeholder for actual registration logic)
        LoginDBContext acc = new LoginDBContext();
        try {
            acc.registerUser(username, password, role, email);
        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Send verification email
        try {
            emailService.sendEmail(email, "Account Verification", "Dear user,\n\n" +
                    "Thank you for registering. Please click the following link to verify your email address:\n\n" +
                    "http://your_website.com/verify?email=" + email + "\n\n" +
                    "Best regards,\n" +
                    "Your Website Team");
            // Redirect user to a confirmation page
            response.sendRedirect("confirmation.html");
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to send verification email");
        }
    }
}
