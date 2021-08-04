package com.codedifferently.group2.Spyglass.Services;

import com.codedifferently.group2.Spyglass.Exceptions.GoalNotFoundException;
import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {
    GoalRepo goalRepo;

    @Autowired
    GoalService(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    public Goal save(Goal goal) {
        goal.setProgress();
        return goalRepo.save(goal);
    }

    public List<Goal> findAll() {
        return goalRepo.findAll();
    }

    public Goal findById(Long id) {
        return goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));
    }

    public void updateGoalById(Long id, Goal updatedGoal) {
        Goal goal = goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));

        //TODO: These will probably mess up if someone enters a Goal with null values
        goal.setName(updatedGoal.getName());
        goal.setDescription(updatedGoal.getDescription());
        goal.setImage(updatedGoal.getImage());
        goal.setTargetAmount(updatedGoal.getTargetAmount());
        goal.setAmountCurrentlySaved(updatedGoal.getAmountCurrentlySaved());
        goal.setTargetDate(updatedGoal.getTargetDate());

        goalRepo.save(goal);
    }

    public void deleteById(Long id) {
        goalRepo.deleteById(id);
    }
}
