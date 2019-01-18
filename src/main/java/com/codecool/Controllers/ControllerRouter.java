package com.codecool.Controllers;

import com.codecool.Models.Student;

public class ControllerRouter {

    private AdminController adminController;
    private ArtifactController artifactController;
    private MentorController mentorController;
    private QuestController questController;
    private StudentController studentController;

    public ControllerRouter(AdminController adminController, ArtifactController artifactController, MentorController mentorController,
                            QuestController questController, StudentController studentController ) {

        this.adminController = adminController;
        this.artifactController = artifactController;
        this.mentorController = mentorController;
        this.questController = questController;
        this.studentController = studentController;
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

    public void insertStudent(Student student) {
        studentController.getStudentDAO().insertStudent(student);
    }

    public void removeStudent(int id) {
        studentController.getStudentDAO().removeStudent(id);
    }
}
