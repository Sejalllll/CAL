package com.exam.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String examName = request.getParameter("examName");
        String date = request.getParameter("date");
        String subject = request.getParameter("subject");
        String duration = request.getParameter("duration");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/examdb", "root", "");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO exams (exam_name, exam_date, subject, duration) VALUES (?, ?, ?, ?)");
            ps.setString(1, examName);
            ps.setString(2, date);
            ps.setString(3, subject);
            ps.setInt(4, Integer.parseInt(duration));
            ps.executeUpdate();

            response.sendRedirect("admin-dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
