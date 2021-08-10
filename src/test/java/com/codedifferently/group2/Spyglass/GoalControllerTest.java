package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Controllers.GoalController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GoalController.class)
public class GoalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GoalRepo goalRepo;

    @MockBean
    private GoalService goalService;

    @MockBean
    private FileStorageService fileStorageService;

    @Test
    public void testCreateGoal() throws Exception {
        String url = "/SpyglassAPI/Goals";
        mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString((new Goal("Hiking", "Mountains", 7000D, 50D))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void testGetAllGoals() throws Exception {
        List<Goal> listGoals = new ArrayList<>();
        listGoals.add(new Goal("Hiking", "Mountains", 7000D, 50D));
        listGoals.add(new Goal("Ski Trip", "Snow", 7000D, 5D));

        Mockito.when(goalService.findAll()).thenReturn(listGoals);

        String url= "/SpyglassAPI/Goals";

        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listGoals);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    public void testGetGoalById() throws Exception {
        Goal thisGoal = new Goal("Hiking", "Mountains", 7000D, 50D);

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
