package Controller.Login;

import Dal.LoginDBContext;
import Entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            LoginDBContext acc = new LoginDBContext();
            Account account;

            account = acc.checkLogin(username, password);

            if (account == null) {
                response.getWriter().println("login failed!");
            } else {
                String role = account.getRole();
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                session.setAttribute("userRole", role);

                if (null != role) switch (role) {
                    case "mentor" -> response.sendRedirect("ViewCreateCv?id=" + account.getId());
                    case "mentee" -> response.sendRedirect("menteelogedinhomepage.jsp?id=" + account.getId());
                    case "admin" -> response.sendRedirect("adminlogedinhomepage.jsp?id=" + account.getId());                  
                }

                String remember = request.getParameter("remember");
                if (remember != null) {
                    Cookie cuser = new Cookie("username", username);
                    Cookie cpass = new Cookie("password", password);

                    cuser.setMaxAge(3600 * 24 * 7);
                    cpass.setMaxAge(3600 * 24 * 7);

                    response.addCookie(cpass);
                    response.addCookie(cuser);
                }
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
