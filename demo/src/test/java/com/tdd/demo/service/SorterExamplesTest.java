package com.tdd.demo.service;

import com.tdd.demo.model.response.UserMembershipDetails;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;


class SorterExamplesTest {

    @InjectMocks
    SorterExamples sorterExamples;

    List<UserMembershipDetails> userMemberships = Arrays.asList(
            new UserMembershipDetails("Ollie", "0117", true),
            new UserMembershipDetails("Winston", "0821", true),
            new UserMembershipDetails("Tony", "1012", false));

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void healthCheck() {
        Assertions.assertTrue(true);
        Assertions.assertNotNull(sorterExamples);
    }

    @DisplayName("Given getLargestNumber1")
    @Nested
    class GivenGetLargestNumber1 {

        @DisplayName("When provided with an array of ints")
        @Nested
        class WhenProvidedWithAnArrayOfInts {

            @DisplayName("Then return the largest number in the array")
            @Test
            void thenReturnTheLargestNumberInTheArray() {

                int[] numbersArray = new int[]{1, 4, 6, 12, 44, 5, 264, 10, 56, 43, 32, 104, 64};
                int expectedLargestInteger = 264;

                int actual = sorterExamples.getLargestNumber1(numbersArray);
                Assertions.assertTrue(actual == expectedLargestInteger);

                numbersArray = new int[]{1, 4, 676, 12, 44, 5, 264, 10, 56, 43, 32, 104, 64};
                actual = sorterExamples.getLargestNumber1(numbersArray);
                expectedLargestInteger = 676;
                Assertions.assertTrue(actual == expectedLargestInteger);
            }
        }
    }

    @DisplayName("Given sortSmallestToLargest")
    @Nested
    class GivenSortSmallestToLargest {

        @DisplayName("When provided with an array of ints")
        @Nested
        class WhenProvidedWithAnArrayOfInts {

            @DisplayName("Then return the largest number in the array")
            @Test
            void thenReturnTheLargestNumberInTheArray() {

                int[] unsortedArray = new int[]{1, 4, 6, 12, 44, 5, 264, 10, 56, 43, 32, 104, 64};

                int[] actualArray = sorterExamples.sortSmallestToLargest(unsortedArray);

                for (int i = 0; i < unsortedArray.length; i++) {

                    if (i == (unsortedArray.length - 1)) break;

                    Assertions.assertTrue(actualArray[i] <= actualArray[i + 1]);
                }
            }
        }
    }

    @DisplayName("Given sortLargestToSmallest")
    @Nested
    class GivenSortLargestToSmallest {

        @DisplayName("When provided with an array of ints")
        @Nested
        class WhenProvidedWithAnArrayOfInts {

            @DisplayName("Then return the largest number in the array")
            @Test
            void thenReturnTheLargestNumberInTheArray() {

                Integer[] unsortedArray = new Integer[]{1, 4, 6, 12, 44, 5, 264, 10, 56, 43, 32, 104, 64};

                Integer[] actualArray = sorterExamples.sortLargestToSmallest(unsortedArray);

                for (int i = 0; i < unsortedArray.length; i++) {

                    if (i == (unsortedArray.length - 1)) break;

                    Assertions.assertTrue(actualArray[i] >= actualArray[i + 1]);
                }
            }
        }
    }

    @DisplayName("Given sortNamesVowelsFirst")
    @Nested
    class GivenSortNamesVowelsFirst {

        @DisplayName("When provided with a list of names")
        @Nested
        class WhenProvidedWithAListOfNames {

            @DisplayName("Then return the expected array")
            @Test
            void thenReturnTheExpectedArray() {

                List<String> inputList = Arrays.asList("Al", "Carl", "Joe", "Bob", "Ollie", "Zeke", "Aaron");
                List<String> expectedList = Arrays.asList(
                        "Aaron",
                        "Al",
                        "Ollie",
                        "Bob",
                        "Carl",
                        "Joe",
                        "Zeke"
                );

                List<String> actualList = sorterExamples.sortNamesVowelsFirst(inputList);

                Assertions.assertNotNull(actualList);
                Assertions.assertTrue(!actualList.isEmpty());
                Assertions.assertTrue(actualList.size() == expectedList.size());
                Assertions.assertEquals(expectedList , actualList);
            }
        }
    }
}