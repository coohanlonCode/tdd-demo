package com.tdd.demo.service;

import com.tdd.demo.service.ArrayMathUtility;
import com.tdd.demo.service.EvenOddService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

class ArrayMathUtilityTest {

    @Spy
    @InjectMocks
    ArrayMathUtility arrayUtilitySpringService;

    @Mock
    EvenOddService evenOddService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHealthCheck() {
        Assert.assertTrue(true);

        Assert.assertNotNull(arrayUtilitySpringService);
        Assert.assertNotNull(evenOddService);
    }

    @DisplayName("Given determineArraySumOddEven")
    @Nested
    class GivenDetermineArraySumOddEven {

        @DisplayName("When the array sums up to odd number")
        @Nested
        class WhenTheArraySumsUpToOddNumber {

            @DisplayName("Then return 'odd'")
            @Test
            void thenReturnOdd() {

                Mockito.doReturn(true).when(evenOddService).isOddNumber(anyInt());

                int[] inputArray = new int[]{1, 2};

                String actual = arrayUtilitySpringService.determineArraySumOddEven(inputArray);

                verify(evenOddService).isOddNumber(3); // 'verify' needs to go after actual exe

                boolean matchesAsExpected = actual.equalsIgnoreCase("odd");

                Assert.assertTrue(matchesAsExpected);
            }
        }

        @DisplayName("When the array sums up to even number")
        @Nested
        class WhenTheArraySumsUpToEvenNumber {
            @DisplayName("Then return 'even'")
            @Test
            void thenReturnEven() {

                Mockito.doReturn(false).when(evenOddService).isOddNumber(anyInt());

                String actual = arrayUtilitySpringService.determineArraySumOddEven(new int[]{1, 9});
                verify(evenOddService).isOddNumber(10);

                Assert.assertTrue(actual.equalsIgnoreCase("even"));
            }
        }

        @DisplayName("When the array is empy and has nothing to sum")
        @Nested
        class WhenTheArrayIsEmpyAndHasNothingToSum{


            @DisplayName("Then return even")
            @Test
            void thenReturnEven(){

                Mockito.doReturn(false).when(evenOddService).isOddNumber(anyInt());
                String actual = arrayUtilitySpringService.determineArraySumOddEven(new int[]{});
                Assert.assertTrue(actual.equalsIgnoreCase("even"));

            }
        }
    }

//    @DisplayName("Given this methodXYZ")
//    @Nested
//    class GivenThisMethodXYZ {
//
//        @DisplayName("When given these paramters")
//        @Nested
//        class WhenGivenTheseParamters {
//
//            @DisplayName("Then expect this")
//            @Test
//            public void thenExpectThis() {
//
//                boolean isExpected = myServiceABC.methodXYZ(43);
//                Assert.assertTrue(isExpected);
//            }
//
//        }
//    }
}