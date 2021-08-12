package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Models.Goal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

@SpringBootTest
public class GoalTest {

    @MockBean
    private Goal goal;

    @Test
    void testGetId() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected ID
        Long expectedId = 1L;
        // Set the actual ID
        thisGoal.setId(1L);
        Long actualId = thisGoal.getId();
        // Test the actual and expected IDs
        assert(actualId).equals(expectedId);
    }

    @Test
    void testSetId() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected ID
        Long expectedId = 2L;
        // Set the actual ID
        thisGoal.setId(2L);
        Long actualId = thisGoal.getId();
        // Test the actual and expected IDs
        assert(actualId).equals(expectedId);
    }

    @Test
    void testGetName() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected name
        String expectedName = "Hiking";
        // Set the actual name
        String actualName = thisGoal.getName();
        // Test the actual and expected names
        assert(actualName).equals(expectedName);
    }

    @Test
    void testSetName() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected name
        String expectedName = "Ski trip";
        // Set the actual name
        thisGoal.setName("Ski trip");
        String actualName = thisGoal.getName();
        // Test the actual and expected names
        assert(actualName).equals(expectedName);
    }

    @Test
    void testGetDescription() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected description
        String expectedDescription = "Mountains";
        // Set the actual description
        String actualDescription = thisGoal.getDescription();
        // Test the actual and expected names
        assert(actualDescription).equals(expectedDescription);
    }

    @Test
    void testSetDescription() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected description
        String expectedDescription = "Ski trip";
        // Set the actual description
        thisGoal.setDescription("Ski trip");
        String actualDescription = thisGoal.getDescription();
        // Test the actual and expected description
        assert(actualDescription).equals(expectedDescription);
    }

    @Test
    void testGetImage() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected image
        String expectedImage = "image.jpg";
        // Set the actual image
        String actualImage = thisGoal.getImage();
        // Test the actual and expected images
        assert(actualImage).equals(expectedImage);
    }

    @Test
    void testSetImage() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected image
        String expectedImage = "newImage.jpg";
        // Set the actual image
        thisGoal.setImage("newImage.jpg");
        String actualImage = thisGoal.getImage();
        // Test the actual and expected images
        assert(actualImage).equals(expectedImage);
    }

    @Test
    void testGetStartDate() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected start date
        Date expectedStartDate = new Date();
        // Set the actual start date
        Date actualStartDate = thisGoal.getStartDate();
        // Test the actual and expected start date
        assert(actualStartDate).equals(expectedStartDate);
    }

    @Test
    void testSetStartDate() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected start date
        Date expectedStartDate = new Date();
        // Set the actual start date
        thisGoal.setStartDate(new Date());
        Date actualStartDate = thisGoal.getStartDate();
        // Test the actual and expected start date
        assert(actualStartDate).equals(expectedStartDate);
    }

    @Test
    void testGetTargetDate() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target date
        Date expectedTargetDate = new Date();
        // Set the actual target date
        Date actualTargetDate = thisGoal.getTargetDate();
        // Test the actual and expected target date
        assert(actualTargetDate).equals(expectedTargetDate);
    }

    @Test
    void testSetTargetDate() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target date
        Date expectedTargetDate = new Date();
        // Set the actual target date
        thisGoal.setTargetDate(new Date());
        Date actualTargetDate = thisGoal.getTargetDate();
        // Test the actual and expected target date
        assert(actualTargetDate).equals(expectedTargetDate);
    }

    @Test
    void testGetTargetAmount() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target amount
        Double expectedTargetAmount =  1200D;
        // Set the actual target amount
        Double actualTargetAmount = thisGoal.getTargetAmount();
        // Test the actual and expected target amount
        assert(actualTargetAmount).equals(expectedTargetAmount);
    }

    @Test
    void testSetTargetAmount() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target amount
        Double expectedTargetAmount =  200D;
        // Set the actual target amount
        thisGoal.setTargetAmount(200D);
        Double actualTargetAmount = thisGoal.getTargetAmount();
        // Test the actual and expected target amount
        assert(actualTargetAmount).equals(expectedTargetAmount);
    }

    @Test
    void testGetAmountCurrentlySaved() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target amount
        Double expectedAmountCurrentlySaved =  60D;
        // Set the actual target amount
        Double actualAmountCurrentlySaved = thisGoal.getAmountCurrentlySaved();
        // Test the actual and expected target amount
        assert(actualAmountCurrentlySaved.equals(expectedAmountCurrentlySaved));
    }

    @Test
    void testSetAmountCurrentlySaved() {
        // Declare a new goal object
        Goal thisGoal = new Goal("Hiking", "Mountains", "image.jpg", new Date(), new Date(), 1200D, 60D);
        // Set the expected target amount
        Double expectedAmountCurrentlySaved =  600D;
        // Set the actual target amount
        thisGoal.setAmountCurrentlySaved(600D);
        Double actualAmountCurrentlySaved= thisGoal.getAmountCurrentlySaved();
        // Test the actual and expected target amount
        assert(actualAmountCurrentlySaved).equals(expectedAmountCurrentlySaved);
    }
}
