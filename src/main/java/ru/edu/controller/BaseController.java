package ru.edu.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.config.Log;
import ru.edu.exception.MyException;
import ru.edu.service.BaseService;

import java.util.Map;

@RestController
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<String> getTest (){
        Log.controllerLog.info("Start getTest");
        return ResponseEntity.ok().body("test");
    }

    @GetMapping(value = "/list/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Character, Integer>> getInputTest (@PathVariable("input") String str) {
        Log.controllerLog.info("Start getInputTest, input: {}", str);
        return ResponseEntity.ok().body(service.start(str));
    }
}
