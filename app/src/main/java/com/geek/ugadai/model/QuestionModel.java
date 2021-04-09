package com.geek.ugadai.model;

import java.io.Serializable;

public class QuestionModel implements Serializable {
    String currentLevel,firstImage,secondImage,thirdImage,fourthImage;

    public QuestionModel(String currentLevel, String firstImage, String secondImage, String thirdImage, String fourthImage) {
        this.currentLevel = currentLevel;
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourthImage = fourthImage;
    }

    public QuestionModel() {}

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public String getFourthImage() {
        return fourthImage;
    }
}
