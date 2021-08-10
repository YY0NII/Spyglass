package com.codedifferently.group2.Spyglass.Services;

import com.codedifferently.group2.Spyglass.Exceptions.GoalNotFoundException;
import com.codedifferently.group2.Spyglass.Models.Comment;
import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Repos.CommentRepository;
import com.codedifferently.group2.Spyglass.Repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    GoalRepo goalRepo;

    public void saveComment(Long goalId, Comment comment) {



            Goal findGoal = goalRepo.findById(goalId).orElseThrow(() -> new GoalNotFoundException(goalId));


            // set comment for the goal.
            comment.setGoal(findGoal);

            // update the comment count
//        thisGoal.setCommentCount(thisGoal.getCommentCount() + 1);

            // Add thr comment
            findGoal.getComments().add(comment);

            // saving the changes
            goalRepo.save(findGoal);
            commentRepository.save(comment);

            // delete the comment
            findGoal.getComments().remove(comment);
        }


        public List<Comment> findAllComments () {
            return commentRepository.findAll();
        }

    public void deleteComment(Long id, Comment comment) {
    }
}





