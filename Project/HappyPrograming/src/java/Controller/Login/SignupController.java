package Controller.Login;

import Dal.LoginDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EmailService;

public class SignupController extends HttpServlet {

    private final EmailService emailService = new EmailService();
    private Map<String, String> verificationCodes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // Initialize the verification codes map
        verificationCodes = (HashMap<String, String>) getServletContext().getAttribute("verificationCodes");
        if (verificationCodes == null) {
            verificationCodes = new HashMap<>();
            getServletContext().setAttribute("verificationCodes", verificationCodes);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String code = generateVerificationCode();
        verificationCodes.put(email, code);

        // Send verification email
        try {
            emailService.sendEmail(email, "Account Verification", """
                                                                  Dear user,
                                                                  
                                                                  Thank you for registering. Here is your verify code:
                                                                  
                                                                  """ + code + "\n");

            // Forward to the verification page with email attribute
            request.setAttribute("email", email);
            request.setAttribute("usename", username);
            request.setAttribute("password", password);
            request.setAttribute("role", role);
            request.getRequestDispatcher("./auth/verify.jsp").forward(request, response);
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to send verification email");
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return String.format("%06d", code);
    }
}
