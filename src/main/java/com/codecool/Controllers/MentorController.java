package com.codecool.Controllers;

import com.codecool.DAO.MentorDAO;

public class MentorController {

    MentorDAO mentorDAO;

    public MentorController(MentorDAO dao) {
        this.mentorDAO = dao;
    }
}
