package com.codedifferently.group2.Spyglass.Services;

import com.codedifferently.group2.Spyglass.Exceptions.GoalNotFoundException;
import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The GoalService Class serves as a middle man between our repo and our controller
 * <p>
 * The GoalService handles contacting the repo on behalf of our controller to save, find, delete and update Goals.
 */
@Service
public class GoalService {
    GoalRepo goalRepo;

    @Autowired
    GoalService(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    /**
     * Calls the save method of goalRepo to save a goal
     *
     * @param goal goal object created by a user
     */
    public void save(Goal goal) {
        goalRepo.save(goal);
    }


    /**
     * returns a list of Goal objects by calling the findAll method on goalRepo
     *
     * @return a list of Goal Objects representing the users tracked goals
     */
    public List<Goal> findAll() {
        return goalRepo.findAll();
    }

    /**
     * returns a specified Goal object via its id and a call to goalRepos findbyid method
     *
     * @param id the id associate with a specific Goal obj
     * @return the Goal object associated with the passed in id
     */
    public Goal findById(Long id) {
        return goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));
    }

    /**
     * Saves an updated version of a specified goal to the repo
     *
     * @param id id of a specified Goal
     * @param updatedGoal a goal object that represents the updated version of a specific goal
     */
    public void updateGoalById(Long id, Goal updatedGoal) {
        goalRepo.save(updatedGoal);
    }

    /**
     * Deletes a Goal specified by an id
     *
     * @param id id associate with a Goal Obj
     */
    public void deleteById(Long id) {
        goalRepo.deleteById(id);
    }
}
