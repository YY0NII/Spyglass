package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Models.Goal;
import com.codedifferently.group2.Spyglass.Repos.GoalRepo;
import com.codedifferently.group2.Spyglass.Services.FileStorageService;
import com.codedifferently.group2.Spyglass.Services.GoalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GoalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoalRepo repo;

    @MockBean
    private GoalService goalService;

    @MockBean
    private FileStorageService fileStorageService;

    @Test
    void testCreateGoal() throws Exception {

        // Declare a new goal object
        Goal newGoal = new Goal(1L,"Hiking", "Mountains", 700D, 10D);

        // Use mockMvc to perform a post request with the newGoal as its content
        mockMvc.perform(post("/SpyglassAPI/Goals").content(new ObjectMapper().writeValueAsString(newGoal))
                // Set the content type to JSON
                .contentType(MediaType.APPLICATION_JSON)
                // The post request can only accept JSON content
                .accept(MediaType.APPLICATION_JSON))
                // Expect 201 HTTP response to be returned
                .andExpect(status().isCreated())
                // Also, expect a string to be returned
                .andExpect(content().string("8080/SpyglassAPI/Goal1")).andReturn();
    }

    @Test
    void testGetAllGoals() throws Exception {
        // Declare a new goal list
        List<Goal> goalList = new ArrayList<>();
        goalList.add(new Goal(1L,"Hiking", "Mountains", 700D, 10D));
        goalList.add(new Goal(2L,"Snow Boarding", "Ice", 700D, 10D));

        // Use Mockito to mock the goalService's findAll() method with the goalList returned
        Mockito.when(goalService.findAll()).thenReturn(goalList);

        // Set url template
        String url = "/SpyglassAPI/Goals";

        // Declare a new mvcResult
        // Use mockMvc to perform a get request to url and expect a 200 HTTP response returned
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk()).andReturn();

        // Set the actualJsonResponse to the response content of previously made get request as a string
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        // Set the goalList to a string formatted as JSON
        String expectedJsonResponse = new ObjectMapper().writeValueAsString(goalList);

        // Test the actualJsonResponse and expectedJsonResponse
        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

    }

    @Test
    void testGetGoalById() throws Exception {
        // Declare a new goal object
        Goal newGoal = new Goal(1L,"Hiking", "Mountains", 700D, 10D);

        // Use Mockito to mock the goalService's findById() method with the newGoal returned
        Mockito.when(goalService.findById(1L)).thenReturn(newGoal);

        // Set url template
        String url = "/SpyglassAPI/Goals/1";

        // Declare a new mvcResult
        // Use mockMvc to perform a get request to url and expect a 200 HTTP response returned
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk()).andReturn();

        // Set the actualJsonResponse to the response content of previously made get request as a string
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        // Set the newGoal to a string formatted as JSON
        String expectedJsonResponse = new ObjectMapper().writeValueAsString(newGoal);

        // Test the actualJsonResponse and expectedJsonResponse
        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void testUpdateGoalById() throws Exception {

        // Declare a new goal object
        Goal newGoal = new Goal(1L,"Hiking", "Mountains", 700D, 10D);

        // Use mockMvc to perform a put request with the newGoal as its content
        mockMvc.perform(put("/SpyglassAPI/Goals/1").content(new ObjectMapper().writeValueAsString(newGoal))
                // Set the content type to JSON
                .contentType(MediaType.APPLICATION_JSON)
                // The put request can only accept JSON content
                .accept(MediaType.APPLICATION_JSON))
                // Expect 200 HTTP response to be returned
                .andExpect(content().string("8080/SpyglassAPI/Goals1")).andReturn();
    }

    @Test
    void testDeleteGoalById() throws Exception {

        // Use mockMvc to perform a delete request
        mockMvc.perform( MockMvcRequestBuilders
                .delete("/SpyglassAPI/Goals/1")
                // The delete request can only accept JSON content
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                // Expect 202 HTTP response to be returned
                .andExpect(status().isAccepted());
    }
}
