package com.codecool;

import com.codecool.Controllers.*;
import com.codecool.DAO.*;

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

        MainController mainController = new MainController(adminController, artifactController, mentorController,
                questController,studentController);

        mainController.sayHello();
    }
}
