package com.tdd.demo.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserMembershipDetails {

    private boolean isEnabled;
}
