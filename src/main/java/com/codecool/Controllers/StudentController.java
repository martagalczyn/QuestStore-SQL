package com.codecool.Controllers;

import com.codecool.DAO.StudentDAO;

public class StudentController {

    StudentDAO studentDAO;

    public StudentController(StudentDAO dao) {
        this.studentDAO = dao;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }
}
