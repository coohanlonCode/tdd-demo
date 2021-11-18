package com.tdd.demo;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ArraySumOddOrEvenTest {

    @Spy
    @InjectMocks
    ArraySumOddOrEven myServiceABC;

    @Mock
    OtherService serviceAutowiredWithinMyServiceABC

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHealthCheck() {
        Assert.assertTrue(true);
        ArraySumOddOrEven myServiceABC = new ArraySumOddOrEven();
        Assert.assertNotNull(myService);
    }

    @DisplayName("Given this methodXYZ")
    @Nested
    class GivenThisMethodXYZ {

        @DisplayName("When given these paramters")
        @Nested
        class WhenGivenTheseParamters {

            @DisplayName("Then expect this")
            @Test
            public void thenExpectThis() {

                boolean isExpected = myServiceABC.methodXYZ(43);

                Assert.assertTrue(isExpected);
            }

        }
    }
}