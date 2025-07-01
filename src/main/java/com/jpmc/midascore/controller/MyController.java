// package com.jpmc.midascore.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class MyController {

//     @GetMapping("/")
//     public String home() {
//         return "MidasCore API is running!";
//     }
// }
package com.jpmc.midascore.controller;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MyController {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @GetMapping("/")
    public String home() {
        return "MidasCore API is running!";
    }

    @PostMapping("/")
    public UserRecord createUser(@RequestBody UserRecord userRecord) {
        return userRecordRepository.save(userRecord);
    }
}
