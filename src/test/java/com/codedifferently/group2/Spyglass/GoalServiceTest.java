package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Repos.GoalRepo;
import com.codedifferently.group2.Spyglass.Services.GoalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class GoalServiceTest {

    @MockBean
    private GoalRepo goalRepo;

    @InjectMocks
    private GoalService goalService;

    @Test
    void testSave() {
        // Create a new expected goal object
        Goal expectedGoal = new Goal("Hiking", "Mountains", 700D, 10D);

        // Use Mockito to mock the saving of the previously made object
        // When the goal repository's save() method is ran, the saved goal is expected to be returned.
        Mockito.when(goalRepo.save(expectedGoal)).thenReturn(expectedGoal);

        // Set the actual goal equal to what is saved from goal service
        Goal actualGoal = goalService.save(expectedGoal);
        System.out.println(actualGoal);

        // Test the actual and expected goals
        assertThat(actualGoal).isEqualTo(expectedGoal);
    }

    @Test
    void testFindAll() {
        // Create a new list of expected goals
        List<Goal> expectedList = new ArrayList<>();
        expectedList.add(new Goal(1L,"Hiking", "Mountains", 700D, 10D));
        expectedList.add(new Goal(2L,"Snow Boarding", "Ice", 700D, 10D));

        // Use Mockito to mock the finding of all the goals
        // When the goal repository's findAll() method is ran, the expectedList is expected to be returned.
        Mockito.when(goalRepo.findAll()).thenReturn(expectedList);

        // Set the actualList equal to what will be returned from findAll()
        List<Goal> actualList = goalService.findAll();
        System.out.println(actualList);

        // Test the actual and expected lists
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    void testFindById() {
        // Create a new expected goal object with an id of 1
        Goal expectedGoal = new Goal(1L,"Hiking", "Mountains", 700D, 10D);

        // Use Mockito to mock the saving of the previously made object
        // When the goal repository's findById() method is ran, the saved goal is expected to be returned.
        Mockito.when(goalRepo.findById(1L)).thenReturn(java.util.Optional.of(expectedGoal));

        // Set the actual goal equal to what is found from goal service
        Goal actualGoal = goalService.findById(1L);
        System.out.println(actualGoal);

        // Test the actual and expected goals
        assertThat(actualGoal).isEqualTo(expectedGoal);
    }

    @Test
    void testUpdateGoalById() {
        // Create a new expected goal object with an id of 1
        Goal expectedGoal = new Goal(1L,"Hiking", "Mountains", 700D, 10D);

        // Use Mockito to mock the saving of the previously made object
        // When the goal repository's save() method is ran, the saved goal is expected to be returned.
        Mockito.when(goalRepo.save(expectedGoal)).thenReturn(expectedGoal);

        // Set the actual goal equal to what is updated from goal service
        Goal actualGoal = goalService.updateGoalById(1L, expectedGoal);
        System.out.println(actualGoal);

        // Test the actual and expected goals
        assertThat(actualGoal).isEqualTo(expectedGoal);
    }

}
