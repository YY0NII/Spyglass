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
        return goalRepo.save(goal);
    }


    public List<Goal> findAll() {
        return goalRepo.findAll();
    }

    public Goal findById(Long id) {
        return goalRepo.findById(id).orElseThrow(()-> new GoalNotFoundException(id));
    }

    public void updateGoalById(Long id, Goal updatedGoal) {
        goalRepo.save(updatedGoal);
    }

    public void deleteById(Long id) {
        goalRepo.deleteById(id);
    }
}
