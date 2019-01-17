package com.codecool.Controllers;

import com.codecool.DAO.QuestDAO;

public class QuestController {

    QuestDAO questDAO;

    public QuestController(QuestDAO dao) {
        this.questDAO = dao;
    }
}
