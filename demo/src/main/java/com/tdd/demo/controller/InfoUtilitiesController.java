package com.tdd.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "infoUtilities", produces = MediaType.APPLICATION_JSON_VALUE)
public class InfoUtilitiesController {

    @RequestMapping(value = "/testString", method = RequestMethod.GET)
    public String getTestString() {
        return "my_Test_String";
    }

    @GetMapping("/testSentence")
    public String getTestSentence() {
        return "Test String from the Java";
    }
}
