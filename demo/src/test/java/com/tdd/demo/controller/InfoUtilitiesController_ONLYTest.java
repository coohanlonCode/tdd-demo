package com.tdd.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(InfoUtilitiesController.class)
class InfoUtilitiesController_ONLYTest {

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

                String endpointUrl = "http://localhost:8080" + "/infoUtilities/testSentence";

                String expectedString = "Test String from the Java";

                mockMvc.perform(get(endpointUrl))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().string(containsString(expectedString)));
            }
        }
    }
}