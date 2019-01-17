package com.codecool.Models;

public class Quest {

    private int id;
    private String name;
    private int reward;
    private String description;
    private String image;

    public Quest(int id, String name, int reward, String description, String image) {
        this.id = id;
        this.name = name;
        this.reward = reward;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
