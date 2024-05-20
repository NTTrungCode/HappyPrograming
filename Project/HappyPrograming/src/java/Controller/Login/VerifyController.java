package Controller.Login;

import Dal.LoginDBContext;
import java.io.IOException;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerifyController extends HttpServlet {

    private Map<String, String> verificationCodes;

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
        // Retrieve the user input
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Validate the verification code
        String expectedCode = verificationCodes.get(email);
        if (expectedCode != null && expectedCode.equals(code)) {
            // Verification successful
            request.setAttribute("message", "Verification successful. You can now log in.");
            verificationCodes.remove(email);
        } else {
            // Verification failed
            request.setAttribute("message", "Invalid verification code. Please try again.");
        }
        
        // Perform user registration (placeholder for actual registration logic)
        LoginDBContext acc = new LoginDBContext();
        try {
            acc.registerUser(username, password, role, email);
        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Forward to the result page
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
