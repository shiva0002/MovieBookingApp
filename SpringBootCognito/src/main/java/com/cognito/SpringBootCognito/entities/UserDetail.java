package com.cognito.SpringBootCognito.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    private String firstName;
    private String lastName;
    private String email;
    
}
