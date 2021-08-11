package com.codedifferently.group2.Spyglass.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The Goal Class serves as a model for mapping aspects of a user's goal to our database.
 * <p>
 * A Goal as defined in our project has the String values name, description, image, Date values startDate
 * and targetDate, and Double values targetAmount and amountCurrentlySaved.
 */
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

    // Established a one to many relationship with the comments.
    @OneToMany(mappedBy = "goal")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void  setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Getter for the id of a goal
     *
     * @return the id of a goal
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the id of a goal
     *
     * @param id the id of a goal
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the name of a goal
     *
     * @return the name of a goal
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of a goal
     *
     * @param name the name of a goal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the description of a goal
     *
     * @return the description of a goal
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description of a goal
     *
     * @param description the description of a goal
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the image of a goal
     *
     * @return the uri of the image associated with a goal
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for the image of a goal
     *
     * @param image the uri of an image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter for the startDate of a goal
     *
     * @return the start date associated with a goal
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter for the startDate of a goal
     *
     * @param startDate the start date associated with a goal
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for the targetDate of a goal
     *
     * @return the target date associated with a goal
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * Setter for the targetDate of a goal
     *
     * @param targetDate the target date associated with a goal
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * Getter for the targetAmount of a goal
     *
     * @return the target amount associated with a goal
     */
    public Double getTargetAmount() {
        return targetAmount;
    }

    /**
     * Setter for the targetAmount of a goal
     *
     * @param targetAmount the target amount associated with a goal
     */
    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    /**
     * Getter for the currently saved amount
     *
     * @return a double representing the amount currently saved
     */
    public Double getAmountCurrentlySaved() {
        return amountCurrentlySaved;
    }

    /**
     * Setter for the currently saved amount of a goal
     *
     * @param amountCurrentlySaved the currently saved amount stored in a goal
     */
    public void setAmountCurrentlySaved(Double amountCurrentlySaved) {
        this.amountCurrentlySaved = amountCurrentlySaved;
    }

    /**
     * updates the currently saved amount of a goal by adding to it
     *
     * @param amount the desired amount to add to a goal
     */
    public void addToCurrentlySaved(Double amount){
        this.amountCurrentlySaved += amount;
    }

    /**
     * generates a string representation of a goal object
     *
     * @return a String representation of a goal object
     */
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
                ", comments=" + comments +
                '}';
    }
}

