package com.tdd.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = SurveyConfig.class)
@TestPropertySource(locations = {
        "classpath:application.properties",
        "classpath:application-survey-settings-dev.properties"})
class SurveyConfigTest {

    @Autowired
    private SurveyConfig surveyConfig;

    /* Read from  tdd-demo/demo/src/test/resources/application-survey-settings-dev.properties */
    @DisplayName("Given SurveyConfig When attributes are request Then provide expected values from extended application env file")
    @Test
    void GivenSurveyConfigWhenAttributesAreRequestThenProvideExpectedValuesFromExtendedApplicationEnvFile() {

        Boolean requestFollowupFlag = surveyConfig.getRequestFollowup();
        assertTrue(requestFollowupFlag);

        String managerName = surveyConfig.getStoreManagerName();
        String expectedManagerName = "Colin";
        assertEquals(expectedManagerName, managerName);
    }


    @Value("${store.opener}")
    String opener;
    // "Winston" @ tdd-demo/demo/src/test/resources/application-survey-settings-dev.properties
    // "Ollie"   @ tdd-demo/demo/src/main/resources/application.properties
    /*
    Try commenting out one of the above names and see how that impacts the below tests
    */
    @DisplayName("Given default config When attributes are requested Then get value from application-env.properties")
    @Test
    void GivenDefaultConfigWhenAttributesAreRequestedThenGetValueFromApplicationEnvProperties() {

        boolean openerIsWinston = StringUtils.equalsIgnoreCase(opener, "Winston");
        assertTrue(openerIsWinston);

//        boolean openerIsOllie = StringUtils.equalsIgnoreCase(opener, "Ollie");
//        assertTrue(openerIsOllie);

    }
}