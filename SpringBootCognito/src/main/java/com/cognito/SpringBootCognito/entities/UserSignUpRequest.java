package com.cognito.SpringBootCognito.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {

    private String username;
    private String email;
    private String password;
    
}
