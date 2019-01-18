package com.codecool.DAO;

import com.codecool.Models.Student;
import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    void insertStudent(Student student);

    void removeStudent(int id);
}
