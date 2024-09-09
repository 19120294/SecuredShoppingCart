package com.KLBproject.KLB_project.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@RestControllerAdvice
public class ValidationException {
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(Exception e, WebRequest request){
        System.out.println("======> handleValidationException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setPath(request.getDescription(false).replace("uri",""));

        String message = e.getMessage();
        if(e instanceof MethodArgumentNotValidException){
            int start=message.lastIndexOf("[");
            int end=message.lastIndexOf("]");
            message=message.substring(start+1,end-1);
            errorResponse.setMessage(message);
            errorResponse.setError("Payload Invalid");
        } else if(e instanceof ConstraintViolationException){
            message=message.substring(message.indexOf(" ")+1);
            errorResponse.setError("Parameter Invalid");
        }
        //errorResponse.setMessage(message);
        return errorResponse;
    }
}
