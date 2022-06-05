package com.tdd.demo.controller;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // need this for testing stuff you autowire
@AutoConfigureMockMvc
class InfoUtilitiesControllerTest {

    @Autowired
    private InfoUtilitiesController infoUtilitiesController;

    // Sanity Check
    @Test
    public void contextLoads() {
        Assert.assertNotNull(infoUtilitiesController);
    }

    // Testing Option #1
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Given /infoUtilities/testString endpoint")
    @Nested
    class GivenInfoUtilitiesTestStringEndpoint {

        @DisplayName("When GET protocol is invoked")
        @Nested
        class WhenGetProtocolIsInvoked {

            @DisplayName("Then return the expected text string")
            @Test
            void thenReturnTheExpectedTextString() {

                String expected = "my_Test_String";

                String endpointUrl = "http://localhost:" + port + "/infoUtilities/testString";
                String actual = restTemplate.getForObject(endpointUrl, String.class);

                boolean stringMatchAsExpected = expected.equals(actual);

                Assert.assertTrue(stringMatchAsExpected);
            }
        }
    }


    // Testing Option #2 for a different method
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Given /infoUtilities/testSentence endpoint")
    @Nested
    class GivenInfoUtilitiesTestSentenceEndpoint {

        @DisplayName("When GET protocol is invoked")
        @Nested
        class WhenGetProtocolIsInvoked {

            @DisplayName("Then return the expected text string")
            @Test
            void thenReturnTheExpectedTextString() throws Exception { // make sure to include throws

                String endpointUrl = "http://localhost:" + port + "/infoUtilities/testSentence";

                String expectedString = "Test String from the Java";

                mockMvc.perform(get(endpointUrl))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().string(containsString(expectedString)));
            }
        }
    }
}