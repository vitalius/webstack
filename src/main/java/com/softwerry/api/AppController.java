package com.softwerry.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db")
public class AppController {

    @GetMapping("hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("build")
    public ResponseEntity<String> rebuildSchema() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
