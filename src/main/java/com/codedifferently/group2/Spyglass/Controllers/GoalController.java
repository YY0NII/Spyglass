package com.codedifferently.group2.Spyglass.Controllers;

import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SpyglassAPI")
public class GoalController {
    GoalService goalService;

    @Autowired
    GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @PostMapping("/Goals")
    public ResponseEntity<String> createGoal(@RequestBody Goal goal){
        goalService.save(goal);
        return new ResponseEntity<>("8080/SpyglassAPI/Goal" + goal.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/Goals")
    public List<Goal> getAllGoals(){
        return goalService.findAll();
    }

    @GetMapping("/Goals/{id}")
    public Goal getGoalById(@PathVariable Long id){
        return goalService.findById(id);
    }

    @PutMapping("/Goals/{id}")
    public ResponseEntity<String> updateGoalById(@PathVariable Long id, @RequestBody Goal goal){
        goalService.updateGoalById(id, goal);
        return new ResponseEntity<>("8080/SpyglassAPI/Goals" + goal.getId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Goals/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Long id){
        goalService.deleteById(id);
        return new ResponseEntity<>("8080/SpyglassAPI/Goals" + id, HttpStatus.ACCEPTED);
    }

}
