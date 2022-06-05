package com.tdd.demo.controller;

import com.tdd.demo.model.request.UserInfoRequest;
import com.tdd.demo.model.response.UserMembershipDetails;
import com.tdd.demo.service.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInfoController {

    @Autowired
    private UserUtilities userUtilities;

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<UserMembershipDetails> doTheThing(@RequestBody UserInfoRequest request) {
        UserMembershipDetails myResponse = userUtilities.getMemberLoyaltyInfo(request.getUserId());

       return new ResponseEntity<>(myResponse, HttpStatus.OK);
    }

}
