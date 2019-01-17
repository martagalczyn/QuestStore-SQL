package com.codecool.Controllers;

public class MainController {

    AdminController adminController;
    ArtifactController artifactController;
    MentorController mentorController;
    QuestController questController;
    StudentController studentController;

    public MainController(AdminController adminController, ArtifactController artifactController, MentorController mentorController,
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
}
