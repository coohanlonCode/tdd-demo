package com.tdd.demo;

@Service
public class EvenOddService {

    public String isOddNumber(int inputNumber) {

        String primeNumbersString = generatePrimeNumbersString(indexBeginning + numbersToReturn );

        String[] primeStringArray = primeNumbersString.split("");

        StringBuilder primeSubstring = new StringBuilder("");
        for (int i = 0; i < numbersToReturn; i++) {
            primeSubstring.append(primeStringArray[indexBeginning + i]);
        }

        return primeSubstring.toString();
    }

}