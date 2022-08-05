package com.tdd.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.demo.model.request.UserInfoRequest;
import com.tdd.demo.model.response.UserMembershipDetails;
import com.tdd.demo.service.UserUtilities;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserInfoController.class)
class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserUtilities userUtilities;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void healthCheck() {
        Assertions.assertTrue(true);

        Assertions.assertNotNull(mockMvc);
        Assertions.assertNotNull(userUtilities);
    }

    private int port = 8080;

    @DisplayName("Given /userinfo/status endpoint is invoked")
    @Nested
    class GivenUserinfoStatusEndpointIsInvoked {

        final String userStatusUrl = "http://localhost:" + String.valueOf(port) + "/userinfo/status";

        @DisplayName("When the request contains a valid user ID")
        @Nested
        class WhenTheRequestContainsAValidUserId {

            @DisplayName("Then pass the request into the service layer (style 1)")
            @Test
            void thenPassTheRequestIntoTheServiceLayer1() throws Exception {

                Mockito.doReturn(new UserMembershipDetails()).when(userUtilities).getMemberLoyaltyInfo(any());

                String userId = "12345";

                // Make sure this uses @JsonSerialize or some other way to provide serialization
                UserInfoRequest requestBodyObject = new UserInfoRequest(userId);

                // One style of testing an @POST
                MvcResult result = mockMvc
                        .perform(post(userStatusUrl)
                                .characterEncoding("utf-8")
                                .content(objectMapper.writeValueAsString(requestBodyObject))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

                verify(userUtilities, times(1)).getMemberLoyaltyInfo(userId);

                String responseBodyAsJsonString = result.getResponse().getContentAsString();
                UserMembershipDetails responseBody = objectMapper.readValue(responseBodyAsJsonString, UserMembershipDetails.class);
                Assertions.assertNotNull(responseBody);
            }


//            @DisplayName("Then pass the request into the service layer (style 2)")
//            @Test
//            void thenPassTheRequestIntoTheServiceLayer2() throws Exception {
//
//                // A different style of testing an @POST than used above
//
//                String userId = "12345";
//                UserInfoRequest requestBodyObject = new UserInfoRequest(userId); // Make sure this uses @JsonSerialize or some other way to provide serialization
//
//                HttpHeaders headers = new HttpHeaders();
//                headers.set("X-COM-PERSIST", "true");
//
//                HttpEntity<UserInfoRequest> request = new HttpEntity<>(requestBodyObject, headers);
//
//                ResponseEntity<UserMembershipDetails> responseEntity = restTemplate.postForEntity(userStatusUrl, request, UserMembershipDetails.class);
//
//                verify(userUtilities, times(1)).getMemberLoyaltyInfo(userId);
//
//                Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//                Assert.assertNotNull(responseEntity.getBody());
//            }
        }
    }
}