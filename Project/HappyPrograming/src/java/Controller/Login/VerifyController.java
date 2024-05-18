/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class VerifyController extends HttpServlet {
   
    private Map<String, String> verificationCodes;

    /**
     *
     * @param verificationCodes
     */
    public VerifyController(Map<String, String> verificationCodes) {
        this.verificationCodes = verificationCodes;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String storedCode = verificationCodes.get(email);

        if (storedCode != null && storedCode.equals(code)) {
            req.setAttribute("message", "Xác thực thành công!");
            verificationCodes.remove(email);
        } else {
            req.setAttribute("message", "Mã xác thực không đúng. Vui lòng thử lại.");
        }

        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
