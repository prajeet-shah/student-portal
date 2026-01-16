package com.blackngreen.studentportal.service;

import com.blackngreen.studentportal.controller.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static final List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public static List<Student> getAllStudents() {
        return students;
    }

    public static void addStudent(String name, String email, String course) {
        Student student = new Student(idCounter++, name, email, course);
        students.add(student);
    }
}
