package com.blackngreen.studentportal.servlet;

import com.blackngreen.studentportal.controller.Student;
import com.blackngreen.studentportal.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // HEADER
        out.println("<h1>Student Portal</h1>");
        out.println("<a href='index.html'>Home</a> | ");
        out.println("<a href='add-student'>Add Student</a> | ");
        out.println("<a href='students'>Student List</a><hr/>");

        out.println("<h2>Student List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>");

        for (Student s : StudentService.getAllStudents()) {
            out.println("<tr>");
            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getEmail() + "</td>");
            out.println("<td>" + s.getCourse() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }
}
