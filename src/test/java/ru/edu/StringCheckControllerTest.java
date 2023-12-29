package ru.edu;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.edu.controller.BaseController;
import ru.edu.service.BaseService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringCheckControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BaseService service;

    @InjectMocks
    public BaseController controller;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @Order(1)
    public void testGetEmptyInput() throws Exception {
        mockMvc.perform(get("/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("test"));
    }

    @Test
    @Order(2)
    public void testGetInput() throws Exception {
        mockMvc.perform(get("/list/abb")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"a\":1,\"b\":2}"));
//                .andExpect(jsonPath("$.a", is(1)))
//                .andExpect(jsonPath("$.b", is(2)));
    }

    /*@Test
    public void checkTotal() {
        given()
                .when()
                .get("https://localhost:8081/list/a")
                .then()
                .body("a", is(1));
    }*/

    //TODO: add negative test
}
