package ru.edu.service;

import org.springframework.stereotype.Service;
import ru.edu.exception.MyException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BaseService {

    public Map<Character, Integer> start(String input) throws MyException {
        if (input.matches("[a-zA-Z]+")) {
            return checkString(input);
        } else throw new MyException("The input data does not match the parameters");
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public Map<Character, Integer> checkString(String input) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (charCountMap.containsKey(c)) {
                int count = charCountMap.get(c);
                charCountMap.put(c, count + 1);
            } else charCountMap.put(c, 1);
        }

        return charCountMap;

        /*return charCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        LinkedHashMap::new,
                        (map1, entry) -> map1.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );*/
    }
}
