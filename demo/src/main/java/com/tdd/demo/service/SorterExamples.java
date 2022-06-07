package com.tdd.demo.service;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

@Component
public class SorterExamples {

    public int getLargestNumber1(int[] numbersArray) {
        Arrays.sort(numbersArray);
        return numbersArray[numbersArray.length - 1];
    }

    public int[] sortSmallestToLargest(int[] numbersArray) {
        Arrays.sort(numbersArray);
        return numbersArray;
    }

    public Integer[] sortLargestToSmallest(Integer[] numbersWrapperArray) {
        Comparator<Integer> howToSort = Collections.reverseOrder();
        Arrays.sort(numbersWrapperArray, Collections.reverseOrder());
        return numbersWrapperArray;
    }

    public List<String> sortNamesVowelsFirst(List<String> inputList) {
        Collections.sort(inputList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String vowelRegex = "^[aeiouAEIOU]\\D+";

                boolean bothStartWithVowels = o1.matches(vowelRegex) && o2.matches(vowelRegex);
                if (bothStartWithVowels) {
                    return o1.compareToIgnoreCase(o2); // both start with vowels, compare directly
                }  else{

                    if(o1.matches(vowelRegex) && !o2.matches(vowelRegex)){
                        return -1; // o1 definitely comes before o2
                    }else if(!o1.matches(vowelRegex) && o2.matches(vowelRegex)){
                        return 1; // o1 definitel comes AFTER o2
                    }else{
                        return o1.compareToIgnoreCase(o2); // both do notstart with vowels, compare directly
                    }
                }
            }
        });
        return inputList;
    }
}
