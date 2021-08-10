package com.codedifferently.group2.Spyglass.Controllers;


import com.codedifferently.group2.Spyglass.Models.Comment;
import com.codedifferently.group2.Spyglass.Services.CommentService;
import com.codedifferently.group2.Spyglass.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    GoalService goalService;

    @CrossOrigin
    @PostMapping("")
    public List<Comment> getAllComments() {
        return commentService.findAllComments();
    }

    @CrossOrigin
    @PostMapping("/{id}")
    public ResponseEntity<String> addComment(@PathVariable Long id, @RequestBody Comment comment) throws URISyntaxException {
        commentService.saveComment(id, comment);
        return new ResponseEntity<>("/comment/" + comment.getId(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeComment(@PathVariable Long id, @RequestBody Comment comment) throws URISyntaxException {
        commentService.deleteComment(id, comment);
        return new ResponseEntity<>("/comment/" + comment.getId(), HttpStatus.ACCEPTED);
    }


}
