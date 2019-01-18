package com.codecool;

import com.codecool.Controllers.*;
import com.codecool.DAO.*;
import com.codecool.Models.Student;

public class App {

    public static void main(String[] args) {

        AdminDAO adminDAO = new AdminPostgres();
        ArtifactDAO artifactDAO = new ArtifactPostgres();
        MentorDAO mentorDAO = new MentorPostgres();
        QuestDAO questDAO = new QuestPostgres();
        StudentDAO studentDAO = new StudentPostgres();

        AdminController adminController = new AdminController(adminDAO);
        ArtifactController artifactController = new ArtifactController(artifactDAO);
        MentorController mentorController = new MentorController(mentorDAO);
        QuestController questController = new QuestController(questDAO);
        StudentController studentController = new StudentController(studentDAO);

        ControllerRouter mainController = new ControllerRouter(
                adminController,
                artifactController,
                mentorController,
                questController,
                studentController
        );

        Student testStudent = new Student(1, "Stanislaw", "Wyrobek", "st.wyrobek@gmail.com", "600252436", "Kraków", 10);

        mainController.sayHello();
//        mainController.insertStudent(testStudent);
        mainController.removeStudent(5);
    }
}
