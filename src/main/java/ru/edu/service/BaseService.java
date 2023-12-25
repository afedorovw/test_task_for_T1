package ru.edu.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BaseService {

    public Map<Character, Integer> start(String input) {
        if (isAlpha(input)) return checkString(input);
        else return null;
    }

    //TODO: add exception

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

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
        }
        return charCountMap;
    }
}
