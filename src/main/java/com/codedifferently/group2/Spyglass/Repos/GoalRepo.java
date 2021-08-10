package com.codedifferently.group2.Spyglass.Repos;

import com.codedifferently.group2.Spyglass.Models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * GoalRepo serves as the bridge between or backend and the database we're using
 */
@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
}
