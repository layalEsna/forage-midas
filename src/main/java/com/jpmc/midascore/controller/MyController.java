package com.jpmc.midascore.controller;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MyController {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private KafkaTemplate<String, UserRecord> kafkaTemplate;

    @Value("${general.kafka-topic}")
    private String topic;

    @PostMapping("/")
    public UserRecord createUser(@RequestBody UserRecord userRecord) {
        
        UserRecord savedUser = userRecordRepository.save(userRecord);
        
        
        kafkaTemplate.send(topic, savedUser);

        return savedUser;
    }

    @GetMapping("/")
    public String home() {
        return "MidasCore API is running!";
    }
}
