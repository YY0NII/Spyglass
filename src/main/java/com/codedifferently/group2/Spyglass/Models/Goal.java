package com.codedifferently.group2.Spyglass.Models;

import java.util.Date;

public class Goal {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Date targetDate;
    private Double targetAmount;
    private Double amountCurrentlySaved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Double getAmountCurrentlySaved() {
        return amountCurrentlySaved;
    }

    public void setAmountCurrentlySaved(Double amountCurrentlySaved) {
        this.amountCurrentlySaved = amountCurrentlySaved;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", targetDate=" + targetDate +
                ", targetAmount=" + targetAmount +
                ", amountCurrentlySaved=" + amountCurrentlySaved +
                '}';
    }
}
