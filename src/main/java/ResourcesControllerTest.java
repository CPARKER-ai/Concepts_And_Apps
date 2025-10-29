// ResourcesTestController Code
package org.concepts3060.pa03project.controller;

import org.concepts3060.pa03project.DTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ResourcesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 1️⃣ Test list endpoint: GET /api/resources
    @Test
    public void testGetAllResources() throws Exception {
        mockMvc.perform(get("/api/resources")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // Expect at least 5 resources (seeded in InMemoryResourceStore)
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(5))));
    }

    // 2️⃣ Test detail endpoint: GET /api/resources/{id}
    @Test
    public void testGetResourceById() throws Exception {
        mockMvc.perform(get("/api/resources/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name", containsStringIgnoringCase("java")));
    }
