package com.tdd.demo.service;

/*
Task:
Given a list of integers, determine whether the sum of its elements is odd or even.

Give your answer as a string matching "odd" or "even".

If the input array is empty consider it as: [0] (array with a zero).
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArrayMathUtility {

    @Autowired
    EvenOddService evenOddService;

    public ArrayMathUtility(EvenOddService evenOddService) {
        this.evenOddService = evenOddService;
    }

    public String determineArraySumOddEven(int[] inputArray) {

        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
        }
        return (evenOddService.isOddNumber(sum)) ? "odd" : "even";
    }
}


