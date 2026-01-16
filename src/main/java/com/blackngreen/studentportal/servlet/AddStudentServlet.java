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

        out.println("<html><head>");
        out.println("<title>Add Student</title>");
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
        out.println("<h2>Add Student</h2>");

        out.println("<form method='post'>");
        out.println("<label>Name</label>");
        out.println("<input name='name' required>");

        out.println("<label>Email</label>");
        out.println("<input name='email' required>");

        out.println("<label>Course</label>");
        out.println("<input name='course' required>");

        out.println("<button type='submit'>Add Student</button>");
        out.println("</form>");
        out.println("</div>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        StudentService.addStudent(
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("course")
        );

        resp.sendRedirect("students");
    }
}
