package br.com.manualdaprogramacao.helpdesk.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.TooManyListenersException;

@ControllerAdvice
@Log4j2
public class ControllerExceptionHandler {

//    @ExceptionHandler(TooManyListenersException.class)
//    public ReponseEntity<StandardError> manyRequestsException(TooManyRequestsException e){
//        StandardError err = new StandardError(HttpStatus.TOO_MANY_REQUESTS.value(), e.getMessage(), e.getMessage);
//        log.error(e.getMessage());
//        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(err);
    }

