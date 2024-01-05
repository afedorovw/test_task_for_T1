package ru.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.edu.controller.BaseController;
import ru.edu.exception.MyException;
import ru.edu.service.BaseService;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StringCheckControllerTest {

    @Mock
    private BaseService service;

    @InjectMocks
    private BaseController controller;

    private final TestData data;

    public StringCheckControllerTest(TestData data) {
        this.data = data;
    }

    @Test
    @Order(1)
    @DisplayName("Тест пустого контроллера")
    public void testGet() {
        ResponseEntity<String> response = controller.getTest();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test", response.getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Тест контроллера с вводом")
    public void testGetInput() throws MyException {
        when(service.start(data.str)).thenReturn(data.map);
        ResponseEntity<Map<Character, Integer>> response = controller.getInputTest(data.str);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(data.map, response.getBody());
    }
}
