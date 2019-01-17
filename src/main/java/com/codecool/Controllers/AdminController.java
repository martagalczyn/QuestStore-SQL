package com.codecool.Controllers;

import com.codecool.DAO.AdminDAO;

public class AdminController {

    AdminDAO adminDAO;

    public AdminController(AdminDAO dao) {
        this.adminDAO = dao;
    }
}
