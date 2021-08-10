package com.codedifferently.group2.Spyglass.Models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    private Date startDate;
    private Date targetDate;
    private Double targetAmount;
    private Double amountCurrentlySaved;
    private Double progress;

    // Established a one to many relationship with the comments.
    @OneToMany(mappedBy = "goal")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void  setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public void addToCurrentlySaved(Double amount){
        this.amountCurrentlySaved += amount;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress() {
        this.progress = this.targetAmount - this.amountCurrentlySaved;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", startDate=" + startDate +
                ", targetDate=" + targetDate +
                ", targetAmount=" + targetAmount +
                ", amountCurrentlySaved=" + amountCurrentlySaved +
                ", progress=" + progress +
                ", comments=" + comments +
                '}';
    }
}
