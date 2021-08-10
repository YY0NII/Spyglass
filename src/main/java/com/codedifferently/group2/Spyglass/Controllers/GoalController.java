package com.codedifferently.group2.Spyglass.Controllers;

import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Payload.UploadFileResponse;
import com.codedifferently.group2.Spyglass.Services.FileStorageService;
import com.codedifferently.group2.Spyglass.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.stream.events.Comment;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/SpyglassAPI")
public class GoalController {
    GoalService goalService;

    @Autowired
    GoalController(GoalService goalService){
        this.goalService = goalService;
    }





    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/Goals")
    public ResponseEntity<String> createGoal(@RequestBody Goal goal) throws ParseException {
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


    @PostMapping(value = "/Goals/newImage/{id}")
    public UploadFileResponse uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws ParseException {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        Goal goal = getGoalById(id);
        goal.setImage(fileDownloadUri);
        goalService.save(goal);
        System.out.println(fileDownloadUri);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @DeleteMapping("/Goals/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Long id){
        goalService.deleteById(id);
        return new ResponseEntity<>("8080/SpyglassAPI/Goals" + id, HttpStatus.ACCEPTED);
    }


}
