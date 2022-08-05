package com.tdd.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "survey.options.followup") // from application-survey-settings-dev.properties
public class SurveyConfig {

    private Boolean requestFollowup;

    private String storeManagerName;
}
