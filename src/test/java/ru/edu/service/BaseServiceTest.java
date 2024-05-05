package ru.edu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.edu.config.TestData;
import ru.edu.exception.MyException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BaseServiceTest implements TestData {

    @InjectMocks
    private BaseService baseService;

    @Test
    void start() {
        var thrown = Assertions
                .assertThrows(MyException.class, () -> {
                    baseService.start("1");
                }, mess);

        Assertions.assertEquals(mess, thrown.getMessage());
    }

    @Test
    void checkString() {
        Map<Character, Integer> actualMap = baseService.checkString(input);
        assertEquals(expectedResult, actualMap);
    }
}