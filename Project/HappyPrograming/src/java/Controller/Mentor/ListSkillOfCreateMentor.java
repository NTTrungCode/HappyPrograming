/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Mentor;

import Controller.Skill.ListSkillController;
import Dal.MentorDBContext;
import Dal.SkillDBContext;
import Entity.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListSkillOfCreateMentor extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ListSkillController.class.getName());
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");    
        SkillDBContext skillDB = new SkillDBContext();
        
        ArrayList<Skill> skills;       
        try {
            skills = skillDB.list();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error while listing skills", e);
            throw new ServletException("Database error while listing skills", e);
        }
       
        request.setAttribute("skills", skills);
        request.getRequestDispatcher("/Mentor/CreateCvMentor.jsp").forward(request, response);
        
    } 

}
