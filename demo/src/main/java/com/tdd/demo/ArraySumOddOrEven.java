package com.tdd.demo;

/*
Task:
Given a list of integers, determine whether the sum of its elements is odd or even.

Give your answer as a string matching "odd" or "even".

If the input array is empty consider it as: [0] (array with a zero).
*/

public class ArraySumOddOrEven {


    public String determineArraySumOddEven(int[] inputArray)   {

        int sum = 0;
        for (int i = 0; i < inputArray.length; i++)
            sum += inputArray[i];

        return (sum % 2 == 0) ? "even" : "odd";
    }
}


