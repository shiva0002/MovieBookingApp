package com.movieticketsystem.location.Exception.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
    private HttpStatus status;
    private Date date;
    private String message;
    private String description;
}
