package com.cognito.SpringBootCognito.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInRequest {

    private String username;
    private String email;
    private String password;
    
}
