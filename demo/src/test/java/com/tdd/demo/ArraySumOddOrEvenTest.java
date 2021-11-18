package com.tdd.demo;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ArraySumOddOrEvenTest {

    @Test
    public void testHealthCheck() {
        Assert.assertTrue(true);
        ArraySumOddOrEven actualObject = new ArraySumOddOrEven();
        Assert.assertNotNull(actualObject);
    }

    @DisplayName("Given determineArraySumOddEven")
    @Nested
    class GivenDetermineArraySumOddEven {

        @DisplayName("When Array is Empty")
        @Nested
        class WhenArrayIsEmpty {

            @DisplayName("Then return 'even'")
            @Test
            public void thenReturnEven() {

                ArraySumOddOrEven myClass = new ArraySumOddOrEven();

                int[] emptyIntArray = new int[]{};
                String actualText = myClass.determineArraySumOddEven(emptyIntArray).trim();

                final String expectedText = "even";
                Assert.assertEquals(expectedText, actualText.toLowerCase());

            }
        }

        @DisplayName("When array adds up to sum that is odd")
        @Nested
        class WhenArrayAddsUpToSumThatIsOdd {

            @DisplayName("Then return 'odd'")
            @Test
            public void thenReturnOdd() throws Exception {

                ArraySumOddOrEven myClass = new ArraySumOddOrEven();

                final String expectedText = "odd";

                int[] arrayAddsUpToOdd = new int[]{1, 2};
                String actualText = myClass.determineArraySumOddEven(arrayAddsUpToOdd).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToOdd = new int[]{1, 2, 3, 1};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToOdd).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToOdd = new int[]{100, 250, 3, 4};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToOdd).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToOdd = new int[]{-1, -3, 4, -2, -1};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToOdd).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());
            }
        }

        @DisplayName("When array adds up to sum that is even")
        @Nested
        class WhenArrayAddsUpToSumThatIsEven {

            @DisplayName("Then return 'even'")
            @Test
            public void thenReturnEven() throws Exception {

                ArraySumOddOrEven myClass = new ArraySumOddOrEven();

                final String expectedText = "even";

                int[] arrayAddsUpToEven = new int[]{4, 2};
                String actualText = myClass.determineArraySumOddEven(arrayAddsUpToEven).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToEven = new int[]{1, 2, 3, 1, 3, 6, 8, 9, 9};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToEven).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToEven = new int[]{570, 251, 3, 4};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToEven).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());

                arrayAddsUpToEven = new int[]{-10, -3, 4, -2, -7};
                actualText = myClass.determineArraySumOddEven(arrayAddsUpToEven).trim();
                Assert.assertEquals(expectedText.toLowerCase(), actualText.toLowerCase());
            }
        }
    }
}