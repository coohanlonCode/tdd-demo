package com.tdd.demo.service;

import org.springframework.stereotype.Service;

@Service
public class EvenOddService {

    public boolean isOddNumber(int inputNumber) {
        return inputNumber%2 == 1;
    }
}