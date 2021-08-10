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

import java.text.ParseException;
import java.util.List;

/**
 * The Goal Controller Class serves to map the end points of our API.
 * <p>
 * The Goal Controller maps endpoints to their functional counterpart on our backend
 */
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

    /**
     * Returns a response entity indicating whether a goal was successfully saved
     * and maps this functionality to the /Goals endpoint for a POST request
     *
     * @param goal goal object created by user
     * @return ResponseEntity
     */
    @PostMapping("/Goals")
    public ResponseEntity<String> createGoal(@RequestBody Goal goal) {
        goalService.save(goal);
        return new ResponseEntity<>("8080/SpyglassAPI/Goal" + goal.getId(), HttpStatus.CREATED);
    }


    /**
     * Returns a list of goals and maps this functionality to the /Goals endpoint
     * for a GET request
     *
     * @return list of Goal objects
     */
    @GetMapping("/Goals")
    public List<Goal> getAllGoals(){
        return goalService.findAll();
    }

    /**
     * Returns a Goal Object associated with a specific id and maps the functionality
     * /Goals/{id} for a GET request
     *
     * @param id the id associated with a Goal
     * @return a Goal object
     */
    @GetMapping("/Goals/{id}")
    public Goal getGoalById(@PathVariable Long id){
        return goalService.findById(id);
    }

    /**
     * Returns a response entity indicating whether a goal was successfully updated
     * and maps this functionality to the /Goals/{id} endpoint for a PUT request
     *
     * @param id
     * @param goal
     * @return
     */
    @PutMapping("/Goals/{id}")
    public ResponseEntity<String> updateGoalById(@PathVariable Long id, @RequestBody Goal goal){
        goalService.updateGoalById(id, goal);
        return new ResponseEntity<>("8080/SpyglassAPI/Goals" + goal.getId(), HttpStatus.ACCEPTED);
    }

    /**
     *
     *
     * @param id
     * @param file
     * @return
     * @throws ParseException
     */
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

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    /**
     * Returns a ResponseEntity that indicates whether a Goal was deleted
     *
     * @param id id associated with a goal
     * @return ResponseEntity
     */
    @DeleteMapping("/Goals/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Long id){
        goalService.deleteById(id);
        return new ResponseEntity<>("8080/SpyglassAPI/Goals" + id, HttpStatus.ACCEPTED);
    }

}
