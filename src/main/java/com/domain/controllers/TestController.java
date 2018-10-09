package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.domain.entities.TestEntity;
import com.domain.services.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        TestEntity testEntity = new TestEntity();
        testEntity.setValue("Value");
        testService.save(testEntity);
        return "OK";
    }
}
