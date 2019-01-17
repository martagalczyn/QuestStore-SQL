package com.codecool.Controllers;

import com.codecool.DAO.ArtifactDAO;

public class ArtifactController {

    ArtifactDAO artifactDAO;

    public ArtifactController(ArtifactDAO dao) {
        this.artifactDAO = dao;
    }
}
