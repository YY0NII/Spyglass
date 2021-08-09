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

@Service
public class GoalService {
    GoalRepo goalRepo;

    @Autowired
    GoalService(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    public Goal save(Goal goal) throws ParseException {

        // Set the progress for each goal
        if ((goal.getAmountCurrentlySaved() != null) && (goal.getTargetAmount() != null)) {
            goal.setProgress();
        }

        return goalRepo.save(goal);
    }

    public List<Goal> findAll() {
        return goalRepo.findAll();
    }

    public Goal findById(Long id) {
        return goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));
    }

    public void updateGoalById(Long id, Goal updatedGoal) {
        /*Goal goal = goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));

        //TODO: These will probably mess up if someone enters a Goal with null values
        if (updatedGoal.getName() != null) {
            goal.setName(updatedGoal.getName());
        }
        if (updatedGoal.getDescription() != null) {
            goal.setDescription(updatedGoal.getDescription());
        }

        if (updatedGoal.getTargetAmount() != null) {
            goal.setTargetAmount(updatedGoal.getTargetAmount());
        }

        if (updatedGoal.getAmountCurrentlySaved() != null) {
            goal.setAmountCurrentlySaved(updatedGoal.getAmountCurrentlySaved());
        }

        if (updatedGoal.getStartDate() != null) {
            goal.setStartDate(updatedGoal.getStartDate());
        }

        if (updatedGoal.getTargetDate() != null) {
            goal.setTargetDate(updatedGoal.getTargetDate());
        }*/


        // Set the progress for each goal
        updatedGoal.setProgress();

        goalRepo.save(updatedGoal);
    }

    public void deleteById(Long id) {
        goalRepo.deleteById(id);
    }
}
