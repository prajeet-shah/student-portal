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

        out.println("<html><head>");
        out.println("<title>Student List</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head><body>");

        out.println("<header>");
        out.println("<h1>Student Portal</h1>");
        out.println("<nav>");
        out.println("<a href='index.html'>Home</a>");
        out.println("<a href='students'>Student List</a>");
        out.println("<a href='add-student'>Add Student</a>");
        out.println("</nav></header>");

        out.println("<div class='container'>");
        out.println("<h2>Student List</h2>");

        out.println("<table>");
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
        out.println("</div>");

        out.println("</body></html>");
    }
}
