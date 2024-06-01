/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.mentor;

import Entity.Mentor;
import Controller.Skill.ListSkillController;
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

/**
 *
 * @author MSI
 */
public class ListSkillOfCreateMentor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SkillDBContext skillDB = new SkillDBContext();

        ArrayList<Skill> skills;
        try {
            skills = skillDB.list();
        } catch (SQLException e) {
            throw new ServletException("Database error while listing skills", e);
        }

        request.setAttribute("skills", skills);
        request.getRequestDispatcher("/mentor/CreateCvMentor.jsp").forward(request, response);
    }

}
