package com.blackngreen.studentportal.servlet;

import com.blackngreen.studentportal.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // HEADER
        out.println("<h1>Student Portal</h1>");
        out.println("<a href='index.html'>Home</a> | ");
        out.println("<a href='add-student'>Add Student</a> | ");
        out.println("<a href='students'>Student List</a><hr/>");

        out.println("<h2>Add Student</h2>");
        out.println("<form method='post'>");
        out.println("Name: <input name='name'/><br/>");
        out.println("Email: <input name='email'/><br/>");
        out.println("Course: <input name='course'/><br/>");
        out.println("<button type='submit'>Add</button>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        if (!name.isEmpty() && !email.isEmpty() && !course.isEmpty()) {
            StudentService.addStudent(name, email, course);
        }

        resp.sendRedirect("students");
    }
}
