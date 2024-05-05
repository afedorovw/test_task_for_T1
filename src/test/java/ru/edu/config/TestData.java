package ru.edu.config;

import java.util.HashMap;
import java.util.Map;

public interface TestData {

    String mess = "The input data does not match the parameters";
    String input = "abbbcc";
    Map<Character, Integer> expectedResult = new HashMap<>(Map.of('a',1, 'b',3,'c',2));

    String jsonRequest = "{\"c\":1,\"a\":2,\"b\":3}";
    String str = "test";
}
