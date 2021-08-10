package com.codedifferently.group2.Spyglass.Repos;

import com.codedifferently.group2.Spyglass.Models.Comment;
import com.codedifferently.group2.Spyglass.Models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;


@Repository
    public interface CommentRepository extends JpaRepository<Comment, Long>{

}

