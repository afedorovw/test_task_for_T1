package ru.edu.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.edu.config.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest implements TestData {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTest() throws Exception {
        var response = mockMvc.perform(get("/")).andReturn();
        String resultJson = response.getResponse().getContentAsString();
        assertEquals(str, resultJson);
    }

    @Test
    void getInputTest() throws Exception {
        var response = mockMvc.perform(
                get("/str/aabbbc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andReturn();

        String resultJson = response.getResponse().getContentAsString();
        assertEquals(jsonRequest, resultJson);
    }
}