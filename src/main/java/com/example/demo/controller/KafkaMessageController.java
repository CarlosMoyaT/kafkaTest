package com.example.demo.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@RestController
public class KafkaMessageController {

    private final int MAX_MESSAGES = 100;

    private final List<String> saveMessages = new LinkedList<>();


    public void addMessage(String message) {
        if (saveMessages.size() >= MAX_MESSAGES) {
            saveMessages.remove(0);
        }
        saveMessages.add(message);
    }

    @GetMapping("/messages")
    public List<String> messages() {
        return saveMessages;

    }
}
