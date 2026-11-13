package fr.simplon.domedespuys.controller_advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice
public class MethodArgumentNotValidExceptionResponse {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse getResponse(MethodArgumentNotValidException e){
        String mess = Arrays.stream(e.getMessage().splitWithDelimiters("default message",10)).toList().getLast();
        return new ExceptionResponse(
                mess,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name()
        );
    }
}
