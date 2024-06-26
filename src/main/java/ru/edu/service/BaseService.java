package ru.edu.service;

import org.springframework.stereotype.Service;
import ru.edu.exception.MyException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BaseService {

    public Map<Character, Integer> start(String input) throws MyException {
        if (input.matches("[a-zA-Z]+")) return checkString(input);
        else throw new MyException("The input data does not match the parameters");
    }

    Map<Character, Integer> checkString(String input) {

        char[] char_array = input.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char i : char_array) {
            charCountMap.put(i, charCountMap.get(i) == null ? 1 : charCountMap.get(i) + 1);
        }

        return charCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        LinkedHashMap::new,
                        (map1, entry) -> map1.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );
    }
}
