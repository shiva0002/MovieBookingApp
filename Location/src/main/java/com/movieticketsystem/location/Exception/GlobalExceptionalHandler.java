package com.movieticketsystem.location.Exception;

import com.movieticketsystem.location.Exception.info.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionalHandler extends RuntimeException{

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionalHandler.class);

     @ExceptionHandler(value = { CityNotFoundException.class })
     public ResponseEntity<ErrorInfo> cityNotFoundExceptionHandeler(CityNotFoundException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { MovieNotFoundException.class })
     public ResponseEntity<ErrorInfo> movieNotFoundExceptionHandeler(MovieNotFoundException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { ScreenNotFoundException.class })
     public ResponseEntity<ErrorInfo> screenNotFoundExceptionHandeler(ScreenNotFoundException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { TheatreNotFoundException.class })
     public ResponseEntity<ErrorInfo> theatreNotFoundExceptionHandeler(TheatreNotFoundException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { SeatNotAvailableException.class })
     public ResponseEntity<ErrorInfo> seatNotAvailableExceptionHandeler(SeatNotAvailableException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { SeatNotFoundException.class })
     public ResponseEntity<ErrorInfo> seatNotFoundExceptionHandeler(SeatNotFoundException exception,
                                                                       WebRequest request) {
         logger.error(exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(value = { AccessDeniedException.class })
     public ResponseEntity<ErrorInfo> acessDeniedExceptionHandeler(AccessDeniedException exception, WebRequest request) {
         logger.error("Access Denied Exceptions : " + exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.FORBIDDEN, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
     }

     @ExceptionHandler(value = { BadCredentialsException.class })
     public ResponseEntity<ErrorInfo> badCredentialsExceptionHandeler(BadCredentialsException exception,
                                                                      WebRequest request) {
         logger.error("Bad Credential Exception: " + exception.getMessage());
         ErrorInfo error = new ErrorInfo(HttpStatus.UNAUTHORIZED, new Date(), exception.getMessage(),
                 request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
     }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception, WebRequest request) {
        logger.error("internal server error : " + exception.getMessage());
        ErrorInfo error = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
